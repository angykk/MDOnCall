package code;

import java.util.*;

public class Main {

  public static void calculateScore(disease disease, int[] symptoms, int sex, int age) {

    disease.setScore(symptomSim(disease.getSymptoms(), symptoms));
    if (disease.getSexPreference() == sex) {
      disease.setScore(disease.getScore() + 1.5);
    }

    if (disease.isRare()) {
      disease.setScore(disease.getScore() * 0.5);
    }
    if (disease.getMaxAge() >= age && disease.getMinAge() <= age) {
      disease.setScore(disease.getScore() * 1.4);
    }

  }

  public static int symptomSim(int[] diseaseData, int[] symptoms) {
    int hits = 0;
    for (int y = 0; y < diseaseData.length; y++) {
      for (int z = 0; z < symptoms.length; z++) {
        if (diseaseData[y] == symptoms[z]) {
          hits++;
          break;
        }
      }
    }
    return hits;
  }
  
  public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
    int response;
		int userAge = 0;
		int userSex = 0;
		//1 = male, 2 = female
		int[] symptomsTemp = new int[34];
		LinkedList diseaseData = new LinkedList();
    diseaseData.SetupExistingDisease ();
		boolean inputError = false;
    System.out.println("================================================");
	  System.out.println("MD ON CALL");
    System.out.println("================================================");

