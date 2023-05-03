package first.folio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Folio1Application implements ConfigurableApplicationContext{


    public static void main(String[] args){
        SpringApplication.run(Folio1Application.class,args);

    }
}
