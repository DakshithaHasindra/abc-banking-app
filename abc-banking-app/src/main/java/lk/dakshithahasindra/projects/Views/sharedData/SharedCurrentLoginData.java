package lk.dakshithahasindra.projects.Views.sharedData;

public class SharedCurrentLoginData {
    public String loginID;
    private  static SharedCurrentLoginData instance;

    public static SharedCurrentLoginData getInstance() {
        return (instance ==null)? instance=new SharedCurrentLoginData(): instance;
    }
}
