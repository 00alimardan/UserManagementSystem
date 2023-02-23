package UMS.model;




import UMS.entity.PersonEntity;

import java.time.LocalDateTime;


public class User {

    private Long id;
    private String userName;
    private String password;
    private LocalDateTime createdAt;
    private PersonEntity person;
}
