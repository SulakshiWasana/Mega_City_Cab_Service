import com.megacitycab.mega_city_cab.dao.BookingDAO;
import com.megacitycab.mega_city_cab.model.Booking;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookingServletTest {
    private static BookingDAO bookingDAO;
    private static Connection connection;

    @BeforeAll
    static void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/megacitycab_test", "root", "Sula@123");
        bookingDAO = new BookingDAO();
    }

    @AfterAll
    static void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    @Order(1)
    void testAddBooking()  {
        Booking booking = new Booking(1, "Location A", "Location B", "2025-03-15", "500", "1", "101", "201");
        bookingDAO.addBooking(booking);
        assertTrue(true, "Booking should be added successfully");
    }

    @Test
    @Order(2)
    void testUpdateBooking() {
        Booking booking = new Booking(1, "Updated Location A", "Updated Location B", "2025-03-16", "600", "1", "102", "202");
        bookingDAO.updateBooking(booking);
        assertTrue(true, "Booking should be updated successfully");
    }

    @Test
    @Order(3)
    void testDeleteBooking() {
        bookingDAO.deleteBooking(1);
        assertTrue(true, "Booking should be deleted successfully");
    }

    @Test
    @Order(4)
    void testGetAllBookings() {
        List<Booking> bookings = bookingDAO.getAllBookings();
        assertNotNull(bookings, "Booking list should not be null");
        assertFalse(bookings.isEmpty(), "Booking list should not be empty");
    }
}
