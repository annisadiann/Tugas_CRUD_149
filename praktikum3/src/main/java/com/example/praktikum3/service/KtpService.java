package com.example.praktikum3.service;

import com.example.praktikum3.dto.KtpDTO;
import com.example.praktikum3.entity.Ktp;

import java.util.List;

public interface KtpService {

    Ktp create(KtpDTO dto);

    List<Ktp> getAll();

    Ktp getById(Integer id);

    Ktp update(Integer id, KtpDTO dto);

    void delete(Integer id);
}
