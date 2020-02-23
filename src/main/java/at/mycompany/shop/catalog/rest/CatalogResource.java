package at.mycompany.shop.catalog.rest;

import at.mycompany.shop.catalog.core.impl.CatalogDataAccessImpl;
import at.mycompany.shop.catalog.core.impl.CatalogServiceImpl;
import at.mycompany.shop.catalog.core.model.jpa.Order;
import at.mycompany.shop.catalog.core.model.jpa.Product;

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

@Path("/catalog")
@Transactional
public class CatalogResource {

    @Inject
    CatalogDataAccessImpl catalogDataAccess;
    @Inject
    CatalogServiceImpl catalogService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/products")
    public Response getProducts() {
        List<Product> products = catalogDataAccess.getProducts();
        if(products == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("No resources found.")
                    .type(MediaType.TEXT_PLAIN).build();
        }
        return Response.status(Response.Status.OK).entity(products).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/products/{id}")
    public Response getProductById(@PathParam("id") Integer id) {
        Product product = catalogDataAccess.getProductById(id);
        if(product == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Resource not found for ID: " + id)
                    .type(MediaType.TEXT_PLAIN).build();
        }
        return Response.status(Response.Status.OK).entity(product).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/orders")
    public Response addOrder(Order order) {
        Integer orderId = catalogService.createOrder(order);
        return Response.status(Response.Status.CREATED).entity(orderId).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/orders/{id}")
    public Response getOrderById(@PathParam("id") Integer id) {
        Order order = catalogDataAccess.getOrderById(id);
        if(order == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Resource not found for ID: " + id)
                    .type(MediaType.TEXT_PLAIN).build();
        }
        return Response.status(Response.Status.OK).entity(order).build();
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/status")
    public String online() {
        return "online";
    }
}