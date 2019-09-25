package io.lucasvalenteds.singleton;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

class MainTest {

    @Test
    void testItOnlyExecutesNewKeywordOneTime() {
        ConcurrentLinkedQueue<String> history = new ConcurrentLinkedQueue<>();

        Database database = Database.getInstance(history);
        assertNotNull(database);
        assertEquals(1, history.size());

        for (int i = 0; i < 100; i++) {
            Database database2 = Database.getInstance(history);
            assertEquals(database, database2);
        }

        assertNotNull(database);
        assertEquals(1, history.size());
    }

    @Test
    @Disabled("It fails when running with other test cases")
    void testItIsNotThreadSafe() {
        ConcurrentLinkedQueue<String> history = new ConcurrentLinkedQueue<>();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(
            CompletableFuture.runAsync(() -> Database.getInstance(history), executor),
            CompletableFuture.runAsync(() -> Database.getInstance(history), executor)
        );

        completableFuture.join();

        while (!completableFuture.isDone()) ;

        assertEquals(2, history.size());
    }
}
