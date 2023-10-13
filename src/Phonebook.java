


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;




public class Phonebook {
    private HashMap<String,ArrayList<String>> book;
    private int maxCountPhoneNumbers = 0;

    public Phonebook(){
        this.book = new HashMap<>(); 
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
        if (buf.size() > this.maxCountPhoneNumbers) this.maxCountPhoneNumbers = buf.size();

        this.book.put(nameStr,buf);
    }
    private StringBuilder StrBuilder(String str){
        StringBuilder answBuilder = new StringBuilder();
        
        if (str != null) {
            answBuilder.append(str);
            answBuilder.append(" --> ");
            answBuilder.append(this.book.get(str));
        }else {
            answBuilder.append("Nothing found!");
        }
        return answBuilder;
    }
    private StringBuilder SearchElementForName(String searchingStr, boolean... pref){ 
        if(pref[0]){ 
            Set<String> setNames =this.book.keySet();
            for(String name : setNames){
                ArrayList<String> valueList = new ArrayList<>();
                valueList.addAll(this.book.get(name));
                for (String value : valueList){
                    if  (value.equals(searchingStr)){
                        return StrBuilder(name);
                    }
                }
            }
            return StrBuilder(null);
        }else {
            if (this.book.containsKey(searchingStr)){
                return StrBuilder(searchingStr);         
            }else return StrBuilder(null);   
        }
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
    public StringBuilder Search(String nameStr){

        return SearchElementForName(nameStr);
    }
    public StringBuilder Search(String valueStr, boolean pref){
        return SearchElementForName(valueStr,pref);
    }
      
    public LinkedHashMap<String,ArrayList<String>> All(){
        LinkedHashMap<String,ArrayList<String>> sortingHashMap = new LinkedHashMap<>();
        Set<String> setNames =this.book.keySet();
        int bufMaxCountNumbers = this.maxCountPhoneNumbers;
        while(bufMaxCountNumbers >= 0){
            for (String name : setNames){
                if (this.book.get(name).size() == bufMaxCountNumbers){
                    sortingHashMap.put(name, this.book.get(name));
                }
            }
            bufMaxCountNumbers--;
        }
        return sortingHashMap;
    }     
}