  do{
    System.out.println("\n================================================");
    System.out.println("MENU"
        + "\n 0: Exit "
				+ "\n 1: Respiratory disease diagnostic."
        + "\n 2: Add new disease"
        + "\n 3: View disease database");
    System.out.println("================================================");
    System.out.print(">>");
    response = scanner.nextInt();
    
    if(response == 1){
         System.out.println("How old are you? ");
    		do {
    			try {
            System.out.print(">>");
    				userAge = scanner.nextInt();
    				inputError = false;
    			} catch (Exception e) {inputError = true; String garbage = scanner.next();}
    		} while (inputError);
    		
    		System.out.println("What is your biological sex? (M/F) ");
    		String tempSex;
    		do {
          System.out.print(">>");
    			tempSex = scanner.next();
    		} while (!(tempSex.equalsIgnoreCase("M") || tempSex.equalsIgnoreCase("F")));
    		if(tempSex.equalsIgnoreCase("M"))
    			userSex = 1;
    		else
    			userSex = 2;
    		System.out.println("What symptoms do you have?");
        printSymptom();
    
    		int numberOfInputtedSymptoms = 0;
    		for(int x = 0; x < 34; x++) {
          
            try {
              System.out.print(">>");
              int temp = scanner.nextInt();
              int sum = 0;
                for (int i = 0; i < x; i++){
                  if (temp == symptomsTemp[i]){
                    sum ++; //keeps track of the numbers in the array and checks if any of them have been repeated
                    break;
                }
              }
               if (sum == 0){
                 numberOfInputtedSymptoms ++;
                 symptomsTemp[x] = temp;
               }
    			} 
             catch(Exception e) {
    				if (scanner.next().equalsIgnoreCase("stop"))
    					break;
             }
    		}

    	int[] symptoms = new int[numberOfInputtedSymptoms];
    	int temp = 0;
      for(int x = 0; x < 34; x ++){
          if (symptomsTemp[x] == 0){
        	  for (int i = x; i < 34; i ++) {
        		 if (symptomsTemp[i] != 0) {
        			 temp = symptomsTemp[i];
        			 symptomsTemp[i] = 0;
        			 break;
        		 }
        	  }
            symptomsTemp[x] = temp;
          }
        }

    	  for(int x = 0; x < numberOfInputtedSymptoms; x++) {
          symptoms[x] = symptomsTemp[x];
    		}
        disease temp1 = diseaseData.getFirst();
		    for(int x = 0; x < diseaseData.getSize(); x++) {
			    calculateScore(temp1, symptoms, userSex, userAge);
			    temp1 = temp1.getNext();
		    }
        disease[] top3 = new disease[3];
		
		    for(int x = 0; x < 3; x++) {
    			disease highest = diseaseData.getFirst();
    			int a = 1;
    			while (highest.isTop3()) {
    				highest = highest.getNext();
    				a += 1;
    			}
    			disease current = highest.getNext();
    			for (int y = a; y < diseaseData.getSize(); y++) {
    				if (current.isTop3() == false && highest.getScore() < current.getScore()) {
    					highest = current;
    				}
    				current = current.getNext();
    			}
    			highest.setTop3(true);
    			top3[x] = highest;
    		}
    		
    		System.out.println("\nThese are the three most probable diseases you have in order: ");
    		for(int x = 0; x < 3; x++) {
          double score = Math.round(top3[x].getScore() * 100.0)/100.0;
          System.out.println("================================================");
    			System.out.println(top3[x].getName() + "  with a score of " + score);
          System.out.println("================================================");
    		}   
        System.out.println("A higher score indicates a higher probability that you have the disease");
      }
      
    else if(response == 2){
      System.out.println("Input the name of disease: ");
      System.out.print(">>");
      String name = scanner.next();

      System.out.println("Select symptoms from below:");
      printSymptom();
      int numberOfInputtedSymptoms = 0;
    		for(int x = 0; x < 34; x++) {
            try {
              System.out.print(">>");
              int temp = scanner.nextInt();
              int sum = 0;
                for (int i = 0; i < x; i++){
                  if (temp == symptomsTemp[i]){
                    sum ++; //keeps track of the numbers in the array and checks if any of them have been repeated
                    break;
                }
              }
               if (sum == 0){
                 numberOfInputtedSymptoms ++;
                 symptomsTemp[x] = temp;
               }
    			} 
             catch(Exception e) {
    				if (scanner.next().equalsIgnoreCase("stop"))
    					break;
             }
    		}

    	int[] symptomList = new int[numberOfInputtedSymptoms];
    	int temp = 0;
      for(int x = 0; x < 34; x ++){
          if (symptomsTemp[x] == 0){
        	  for (int i = x; i < 34; i ++) {
        		 if (symptomsTemp[i] != 0) {
        			 temp = symptomsTemp[i];
        			 symptomsTemp[i] = 0;
        			 break;
        		 }
        	  }
            symptomsTemp[x] = temp;
          }
        }

    	  for(int x = 0; x < numberOfInputtedSymptoms; x++) {
          symptomList[x] = symptomsTemp[x];
    		}
        System.out.println("What age range is most vulnerable? Enter the minimum age then the maximum age. If it affects all ages, indicate an age range of 0 to 100"); 
        System.out.print(">>");
        int minAge = scanner.nextInt();
        System.out.print(">>");
        int maxAge = scanner.nextInt();
        int sex = 0;
        System.out.println("Is one biological sex more vulnerable than the other? (M/F) If not applicable, enter 'none'");

      String tempSex = null;
      do {
          System.out.print(">>");
    			tempSex = scanner.next();
    		} while (!(tempSex.equalsIgnoreCase("M") || tempSex.equalsIgnoreCase("F")||tempSex.equalsIgnoreCase("none")));
    		if(tempSex.equalsIgnoreCase("M"))
    			sex = 1;
    		else if (tempSex.equalsIgnoreCase("F"))
    			sex = 2; 
        else
          sex = 0;

      System.out.println("Is the disease rare (<30% population) or common? (true for rare or false for common)");
      System.out.print(">>");
      Boolean rare = scanner.nextBoolean();
      diseaseData.newDisease(name, symptomList, maxAge, minAge, sex, rare);
      
      }
    else if(response == 3){
      diseaseData.DisplayDisease();
    }
  }while(response != 0);
  }

  public static void printSymptom(){
    System.out.println(""
          	+ "1	Body aches\r\n"
    				+ "2	Chest pain\r\n"
    				+ "3	Coughing up blood\r\n"
    				+ "4	Cough\r\n"
    				+ "5	Congestion\r\n"
    				+ "6	Drowsiness/tiredness\r\n"
    				+ "7	Difficulty sleeping\r\n"
    				+ "8	Difficulty breathing\r\n"
    				+ "9	Difficulty hearing\r\n"
    				+ "10	Diarrhea\r\n"
    				+ "11	Ear pain\r\n"
    				+ "12	Ear discharge/fluid\r\n"
    				+ "13	Fever\r\n"
    				+ "14	Fatigue\r\n"
    				+ "15	Facial pain\r\n"
    				+ "16	Fast breathing\r\n"
    				+ "17	Fainting\r\n"
    				+ "18	Headache\r\n"
    				+ "19	Hoarse voice\r\n"
    				+ "20	Inflamed/swollen tonsils\r\n"
    				+ "21	Irritation in and around ear canal\r\n"
    				+ "22	Loss of appetite\r\n"
    				+ "23	Loss of smell\r\n"
    				+ "24	Loss of taste\r\n"
    				+ "25	Muscle aches\r\n"
    				+ "26	Nausea\r\n"
    				+ "27	Pressure inside ear\r\n"
    				+ "28	Runny nose\r\n"
    				+ "29	Red/swollen outerear and ear canal\r\n"
    				+ "30	Rash\r\n"
    				+ "31	Shortness of breath\r\n"
    				+ "32	Sore/painful throat\r\n"
    				+ "33	Weight loss\r\n"
    				+ "34	Wheezing\r\n\n"
    				+ "Please input the corresponding numbers one by one. Type 'stop' after the final number: \n\r");
  }
}
