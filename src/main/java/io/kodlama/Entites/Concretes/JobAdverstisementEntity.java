package io.kodlama.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Tables;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_advertisement")
public class JobAdverstisementEntity {

    @Id
    @Column(name = "user_id")
    private long userId;

    @Column(name = "desciription")
    private String desciription;

    @Column(name="active")
    private boolean active;

    @Column(name = "business_sector")

    private int businessSector;

    @Column(name = "relase_date")
    private Date relaseDate;

    @Column(name = "active_date")
    private Date activeDate;

    @Column(name = "open_positions")
    private int openPosition;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.REFRESH)
    private BusinessSectorsEntity businessSectorsEntity;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.REFRESH)

    private UserEntity userEntity;

}
