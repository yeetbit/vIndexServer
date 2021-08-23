/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vindexserver.assets.help;
import java.io.BufferedReader;

/**
 *
 * @author obi
 * 
 * usage of delimiters: 
 *  !@ = Read Not at line go to next
 *  &@ = Read Line
 *  ;@ = Last line of article
 *  ;& = Last line of current article, read more related details in other articles
 *  && = Branching
 * 
 */
public class HelpEngine {

    char read = '&';
    char readNot = '!';
    char stop = ';';
    char atLine = '@';
            
    // mips
    protected class Launcher  {
        private Launcher(){
            
        }
        
        protected Launcher launch(){
            if(true){
            
                Launcher lchr = new Launcher();
                return lchr;
            }        
            return null;
        }
    }
    
    protected class DocHandler {
        
    }
}