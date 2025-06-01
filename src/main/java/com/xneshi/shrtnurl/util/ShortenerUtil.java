package com.xneshi.shrtnurl.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class ShortenerUtil {
  private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

  public static String hashUrl(String url) {
    try {
      // Step 1: Hash the URL
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] hash = digest.digest(url.getBytes(StandardCharsets.UTF_8));

      // Step 2: Convert hash to positive BigInteger
      BigInteger number = new BigInteger(1, hash);

      // Step 3: Base62 encode
      StringBuilder shortCode = new StringBuilder();
      while (number.compareTo(BigInteger.ZERO) > 0 && shortCode.length() < 6) {
        int index = number.mod(BigInteger.valueOf(62)).intValue();
        shortCode.append(BASE62.charAt(index));
        number = number.divide(BigInteger.valueOf(62));
      }

      // Step 4: Pad if needed (rare)
      while (shortCode.length() < 6) {
        shortCode.append('0');
      }

      return shortCode.toString();
    } catch (Exception e) {
      throw new RuntimeException("Failed to generate short code", e);
    }
  }
}
