package com.example.BaiTapKiemTra.Controller;

import com.example.BaiTapKiemTra.Model.NhanVien;
import com.example.BaiTapKiemTra.Repository.PhongBanRepository;
import com.example.BaiTapKiemTra.Service.NhanVienService;
import com.example.BaiTapKiemTra.Service.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private PhongBanService phongBanService;

    // Hiển thị danh sách nhân viên
    @GetMapping("")
    public String listNhanVien(Model model) {
        List<NhanVien> nhanViens = nhanVienService.getAllNhanVien();
        nhanViens.forEach(System.out::println);
        model.addAttribute("nhanViens", nhanViens);
        return "nhanvien/list";
    }

    // Hiển thị form thêm nhân viên
    @GetMapping("/add")
    public String showAddNhanVienForm(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("phongBans", phongBanService.getAllPhongBans());
        return "nhanvien/add";
    }

    // Xử lý thêm nhân viên từ form
    @PostMapping("/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanVien") NhanVien nhanVien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("nhanVien", nhanVien);
            model.addAttribute("phongBans", phongBanService.getAllPhongBans());
            return "nhanvien/add";
        }
        nhanVienService.saveNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    // Hiển thị form chỉnh sửa nhân viên
    @GetMapping("/edit/{id}")
    public String showEditNhanVienForm(@PathVariable("id") String id, Model model) {
        Optional<NhanVien> optionalNhanVien = nhanVienService.getNhanVienById(id);
        if (optionalNhanVien.isEmpty()) {
            throw new RuntimeException("Không tìm thấy nhân viên có ID: " + id);
        }
        model.addAttribute("nhanVien", optionalNhanVien.get());
        model.addAttribute("phongBans", phongBanService.getAllPhongBans());
        return "nhanvien/edit";
    }

    // Xử lý chỉnh sửa nhân viên từ form
    @PostMapping("/edit/{id}")
    public String editNhanVien(@PathVariable("id") String id, @Valid @ModelAttribute("nhanVien") NhanVien nhanVien,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("phongBans", phongBanService.getAllPhongBans());
            return "nhanvien/edit";
        }
        nhanVienService.saveNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    // Xóa nhân viên
    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable("id") String id) {
        nhanVienService.deleteNhanVien(id);
        return "redirect:/nhanvien";
    }
}
