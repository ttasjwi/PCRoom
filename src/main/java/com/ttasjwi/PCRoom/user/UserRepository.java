package com.ttasjwi.PCRoom.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Long save(User user);
    Optional<User> findById(Long userId);
    List<User> findAll();

}
