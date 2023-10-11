package phonebook.lib;


import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.html.parser.Element;

public class phonebook {
    private HashMap<String,ArrayList<String>> book;
    private int maxCountPhoneNumbers = 0;
    public phonebook(){
        this.book = new HashMap<>(10); 
    }

    private void Entry(String nameStr,String valueStr){
        ArrayList<String> buf = new ArrayList<String>();

        if (this.book.containsKey(nameStr)){
            if (null != this.book.get(nameStr)){
                buf = this.book.get(nameStr);
            }
        }
        if (null != valueStr){
            buf.add(valueStr);
        }
        if (buf.size() > maxCountPhoneNumbers) maxCountPhoneNumbers = buf.size();

        this.book.put(nameStr,buf);
    }
    private StringBuilder SearchElement(String str){
        StringBuilder answBuilder = new StringBuilder();
        if (this.book.containsKey(str)){
            answBuilder.append(str);
            answBuilder.append(" --> ");
            answBuilder.append(this.book.get(str));         
        }else{
            answBuilder.append("Nothing found!");
        }

        return answBuilder;
    }

    public void Add(String nameStr){
        if(this.book.containsKey(nameStr)){
            System.out.println("This name alrady exist!");
        }else{
            Entry(nameStr, null);
        }
    } 
    public void Add(String nameStr,String valueStr) { Entry(nameStr, valueStr);}
    public void Add(String nameStr,String[] valueStr){
        for(String value :valueStr){
            Entry(nameStr, value);
        }
    }
    public void Search(String nameStr){

    }
      
            
}
