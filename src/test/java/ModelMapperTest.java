import org.java.learn.spring.tool.Address;
import org.java.learn.spring.tool.Customer;
import org.java.learn.spring.tool.Name;
import org.java.learn.spring.tool.Order;
import org.java.learn.spring.tool.OrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * 作用:
 * User: duqi
 * Date: 2017/9/1
 * Time: 13:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ModelMapperTest {

    @Test
    public void testModelMapper() {
        Name name = new Name("du", "qi");
        Address address = new Address("111street", "222city");
        Customer customer = new Customer(name);
        Order order = new Order(customer, address);

        ModelMapper modelMapper = new ModelMapper();
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

        assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
        assertEquals(order.getCustomer().getName().getLastName(), orderDTO.getCustomerLastName());
        assertEquals(order.getBillingAddress().getStreet(), orderDTO.getBillingStreet());
        assertEquals(order.getBillingAddress().getCity(), orderDTO.getBillingCity());
    }
}
