package de.fau.cs.mad.kwikshop.common.util;

public class ObjectHelper {

    public static <T> boolean compare (T str1, T str2) {

        // both are null => true
        if(str1 == null && str2 == null) {
            return true;
        }

        // only one of them is null => false
        if(str1 == null || str2 == null) {
            return false;
        }

        //both values are not null => comare
        return str1.equals(str2);
    }

}
