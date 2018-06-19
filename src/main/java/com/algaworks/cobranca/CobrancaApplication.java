package com.algaworks.cobranca;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class CobrancaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CobrancaApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

	
	@Configuration
	public static class MvcConfig implements WebMvcConfigurer {
		
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addRedirectViewController("/", "/titulos");
		}
	
	}
	
	/*	
	@Configuration
	@EnableWebMvc
	@ComponentScan("com.algaworks.cobranca")
	public static class ThymeleafConfig implements WebMvcConfigurer, ApplicationContextAware {

		private ApplicationContext applicationContext;

		@Override
		public void setApplicationContext(ApplicationContext appCtx)
				throws BeansException {
			this.applicationContext = appCtx;
			
		}
		
		@Bean
		public ViewResolver viewResolver() {
			ThymeleafViewResolver resolver = new ThymeleafViewResolver();
			//resolver.setTemplateEngine((ISpringTemplateEngine) templateEngine());
			resolver.setCharacterEncoding("UTF-8");
			return resolver;
		}

		@Bean
		public TemplateEngine templateEngine() {
			SpringTemplateEngine engine = new SpringTemplateEngine();
			engine.setEnableSpringELCompiler(true);
			engine.setTemplateResolver(templateResolver());
			return engine;
		}

		private ITemplateResolver templateResolver() {
			SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
			resolver.setApplicationContext(applicationContext);
			resolver.setPrefix("/templates/");
			resolver.setTemplateMode(TemplateMode.HTML);
			return resolver;
		}

	}	
	 */	
}
