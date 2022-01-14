package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingleton {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        System.out.println("memberService -> MemberRepository = " + memberService.memberRepository());
        System.out.println("orderService  -> MemberRepository = " + orderService.memberRepository());
        System.out.println("memberRepository = " + memberRepository);

        /*Assertions.assertThat(memberService.memberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.memberRepository()).isSameAs(memberRepository);*/

        Assertions.assertThat(memberService.memberRepository()).isNotSameAs(memberRepository);
        Assertions.assertThat(orderService.memberRepository()).isNotSameAs(memberRepository);
        Assertions.assertThat(memberService.memberRepository()).isNotSameAs(orderService.memberRepository());
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //AppConfig 도 스프링 빈으로 등록된다.
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        //@Configuration 이 붙을 때
        //bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$121335e9


    }

}
