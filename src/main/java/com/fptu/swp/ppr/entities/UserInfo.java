package com.fptu.swp.ppr.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "user_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {

    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    private String phone;
    private Integer status;

    @Getter
    public enum UserStatus {
        ACTIVE(1), DISABLED(0), DEACTIVATED(-1);
        private final Integer value;
        UserStatus(Integer value) {
            this.value = value;
        }
    }
}
