package hangman.web;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@WebListener
public class AppCtxListener implements ServletContextListener {
	
	public static final String SPTING_CTX_NAME = "Spring context";

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		arg0.getServletContext().setAttribute(SPTING_CTX_NAME, context);
		
	}

	
}
