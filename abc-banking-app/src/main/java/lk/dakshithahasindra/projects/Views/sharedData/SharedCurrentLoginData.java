package lk.dakshithahasindra.projects.Views.sharedData;

import lk.dakshithahasindra.projects.Models.Account;
import lk.dakshithahasindra.projects.Models.Client;

public class SharedCurrentLoginData {
    public static String loginID;
    public static Client loggedInClient;

    private  static SharedCurrentLoginData instance;

    public static SharedCurrentLoginData getInstance() {
        return (instance ==null)? instance=new SharedCurrentLoginData(): instance;
    }
}
