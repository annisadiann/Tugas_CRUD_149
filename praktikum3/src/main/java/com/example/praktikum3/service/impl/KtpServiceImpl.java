package com.example.praktikum3.service.impl;

import com.example.praktikum3.dto.KtpDTO;
import com.example.praktikum3.entity.Ktp;
import com.example.praktikum3.repository.KtpRepository;
import com.example.praktikum3.service.KtpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KtpServiceImpl implements KtpService {

    private final KtpRepository repository;

    public KtpServiceImpl(KtpRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ktp create(KtpDTO dto) {

        repository.findByNomorKtp(dto.getNomorKtp())
                .ifPresent(e -> {
                    throw new RuntimeException("Nomor KTP sudah ada");
                });

        Ktp ktp = new Ktp();
        ktp.setNomorKtp(dto.getNomorKtp());
        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());
        ktp.setTanggalLahir(dto.getTanggalLahir());
        ktp.setJenisKelamin(dto.getJenisKelamin());

        return repository.save(ktp);
    }

    @Override
    public List<Ktp> getAll() {
        return repository.findAll();
    }

    @Override
    public Ktp getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));
    }

    @Override
    public Ktp update(Integer id, KtpDTO dto) {

        Ktp ktp = getById(id);

        ktp.setNomorKtp(dto.getNomorKtp());
        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());
        ktp.setTanggalLahir(dto.getTanggalLahir());
        ktp.setJenisKelamin(dto.getJenisKelamin());

        return repository.save(ktp);
    }

    @Override
    public void delete(Integer id) {

        Ktp ktp = getById(id);

        repository.delete(ktp);
    }
}
