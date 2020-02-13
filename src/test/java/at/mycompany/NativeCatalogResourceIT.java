package at.mycompany;

import at.mycompany.tests.CatalogResourceTest;
import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeCatalogResourceIT extends CatalogResourceTest {

    // Execute the same tests but in native mode.
}