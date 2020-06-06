package com.fptu.swp.ppr.booking.service;


import com.fptu.swp.ppr.booking.request.BookingCreateRequest;
import com.fptu.swp.ppr.booking.repository.BookingRepository;
import com.fptu.swp.ppr.entities.Booking;
import com.fptu.swp.ppr.entities.Place;
import com.fptu.swp.ppr.entities.UserInfo;
import com.fptu.swp.ppr.exceptions.EntityNotFoundException;
import com.fptu.swp.ppr.place.repository.PlaceRepository;
import com.fptu.swp.ppr.user.repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
@AllArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final PlaceRepository placeRepository;
    private final UserInfoRepository userInfoRepository;

    public Booking findById(int id) {

        return bookingRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Booking create(BookingCreateRequest bookingCreateRequest) throws Exception {
        Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(bookingCreateRequest.getStartTime());
        Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(bookingCreateRequest.getEndTime());
        if (!isValidDate(startDate, endDate, bookingCreateRequest.getPlaceid())) {
            return null;
        }


        Place place = placeRepository.findById(bookingCreateRequest.getPlaceid())
                .orElseThrow(EntityNotFoundException::new);
        UserInfo registration = userInfoRepository.findById(bookingCreateRequest.getUserId())
                .orElseThrow(EntityNotFoundException::new);

        Booking booking = new Booking();
        booking.setStartTime(startDate);
        booking.setEndTime(endDate);
        booking.setStatus(Booking.BookingStatus.NOT_STARTED);
        booking.setPlace(place);
        booking.setUserInfo(registration);

        return bookingRepository.save(booking);
    }

    public List<Booking> findByPlaceId(int placeId) {
        return bookingRepository.findByPlaceIdOrderByStartTimeAsc(placeId);
    }

    public Booking updateStatus(int bookingId, Booking.BookingStatus status) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(EntityNotFoundException::new);
        booking.setStatus(status);

        return bookingRepository.save(booking);
    }

    public List<Booking> findByUserId(String userId) {
        UserInfo userInfo = userInfoRepository.findById(userId).orElseThrow(EntityNotFoundException::new);

        return bookingRepository.findByUserInfoOrderByStartTimeAsc(userInfo);
    }

    public List<Booking> findByStatus(Booking.BookingStatus status) {
        return bookingRepository.findByStatusOrderByStartTimeAsc(status);
    }

    private boolean isValidDate(Date startD, Date endD, int placeid) {
        long lasted = endD.getTime() - startD.getTime();
        if (endD.before(startD) || (lasted < 3600000)) {
            return false;
        }

        List<Booking> bookingList = bookingRepository.findByPlaceIdOrderByStartTimeAsc(placeid);
        for (Booking book: bookingList) {
            long fromTime = book.getStartTime().getTime() - 3600000;
            long toTime = book.getEndTime().getTime() + 3600000;

            if((startD.getTime() < toTime && startD.getTime() > fromTime) ||
                    (endD.getTime() < toTime && endD.getTime() > fromTime) ||
                    (startD.getTime() <= fromTime && endD.getTime() >= toTime)){
                return false;
            }
        }

        return true;
    }

}
