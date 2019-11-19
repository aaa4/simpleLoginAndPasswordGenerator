package passwGen;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.*;



public class WriteLoginAndPassFile {

    private static   int numberOfLogins = 100;
    private static int harness = 4;

    public static void setHarness(int harness) {
        WriteLoginAndPassFile.harness = harness;
    }

    public static void setNumberOfLogins(int numberOfLogins) {
        WriteLoginAndPassFile.numberOfLogins = numberOfLogins;
    }

    public static String getLogin(){
        SimpleLoginGenerator loginGenerator = new SimpleLoginGenerator();
        return loginGenerator.getLogin();
    }

    public static String getPassword(){
        SimplePasswordGenerator passwordGenerator = new SimplePasswordGenerator();
        return passwordGenerator.getPassword();
    }

    public static String getLoginAndPasswordSequence(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(harness);
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        sb.append(" ");
        sb.append("login");
        sb.append("      ");
        sb.append("password");
        sb.append("      ");
        sb.append("encoded("+harness+") password");
        sb.append("\n");
        for (int i = 0; i < numberOfLogins; i++) {



            sb.append(i);
            sb.append(" ");
            sb.append(getLogin());
            sb.append(" ");
            String pwd = getPassword();
            sb.append(pwd);
            sb.append(" ");
            sb.append(encoder.encode(pwd));
            sb.append("\n");
        }
        return sb.toString();
    }


    public static void writeLoginAndPasswordToFile(String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        String loginAndPasswordSequence = getLoginAndPasswordSequence();
        writer.write(loginAndPasswordSequence);
        writer.close();
    }

    public static void printUserGreeting(){
        String userName = System.getProperty("user.name");
        System.out.println("Hello "+userName);
        System.out.println("Enter filename to save login and password pairs");
        System.out.println("Example: C:\\foldername\\filename.txt");
    }






    public static String readWordFromConsole() throws IOException {
        String word = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            word = reader.readLine();
        }
        return word;
    }

    public static void doIt(){

        try {
            System.out.println("Enter number of logins");
            int numberOfLogins = Integer.parseInt(readWordFromConsole());
            setNumberOfLogins(numberOfLogins);
            printUserGreeting();
            String filename = readWordFromConsole();
            System.out.println("Enter encryption harness from 1 to 10");
            int harness = Integer.parseInt(readWordFromConsole());
            setHarness(harness);
            System.out.println("Encryption harness is "+harness);
            writeLoginAndPasswordToFile(filename);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void doSomethingElse(){

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter number of logins");
            int numberOfLogis = Integer.parseInt(reader.readLine());
            setNumberOfLogins(numberOfLogis);
            System.out.println("Number of logins = ");


            System.out.println("Enter encryption harness");
            int harness = Integer.parseInt(reader.readLine());
            setHarness(harness);
            System.out.println("Harness is "+harness);

            printUserGreeting();
            String filename = reader.readLine();
            System.out.println("Filename = "+filename);

            writeLoginAndPasswordToFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public static void main(String[] args)  {
        //doIt();
        doSomethingElse();

    }
}
