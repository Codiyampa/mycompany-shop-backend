package at.mycompany.shop.architecture.web.resource;

import at.mycompany.shop.domain.model.entity.Product;
import at.mycompany.shop.application.ProductDataAccessImpl;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author: Codiyampa
 * @date: 13.03.2020
 */

@Path("/v1/products")
@Transactional
public class ProductResource {

    @Inject
    ProductDataAccessImpl productDataAccess;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        List<Product> products = productDataAccess.getProducts();
        return Response.status(Response.Status.OK).entity(products).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getProductById(@PathParam("id") Integer id) {
        Product product = productDataAccess.getProductById(id);
        if(product == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Resource not found for ID: " + id)
                    .type(MediaType.TEXT_PLAIN).build();
        }
        return Response.status(Response.Status.OK).entity(product).build();
    }
}