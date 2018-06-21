package run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Arrays;

//@Configuration
//@EnableAutoConfiguration
@ComponentScan({"controller"})
//@EntityScan({"net.atos.qhc.entity"})
//@EnableJpaRepositories("net.atos.qhc.repository")
//@EnableScheduling
//@EnableCaching
@SpringBootApplication
public class Application/* extends WebMvcConfigurationSupport*/ {
    public static void main(String[] args){
        String separator = ",";
        Arrays.asList( "a", "b", "d" ).forEach(
                ( String e ) -> System.out.print( e + separator ) );
        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
    }
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.setUseSuffixPatternMatch(false)
//                .setUseTrailingSlashMatch(true);
//    }
}
