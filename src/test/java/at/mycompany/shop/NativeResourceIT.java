package at.mycompany.shop;

import at.mycompany.shop.tests.ResourceTest;
import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeResourceIT extends ResourceTest {

    // Execute the same tests but in native mode.
}