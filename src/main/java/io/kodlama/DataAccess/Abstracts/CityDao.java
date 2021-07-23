package io.kodlama.DataAccess.Abstracts;

import io.kodlama.Entites.Concretes.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<CityEntity,Integer> {

    CityEntity findByCityname(String name);

}
