package com.ttasjwi.PCRoom.user;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Long join(User user);
    Optional<User> findUser(Long id);
    List<User> findAllUsers();

}
