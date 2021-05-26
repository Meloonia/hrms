package io.kodlama.Entites.Concretes;

import io.kodlama.Entites.Abstracts.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employers")
public class EmployerEntity implements UsersEntity {



    @Id
    @Column(name = "fk_user_id")

    private long userId;

    @Column(name = "employer_name")
    private String employerName;


    @Column(name = "employer_email")
    private String employerEmail;

    @Column(name = "employer_phone")
    private String employerPhone;

    @Column(name ="employer_adress")
    private String employerAdress;

    // Db Sektör Id ları dizi olarak eklenecek.

    @Column (name = "employer_website")
    private String EmployerWebsite;

    @PrimaryKeyJoinColumn(name = "fk_user_id",referencedColumnName = "user_id")
    @OneToOne
    UserEntity user;

    public EmployerEntity(UserEntity user) {

        this.userId = user.getUserId();
        this.user = user;
    }

}
