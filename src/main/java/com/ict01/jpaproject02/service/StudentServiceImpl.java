package com.ict01.jpaproject02.service;

import com.ict01.jpaproject02.ResourceNotFoundException;
import com.ict01.jpaproject02.model.Student;
import com.ict01.jpaproject02.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Spring의 서비스 레이어 컴포넌트로 선언
public class StudentServiceImpl implements StudentService{

  // 생성자를 통한 의존성 주입
  private final StudentRepository studentRepository; // 학생 정보를 처리하는 레포지토리

  @Autowired // 의존성 자동 주입
  public StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository; // 레포지토리 초기화
  }

  @Override
  public List<Student> lists() {
    return studentRepository.findAll(); // 모든 학생 정보 조회
  }

  @Override
  public void saveStudent(Student student) {
    studentRepository.save(student); // 학생 정보 저장
  }

  @Override
  public Student getStudent(int id) throws ResourceNotFoundException {
    // 학생 ID로 정보 조회, 없으면 'ResourceNotFoundException' 예외 발생
    return studentRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException(id));
  }

  @Override
  public void deleteStudent(int id) throws ResourceNotFoundException {
    studentRepository.deleteById(id); // 학생 정보 삭제
  }
}
