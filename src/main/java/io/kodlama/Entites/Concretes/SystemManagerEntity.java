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

public class SystemManagerEntity {




    @Id
    @Column(name = "system_manager_id")

    private long systemManagerId;
    @NotNull
    @NotBlank
    @Column(name = "system_manager_name")
    private String SystemManagerName;
    @NotNull
    @NotBlank
    @Column(name = "system_manager_surname")
    private String SystemManagersurname;
    @NotNull
    @NotBlank
    @Email
    @Column(name = "system_manager_email")
    private String SystemManagerEmail;
    @NotNull
    @NotBlank
    @Column(name = "system_manager_phone")
    private String SystemManagerPhone;
    @NotNull
    @NotBlank
    @Column(name = "system_manager_adress")
    private String SystemManagerAdress;

    @ManyToOne( fetch =  FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;


}
