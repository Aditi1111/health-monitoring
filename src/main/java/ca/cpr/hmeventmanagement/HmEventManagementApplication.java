package ca.cpr.hmeventmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan("ca.cpr.hmem.*")
public class HmEventManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HmEventManagementApplication.class, args);
    }

}
