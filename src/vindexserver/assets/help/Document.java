
package vindexserver.assets.help;
import java.util.ArrayList;


/**
 *
 * @author obi
 */
public class Document {
    
    private ArrayList<String> txt;
    
    protected Document(ArrayList<String> txt){        
        this.txt = txt;
    }
    protected void addLine(String... line){
        for(String l:line){
            txt.add(l);
        }
    }
    protected void wipeDoc(){
        txt.clear();        
        
    }
    
    
}
