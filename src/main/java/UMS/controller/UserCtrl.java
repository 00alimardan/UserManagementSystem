package UMS.controller;

import UMS.dto.UserDTO;
import UMS.entity.UserEntity;
import UMS.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ums/user")
public class UserCtrl {

    private final UserService service;
    public UserCtrl(UserService service) {
        this.service = service;
    }

    @PostMapping("/save/{pId}")
    public void save(@PathVariable Long pId, @RequestBody UserDTO dto){

        service.save(pId,dto);
    }
    @PutMapping("/updt/{pId}")
    public void update(@PathVariable Long pId, @RequestBody UserEntity user){
        service.update(pId, user);
    }

    @GetMapping("/all")
    public List<UserDTO> getAll(){
        return service.getAll();

    }
    @GetMapping("/gID/{id}")
    public UserDTO getById(@PathVariable Long id){
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
