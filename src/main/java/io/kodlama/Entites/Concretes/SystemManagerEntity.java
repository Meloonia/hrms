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
import java.io.Serializable;

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

    @NotNull
    @NotBlank
    @Column(name = "system_manager_name",nullable = false)
    private String SystemManagerName;
    @NotNull
    @NotBlank
    @Column(name = "system_manager_surname",nullable = false)
    private String SystemManagersurname;
    @NotNull
    @NotBlank
    @Email
    @Column(name = "system_manager_email",nullable = false)
    private String SystemManagerEmail;
    @NotNull
    @NotBlank
    @Column(name = "system_manager_phone")
    private String SystemManagerPhone;
    @NotNull
    @NotBlank
    @Column(name = "system_manager_adress")
    private String SystemManagerAdress;

    @OneToOne( fetch =  FetchType.LAZY , cascade = CascadeType.ALL)

    @JoinColumn(referencedColumnName = "user_id")

    private UserEntity user;

}
