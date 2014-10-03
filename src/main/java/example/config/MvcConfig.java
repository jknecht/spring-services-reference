package example.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Configuration for Spring Web MVC.
 * 
 * @author jeff.knecht
 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
 */
@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

    /**
     * Sets up the /resources/ directory (and its subdirectories) to bypass controller resolution.
     * This is where you put things like javascript libraries, images, and stylesheets.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    /**
     * Provides a ViewResolver that produces the correct view based on the content that
     * is being returned to the client.  In our case, this will either be a JSP or
     * JSON content.
     * 
     * @param manager
     * @return
     */
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {

        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

        // resolve traditional web pages
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setViewClass(JstlView.class);
        resolvers.add(internalResourceViewResolver);

        // resolve JSON requests
        JsonViewResolver jsonViewResolver = new JsonViewResolver();
        resolvers.add(jsonViewResolver);

        // Choose the right resolver based on the type of request
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setViewResolvers(resolvers);
        resolver.setContentNegotiationManager(manager);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
