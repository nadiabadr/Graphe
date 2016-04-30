package BusinessDelegator;

import java.io.IOException;

public class SendEmail {
    
    public static void main(String[] args) throws IOException {
        
        String[] to= {"mohamedsheni.gafsi@esprit.tn"};
        
        if(EmailSender.sendEmail("pigaleriedesarts@gmail.com","ScrumMaster" , "message to reciepents", to))
            System.out.println("email sent successfully");
        else System.out.println("some error occured");
        
    }
   
    }

