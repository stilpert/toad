package com.toad.dykyi.utils;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.security.SecureRandom;
@Component
@NoArgsConstructor
public class UniqueCodeGenerator {
    // Символи, з яких буде формуватись код
    private final String CHARACTERS =
            "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz0123456789";
    private final SecureRandom random = new SecureRandom();
    private final int count = 8;
    public String generateUniqueCode() {
        StringBuilder code = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            int index = random.nextInt(CHARACTERS.length());
            code.append(CHARACTERS.charAt(index));
        }
        return code.toString();
    }
}