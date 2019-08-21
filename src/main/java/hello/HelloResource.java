package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/api/hello")
public class HelloResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String getHello(@PathVariable(value = "name") String name) {
      /*  ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:8080/api/hello/"+name, String.class);
        return response.getBody();*/
        
        return this.restTemplate.getForObject("http://localhost:8080/api/hello/"+name, String.class);
    }
}
