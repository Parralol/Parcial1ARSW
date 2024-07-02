package parcial.arsw.parcial1.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import parcial.arsw.parcial1.model.Client;

@RestController
public class Parcial1Controller {
    private  Client client = new Client();

    @RequestMapping(value = "/status", method = RequestMethod.GET, produces = "application/json")
    public String status() {
        return "{\"status\":\"Greetings from Spring Boot. "
                + java.time.LocalDate.now() + ", "
                + java.time.LocalTime.now()
                + ". " + "The server is Runnig!\"}";
    }

    @GetMapping("/rest")
    public String search(@RequestParam(value = "quer", defaultValue = "MSFT") String val, @RequestParam(value = "type", defaultValue = "TIME_SERIES_DAILY_ADJUSTED") String type) throws IOException{
        return client.invoke(val, type);
    }
}
