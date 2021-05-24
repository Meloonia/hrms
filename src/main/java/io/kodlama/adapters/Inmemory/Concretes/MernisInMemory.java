package io.kodlama.adapters.Inmemory.Concretes;

import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.adapters.Inmemory.Abstracts.Mernis;

import java.util.ArrayList;
import java.util.List;

public class MernisInMemory implements Mernis {

    private List<JobSeekerEntity> liste = new ArrayList<JobSeekerEntity>() {


        public void MernisInMemory() {
            JobSeekerEntity jobSeekerEntity = new JobSeekerEntity(1, 1234567891, "isim", "soyisim", "5555555555", "adres", 1985);
            JobSeekerEntity jobSeekerEntity2 = new JobSeekerEntity(2, 987445614, "ilker", "çelimli", "555541545", "adres", 2000);
            JobSeekerEntity jobSeekerEntity3 = new JobSeekerEntity(3, 222222222, "abdullah", "soyisim", "1234567", "adres", 1980);
            JobSeekerEntity jobSeekerEntity4 = new JobSeekerEntity(4, 1234567890, "satılmış", "aga", "555555", "adres", 5555);

            liste.add(jobSeekerEntity);
            liste.add(jobSeekerEntity2);
            liste.add(jobSeekerEntity3);
            liste.add(jobSeekerEntity4);
        }


    };

    @Override
    public boolean TCNoDogrula(long TC, String name, String surname, int birtday) {
        for (JobSeekerEntity seeker : liste) {
            if (liste.stream().anyMatch(j -> j.getJobSeekerNationalId() == TC && j.getJobSeekerName().equals(name) &&
                    j.getJobSeekerSurname().equals(surname) && j.getBirtday() == birtday)) {

            } else return false;
        }
        return true;
    }


}