package com.mysite.sbb.question;

import com.mysite.sbb.question.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject); //프록시 패턴으로  JpaRepository를 상속한 QuestionRepository 객체가 생성될때

    // DI에 의해 스프링이 자동으로 QuestionRepository 객체를 생성한다
    //리포지터리 객체의 메서드가 실행될때 JPA가 해당 메서드명을 분석하여 쿼리를 만들고 실행한다.
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);

    Page<Question> findAll(Pageable pageable);
}
