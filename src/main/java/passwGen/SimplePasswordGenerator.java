package passwGen;


import org.passay.CharacterRule;

public class SimplePasswordGenerator {

    private Rules rules;

    private int customPasswordLength;
    private CharacterRule minNumberOfUpperCaseEngChars ;
    private CharacterRule minNumberOfLowCaseEngChars ;
    private CharacterRule minNumberOfDigits ;
    private CharacterRule minNumberOfSpecialSimbols;


    public SimplePasswordGenerator() {
        this.rules = new Rules();
    }

    public void setRules(){
        Rules rules = new Rules();
        this.customPasswordLength = rules.getDefaultPasswordLength();
        this.minNumberOfLowCaseEngChars = rules.getMinNumberOfLowCaseEngChars();
        this.minNumberOfUpperCaseEngChars = rules.getMinNumberOfUpperCaseEngChars();
        this.minNumberOfDigits = rules.getMinNumberOfDigits();
        this.minNumberOfSpecialSimbols = rules.getMinNumberOfSpecialSimbols();
    }


    public String getPassword() {
         setRules();

        org.passay.PasswordGenerator passwordGenerator = new org.passay.PasswordGenerator();
        String generatedPassword = passwordGenerator.generatePassword(
                customPasswordLength,
                minNumberOfUpperCaseEngChars,
                minNumberOfLowCaseEngChars,
                minNumberOfDigits,
                minNumberOfSpecialSimbols);
        return generatedPassword;
    }

    public static void main(String[] args) {
        SimplePasswordGenerator gen = new SimplePasswordGenerator();
        String password = gen.getPassword();
        System.out.println(password);
    }
}
