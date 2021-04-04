package com.testtask.exception.file;

public class ImageLoadException extends RuntimeException {
    public ImageLoadException(String message) {
        super(message);
    }

    public ImageLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
