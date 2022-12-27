package com.example.dosenklp1.models;

public class Logbook {

    String bulan;
    String tanggal;
    String keterangan;

    public Logbook(){}

    public Logbook(String bulan, String tanggal, String keterangan){
        this.bulan = bulan;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
