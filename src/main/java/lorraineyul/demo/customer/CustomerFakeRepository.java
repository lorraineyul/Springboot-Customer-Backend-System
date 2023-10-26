package lorraineyul.demo.customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomer() {
        return Arrays.asList(
                new Customer(1L, "James", "123", "email@gmail.com"),
                new Customer(2L, "Jamila", "456", "email@gmail.com")
        );
    }
}

