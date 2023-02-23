package UMS.repository;

import UMS.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepo extends JpaRepository<PersonEntity, Long> {
}
