package io.kodlama.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotNull
    @NotBlank
    @Column(name = "business_sector_name",nullable = false)
    private String businessSectorName;

    @OneToMany(mappedBy = "businessSector" ,fetch =FetchType.LAZY )
    private Set<JobAdverstisementEntity> jobAdverstisementEntity = new HashSet();


}
