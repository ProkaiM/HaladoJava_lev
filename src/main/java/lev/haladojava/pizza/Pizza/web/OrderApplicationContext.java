package lev.haladojava.pizza.Pizza.web;

import lev.haladojava.pizza.Pizza.persist.HamburgerDAO;
import lev.haladojava.pizza.Pizza.persist.HamburgerDAOlmpl;
import lev.haladojava.pizza.Pizza.service.HamburgerService;
import lev.haladojava.pizza.Pizza.service.HamburgerServicelmpl;
import lev.haladojava.pizza.Pizza.persist.HotDogDAO;
import lev.haladojava.pizza.Pizza.persist.HotDogDAOImpl;
import lev.haladojava.pizza.Pizza.service.HotDogService;
import lev.haladojava.pizza.Pizza.service.HotDogServicelmpl;
import lev.haladojava.pizza.Pizza.persist.PizzaDAO;
import lev.haladojava.pizza.Pizza.persist.PizzaDAOlmpl;
import lev.haladojava.pizza.Pizza.service.PizzaService;
import lev.haladojava.pizza.Pizza.service.PizzaServicelmpl;
import lev.haladojava.pizza.Pizza.persist.OrderDAO;
import lev.haladojava.pizza.Pizza.persist.OrderDAOImpl;
import lev.haladojava.pizza.Pizza.service.OrderService;
import lev.haladojava.pizza.Pizza.service.OrderServicelmpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "lev.haladojava.pizza.Pizza.controller")
public class OrderApplicationContext {

	 @Bean
	    public HamburgerService hamburgerService() {
	        return new HamburgerServicelmpl(hamburgerDAO());
	    }

	    @Bean(name = "HamburgerDAO")
	    public HamburgerDAO hamburgerDAO() {
	        return new HamburgerDAOlmpl();
	    }
	    
	    @Bean
	    public HotDogService hotdogService() {
	        return new HotDogServicelmpl(hotdogDAO());
	    }

	    @Bean(name = "HotDogDAO")
	    public HotDogDAO hotdogDAO() {
	        return new HotDogDAOImpl();
	    }
	    
	    @Bean
	    public PizzaService pizzaService() {
	        return new PizzaServicelmpl(pizzaDAO());
	    }

	    @Bean(name = "PizzaDAO")
	    public PizzaDAO pizzaDAO() {
	        return new PizzaDAOlmpl();
	        	        
	    }
	    
	    @Bean
	    public OrderService orderService() {
	        return new OrderServicelmpl(orderDAO());
	    }

	    @Bean(name = "OrderDAO")
	    public OrderDAO orderDAO() {
	        return new OrderDAOImpl();
	    }
}