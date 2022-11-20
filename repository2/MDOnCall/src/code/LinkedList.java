package code;

public class LinkedList {
	private disease first;
	private disease last;
	private int size = 0;
	public LinkedList () {
		first = null;
		last = null;
		size = 0;
	}
	public void newDisease(String name, int[] symptoms, int maxAge, int minAge, int sexPreference, boolean rare) {
		disease temp = new disease (name, symptoms, maxAge, minAge, sexPreference, rare);
		if (first == null) {
			first = temp;
			last = temp;
			first.setNext(null);
			first.setPrev(null);
		}
		else {
			last.setNext(temp);
			temp.setPrev(last);
			last = temp;
		}
		size++;
		
	}
  public disease getFirst() {
		return first;
	}
	public void setFirst(disease first) {
		this.first = first;
	}
	public disease getLast() {
		return last;
	}
	public void setLast(disease last) {
		this.last = last;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
  
  public void SetupExistingDisease() 
  
  {
		int[] otitisMediaSyp = {13, 7, 9, 11};
		this.newDisease("Otitis Media", otitisMediaSyp, 2, 0, 1, false);
		
		int[] croup = {13, 11, 9};
		this.newDisease("Croup", croup, 3, 0, 1, true);

    int[] lowerRTI = {13, 5, 28, 4, 32, 18};
    this.newDisease("Lower TRI", lowerRTI, 100, 65, 1, false);

    int[] otitisExterna = {11, 21, 29, 27, 9, 12};
    this.newDisease("Otitis Externa", otitisExterna, 12, 7, 1, true);

    int[] tonsillitis  = {13, 20, 32, 11, 4, 18};
    this.newDisease("Tonsillitis", tonsillitis, 18, 0, 2, false);

    //1 = male, 2 = female
    //rare == true
    //common == false
    int[] lungCancer = {4, 2, 31, 3, 33, 14};
    this.newDisease("Lung Cancer", lungCancer, 65, 0, 1, true);

    int[] sinusitis = {28, 33, 4, 15, 5};
    this.newDisease("Sinusitis", sinusitis, 7, 7, 2, false);

    int[] asthma = {34, 4, 15, 5, 17};
    this.newDisease("Asthma", asthma, 65, 1, 0, false);

    int[] strepThroat = {1, 13, 18, 20, 26, 30, 32};
    this.newDisease("Strep throat", strepThroat, 15, 5, 0, false);

    int[] covid = {4, 13, 6, 24, 23, 18, 32, 8, 10};
    this.newDisease("Covid", covid, 65, 1, 0, false);

    int[] mononucleosis = {13, 14, 32, 22, 25};
    this.newDisease("Mononucleosis", mononucleosis, 25, 15, 0, false);
    
	}
  public static String symptomFinder(int number) {
    String symptomName = "";
    switch (number) {
      case 1:
        symptomName = "Body Aches";
        break;
      case 2:
        symptomName = "Chest pain";
        break;
      case 3:
        symptomName = "Coughing up blood";
        break;
      case 4:
        symptomName = "Cough";
        break;
      case 5:
        symptomName = "Congestion";
        break;
      case 6:
        symptomName = "Drowisiness/tiredness";
        break;
      case 7:
        symptomName = "Difficulty sleeping";
        break;
      case 8:
        symptomName = "Difficulty breathing";
        break;
      case 9:
        symptomName = "Difficulty hearing";
        break;
      case 10:
        symptomName = "Diarrhea";
        break;
      case 11:
        symptomName = "Ear pain";
        break;
      case 12:
        symptomName = "Ear discharage/fluid";
        break;
      case 13:
        symptomName = "Fever";
        break;
      case 14:
        symptomName = "Fatigue";
        break;
      case 15:
        symptomName = "Facial pain";
        break;
      case 16:
        symptomName = "Fast breathing";
        break;
      case 17:
        symptomName = "Fainting";
        break;
      case 18:
        symptomName = "Headache";
        break;
      case 19:
        symptomName = "Hoarse voice";
        break;
      case 20:
        symptomName = "Inflamed/swollen tonsils";
        break;
      case 21:
        symptomName = "Irritation in and around ear canal";
        break;
      case 22:
        symptomName = "Loss of appetite";
        break;
      case 23:
        symptomName = "Loss of smell";
        break;
      case 24:
        symptomName = "Loss of taste";
        break;
      case 25:
        symptomName = "Muscle aches";
        break;
      case 26:
        symptomName = "Nausea";
        break;
      case 27:
        symptomName = "Pressure inside ear";
        break;
      case 28:
        symptomName = "Runny nose";
        break;
      case 29:
        symptomName = "Red/swollen outerear and ear canal";
        break;
      case 30:
        symptomName = "Rash";
        break;
      case 31:
        symptomName = "Shortness of breath";
        break;
      case 32:
        symptomName = "Sore/painful throat";
        break;
      case 33:
        symptomName = "Weight loss";
        break;
      case 34:
        symptomName = "Wheezing";
        break;
    }
    return symptomName;
  }
  
  public void DisplayDisease() {
		disease temp = this.first;
		for (int x = 0; x < this.size; x++) {
			System.out.println(temp.getName() + ":");
			System.out.print("Symptoms: ");
			for (int y = 0; y < temp.getSymptoms().length; y++) {
				System.out.print("\n- " + symptomFinder(temp.getSymptoms()[y]));
			}
			System.out.println();
			System.out.println("Most afflicted age range: " + temp.getMinAge() + " - " + temp.getMaxAge() + " years old");
			if (temp.getSexPreference() == 1)
				System.out.println("More common in male");
			else if (temp.getSexPreference() == 2)
				System.out.println("More common in female");
			else 
				System.out.println("Not affected by sex");

      String rarity = "";
      if (temp.isRare()){
        rarity = "Yes";
      }
      else if (!temp.isRare()){
        rarity = "No";
      }
			System.out.println("Is this disease rare? " + rarity); 
			System.out.println();
			temp = temp.getNext();
		}
		
	}
  

}

	
  
