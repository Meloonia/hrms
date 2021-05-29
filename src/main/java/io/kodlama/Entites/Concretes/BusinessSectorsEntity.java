package io.kodlama.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "business_sectors")
public class BusinessSectorsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_sector_id")
    private long businessSectorId;

    @Column(name = "business_sector_name")
    private String businessSectorName;

    @OneToMany(mappedBy = "business_sectors" ,fetch =FetchType.LAZY )
    private Set<JobAdverstisementEntity> jobAdverstisementEntity = new HashSet();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessSectorsEntity that = (BusinessSectorsEntity) o;
        return businessSectorId == that.businessSectorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(businessSectorId);
    }
}
