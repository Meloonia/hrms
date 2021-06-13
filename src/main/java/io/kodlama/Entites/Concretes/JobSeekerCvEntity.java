package io.kodlama.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_seeker_cv")
@Entity
public class JobSeekerCvEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_id")
    private long cvId;

    @JoinColumn(name = "userId")
    private long userId;

    @Column(name = "cv_image_url")
    private String imageUrl;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private JobSeekerEntity jobSeekerEntity;

}
