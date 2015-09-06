package de.fau.cs.mad.kwikshop.common;

public class ArgumentNullException extends IllegalArgumentException {

    public ArgumentNullException(String argumentName) {
        super(String.format("'%s' must not be null", argumentName));
    }

}
