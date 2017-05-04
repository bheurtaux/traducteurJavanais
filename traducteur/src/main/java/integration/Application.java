package integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import services.IServiceTraduction;
import services.impl.ServiceTraductionJavanais;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean("traducteur")
    public IServiceTraduction serviceTraductionJavanaise(){
    	return new ServiceTraductionJavanais();
    }
    

}
