package at.mycompany.mocks;

import at.mycompany.shop.catalog.core.impl.CatalogDataAccessImpl;
import at.mycompany.shop.catalog.core.model.jpa.Product;
import io.quarkus.test.Mock;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

@Mock
@ApplicationScoped
public class MockCatalogDataAccessImpl extends CatalogDataAccessImpl {
    @Override
    public Product getProductById(Integer id) {
        return new Product(id, "Getrocknete Apfelstücke 500 Gramm", new BigDecimal("7.99"));
    }
}