package io.kodlama.adapters.Inmemory.Concretes;

import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.adapters.Inmemory.Abstracts.Mernis;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MernisInMemory implements Mernis {
    JobSeekerEntity jobSeekerEntityFake = new JobSeekerEntity(1, 1234567891, "isim", "soyisim", "5555555555", "adres", 1985);
    JobSeekerEntity jobSeekerEntity2Fake = new JobSeekerEntity(2, 987445614, "ilker", "çelimli", "555541545", "adres", 2000);
    JobSeekerEntity jobSeekerEntity3fake = new JobSeekerEntity(3, 222222222, "abdullah", "soyisim", "1234567", "adres", 1980);
    JobSeekerEntity jobSeekerEntity4Fake = new JobSeekerEntity(4, 1234567890, "satılmış", "aga", "555555", "adres", 5555);

    private final List<JobSeekerEntity> liste = new ArrayList<JobSeekerEntity>();

    @Override
    public boolean TCNoDogrula(long TC, String name, String surname, int birtday) {
        liste.add(jobSeekerEntityFake);
        liste.add(jobSeekerEntity2Fake);
        liste.add(jobSeekerEntity3fake);
        liste.add(jobSeekerEntity4Fake);
        return liste.stream().anyMatch(j -> j.getJobSeekerNationalId() == TC &&
                j.getJobSeekerName().equals(name) &&
                j.getJobSeekerSurname().equals(surname) &&
                j.getBirtday() == birtday);

    }


    }
