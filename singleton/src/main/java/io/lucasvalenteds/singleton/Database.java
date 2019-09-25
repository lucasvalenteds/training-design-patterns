package io.lucasvalenteds.singleton;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class Database {

    private static Database INSTANCE = null;

    private Database() {
    }

    public static Database getInstance(ConcurrentLinkedQueue<String> history) {
        return Optional.ofNullable(INSTANCE)
            .orElseGet(() -> {
                history.add(LocalDateTime.now().toString());
                INSTANCE = new Database();
                return INSTANCE;
            });
    }
}
