package com.fptu.swp.ppr.booking.controller;


import com.fptu.swp.ppr.booking.request.BookingCreateRequest;
import com.fptu.swp.ppr.booking.service.BookingService;
import com.fptu.swp.ppr.entities.Booking;
import com.fptu.swp.ppr.util.APIPath;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(APIPath.BOOKING)
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/{bookingId}")
    public Booking findById(@PathVariable int bookingId) {
        return bookingService.findById(bookingId);
    }

    @GetMapping("/place/{placeId}")
    public List<Booking> findByPlaceId(@PathVariable int placeId) {
        return bookingService.findByPlaceId(placeId);
    }

    @GetMapping("/status")
    public List<Booking> findByStatus(@RequestParam Booking.BookingStatus status) {
        return bookingService.findByStatus(status);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> findByUsername(@PathVariable String userId) {
        return bookingService.findByUserId(userId);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody BookingCreateRequest bookingCreateRequest) {

        try {
            Booking booking = bookingService.create(bookingCreateRequest);
            if (booking != null) {
                return new ResponseEntity(booking, HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PatchMapping
    public ResponseEntity updateStatus(@RequestParam int bookingId, @RequestParam Booking.BookingStatus status) {
        try {
            Booking booking = bookingService.updateStatus(bookingId, status);
            return new ResponseEntity(booking, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
