package io.kodlama.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employer_business_sectors")
public class EmployerBusinessSectorsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employer_business_sectors_id")
    private long employerBusinessSectorId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employer_entity_id")
    private EmployerEntity employerEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "business_sector_id")
    private BusinessSectorsEntity businessSectorsEntity;
}

