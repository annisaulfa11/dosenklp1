package com.example.dosenklp1.models;

public class Mahasiswa {

    String nama;
    Object profil;

    public Mahasiswa(int id, String name, Object photo){

    }

    public Mahasiswa(String nama, Object profil){
        this.nama = nama;
        this.profil = profil;

    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Object getProfil() {
        return profil;
    }

    public void setProfil(Object profil) {
        this.profil = profil;
    }
}
