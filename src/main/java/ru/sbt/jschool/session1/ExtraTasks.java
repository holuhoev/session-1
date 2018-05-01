package ru.sbt.jschool.session1;

import java.util.Arrays;

public class ExtraTasks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new long[]{1, 2, 3}, new long[]{1, 2, 3})));
        System.out.println(Arrays.toString(intersection(new long[]{1, 2, 3, 4}, new long[]{2, 3})));
        System.out.println(Arrays.toString(intersection(new long[]{0}, new long[]{1, 2, 3})));
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

    private static long[] intersection(long[] arr1, long[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;
        long[] result = new long[len1 > len2 ? len2 : len1];
        long[] sortedArr1 = arr1.clone();
        long[] sortedArr2 = arr2.clone();
        Arrays.sort(sortedArr1);
        Arrays.sort(sortedArr2);

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < len1 && j < len2) {
            if (sortedArr1[i] == sortedArr2[j]) {
                result[k] = sortedArr1[i];
                i++;
                j++;
                k++;
            } else if (sortedArr1[i] < sortedArr2[j]) {
                i++;
            } else if (sortedArr1[i] > sortedArr2[j]) {
                j++;
            }
        }

        return Arrays.copyOf(result, k);
    }

}
