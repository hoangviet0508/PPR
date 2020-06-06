package com.fptu.swp.ppr.place.controller;

import com.fptu.swp.ppr.entities.Place;
import com.fptu.swp.ppr.place.request.PlaceCreateRequest;
import com.fptu.swp.ppr.place.request.PlaceUpdateRequest;
import com.fptu.swp.ppr.place.service.PlaceService;
import com.fptu.swp.ppr.util.APIPath;
import com.fptu.swp.ppr.util.BaseResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(APIPath.PLACE)
@AllArgsConstructor
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping("/{placeId}")
    public Place findById(@PathVariable int placeId){
        return placeService.findById(placeId);
    }

    @GetMapping
    public List<Place> findAllEnable(){
        return placeService.getAllAvailablePlaces();
    }

    @PostMapping
    public Place create(@RequestBody PlaceCreateRequest request){
        return placeService.create(request);
    }

    @PutMapping("/{placeId}")
    public ResponseEntity<BaseResponse> updatePlace(@PathVariable("placeId") Integer id, @RequestBody PlaceUpdateRequest request) {
        boolean result = placeService.update(id, request);
        if (result) {
            return ResponseEntity.ok(new BaseResponse(true, "OK"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new BaseResponse(false, "Update fail"));
        }
    }

}
