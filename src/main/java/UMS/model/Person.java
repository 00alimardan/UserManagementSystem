package UMS.model;

import UMS.entity.Gender;
import UMS.entity.MarriageStatus;

import java.time.LocalDateTime;


public class Person {

    private Long id;
    private String name;
    private String surname;
    private String patronymicName;
    private String fin;
    private Gender gender;
    private String birthDate;
    private MarriageStatus marriageStatus;
    private String nationality;
    private String address;
    private String workDetails;
    private String education;
    private LocalDateTime createdAt;
}
