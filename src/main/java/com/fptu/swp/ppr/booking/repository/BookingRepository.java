package com.fptu.swp.ppr.booking.repository;

import com.fptu.swp.ppr.entities.Booking;
import com.fptu.swp.ppr.entities.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking,Integer> {

    List<Booking> findByPlaceIdOrderByStartTimeAsc(int placeid);
    List<Booking> findByUserInfoOrderByStartTimeAsc(UserInfo userInfo);
    List<Booking> findByStatusOrderByStartTimeAsc(Booking.BookingStatus status);
}
