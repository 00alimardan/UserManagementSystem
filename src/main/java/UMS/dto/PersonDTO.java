package UMS.dto;

import UMS.entity.Gender;
import UMS.entity.MarriageStatus;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
public class PersonDTO implements Serializable {

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

}
