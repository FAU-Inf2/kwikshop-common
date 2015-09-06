package de.fau.cs.mad.kwikshop.common.util;

public class StringHelper {


    public static boolean isNullOrWhiteSpace(CharSequence value) {
        return value == null || isNullOrWhiteSpace(value.toString());
    }

    public static boolean isNullOrWhiteSpace(String value) {
        if (value == null) {
            return true;
        } else {
            return value.trim().length() == 0;
        }
    }


    public static String removeSpacesAtEndOfWord(String word) {
        if (null == word || word.isEmpty())
            return word;

        while (word.charAt(word.length() - 1) == ' ') {
            word = word.substring(0,word.length() - 1);
        }

        return word;
    }
}
