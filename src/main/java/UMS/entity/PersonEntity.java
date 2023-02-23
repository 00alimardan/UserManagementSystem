package UMS.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="persons", schema = "ums")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="patronymic_name")
    private String patronymicName;

    @Column(name="fin", unique = true)
    private String fin;

    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name="birth_date")
    private String birthDate;

    @Column(name="marriage_status")
    @Enumerated(value=EnumType.STRING)
    private MarriageStatus marriageStatus;

    @Column(name="nationality")
    private String nationality;

    @Column(name="address")
    private String address;

    @Column(name="work_details")
    private String workDetails;

    @Column(name="education")
    private String education;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
