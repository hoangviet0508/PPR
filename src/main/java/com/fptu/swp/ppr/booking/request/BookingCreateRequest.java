package com.fptu.swp.ppr.booking.request;

import lombok.*;

@Data
public class BookingCreateRequest {

    private String userId;
    private int placeid;
    private String startTime;
    private String endTime;
}
