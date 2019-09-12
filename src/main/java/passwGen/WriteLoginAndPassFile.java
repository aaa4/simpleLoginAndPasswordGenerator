package passwGen;

import java.io.*;

public class WriteLoginAndPassFile {

    private static final int NUMBER_OF_LOGINS = 100;


    public static String getLogin(){
        SimpleLoginGenerator loginGenerator = new SimpleLoginGenerator();
        return loginGenerator.getLogin();
    }

    public static String getPassword(){
        SimplePasswordGenerator passwordGenerator = new SimplePasswordGenerator();
        return passwordGenerator.getPassword();
    }

    public static String getLoginAndPasswordSequence(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_LOGINS; i++) {
            sb.append(i);
            sb.append(" ");
            sb.append(getLogin());
            sb.append(" ");
            sb.append(getPassword());
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


    public static String getFilenmame() throws IOException {
        String filename;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        filename = reader.readLine();
        reader.close();
        return filename;
    }

    public static void doIt(){
        printUserGreeting();
        try {
            String filename = getFilenmame();
            writeLoginAndPasswordToFile(filename);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args)  {
        doIt();

    }
}
