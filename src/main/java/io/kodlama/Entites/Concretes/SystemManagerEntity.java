package io.kodlama.Entites.Concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import static io.kodlama.Utils.ValidationMessages.*;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "system_managers")
public class SystemManagerEntity{


    @Id
    @Column(name = "system_manager_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long systemManagerId ;

    @NotNull(message = nameNull)
    @NotBlank(message = nameBlank)
    @Size(min = 3 , message = nameLenght)
    @Column(name = "system_manager_name",nullable = false)
    private String SystemManagerName;

    @NotNull(message = surNameNull)
    @NotBlank(message = surNameBlank)
    @Size(min =3 , message = surNameSize)
    @Column(name = "system_manager_surname",nullable = false)
    private String SystemManagersurname;

    @NotNull(message = phoneNull)
    @NotBlank(message = phoneBlank)
    @Size(min = 10,max = 10,message = phoneSize)
    @Column(name = "system_manager_phone",nullable = false)
    private String SystemManagerPhone;


    @NotNull(message = adressNull)
    @NotBlank(message = adressBlank)
    @Column(name = "system_manager_adress")
    private String SystemManagerAdress;

    @OneToOne( fetch =  FetchType.LAZY , cascade = CascadeType.ALL)

    @JoinColumn(referencedColumnName = "user_id")

    private UserEntity user;

}
