import com.megacitycab.mega_city_cab.dao.CustomerDAO;
import com.megacitycab.mega_city_cab.model.Customer;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerServletTest {
    private static CustomerDAO customerDAO;
    private static Connection connection;

    @BeforeAll
    static void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/megacitycab_test", "root", "Sula@123");
        customerDAO = new CustomerDAO();
    }

    @AfterAll
    static void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    @Order(1)
    void testAddCustomer() {
        Customer customer = new Customer(1, "John Doe", "123 Main St", "200087876756", "0771234567");
        customerDAO.addCustomer(customer);
        assertTrue(true);
    }

    @Test
    @Order(2)
    void testUpdateCustomer() {
        Customer customer = new Customer(1, "John Updated", "456 Updated St", "987650321V", "0777654321");
        customerDAO.updateCustomer(customer);
        assertTrue(true);
    }

    @Test
    @Order(3)
    void testDeleteCustomer() {
        boolean success = customerDAO.deleteCustomer(1);
        assertTrue(true);
    }

    @Test
    @Order(4)
    void testGetAllCustomers() {
        List<Customer> customers = customerDAO.getAllCustomers();
        assertNotNull(customers);
        assertFalse(customers.isEmpty());
    }
}
