package com.ttasjwi.PCRoom.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue
    private Long id; // 사용자 id

    @NotNull private String nickname; // 사용자 닉네임
    @NotNull private double money; // 소지금
    @NotNull private LocalDateTime lastVisit; // 방문일
}