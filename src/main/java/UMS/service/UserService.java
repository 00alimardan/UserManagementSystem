package UMS.service;

import UMS.dto.UserDTO;
import UMS.entity.UserEntity;
import UMS.mapping.UserMapper;
import UMS.repository.PersonRepo;
import UMS.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepo repo;
    private final PersonRepo personRepo;

    public UserService(UserRepo repo, PersonRepo personRepo) {
        this.repo = repo;
        this.personRepo = personRepo;
    }

    public void save(Long pId, UserDTO dto){
        var entity = UserEntity.builder()
                .userName(dto.getUserName())
                .password(dto.getPassword())
                .person(personRepo.getById(pId)).build();

        repo.save(entity);
    }


    public void update(Long pId, UserEntity user){
        var entity = repo.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("YOU AREN'T FOUND!"));

        if (Objects.equals(entity.getPerson().getId(), pId)){
            entity.setUserName(user.getUserName());
            entity.setPassword(user.getPassword());
        }
        repo.save(entity);
    }

    public List<UserDTO> getAll(){

        return UserMapper.Mapping.mapToDtoList(repo.findAll());
    }

    public UserDTO getById(Long id){
        return UserMapper.Mapping.mapToDto(repo.getById(id));
    }

    public void deleteAll(){
        repo.deleteAll();
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }
}
