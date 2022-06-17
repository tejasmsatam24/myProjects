import java.util.*;

public class EmailAddresses {

    public static void main(String[] args){
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        EmailAddresses es = new EmailAddresses();
        System.out.println(es.numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {
        ArrayList<String> str = new ArrayList<String>();
        for(int i = 0; i < emails.length; i++){
            StringBuilder tempStr = new StringBuilder(emails[i]);
            for(int j = 0; j < tempStr.length(); j++){
    
                if (tempStr.charAt(j) == '.'){
                    tempStr.deleteCharAt(j);
                }
                if(tempStr.charAt(j) == '+'){
                     do{
                        tempStr.deleteCharAt(j);
                    }while(tempStr.charAt(j) != '@');
                }
                if (tempStr.charAt(j) == '@'){
                    break;
                }
            }
            
            if(!str.contains(tempStr.toString())){
                str.add(tempStr.toString());
            }
        }
        return str.size();
    }
    
}
