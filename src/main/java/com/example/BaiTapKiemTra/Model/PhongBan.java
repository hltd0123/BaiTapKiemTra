package com.example.BaiTapKiemTra.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PHONGBAN")
public class PhongBan {
    @Id
    @NotBlank(message = "Mã phòng không được trống")
    @Size(min = 1, max = 2, message = "Mã phòng phải từ 1 - 2 kí tự")
    @Column(length = 2)
    private String Ma_Phong;

    @Column(length = 30)
    @NotBlank(message = "Tên phòng không được trống")
    @Size(min = 1, max = 30, message = "Tên phòng phải từ 1 - 30 kí tự")
    private String Ten_Phong;
}
