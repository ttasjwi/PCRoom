package com.ttasjwi.PCRoom.user;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class) // JUnit5에게 Spring 관련 테스트 하는 것을 알려줘야함.
@SpringBootTest // 스프링 부트 테스트
class JpaUserRepositoryTest {

    @Autowired JpaUserRepository repository;

    @Test
    @DisplayName("save 테스트")
    @Transactional
    public void userTest() {
        User user = new User();
        user.setNickname("호눅스");
        user.setMoney(10000);
        user.setLastVisit(LocalDateTime.of(2022, 02,06,23,59,59));

        repository.save(user);

        System.out.println(user);
        User findUser = repository.findById(user.getId()).get();
        System.out.println(findUser);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(user).isSameAs(findUser);
        softAssertions.assertThat(user.getId()).isEqualTo(findUser.getId());
        softAssertions.assertThat(user.getMoney()).isEqualTo(findUser.getMoney());
        softAssertions.assertThat(user.getLastVisit()).isEqualTo(findUser.getLastVisit());
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("findAll 테스트")
    @Transactional
    void findAll() {
        User user1 = new User();
        user1.setNickname("호눅스");
        user1.setMoney(10000);
        user1.setLastVisit(LocalDateTime.of(2022, 02,06,23,59,59));
        repository.save(user1);

        User user2 = new User();
        user2.setNickname("JK");
        user2.setMoney(20000);
        user2.setLastVisit(LocalDateTime.of(2022, 02,07,23,59,59));
        repository.save(user2);

        List<User> users = repository.findAll();
        assertThat(users.size()).isEqualTo(2);
    }
}