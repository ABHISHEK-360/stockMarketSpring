/*
 * abhishek360
 */

package org.wells.exceptionHandler;

import java.util.Map;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Class clazz, Map<String, Object> searchParamsMap) {
        super(EntityNotFoundException.generateMessage(clazz.getSimpleName(), searchParamsMap));
    }

    private static String generateMessage(String entity, Map<String, Object> searchParams) {
        return entity + " was not found for parameters " + searchParams;
    }
}