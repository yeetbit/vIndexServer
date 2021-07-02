
package vindexserver;
import java.time.LocalDateTime;
import java.time.chrono.JapaneseDate;
import java.time.chrono.ThaiBuddhistDate;
import java.time.format.*;
/**
 *
 * @author obi
 */
public class VIndexServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LocalDateTime lDate = LocalDateTime.now();
        ThaiBuddhistDate buddaDate = ThaiBuddhistDate.from(lDate);
        JapaneseDate japDateSlutz = JapaneseDate.from(lDate);
        String isoDate = lDate.format(DateTimeFormatter.ISO_DATE_TIME);
        String dDate = lDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("Current Gregorian date: "+lDate+
                "\nCurrent Thai Buddhist date: "+ThaiBuddhistDate.now()+
                "\nCurrent Japanese date: "+JapaneseDate.now()+
                "\nCurrent formatted Gregorian date: "+dDate);
         
    }
    
}
