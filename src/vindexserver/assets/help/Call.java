
package vindexserver.assets.help;

/**
 *
 * @author obi
 */
public interface Call {
    
    public void forHelp(String keyWord);
    public void forHelp(String[] keyWords);
    
    public void printResult(Document doc);
    
    
}
