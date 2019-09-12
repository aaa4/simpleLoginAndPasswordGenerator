package passwGen;


import org.passay.PasswordGenerator;

public class SimpleLoginGenerator {

  private Rules rules;

    public SimpleLoginGenerator() {
        this.rules = new Rules();
    }

    public String getLogin(){
        PasswordGenerator loginGenerator = new PasswordGenerator();
        String generatedLogin = loginGenerator.generatePassword(
                rules.getDefaultLoginLength(),
                rules.getMinNumberOfLowCaseEngChars(),
                rules.getMinNumberOfUpperCaseEngChars(),
                rules.getMinNumberOfSpecialSimbols(),
                rules.getMinNumberOfDigits()
        );
        return generatedLogin;
    }



}
