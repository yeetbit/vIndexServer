/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vindexserver;

import java.time.LocalDateTime;
import java.time.chrono.JapaneseDate;
import java.time.chrono.ThaiBuddhistDate;
import java.time.format.*;

/**
 *
 * @author obi
 * mips
 */
public class DateTime {
    
    public DateTime(){
        
        LocalDateTime lDate = LocalDateTime.now();
        ThaiBuddhistDate buddaDate = ThaiBuddhistDate.from(lDate);
        JapaneseDate japDateSlutz = JapaneseDate.from(lDate);
        String isoDate = lDate.format(DateTimeFormatter.ISO_DATE_TIME);
        String dDate = lDate.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        
        
        System.out.println("Current Gregorian date: "+lDate+
                "\nCurrent Thai Buddhist date: "+ThaiBuddhistDate.now()+
                "\nCurrent Japanese date: "+JapaneseDate.now()+
                "\nCurrent formatted Gregorian date: "+dDate
        );
        
    }
    
        
        
        
         
    
}
