import java.util.concurrent.*;
import java.io.*;    

public class Test {
    public static void main(String[] args) throws java.io.IOException {
        System.out.println("WELCOME TO THE TECHNO QUIZ ");
        Question q = new Question();
        for(int i=0;i<7;i++)
        {
            System.out.println("YOU HAVE 30 SECONDS"); 
        System.out.println("QUESTION "+(i+1)+"=" + q.toString());
if(i==0)
            System.out.println("1-RED HYDROGEN ONE      2-BLUE HYDROGEN     3-HOLOPHONE     4-HOLO-PHO");
if(i==1)
            System.out.println("1-BILL GATES        2-ELONE MUSK        3-ROBERT DROWNEY JR         4-RUSO BROTHERS");
if(i==2)
            System.out.println("1-NASA        2-ISRO        3-BLUE ORIGIN         4-SPACEX");
if(i==3)
            System.out.println("1-PAL.COM        2-PAY.COM        3-X.COM         4-SV.COM");
if(i==4)
            System.out.println("1-MARCH 30,2017        2-FEBRUARY 6,2018       3-FEBRUARY 23,2019         4-MARCH 30,2018");
if(i==5)
            System.out.println("BILL GATES         2-ELONE MUSK       3-JEFF BEZOS         4-MUKASH AMBANI");
if(i==6)
            System.out.println("1-BILL GATES        2-ELONE MUSK        3-ROBERT DROWNEY JR         4-RUSO BROTHERS");            
if(i==7)
            System.out.println("1-ATONOMOS DRIVING        2-AUTO PILOT        3-AUTO DRIVE         4-DRIVE AUTO");            
                        
            
        String userAnswer = null;    
        ExecutorService ex = Executors.newSingleThreadExecutor();
        try {
          Future<String> result = ex.submit(new GetInputLineCallable());
          try {
            userAnswer = result.get(30, TimeUnit.SECONDS);
            if (Integer.valueOf(userAnswer) == q.getAnswer()){
                System.out.println("good!");
            }
            else{
                System.out.println("INCORRECT! YOU LOOSE !");
            
                break;
            }

          } catch (ExecutionException e) {
            e.getCause().printStackTrace();
          } catch (TimeoutException e){
            System.out.println("YOU SNOOZE ! YOU LOOSE");
            return;
          } catch (InterruptedException e){
            System.out.println("interrupted?");
            e.getCause().printStackTrace();
          }

        } finally {
          ex.shutdownNow();
        }
    }
    }
}



class GetInputLineCallable implements Callable<String>
 {
  public String call() throws IOException 
{
    BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    while ("".equals(input)) 
{
      try {
        while (!inp.ready()) 
{
          Thread.sleep(100);
        }
        input = inp.readLine();
      } catch (InterruptedException e) {
        return null;
      }
    } 
    return input;
  }
}

class Question{
  int p1, p2,A;
  String Q;
  public Question(){
    p1 = 1;
    p2 = 1;
    Q="";
    A=0;
  }
  public String toString(){
    switch(p1)
     {
case 1:
Q="NAME THE FIRST 3D HOLOGRAM PHONE";
break;

case 2:
Q="WHERE DO TONY STARK FRICTIONAL CHARACTER IDEA CAME ?";
  break;

case 3:
Q="NAME THE AEROSPACE COMPANY WHICH SUCCESSFULLY ACHIEVED THE FIRST REFLIGHT OF AN ORBITAL CLASS ROCKET  ?";
  break;

  case 4:
Q="NAME THE ORGNAL NAME OF PAYPAL ?";
  break;
 
  case 5:
Q="ON WHICH DAY AEROSPACE COMPANY SPACEX SUCCESSFULLY ACHIEVED THE FIRST REFLIGHT OF AN ORBITAL CLASS ROCKET  ?";
  break;

         case 6:
Q="NAME THE OWNER OF BLUE ORIGIN  ?";
  break; 
           case 7:
Q="NAME THE OWNER OF TESLA CARS  ?";
  break; 
   case 8:
Q="TESLA CARS ARE KNOWN FOR THEIR  ?";
  break; 
     }
     
 p1++;
  return Q;
      
  }
  
  public int getAnswer(){
    switch(p2)
     {
case 1:
  A=1;
 break;

  case 2:
  A=2;
  break;

  case 3:
  A=4;
  break;
 
 case 4:
  A=3;
  break;
  
  case 5:
  A=1;
  break;
 
 case 6:
  A=3;
  break;
  case 7:
  A=2;
  break;
  case 8:
  A=3;
  break;

     } 
    
  p2++;
return A; }
}
