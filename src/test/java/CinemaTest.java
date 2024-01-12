import org.example.Cinema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CinemaTest {

    @Test
    void testBookSeats() {
        Cinema cinema = new Cinema(5, 10, 20);

        cinema.bookSeats(0, 2, new int[]{3, 4, 5});
        assertTrue(cinema.checkAvailability(0, 3));

        cinema.bookSeats(0, 3, new int[]{1, 2, 3, 4, 10, 15, 16, 17, 19});
        assertTrue(cinema.checkAvailability(0, 7));

        cinema.bookSeats(0, 2, new int[]{4, 5, 13});
        assertTrue(cinema.checkAvailability(0, 1));

        cinema.cancelBooking(0, 2, new int[]{4, 5, 13});
        assertTrue(cinema.checkAvailability(0, 3));
    }

    @Test
    void testCheckAvailability() {
        Cinema cinema = new Cinema(5, 3, 20);

        assertTrue(cinema.checkAvailability(1, 5));

        cinema.bookSeats(1, 1, new int[]{3, 4, 5, 9, 10, 11, 12, 13, 14, 19});
        cinema.bookSeats(1, 2, new int[]{3, 4, 5, 9, 10, 11, 12, 13, 14, 19});
        cinema.bookSeats(1, 3, new int[]{3, 4, 5, 9, 10, 11, 12, 13, 14, 19});
        assertFalse(cinema.checkAvailability(1, 5));

        cinema.cancelBooking(1, 2, new int[]{14});
        assertTrue(cinema.checkAvailability(1, 5));
    }

    @Test
    void testPrintSeatingArrangement() {
        Cinema cinema = new Cinema(2, 3, 5);
        cinema.bookSeats(0, 1, new int[]{1, 2, 3});
        cinema.bookSeats(1, 2, new int[]{1, 2, 4});

        cinema.printSeatingArrangement(0);
        System.out.println();
        cinema.printSeatingArrangement(1);
    }
}

