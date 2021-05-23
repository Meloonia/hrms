package io.kodlama.DataAccess.Abstracts;



import io.kodlama.Entites.Concretes.BusinessSectorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BusinessAreaDao extends JpaRepository<BusinessSectorsEntity,Integer> {

}
