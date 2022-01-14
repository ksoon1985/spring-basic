package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    // 이 함수를 통해서만 SingletonService 를 사용할 수 있다.
    public static SingletonService getInstance(){
        return instance;
    }

    // 다른 곳에서 new 하지 못하게 private 생성자
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
