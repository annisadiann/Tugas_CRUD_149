package com.example.praktikum3.dto;

import lombok.Data;
import java.util.Date;

@Data
public class KtpDTO {

    private String nomorKtp;
    private String namaLengkap;
    private String alamat;
    private Date tanggalLahir;
    private String jenisKelamin;
}
