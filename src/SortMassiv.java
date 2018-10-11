
	
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.lang.Math;


public class SortMassiv {

	    static Comparator<String> compare = new Comparator<String>() {

	        public int compare(String s1, String s2) {

	            s1 = s1.toUpperCase();
	            s2 = s2.toUpperCase();

	            if (s1.equals(s2)) {
	                return 1;
	            }
	            for (int i = 0; i < Math.min(s1.length(),s2.length()); ++i){

	                if (s1.charAt(i) != s2.charAt(i)) {

	                    if (s1.charAt((i)) < s2.charAt((i))) {
	                        return -1;
	                    } else {
	                        return 1;
	                    }   
	                }
	            }
	            return s1.compareToIgnoreCase(s2);
	        }
	    };

	    public static LinkedList<String> sort(String [] wordsList) {
      
	            LinkedList<String> list = new LinkedList<>();

	            for (String word: wordsList) {
	            	list.add (word);
	            }
	            
	            System.out.println(list);

	            TreeSet<String> words = new TreeSet<>(compare);
	            
	            words.addAll (list);

	            LinkedList<String> list1 = new LinkedList<>();
	            LinkedList<String> finalResult = new LinkedList<>();
	            finalResult.add("");
	            
	            for (String str: words) { 
	                list1.add(str); 
	            } 
	            
	            System.out.println ("New wordsList =>" + list1);
	            
	            ConcurrentMap<Object, AtomicInteger> result = new ConcurrentHashMap<Object, AtomicInteger>();
	            
	            for (Object element : list1) {
	                result.putIfAbsent(element, new AtomicInteger(0)); 
	                result.get(element).incrementAndGet();
	            }
	            
	            System.out.println ("Result =>" + result);
	            return list1;
	    }
}
