package io.kodlama.DataAccess.Abstracts;



import io.kodlama.Entites.Concretes.BusinessSectorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessAreaDao extends JpaRepository<BusinessSectorsEntity,Integer> {

    BusinessSectorsEntity getByBusinessSectorName(String name);
    BusinessSectorsEntity findByBusinessSectorName(String name);
}
