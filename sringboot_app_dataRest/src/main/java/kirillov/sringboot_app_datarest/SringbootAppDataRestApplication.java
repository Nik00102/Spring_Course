package kirillov.sringboot_app_datarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SringbootAppDataRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SringbootAppDataRestApplication.class, args);

        // Для actuator используем следующие endPoints:
        // /actuator/health - поднято ли приложение
        // /actuator/info - информация о приложении
        // /actuator/beans (mappings) - информация о Beans (по умолчанию выкл, нужно прописать в application.properties
        // для включения - management.endpoints.web.exposure.include=beans, mappings либо management.endpoints.web.exposure.include=*)

        // Для security можно использовать следующее:
        // spring.security.user.name=nik
        // spring.security.user.password=kirillov

        // dependency в pom файл:
        //        <dependency>
        //            <groupId>org.springframework.boot</groupId>
        //            <artifactId>spring-boot-starter-security</artifactId>
        //        </dependency>

    }

}
