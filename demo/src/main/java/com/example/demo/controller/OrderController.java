package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.model.OrdersProducts;
import com.example.demo.model.Product;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.OrdersProductsRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

@Autowired
private OrdersProductsRepository ordersProductsRepository;
    @Autowired
    private OrderRepository orderRepository;


@GetMapping("/getOrders")
public List<Order> getOrder(){
    List<Order> order = orderRepository.findAll();
    return order;
}

@GetMapping(value = "/{orderId}")
public Order getOrderById(@PathVariable("orderId") int orderId){

    Order order = orderRepository.getOne(orderId);

   return order;

}


@GetMapping(value = "/getOrderProducts/{orderId}")
public List<OrdersProducts> getOrderProducts(@PathVariable("orderId") int orderId){

   return ordersProductsRepository.findByOrder_IdOrder(orderId);
}


@PostMapping("/addNewOrder")
    public ResponseEntity<String> addOrder(  @RequestBody
                                             @NotEmpty(message = "Input movie list cannot be empty.")
                                             List<OrdersProducts> ordersProducts)
    {
    orderService.addOrdersToDatabase(ordersProducts);
    return  new ResponseEntity<>("Zamówienia zostały dodane", HttpStatus.OK);

}



    @GetMapping( value = "getOrdersProducts/{orderId}")
    public List<OrdersProducts> getOrdersProducts(@PathVariable("orderId") int orderId){

        return ordersProductsRepository.findByOrder_IdOrder(orderId);

    }

    @GetMapping( value = "deleteById/{orderId}")
    public ResponseEntity<String> deleteOrderById(@PathVariable("orderId") int orderId){

        orderService.deleteOrderById(orderId);
        return  new ResponseEntity<>("Zamówienie zostało usunięte", HttpStatus.OK);
    }

    @PostMapping(value = "/addProductToOrder/{orderId}")
    public ResponseEntity<String> addProductToOrder(@PathVariable("orderId") int orderId, @RequestBody List<OrdersProducts> orderProducts) {
    orderService.addProductsToOrder(orderId, orderProducts);
        return  new ResponseEntity<>("Zamówienie zostało usunięte", HttpStatus.OK);
    }
}
