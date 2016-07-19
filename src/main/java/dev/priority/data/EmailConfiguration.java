package dev.priority.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource("application.properties")
public class EmailConfiguration {


  @Value("${userName}")
  protected String userName;

  @Value("${password}")
  protected String password;

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

}
