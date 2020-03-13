package at.mycompany.shop.architecture.web.resource;

import at.mycompany.shop.domain.model.entity.Order;
import at.mycompany.shop.domain.service.OrderDataAccess;
import at.mycompany.shop.domain.service.OrderService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

@Path("/v1/orders")
@Transactional
public class OrderResource {

    @Inject
    OrderDataAccess catalogDataAccess;
    @Inject
    OrderService catalogService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addOrder(Order order) {
        Integer orderId = catalogService.createOrder(order);
        return Response.status(Response.Status.CREATED).entity(orderId).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrders() {
        List<Order> orders = catalogDataAccess.getOrders();
        return Response.status(Response.Status.OK).entity(orders).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getOrderById(@PathParam("id") Integer id) {
        Order order = catalogDataAccess.getOrderById(id);
        if(order == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Resource not found for ID: " + id)
                    .type(MediaType.TEXT_PLAIN).build();
        }
        return Response.status(Response.Status.OK).entity(order).build();
    }
}