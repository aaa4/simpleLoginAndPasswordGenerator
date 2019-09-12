package passwGen;


import lombok.Getter;
import org.passay.CharacterData;


@Getter
public class CustomCharacterData implements CharacterData {

    private final String errorCode = "ERRONEOUS_SPECIAL_CHARS";
    private final String characters = "!@#$%^&*()_+";

}
