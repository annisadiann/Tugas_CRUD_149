package com.example.praktikum3.mapper;

import com.example.praktikum3.dto.KtpDTO;
import com.example.praktikum3.entity.Ktp;

public class KtpMapper {

    public static Ktp toEntity(KtpDTO request){
        Ktp ktp = new Ktp();
        ktp.setNomorKtp(request.getNomorKtp());
        ktp.setNamaLengkap(request.getNamaLengkap());
        ktp.setAlamat(request.getAlamat());
        ktp.setTanggalLahir(request.getTanggalLahir());
        ktp.setJenisKelamin(request.getJenisKelamin());
        return ktp;
    }

}
