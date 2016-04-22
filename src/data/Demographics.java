package data;

import java.util.Map;

public class Demographics {
	private int genderMale;
	private int genderFemale;
	Map<String, Integer> genderCount;
	Map<String, Integer> salaryTotal;

	public Demographics() {
	}

	public int getGenderFemale() {
		return genderFemale;
	}
	public int getGenderMale() {
		return genderMale;
	}
	public Map<String, Integer> getGenderCount() {
		return genderCount;
	}
	public Map<String, Integer> getSalaryTotal() {
		return salaryTotal;
	}

	public void setGenderFemale(int genderFemale) {
		this.genderFemale = genderFemale;
	}
	public void setGenderMale(int genderMale) {
		this.genderMale = genderMale;
	}
	public void setGenderCount(Map<String, Integer> genderCount) {
		this.genderCount = genderCount;
	}
	public void setSalaryTotal(Map<String, Integer> salaryTotal) {
		this.salaryTotal = salaryTotal;
	}
}
