package com.example.dosenklp1.home;

public class Mahasiswa {

    String nama, profil;

    public Mahasiswa(){}

    public Mahasiswa(String nama, String profil){
        this.nama = nama;
        this.profil = profil;

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }
}
