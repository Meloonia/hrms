package io.kodlama.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import static io.kodlama.Utils.ValidationMessages.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "business_sectors")
public class BusinessSectorsEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_sector_id")
    private long businessSectorId;

    @NotNull(message = businessSectorNullAndBlank)
    @NotBlank(message = businessSectorNullAndBlank)
    @Column(name = "business_sector_name",nullable = false)
    private String businessSectorName;

    @OneToMany(mappedBy = "businessSectorsEntity" ,fetch =FetchType.LAZY ,cascade = CascadeType.ALL)
    private Set<JobAdverstisementEntity> jobAdverstisementEntity = new HashSet();


}
