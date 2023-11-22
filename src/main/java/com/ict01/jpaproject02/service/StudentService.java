package com.ict01.jpaproject02.service;

import com.ict01.jpaproject02.ResourceNotFoundException;
import com.ict01.jpaproject02.model.Student;
import java.util.List;

public interface StudentService {

  //(1) 전체 학생 조회 (Read)
  // 모든 학생의 정보를 조회하는 메서드
  public List<Student> lists(); // 'lists'라는 메서드 이름은 일반적인 네이밍 룰에 따르면 'list'나 'findAll' 등으로 사용될 수 있음.

  //(2) 학생 등록 (Create)
  // 학생 정보를 데이터베이스에 저장하는 메서드
  public void saveStudent(Student student);

  //(3) 학생정보 수정 (Update)
  // 주어진 ID에 해당하는 학생의 정보를 조회하는 메서드
  public Student getStudent(int id) throws ResourceNotFoundException; // 학생 정보가 없을 경우 'ResourceNotFoundExeption' 예외 발생

  //(4) 학생정보 삭제 (Delete)
  // 주어진 ID에 해당하는 학생의 정보를 삭제하는 메서드
  public void deleteStudent(int id) throws ResourceNotFoundException; // 학생 정보가 없을 경우 'ResourceNotFoundExeption' 예외 발생

}
