package com.example.freecrmbackend.security.service;

public enum PasswordLengthParameters {
    LOWER_CASE_RULE_LENGTH(5),
    UPPER_CASE_RULE_LENGTH(5),
    DIGIT_RULE_LENGTH(3),
    SPECIAL_CHAR_RULE_LENGTH(2);

    private final int sequence_length;

    PasswordLengthParameters(int sequence_length) {
        this.sequence_length = sequence_length;
    }

    public int getSequence_length() {
        return sequence_length;
    }
}
