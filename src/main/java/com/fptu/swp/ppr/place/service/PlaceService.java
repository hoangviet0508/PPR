package com.fptu.swp.ppr.place.service;

import com.fptu.swp.ppr.entities.Place;
import com.fptu.swp.ppr.exceptions.EntityNotFoundException;
import com.fptu.swp.ppr.place.mapper.PlaceMapper;
import com.fptu.swp.ppr.place.repository.PlaceRepository;
import com.fptu.swp.ppr.place.request.PlaceCreateRequest;
import com.fptu.swp.ppr.place.request.PlaceUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final PlaceMapper placeMapper;

    public Place findById(int id){
        return placeRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Place create(PlaceCreateRequest request) {
        return placeRepository.save(placeMapper.requestCreateToEntity(request));
    }

    public List<Place> getAllAvailablePlaces() {
        // TODO implement this after implement booking
        throw new UnsupportedOperationException();
    }

    public boolean update(int id, PlaceUpdateRequest request) {
        placeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        Place updatePlace = placeMapper.requestUpdateToEntity(request);
        updatePlace.setId(id);
        placeRepository.save(updatePlace);
        return true;
    }
}
