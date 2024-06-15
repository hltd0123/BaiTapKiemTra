package com.example.BaiTapKiemTra.Repository;

import com.example.BaiTapKiemTra.Model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {

}
