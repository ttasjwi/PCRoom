package com.ttasjwi.PCRoom.user;


import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class) // JUnit5에게 Spring 관련 테스트 하는 것을 알려줘야함.
@SpringBootTest // 스프링 부트 테스트
@Transactional
public class UserServiceIntegrationTest {

    @Autowired UserService userService;

    @Test
    @DisplayName("회원가입 테스트")
    void joinTest() {

        //given
        User user = new User();
        user.setNickname("호눅스");
        user.setMoney(2500);
        user.setLastVisit(LocalDateTime.now());

        //when
        Long id = userService.join(user);

        //then
        User findUser = userService.findUser(id).get();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(user).isSameAs(findUser);
        softAssertions.assertThat(user.getId()).isEqualTo(findUser.getId());
        softAssertions.assertThat(user.getNickname()).isEqualTo(findUser.getNickname());
        softAssertions.assertThat(user.getMoney()).isEqualTo(findUser.getMoney());
        softAssertions.assertThat(user.getLastVisit()).isEqualTo(findUser.getLastVisit());
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("전체 이용자 반환 테스트")
    void findAllUsersTest() {
        User user1 = new User();
        user1.setNickname("호눅스");
        user1.setMoney(100);
        user1.setLastVisit(LocalDateTime.of(2022, 02,06,23,59,59));
        userService.join(user1);

        User user2 = new User();
        user2.setNickname("JK");
        user2.setMoney(2000);
        user2.setLastVisit(LocalDateTime.of(2022, 02,07,23,59,59));
        userService.join(user2);

        List<User> users = userService.findAllUsers();
        assertThat(users.size()).isEqualTo(2);
    }
}
