package com.zageno.urlshortner.exceptions;
/** Custom exception created for invalid url.
 * @author Rishi Pathania
 * @version 1.0
 */
public class UrlInvalidException extends RuntimeException {
    public UrlInvalidException(String exceptionMessage){
        super(exceptionMessage);
    }

}
