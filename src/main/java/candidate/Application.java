package candidate;

import candidate.Candidate;

import java.util.Arrays;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.stream.Stream;


@EnableSwagger2
@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");


        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

    @Bean
  ApplicationRunner init(CandidateRepository repository) {
    // Most recently updated: 2/27/20, https://www.realclearpolitics.com/epolls/2020/president/us/2020_democratic_presidential_nomination-6730.html
    String[][] data = {
        {"Bernie", "Sanders", "DEMOCRAT", "2020", "29.5"},
        {"Joe", "Biden", "DEMOCRAT", "2020", "18.0"},
        {"Michael", "Bloomberg", "DEMOCRAT", "2020", "14.7"},
        {"Elizabeth", "Warren", "DEMOCRAT", "2020", "12.0"},
        {"Pete", "Buttigieg", "DEMOCRAT", "2020", "10.3"},
        {"Amy", "Klobuchar", "DEMOCRAT", "2020", "5.3"},
        {"Tulsi", "Gabbard", "DEMOCRAT", "2020", "2.2"},
        {"Donald", "Trump", "REPUBLICAN", "2020", "85.4"},
        {"Bill", "Weld", "REPUBLICAN", "2020", "2.8"},
    };

    return args -> {
      Stream.of(data).forEach(array -> {
        try {
          Candidate candidate = new Candidate(
              array[0],
              array[1],
              Party.valueOf(array[2]),
              array[3],
              Double.parseDouble(array[4])
          );
          repository.save(candidate);
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      });
      repository.findAll().forEach(System.out::println);
    };
  }

}
