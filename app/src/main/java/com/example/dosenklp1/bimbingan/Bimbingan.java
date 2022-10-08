package com.example.dosenklp1.bimbingan;

public class Bimbingan {

    String nama, nim, judul, profil;

    public Bimbingan(){}

    public Bimbingan(String nama, String nim, String judul,String profil){
        this.nama = nama;
        this.nim = nim;
        this.judul = judul;
        this.profil = profil;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }
}
