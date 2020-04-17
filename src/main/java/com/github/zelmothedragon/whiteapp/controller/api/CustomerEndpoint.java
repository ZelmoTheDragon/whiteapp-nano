package com.github.zelmothedragon.whiteapp.controller.api;

import com.github.zelmothedragon.whiteapp.model.entity.Customer;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerEndpoint {

    public CustomerEndpoint() {
    }

    @GET
    @Path("/list")
    public List<Customer> save() {
        return Customer.find();
    }

}
