package com.fptu.swp.ppr.user.services;

import com.fptu.swp.ppr.entities.UserInfo;
import com.fptu.swp.ppr.exceptions.EntityNotFoundException;
import com.fptu.swp.ppr.user.repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfo getUserById(String userId){
        return userInfoRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
    }

}
