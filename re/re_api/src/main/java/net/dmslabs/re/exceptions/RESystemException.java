package net.dmslabs.re.exceptions;

public class RESystemException extends Exception {
    private static final long serialVersionUID = 1L;

    public RESystemException(String message, Exception ex) {
        super(message, ex);
    }
}
