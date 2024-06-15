package com.example.BaiTapKiemTra.Service;

import com.example.BaiTapKiemTra.Model.PhongBan;
import com.example.BaiTapKiemTra.Repository.NhanVienRepository;
import com.example.BaiTapKiemTra.Repository.PhongBanRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Service
public class PhongBanService {
    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<PhongBan> getAllPhongBans() {
        return phongBanRepository.findAll();
    }
}
