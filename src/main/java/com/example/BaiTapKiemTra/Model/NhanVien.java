package com.example.BaiTapKiemTra.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "NHANVIEN")
public class NhanVien {
    @Id
    @NotBlank(message = "Mã Nhân viên không được trốn")
    @Column(name = "Ma_NV", length = 3)
    private String ma_NV;
    @Column(name = "Ten_NV", length = 100)
    @NotBlank(message = "Tên nhân viên không được trống")
    @Size(min = 1, max = 100, message = "Tên nhân viên phải từ 1 - 100 k tự")
    private String ten_NV;

    @Column(name = "Phai", length = 3)
    private String phai;

    @Column(name = "Noi_Sinh", length = 200)
    private String noi_Sinh;

    @ManyToOne
    @JoinColumn(name = "Ma_Phong", referencedColumnName = "Ma_Phong")
    private PhongBan phongBan;

    @Column(name = "Luong")
    private int luong;
}
