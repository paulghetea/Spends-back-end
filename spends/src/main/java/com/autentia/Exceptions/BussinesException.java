package com.autentia.Exceptions;

public class BussinesException extends Exception  {
        private int errorCode;

        public BussinesException() {
        }

        public BussinesException(int errorCode, String message, Throwable cause) {
            super(message, cause);
            this.errorCode = errorCode;
        }

        public int getErrorCode() {
            return errorCode;
        }

    }

