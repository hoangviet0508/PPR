package com.fptu.swp.ppr.exceptions;

public class EntityNotFoundException extends IllegalArgumentException {
    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String s) {
        super(s);
    }
}
