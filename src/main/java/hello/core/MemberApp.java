package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        // 단축키 : ctrl + alt + v
        memberService.join(memberA);

        Member member = memberService.findMember(1L);
        System.out.println("member = " + member);
        System.out.println("memberA = " + memberA);

        /***
         * 이렇게 테스트 하는건 좋은 방법이 아닌 것 같다...
         * -> junit test framework 를 이용해 보자 !!
         *
         */
    }
}
