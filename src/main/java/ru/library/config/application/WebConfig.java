package ru.library.config.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import ru.library.dao.BookDao;
import ru.library.dao.BookDaoImpl;
import ru.library.service.BookService;
import ru.library.service.BookServiceImpl;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan({ "ru.library.config", "ru.library.controllers" })
public class WebConfig {
 
@Bean
 public InternalResourceViewResolver viewResolver() {
 InternalResourceViewResolver viewResolver
 = new InternalResourceViewResolver();
 viewResolver.setViewClass(JstlView.class);
 viewResolver.setPrefix("/WEB-INF/views/");
 viewResolver.setSuffix(".jsp");
 return viewResolver;
 }

 @Bean
 public JdbcTemplate getJdbcTemplate(){
  return new JdbcTemplate(getDataSource());
 }

 @Bean
 public DataSource getDataSource() {
  DriverManagerDataSource dataSource = new DriverManagerDataSource();
  dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres?useSll=false");
  dataSource.setDriverClassName("org.postgresql.Driver");
  return dataSource;
 }

 @Bean
 public BookDao getBookDao(){
 return new BookDaoImpl(getJdbcTemplate());
 }

 @Bean
 public BookService getBookService(){
 return new BookServiceImpl();
 }
}
