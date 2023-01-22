package com.example.freecrmbackend.security.service;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.stereotype.Service;

@Service
public class PasswordGeneratorService {

    public String generatePassword(){
        var generator = new PasswordGenerator();

        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(PasswordLengthParameters
                .LOWER_CASE_RULE_LENGTH
                .getSequence_length());

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(PasswordLengthParameters
                .UPPER_CASE_RULE_LENGTH
                .getSequence_length());

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(PasswordLengthParameters
                .DIGIT_RULE_LENGTH
                .getSequence_length());

        CharacterData specialChars = new CharacterData() {
            @Override
            public String getErrorCode() {
                return EnglishCharacterData.Special.getErrorCode();
            }

            @Override
            public String getCharacters() {
                return "!@#$%^&*()_+";
            }
        };
        CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(PasswordLengthParameters
                .SPECIAL_CHAR_RULE_LENGTH
                .getSequence_length());

        return generator.generatePassword(15, lowerCaseRule,
                upperCaseRule, digitRule, splCharRule);
    }
}
