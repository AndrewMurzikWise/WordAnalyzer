import java.util.LinkedList;

public class RetryCounter {

	public static void count (LinkedList<String> list1) {
		   int counter = 1;
           int counterTemp = 0;
           int finalCounter = 0;
           
           LinkedList<String> finalResult = new LinkedList<>();
           finalResult.add("");
           
           if (list1.size()==0) {
           	finalResult = list1;
           } else if (list1.size()>0 & list1.size()<2) {
           	   	finalResult = list1;
           	   	finalCounter = 1;
           } else {
           	
        	   int r=0;
           	
               while (r<list1.size()) {

               	String temp = list1.get(r);
               	String temp1 = finalResult.getLast();
               	r++;
               	
               	if (temp.equals(temp1)) {
	                	counter++;
	                	counterTemp=counter;
	                	if (r==list1.size() & counter < finalCounter) {
	                		finalResult.removeLast();
	                	}
	                	if (r==list1.size() & counter > finalCounter) {
	                		finalCounter = counter;
	                		finalResult.clear();
	                		finalResult.add(temp);
	                	} 
	           } else if (counter > counterTemp|counterTemp==0) {  
	                		finalResult.clear();
	                		finalResult.add(temp);
	                		counterTemp++;
	           } else if (counter<finalCounter & finalCounter > 1 ) {
	                		finalResult.removeLast();
	                		finalResult.add(temp);
	                		counter = 1;
	                		counterTemp = 1;
	           } else {
	                		if (counter == finalCounter ) {
	                			finalResult.add(temp);
		                		counter = 1;
		                		counterTemp = 1;
		                		counter = 1;
		                		counterTemp = 1;
		                		if (r==list1.size() & counter < finalCounter) {
			                		finalResult.removeLast();
			                	}
		                	}
	                		if (counter > finalCounter ) {
	                			finalCounter = counter;
	                			finalResult.clear();
	                			finalResult.add(temp1);
	                			finalResult.add(temp);
	                			counter = 1;
		                		counterTemp = 1;
		                		if (r==list1.size() & counter < finalCounter) {
			                		finalResult.removeLast();
		                		}
	                		}
	           			}
	         }
          }
           System.out.println("finalResult =>" + finalResult);
           System.out.println("finalCounter =>" + finalCounter);
	}
	
}
