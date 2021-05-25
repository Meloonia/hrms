package io.kodlama.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "system_managers")
public class SystemManagerEntity {

    @Id
    @JoinColumn(name = "fk_user_id" , referencedColumnName = "user_id" )
    private long SystemManagerId;

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
}
