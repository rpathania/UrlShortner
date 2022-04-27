package com.zageno.urlshortner.exceptions;
/** Custom exception created for link expire notification.
 * @author Rishi Pathania
 * @version 1.0
 */
public class LinkExpiredException extends RuntimeException{

    public LinkExpiredException(String exceptionMessage){
        super(exceptionMessage);
    }
}
