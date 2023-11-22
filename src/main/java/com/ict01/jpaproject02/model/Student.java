package com.ict01.jpaproject02.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok을 사용하여 getter, setter, toString, equals, hashCode 메서드 자동 생성
@NoArgsConstructor // Lombok을 사용하여 기본 생성자 자동 생성
@AllArgsConstructor // Lombok을 사용하여 모든 필드 값을 인자로 받는 생성자 자동 생성
@Entity // JPA 엔터티 클래스로 선언
public class Student {

    @Id // 기본 키 필드로 선언
    @GeneratedValue(strategy = GenerationType.AUTO) // 기본 키 생성 전략 설정 (자동 생성)

    private int id; // 학생 ID

    @Column(length = 30) // 컬럼 속성 설정 (길이 30)
    private String name; // 학생 이름

    @Column(length = 30) // 컬럼 속성 설정 (길이 30)
    private String email; // 학생 이메일

    @Column(length = 100) // 컬럼 속성 설정 (길이 100)
    private String address; // 학생 주소
}
