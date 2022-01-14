package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        // 현재 memberService 의 구현체가 MemberServiceImpl 인지 ...
        // AppConfig 를 보면 알 수 있듯이 MemberServiceImpl 가 맞다.
    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean( MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    // 구체 타입으로 조회하면 변경 시 유연성이 떨어진다.
    @Test
    @DisplayName("구체 타입으로 찾기")
    void findBeanByName2(){
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("xxxxxx",MemberService.class));
    }


}
