package UMS.service;


import UMS.dto.PersonDTO;
import UMS.dto.UserDTO;
import UMS.entity.PersonEntity;
import UMS.entity.UserEntity;
import UMS.mapping.PersonMapper;
import UMS.mapping.UserMapper;
import UMS.repository.PersonRepo;
import UMS.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Service
public class PersonService {
    private final PersonRepo repo;
    private final UserRepo userRepo;

    public PersonService(PersonRepo repo, UserRepo userRepo) {this.repo = repo;
        this.userRepo = userRepo;
    }





    public void save(PersonDTO dto) {
        PersonEntity entity = PersonMapper.Mapping.mapToEntity(dto);
            repo.save(entity);
    }

    public void update(PersonEntity person){
        PersonEntity entity=repo.getById(person.getId());

        entity.setName(person.getName());
        entity.setSurname(person.getSurname());
        entity.setPatronymicName(person.getPatronymicName());
        entity.setFin(person.getFin());
        entity.setGender(person.getGender());
        entity.setBirthDate(person.getBirthDate());
        entity.setMarriageStatus(person.getMarriageStatus());
        entity.setAddress(person.getAddress());
        entity.setWorkDetails(person.getWorkDetails());
        entity.setEducation(person.getEducation());

        repo.save(entity);
    }

    public List<PersonDTO> getPersons(){
        return PersonMapper.Mapping.mapToDtoList(repo.findAll());
    }

    public PersonDTO getById(Long id){
        return PersonMapper.Mapping.mapToDto(repo.getById(id));
    }

    public List<UserDTO> getUsers(Long pId){
        return userRepo.findAll().stream()
                .filter(x -> Objects.equals(x.getPerson().getId(), pId))
                .map(UserMapper.Mapping::mapToDto)
                .collect(Collectors.toList());
    }

    public void deleteAll(){
        userRepo.deleteAll();
        repo.deleteAll();
    }

    public void deleteById(Long id){

        for (UserEntity entity: userRepo.findAll()){
            if (Objects.equals(entity.getPerson().getId(), id)){
                userRepo.delete(entity);
            }
        }
    }
}