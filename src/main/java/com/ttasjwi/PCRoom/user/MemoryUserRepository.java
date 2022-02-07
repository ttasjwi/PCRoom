package com.ttasjwi.PCRoom.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryUserRepository implements UserRepository{

    private Map<Long, User> store = new ConcurrentHashMap<>();
    private static Long sequence = 0L;

    @Override
    public Long save(User user) {
        user.setId(++sequence);
        Long userId = user.getId();
        store.put(userId, user);
        return userId;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
        return;
    }
}
