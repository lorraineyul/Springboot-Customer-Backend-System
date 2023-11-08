package lorraineyul.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {
    @Autowired
    private  CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        // given
        Customer jane = new Customer(1L, "jane", "123", "jane@gmail.com");
        Customer ali = new Customer(2L, "ali", "123", "ali@gmail.com");

        customerRepository.saveAll(Arrays.asList(jane, ali));

        //when
        List<Customer> customers = underTest.getCustomers();

        // then
        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        //given
        Customer jane = new Customer(1L, "jane", "123", "jane@gmail.com");

        customerRepository.save(jane);

        // when
        Customer actual = underTest.getCustomer(1L);

        // then
        assertEquals(1L, actual.getId());
        assertEquals("jane", actual.getName());
        assertEquals("123", actual.getPassword());
        assertEquals("jane@gmail.com", actual.getEmail());
    }
}