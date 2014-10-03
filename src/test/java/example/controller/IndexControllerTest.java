package example.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IndexControllerTest {

    IndexController controller;

    @Before
    public void setup() {
        controller = new IndexController();
    }

    @Test
    public void indexShouldReturnReferenceToCorrectPage() {
        String response = controller.index();
        assertEquals(IndexController.INDEX_PAGE, response);
    }

}
