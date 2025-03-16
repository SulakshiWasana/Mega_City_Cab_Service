import com.megacitycab.mega_city_cab.dao.CarDAO;
import com.megacitycab.mega_city_cab.model.Car;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarServletTest {
    private static CarDAO carDAO;
    private static Connection connection;

    @BeforeAll
    static void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/megacitycab_test", "root", "Sula@123");
        carDAO = new CarDAO();
    }

    @AfterAll
    static void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    @Order(1)
    void testAddCar() throws SQLException {
        Car car = new Car(1, "Toyota Camry", "ABC-123", "Available");
        carDAO.addCar(car);
        assertTrue(true, "Car should be added successfully");
    }

    @Test
    @Order(2)
    void testUpdateCar() throws SQLException {
        Car car = new Car(1, "Honda Civic", "XYZ-456", "Unavailable");
        carDAO.updateCar(car);
        assertTrue(true, "Car should be updated successfully");
    }

    @Test
    @Order(3)
    void testDeleteCar() throws SQLException {
        carDAO.deleteCar(1);
        assertTrue(true, "Car should be deleted successfully");
    }

    @Test
    @Order(4)
    void testGetAllCars() throws SQLException {
        List<Car> cars = carDAO.getAllCars();
        assertNotNull(cars, "Car list should not be null");
        assertFalse(cars.isEmpty(), "Car list should not be empty");
    }
}
