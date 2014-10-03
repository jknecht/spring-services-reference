package example.web.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import example.web.controller.IndexController;

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
