package io.kodlama.Entites.Concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "system_managers")

public class SystemManagerEntity {


    @JoinColumn(name = "system_manager_id")

    @Id
    @Column(name = "system_manager_id")

    private long systemManagerId;

    @Column(name = "system_manager_name")
    private String SystemManagerName;

    @Column(name = "system_manager_surname")
    private String SystemManagersurname;

    @Column(name = "system_manager_email")
    private String SystemManagerEmail;

    @Column(name = "system_manager_phone")
    private String SystemManagerPhone;

    @Column(name = "system_manager_adress")
    private String SystemManagerAdress;

    @ManyToOne( fetch =  FetchType.LAZY , cascade = CascadeType.ALL)

    private UserEntity user;


}
