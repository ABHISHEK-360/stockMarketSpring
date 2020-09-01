/*
 * abhishek360
 */

package org.wells.exceptionHandler;

public class GenericException extends RuntimeException {
    public GenericException(Exception e) {
        super(GenericException.generateMessage(e.toString()));
    }

    private static String generateMessage(String exception) {
        return  "Error: " + exception;
    }
}
