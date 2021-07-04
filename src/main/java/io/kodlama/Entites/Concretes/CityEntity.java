package io.kodlama.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "city")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityId;

    @Column(name = "city_name")
    private String cityname;

    @OneToMany(mappedBy = "cityId" , fetch = FetchType.LAZY)
    private Set<EmployerEntity> employerEntity = new HashSet<>();

}
