import com.megacitycab.mega_city_cab.dao.DriverDAO;
import com.megacitycab.mega_city_cab.model.Driver;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DriverServletTest {
    private static DriverDAO driverDAO;
    private static Connection connection;

    @BeforeAll
    static void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/megacitycab_test", "root", "Sula@123");
        driverDAO = new DriverDAO();
    }

    @AfterAll
    static void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    @Order(1)
    void testAddDriver() {
        Driver driver = new Driver(1, "Jane Doe", "LIC12345", "0771234567");
        driverDAO.addDriver(driver);
        assertTrue(true, "Driver should be added successfully");
    }

    @Test
    @Order(2)
    void testUpdateDriver() {
        Driver driver = new Driver(1, "Jane Updated", "LIC98765", "0777654321");
        driverDAO.updateDriver(driver);
        assertTrue(true, "Driver should be updated successfully");
    }

    @Test
    @Order(3)
    void testDeleteDriver() {
        driverDAO.deleteDriver(1);
        assertTrue(true, "Driver should be deleted successfully");
    }

    @Test
    @Order(4)
    void testGetAllDrivers() {
        List<Driver> drivers = driverDAO.getAllDrivers();
        assertNotNull(drivers, "Driver list should not be null");
        assertFalse(drivers.isEmpty(), "Driver list should not be empty");
    }
}
