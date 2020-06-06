package com.fptu.swp.ppr.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class BaseResponse implements Serializable {
    private boolean success;
    private String message;
}
