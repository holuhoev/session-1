package ru.sbt.jschool.session1;

public class ExtraTasks {
    public static void main(String[] args) {
        System.out.println(sumOf("1", "101", 2));
        System.out.println(sumOf("1", "1", 3));
    }

    private static long longValueOf(String s, int radix) {
        long result = 0;
        int i = 0, len = s.length();
        if (len > 0) {
            while (len > i) {
                int digit = Character.digit(s.charAt(i++), radix);
                if (digit < 0) {
                    throw new NumberFormatException(String.format("for input string %s.", s));
                }
                result *= radix;
                result += digit;
            }
        } else {
            throw new NumberFormatException(String.format("for input string %s.", s));
        }
        return result;
    }

    private static long sumOf(String s1, String s2, int radix) {
        long result = 0;
        int len1 = s1.length(), len2 = s2.length();
        int len = len1 > len2 ? len1 : len2;
        int i = 0;
        int mult = 1;
        if (len > 0) {
            while (i < (len)) {
                int digit1 = i < len1 ? Character.digit(s1.charAt(len1 - 1 - i), radix) : 0;
                int digit2 = i < len2 ? Character.digit(s2.charAt(len2 - 1 - i), radix) : 0;
                i++;
                result += (digit1 + digit2) * mult;
                mult *= radix;
            }
        } else {
            throw new NumberFormatException(String.format("for input strings: %s and %s.", s1, s2));
        }
        return result;
    }

}
