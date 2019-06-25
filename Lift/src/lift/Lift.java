package lift;
import java.io.*;
import java.util.*;
public class Lift {

    
    public static int checkStop(int []a){
        int i = 0;
        for(int x:a){
            if(x==1){
                i++;
            }
        }
        return i;
    }
    
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        
        int []EntryFlag = new int[6];
        int direction = 0;
        int numberOfPersons = 0;
        final int maxPersons = 10;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int EntryFloor, ExitFloor, ch;
        
        //Starting Step
        System.out.println("Enter the floor you're in");
        EntryFloor = Integer.parseInt(br.readLine());
        EntryFlag[EntryFloor] = 1;
        
        do{
            System.out.println("Enter your Choice!\n1)Select Entry Floor\n2)Display\n3)Exit");
            ch = Integer.parseInt(br.readLine());
            if(ch==1){
                System.out.println("Enter the floor you're in");
                EntryFloor = Integer.parseInt(br.readLine());
                EntryFlag[EntryFloor] = 1;
            }
            else if(ch==2){
                do{
                if(direction == 0){
                    for(int i=0;i<6;i++){
                        if(EntryFlag[i]==1){
                                System.out.println("Lift Stopped in Floor "+i);
                                System.out.println("People want Enter: yes or no");
                                String xx = br.readLine();
                                if(xx.equals("yes")){
                                    System.out.println("People Enter inside the Lift");
                                    System.out.println("Enter the Exit Floors");
                                    String []l = br.readLine().split(" ");
                                    for(String ii:l){
                                        int v = Integer.parseInt(ii);
                                        EntryFlag[v] = 1;
                                }
                                }
                                    
                            EntryFlag[i]=0;
                        }
                    }
                    direction = 1;
                }
                else{
                    Collections.reverse(Arrays.asList(EntryFlag)); 
                    for(int i=0;i<6;i++){
                        if(EntryFlag[i]==1){
                                System.out.println("Lift Stopped in Floor "+i);
                                System.out.println("People want Enter: yes or no");
                                String xx = br.readLine();
                                if(xx.equals("yes")){
                                    System.out.println("Please Enter inside the Lift");
                                    System.out.println("Enter the Exit Floors");
                                    String []l = br.readLine().split(" ");
                                    for(String ii:l){
                                        int v = Integer.parseInt(ii);
                                        EntryFlag[5-v] = 1;
                                    }
                                }
                                
                            EntryFlag[5-i]=0;
                        }
                    }
                    direction = 0;
                    Collections.reverse(Arrays.asList(EntryFlag)); 
                }
                
                }while(checkStop(EntryFlag)!=0);
            }
        }while(ch!=3);
        System.out.println("ThankYou");
    }
}
