/*
 * abhishek360
 */

package org.wells.exceptionHandler;

public class MissingParamsException extends RuntimeException {
    public MissingParamsException(String e) {
        super(MissingParamsException.generateMessage(e));
    }

    private static String generateMessage(String exception) {
        return  "Error: " + exception;
    }
}
