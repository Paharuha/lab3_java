package lab.controller;

import lab.model.Student;
import lab.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private StudentRepo studentRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping
    public String showStudents(Model model) {
        Iterable<Student> all = studentRepo.findAll();
        List<Student> students = (List<Student>) all;

        model.addAttribute("students", students);

        return "index";
    }

    @GetMapping("add")
    public String addStudent() {

        return "addStudent";
    }

    @PostMapping("add")
    public String add(Student student, Model model, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            student.setProfilePhoto(resultFilename);
        }

        studentRepo.save(student);

        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String removeStudent(@PathVariable String id) {
        Student student = studentRepo.findById(Integer.valueOf(id)).get();
        studentRepo.delete(student);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        Student student = studentRepo.findById(Integer.valueOf(id)).get();
        model.addAttribute("student", student);
        return "edit";
    }

    @PostMapping("/")
    public String saveEdit(Student student) {
        studentRepo.save(student);

        return "redirect:/";
    }
}
