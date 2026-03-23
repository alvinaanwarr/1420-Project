package test;

import model.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {

    @Test
    void testStudentLimit() {
        Student s = new Student("U1", "Lana", "lana@email.com");
        assertEquals(3, s.getMaxConfirmedBookings());
    }

    @Test
    void testWorkshopCreation() {
        Workshop w = new Workshop("E1", "Java", LocalDateTime.now(), "Room", 10, "OOP");
        assertEquals("Workshop", w.getEventType());
    }

    @Test
    void testBookingStatus() {
        Booking b = new Booking("B1", "U1", "E1", LocalDateTime.now(), BookingStatus.CONFIRMED);
        assertEquals(BookingStatus.CONFIRMED, b.getBookingStatus());
    }

    @Test
    void testInvalidCapacity() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Workshop("E1", "Bad", LocalDateTime.now(), "Room", 0, "OOP");
        });
    }
}
