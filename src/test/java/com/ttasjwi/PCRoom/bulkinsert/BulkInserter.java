//package com.ttasjwi.PCRoom.bulkinsert;
//
//import com.ttasjwi.PCRoom.user.User;
//import com.ttasjwi.PCRoom.user.UserService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.transaction.annotation.Transactional;
//
//@ExtendWith(SpringExtension.class) // JUnit5에게 Spring 관련 테스트 하는 것을 알려줘야함.
//@SpringBootTest // 스프링 부트 테스트
//public class BulkInserter {
//
//    @Autowired
//    UserService userService;
//
//    @Test
//    @Transactional
//    @Rollback(value = false)
//    void bulkInsert() {
//        for (int i=0; i<1000000; i++) {
//            User user = new User();
//            user.setNickname(MyRandomNickName.generate());
//            user.setMoney((int)(Math.random()*10000) + 1);
//            user.setLastVisit(MyRandomDateTime.generate());
//
//            userService.join(user);
//        }
//    }
//}
