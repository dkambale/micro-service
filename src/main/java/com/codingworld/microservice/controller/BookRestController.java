package com.codingworld.microservice.controller;

import com.codingworld.microservice.bean.Book;
import com.codingworld.microservice.bean.ResponseWithPort;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookRestController {

  @Value("${server.port}")
  private String serverPort;

  @GetMapping("/all")
  public List<Book> getAll(){
    return List.of(
        new Book(501, "Head First Java", 439.75),
        new Book(502, "Spring in Action", 340.75),
        new Book(503, "Hibernate in Action", 355.75)
    );
  }

  @GetMapping("/allbook")
  public ResponseWithPort getAllBook(){
    ResponseWithPort response=new ResponseWithPort();

    List<Book> books=List.of(
        new Book(501, "Head First Java", 439.75),
        new Book(502, "Spring in Action", 340.75),
        new Book(503, "Hibernate in Action", 355.75));
    response.setData(books);
    String port=System.getProperty("server.port");
    response.setPort(serverPort);
    return response;
  }

}
