package edu.iu.c322.orderservice.controller;

import edu.iu.c322.orderservice.Repository.CustomerRepository;
import edu.iu.c322.orderservice.Repository.InMemoryCustomerRepository;
import edu.iu.c322.orderservice.model.Invoice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class InvoiceController {

    //get localhost:8080/customers
    private CustomerRepository repository;

    public void CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    //INVOICE COMMANDS
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/invoices/{orderId}")
    public Invoice findInvoice(@PathVariable int id, int orderid) {
        InMemoryCustomerRepository myrepo = (InMemoryCustomerRepository) repository;
        return myrepo.getCustomerbyId(id).getOrders().get(orderid).getInvoice();
    }



    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/invoices/{orderId}")
    public void updateShippingstatus(@PathVariable int id, @RequestBody String status) {
        InMemoryCustomerRepository myrepo = (InMemoryCustomerRepository) repository;
        myrepo.getCustomerbyId(id).getOrders().get(id).getInvoice().setShippingStatus(status);
    }
}







