package code;

public class disease {
	private String name;
	private int[] symptoms;
	private int maxAge;
	private int minAge;
	private int sexPreference = 0;
	private disease next;
	private disease prev;
	private double score = 0;
	private boolean top3;

	
	
	public disease(String name, int[] symptoms, int maxAge, int minAge, int sexPreference, boolean rare) {
		this.name = name;
		this.symptoms = symptoms;
		this.maxAge = maxAge;
		this.minAge = minAge;
		this.sexPreference = sexPreference;
		this.rare = rare;
	}
	public boolean isTop3() {
		return top3;
	}

	public void setTop3(boolean top3) {
		this.top3 = top3;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public disease getNext() {
		return next;
	}
	public void setNext(disease next) {
		this.next = next;
	}
	public disease getPrev() {
		return prev;
	}
	public void setPrev(disease prev) {
		this.prev = prev;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(int[] symptoms) {
		this.symptoms = symptoms;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getSexPreference() {
		return sexPreference;
	}
	public void setSexPreference(int sexPreference) {
		this.sexPreference = sexPreference;
	}
	public boolean isRare() {
		return rare;
	}
	public void setRare(boolean rare) {
		this.rare = rare;
	}
	private boolean rare;
	
	
	
}
