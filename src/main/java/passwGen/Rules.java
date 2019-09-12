package passwGen;


import lombok.Data;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;

@Data
public class Rules {

    private int defaultLoginLength = 12;
    private int defaultPasswordLength = 14;

    private CharacterRule minNumberOfUpperCaseEngChars ;
    private CharacterRule minNumberOfLowCaseEngChars ;
    private CharacterRule minNumberOfDigits;
    private CharacterRule minNumberOfSpecialSimbols;

    public Rules() {
        this.minNumberOfUpperCaseEngChars = new CharacterRule(EnglishCharacterData.UpperCase, 1);
        this.minNumberOfLowCaseEngChars =  new CharacterRule(EnglishCharacterData.LowerCase, 1);
        this.minNumberOfDigits = new CharacterRule(EnglishCharacterData.Digit, 1);
        CustomCharacterData specialSymbolsData = new CustomCharacterData();
        this.minNumberOfSpecialSimbols = new CharacterRule(specialSymbolsData, 1);
    }



}
