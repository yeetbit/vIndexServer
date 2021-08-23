
package vindexserver;
import vindexserver.assets.help.*;


/**
 *
 * @author obi
 */
public class VIndexServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length!=0){
            argumentParser(args);
        }else{
            ShowExample();
        }
   
    }
    
    private static void argumentParser(String[] args){
        for(String argStr:args){
            switch (argStr){
                case "Help": case "help": case "-H":  case "-h":
                    System.out.println("Help menu");
                    break;
                case "Verbose": case "verbose": case "-V" : case "v":
                    System.out.println("Verbose mode");
                    break;
                case "1": case "2": case "3": case "4":
                    System.out.println("Goedemiddag");
                    break;
                case "Time": case "time": case "-T": case "-t":
                    ShowTime();
                    break;
                default : System.out.println("No usable argument");
                                           
            }
            
        }

    }
    
    private static void ShowTime(){
        new DateTime();
    }
    
    private static void ShowExample(){
        
        System.out.println("Poep");
        
        
    }
    
}
