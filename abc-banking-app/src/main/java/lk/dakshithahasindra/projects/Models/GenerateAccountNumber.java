package lk.dakshithahasindra.projects.Models;

public class GenerateAccountNumber {
    public static String generateAccNumber(){
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0 ; i < 16 ; i++){
            double random = Math.random();
           accountNumber.append(Math.round(random*10%10));
        }
        return accountNumber.toString();
    }
}
