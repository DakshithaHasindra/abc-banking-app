package lk.dakshithahasindra.projects.Models;

public class GenerateAccountNumber {
//    TODO : Stop generate same Account numbers Again and Again,
//    TODO : Stop generating Account numbers starts with 0;
    public static String generateAccNumber(){
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0 ; i < 16 ; i++){
            double random = Math.random();
           accountNumber.append(Math.round(random*10%10));
        }
        return accountNumber.toString();
    }
}
