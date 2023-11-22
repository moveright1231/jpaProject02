package com.ict01.jpaproject02.controller;

import com.ict01.jpaproject02.ResourceNotFoundException;
import com.ict01.jpaproject02.model.Student;
import com.ict01.jpaproject02.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Spring MVC의 컨트롤러로 선언
@RequestMapping("/student") // 기본 URI 경로 설정
@RequiredArgsConstructor // Lombok을 사용하여 필수 생성자 자동 생성
public class StudentController {

    private final StudentService studentService; // 학생 서비스 객체

    // [1] 전체 학생 정보 조회
    @GetMapping("/lists") // GET 요청을 처리하는 메서드
    public String lists(Model model){

        List<Student> students = studentService.lists(); // 전체 학생 정보 조회

        model.addAttribute("students",students); // 모델에 학생 리스트 추가

        return "listStudents"; // listStudent 뷰 반환
    }

    // [2] 학생 정보 등록
    // [2-1] 학생 정보 등록 폼 표시
    @GetMapping("/showForm") // GET 요청을 처리하는 메서드
    public String showFormAdd(Model model){
        Student student = new Student(); // 새 학생 객체 생성
        model.addAttribute("student",student); // 모델에 학생 객체 추가
        return "studentForm"; // studentForm 뷰 반환
    }

    // [2-2] 학생 정보 저장 액션
    @PostMapping("/saveStudent") // POST 요청을 처리하는 메서드
    public String saveStudent(@ModelAttribute("student")Student student){
        studentService.saveStudent(student); // 학생 정보 저장
        return "redirect:/student/lists"; // 학생 리스트 페이지로 리다이렉트
    }

    // [3] 학생 정보 수정
    // [3-1] 학생 정보 수정 폼 표시
    @GetMapping("/updateForm") // GET 요청을 처리하는 메서드
    public String showFormUpdate(@RequestParam("studentId")int id, Model model)throws ResourceNotFoundException{
        Student student = studentService.getStudent(id); // 학생 정보 조회
        model.addAttribute("student", student); // 모델에 학생 객체 추가
        return "updateForm"; // updateForm 뷰 반환
    }

    // [3-2] 학생 정보 수정 액션
    @PostMapping("/updateStudent") // POST 요청을 처리하는 메서드
    public String updateStudent(@ModelAttribute("student")Student student){
        studentService.saveStudent(student); // 학생 정보 저장
        return "redirect:/student/lists"; // 학생 리스트 페이지로 리다이렉트
    }

    // [4] 학생 정보 삭제
    @GetMapping("/delete") // GET 요청을 처리하는 메서드
    public String deleteStudent(@RequestParam("studentId")int id)throws ResourceNotFoundException {
        studentService.deleteStudent(id); // 학생 정보 삭제
        return "redirect:/student/lists"; // 학생 리스트 페이지로 리다이렉트
    }
}

