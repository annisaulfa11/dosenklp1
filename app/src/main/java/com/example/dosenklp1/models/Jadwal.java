package com.example.dosenklp1.models;

public class Jadwal {
    String profil, nama, nim;
    String hariSeminar, ruangSeminar, waktuSeminar;
    String hariSidang, ruangSidang, waktuSidang;

    public Jadwal(){

    }

    public Jadwal (String profil, String nama, String nim, String hariSeminar, String ruangSeminar, String waktuSeminar, String hariSidang, String ruangSidang, String waktuSidang){
        this.profil = profil;
        this.nama = nama;
        this.nim = nim;
        this.hariSeminar = hariSeminar;
        this.ruangSeminar = ruangSeminar;
        this.waktuSeminar = waktuSeminar;
        this.hariSidang = hariSidang;
        this.ruangSidang = ruangSidang;
        this.waktuSidang = waktuSidang;
    }

    public String getProfil() {
        return profil;
    }

    public String getNama(){
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getHariSeminar() {
        return hariSeminar;
    }

    public String getRuangSeminar() {
        return ruangSeminar;
    }

    public String getWaktuSeminar() {
        return waktuSeminar;
    }

    public String getHariSidang() {
        return hariSidang;
    }

    public String getRuangSidang() {
        return ruangSidang;
    }

    public String getWaktuSidang() {
        return waktuSidang;
    }
}
