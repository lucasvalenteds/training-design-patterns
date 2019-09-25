package io.lucasvalenteds.builder;

import java.time.LocalDate;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testItCanCreatePersonWithAddress() {
        Person john = new Person.Builder()
            .details(it -> {
                it.name = "John Smith";
                it.birthday = LocalDate.of(1986, Month.FEBRUARY, 17);
            })
            .address(it -> {
                it.street = "5th Avenue";
                it.number = 101;
                it.city = "Austin";
                it.state = "Texas";
            })
            .build();

        assertEquals("John Smith", john.getName());
        assertEquals(17, john.getBirthday().getDayOfMonth());
        assertEquals(2, john.getBirthday().getMonthValue());
        assertEquals(1986, john.getBirthday().getYear());

        assertEquals("5th Avenue", john.getAddress().getStreet());
        assertEquals(101, john.getAddress().getNumber());
        assertEquals("Austin", john.getAddress().getCity());
        assertEquals("Texas", john.getAddress().getState());
    }
}
