package lorraineyul.demo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

public class CustomerRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomer() {
        // to do connect to real db
        return Collections.emptyList(
        );
    }
}
