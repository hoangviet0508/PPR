package com.fptu.swp.ppr.user.repository;

import com.fptu.swp.ppr.entities.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, String> {
}
