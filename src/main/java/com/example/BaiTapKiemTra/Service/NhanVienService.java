package com.example.BaiTapKiemTra.Service;

import com.example.BaiTapKiemTra.Model.NhanVien;
import com.example.BaiTapKiemTra.Repository.NhanVienRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RequiredArgsConstructor
@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    public void saveNhanVien(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    public Optional<NhanVien> getNhanVienById(String ma_NV) {
        return nhanVienRepository.findById(ma_NV);
    }

    public void deleteNhanVien(String ma_NV) {
        nhanVienRepository.deleteById(ma_NV);
    }
}
