import java.util.LinkedList;

public class WordAnalyzer {

	public static void main(String[] args) {
		String [] words = {"i", "i", "this", "you", "i", "built", "you","i", "built", "built", "i", "built"};
		//{"f","f", "f","i","g","f","i","i","i","g","f"};
		
		LinkedList<String> sortedList = new LinkedList<>();
		
		sortedList = SortMassiv.sort(words);
		RetryCounter.count(sortedList);
			
		

	}

}
