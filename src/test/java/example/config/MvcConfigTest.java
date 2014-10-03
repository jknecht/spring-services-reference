package example.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class MvcConfigTest {
    MvcConfig config;

    @Before
    public void setup() {
        config = new MvcConfig();
    }

    @Test
    public void viewResolversShouldBeCorrectlyConfigured() {
        ViewResolver viewResolver = config.contentNegotiatingViewResolver(new ContentNegotiationManager());
        assertTrue("viewResolver is not a ContentNegotiatingViewResolver", viewResolver instanceof ContentNegotiatingViewResolver);

        ContentNegotiatingViewResolver contentNegotiatingViewResolver = (ContentNegotiatingViewResolver) viewResolver;
        List<ViewResolver> viewResolvers = contentNegotiatingViewResolver.getViewResolvers();
        assertEquals(2, viewResolvers.size());

        boolean containsJsonViewResolver = false;
        boolean containsInternalViewResolver = false;
        for (ViewResolver resolver : viewResolvers) {
            if (resolver instanceof JsonViewResolver) {
                containsJsonViewResolver = true;
            }
            if (resolver instanceof InternalResourceViewResolver) {
                containsInternalViewResolver = true;
            }
        }

        assertTrue("Json View Resolver is not configured", containsJsonViewResolver);
        assertTrue("Internal Resource View Resolver is not configured", containsInternalViewResolver);
    }

}
