package co.oriable.parkir;

import java.io.Serializable;

public class Kendaraan implements Serializable {
    String no_kendaraan, nama_pemilik, jenis_kendaraan, status;

    public Kendaraan(String no_kendaraan, String nama_pemilik, String jenis_kendaraan, String status) {
        this.no_kendaraan = no_kendaraan;
        this.nama_pemilik = nama_pemilik;
        this.jenis_kendaraan = jenis_kendaraan;
        this.status = status;
    }

    public String getNo_kendaraan() {
        return no_kendaraan;
    }

    public void setNo_kendaraan(String no_kendaraan) {
        this.no_kendaraan = no_kendaraan;
    }

    public String getNama_pemilik() {
        return nama_pemilik;
    }

    public void setNama_pemilik(String nama_pemilik) {
        this.nama_pemilik = nama_pemilik;
    }

    public String getJenis_kendaraan() {
        return jenis_kendaraan;
    }

    public void setJenis_kendaraan(String jenis_kendaraan) {
        this.jenis_kendaraan = jenis_kendaraan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
