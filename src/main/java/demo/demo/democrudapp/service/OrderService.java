package demo.demo.democrudapp.service;

import demo.demo.democrudapp.model.Order;
import demo.demo.democrudapp.model.Product;
import demo.demo.democrudapp.repository.OrderRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> findOrderById(Long id) {
        return orderRepository.findOrderById(id);
    }

    public Order createNewOrder(Order order) {
        return orderRepository.save(order);
    }

    public String updateOrder(Order order) {
        String response = "";
        Optional<Order> currentOrder = orderRepository.findById(order.getId());
        if (currentOrder.isPresent()) {
            orderRepository.save(order);
            response = "Order was updated in database!";
        } else {
            response = "Order with id " + order.getId() + " was not found. Database was not updated!";
        }
        return response;
    }

    public String deleteOrderById(Long id) {
        String response = "";
        Optional<Order> currentOrder = orderRepository.findById(id);
        if (currentOrder.isPresent()) {
            orderRepository.deleteById(id);
            response = "Order with id " + id + " deleted from database!";
        } else {
            response = "Order with id " + id + " was not found. Database was not updated!";
        }
        return response;
    }

//    public String deleteProductFromOrder(Long idProduct, Long idOrder){
//
//    }
}
