package passwGen;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.*;


public class WriteLoginAndPassFile {

    private static int numberOfLogins = 100;
    private static int harness = 4;

    private static void setHarness(int harness) {
        WriteLoginAndPassFile.harness = harness;
    }

    private static void setNumberOfLogins(int numberOfLogins) {
        WriteLoginAndPassFile.numberOfLogins = numberOfLogins;
    }

    private static String getLogin() {
        SimpleLoginGenerator loginGenerator = new SimpleLoginGenerator();
        return loginGenerator.getLogin();
    }

    private static String getPassword() {
        SimplePasswordGenerator passwordGenerator = new SimplePasswordGenerator();
        return passwordGenerator.getPassword();
    }

    private static String getLoginAndPasswordSequence() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(harness);
        StringBuilder sb = new StringBuilder();
        sb.append("#")
                .append(" ")
                .append("login")
                .append("      ")
                .append("password")
                .append("      ")
                .append("encoded(" + harness + ") password");
        for (int i = 0; i < numberOfLogins; i++) {
            String pwd = getPassword();
            sb.append(i)
                    .append(" ")
                    .append(getLogin())
                    .append(" ")
                    .append(pwd)
                    .append(" ")
                    .append(encoder.encode(pwd))
                    .append("\n");
        }
        return sb.toString();
    }

    private static void writeLoginAndPasswordToFile(String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        String loginAndPasswordSequence = getLoginAndPasswordSequence();
        writer.write(loginAndPasswordSequence);
        writer.close();
    }

    private static void printUserGreeting() {
        String userName = System.getProperty("user.name");
        System.out.println("Hello " + userName);
        System.out.println("Enter filename to save login and password pairs");
        System.out.println("Example: C:\\foldername\\filename.txt");
    }

    private static void doSomethingElse() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter number of logins");
            int numberOfLogis = Integer.parseInt(reader.readLine());
            setNumberOfLogins(numberOfLogis);
            System.out.println("Number of logins = ");


            System.out.println("Enter encryption harness");
            int harness = Integer.parseInt(reader.readLine());
            setHarness(harness);
            System.out.println("Harness is " + harness);

            printUserGreeting();
            String filename = reader.readLine();
            System.out.println("Filename = " + filename);

            writeLoginAndPasswordToFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        doSomethingElse();

    }
}
