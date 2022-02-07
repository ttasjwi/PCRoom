package com.ttasjwi.PCRoom.user;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryUserRepositoryTest {

    MemoryUserRepository repository = new MemoryUserRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    @DisplayName("MemoryUserRepository 저장 테스트")
    void save() {
        User user = new User();
        user.setNickname("호눅스");
        user.setMoney(10000L);
        user.setLastVisit(LocalDateTime.of(2022, 02,06,23,59,59));

        repository.save(user);
        User findUser = repository.findById(user.getId()).get();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(user).isSameAs(findUser);
        softAssertions.assertThat(user.getId()).isEqualTo(findUser.getId());
        softAssertions.assertThat(user.getMoney()).isEqualTo(findUser.getMoney());
        softAssertions.assertThat(user.getLastVisit()).isEqualTo(findUser.getLastVisit());
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("findAll 테스트")
    void findAll() {
        User user1 = new User();
        user1.setNickname("호눅스");
        user1.setMoney(10000L);
        user1.setLastVisit(LocalDateTime.of(2022, 02,06,23,59,59));
        repository.save(user1);

        User user2 = new User();
        user2.setNickname("JK");
        user2.setMoney(20000L);
        user2.setLastVisit(LocalDateTime.of(2022, 02,07,23,59,59));
        repository.save(user2);

        List<User> users = repository.findAll();
        assertThat(users.size()).isEqualTo(2);
    }
}