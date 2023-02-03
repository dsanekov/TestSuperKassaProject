package main.controllers;

import main.dto.Response;
import main.services.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {
    private final Service service;

    public Controller(Service indexingService) {
        this.service = indexingService;
    }

    @PostMapping("/modify")
    public ResponseEntity<Object> modify(@RequestParam(name = "id") int id,
                                      @RequestParam(name = "add") int add){
        Response response = service.modify(id,add);
        if(response.getCurrent() == -1){
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
