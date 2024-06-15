package com.example.BaiTapKiemTra.Repository;

import com.example.BaiTapKiemTra.Model.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongBanRepository extends JpaRepository<PhongBan, String> {
}
