package in.saurabh;

import java.util.List;

public class UserService {


//    private final List<String> userName;
//    private List<String> userNames;
//    public UserService(List<String> userName){
//        System.out.println("User Service Created !! ");
//        this.userName=userName;
//    }
//    public List<String> getUserNames() {
//        return userName;
//    }

    public UserService(){
        System.out.println("user service created !! ");
    }

    public void init(){
        System.out.println("Post construct phase !! ");
    }

    public void cleanup(){
        System.out.println("pre destroy phase !! ");
    }

}
