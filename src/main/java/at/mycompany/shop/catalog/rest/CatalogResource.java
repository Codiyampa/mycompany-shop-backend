package at.mycompany.shop.catalog.rest;

import at.mycompany.shop.catalog.core.impl.CatalogDataAccessImpl;
import at.mycompany.shop.catalog.core.model.jpa.Product;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

@Path("/catalog")
public class CatalogResource {

    @Inject
    CatalogDataAccessImpl catalogDataAccess;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/products/")
    public Response getProducts() {
        List<Product> products = catalogDataAccess.getProducts();
        if(products == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("No products found").build();
        }
        return Response.status(Response.Status.OK).entity(products).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/products/{id}")
    public Response getProductById(@PathParam("id") Integer id) {
        Product product = catalogDataAccess.getProductById(id);
        if(product == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Resource not found for ID: " + id).build();
        }
        return Response.status(Response.Status.OK).entity(product).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/status")
    public String online() {
        return "online";
    }
}