package UMS.controller;

import UMS.dto.PersonDTO;
import UMS.dto.UserDTO;
import UMS.entity.PersonEntity;
import UMS.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ums/person")
public class PersonCtrl {

    private final PersonService service;

    public PersonCtrl(PersonService service) {
        this.service = service;
    }


    @PostMapping("/save")
    public void save(@RequestBody PersonDTO person){

        service.save(person);
    }
    @PutMapping("/updt")

    public void update(@RequestBody PersonEntity person){

        service.update(person);
    }

    @GetMapping("/persons")
    public List<PersonDTO> getPeople(){

        return service.getPersons();
    }
    @GetMapping("/users/{pId}")
    public List<UserDTO> getUsers(@PathVariable Long pId){

        return service.getUsers(pId);
    }

    @GetMapping("/gID/{id}")
    public PersonDTO getById(@PathVariable Long id){

        return service.getById(id);
    }

    @DeleteMapping("/delAll")
    public void deleteAll(){

        service.deleteAll();
    }

    @DeleteMapping("/dID/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}
