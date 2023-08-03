
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class codsoft_2 {
	
	public static void countWords(String text){
		String[] words=text.split("[\\s.,:;!?()\\[\\]{}\"']+");
		int totalCount=words.length;
		
		Map<String, Integer> wordCountMap=new HashMap<>();
		for(String word: words) {
			word=word.toLowerCase();
			if(!word.isEmpty()) {
				wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) +1);
			}
		}
		System.out.println("Total word count : " + totalCount);
		System.out.println("Unique word count : " + wordCountMap.size());
	}
	
	public static String readFile(String filePath) {
		try(BufferedReader reader=new BufferedReader(new FileReader(filePath))){
			StringBuilder stringBuilder=new StringBuilder();
			String line;
			while((line=reader.readLine())!=null){
				stringBuilder.append(line).append(" ");
			}
			return stringBuilder.toString().trim();
			
		}catch(IOException e) {
			System.out.println("Error reading the file.please check the file path and try again.");
		}
		return null;
	}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("****** WELCOME TO WORD COUNTER ******");
		
		while(true) {
			System.out.println("Enter '1' to input text or '2' to provide a file :  ");
			int choice=sc.nextInt();
			sc.nextLine();
			
			if(choice==1) {
				System.out.println("Enter the text : ");
				String text=sc.nextLine();
				countWords(text);
				break;
				
			}else if(choice==2) {
				System.out.println("Enter the file path : ");
				String filePath=sc.nextLine();
				String text=readFile(filePath);
				if(text!=null) {
					countWords(text);
					break;
				}
				
				}
			    else {
				System.out.println("Invalid choice. please try again");
			  }
				
		}sc.close();
		

	}


}