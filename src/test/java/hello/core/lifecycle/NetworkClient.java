package hello.core.lifecycle;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url){
        this.url = url;
    }

    //서비스 시작 시 호출
    public void connect(){
        System.out.println("connect : "+url);
    }

    public void call(String message){
        System.out.println("call: " + url + "message = "+message);
    }

    //서비스 종료 시 호출
    public void disconnect(){
        System.out.println("close : "+url);
    }

    // 의존 관계 끝나면
    // 초기화 메서드 호출
    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }

    // 빈 이 소멸될 때 호출
    @Override
    public void destroy() throws Exception {
        disconnect();
    }

}
