package io.kodlama.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_seeker_cv")
@Entity
public class JobSeekerCvEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_id")
    private long cvId;


    @Column(name = "cv_image_url")
    private String imageUrl;


    @ManyToOne
    @JoinColumn
    private JobSeekerEntity jobSeekerEntity;

}
