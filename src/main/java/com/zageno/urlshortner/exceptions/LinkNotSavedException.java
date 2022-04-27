package com.zageno.urlshortner.exceptions;
/** Custom exception created for any exception while saving the long url.
 * @author Rishi Pathania
 * @version 1.0
 */
public class LinkNotSavedException extends RuntimeException {
    public LinkNotSavedException(String message) {
        super(message);
    }
}
