package assignment3.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class HealthProfile {

	@Id
	@GeneratedValue
	private Long healthprofile_id;

	private Long person_id;

	private Double weight;
	private Double height;
	private Date date;
	private Integer steps;
	private Integer calories;

	public HealthProfile() {
		super();
	}

	public HealthProfile(Long personId, Double weight, Double height, Date date, Integer steps, Integer calories) {
		super();
		this.person_id = personId;
		this.weight = weight;
		this.height = height;
		this.date = date;
		this.steps = steps;
		this.calories = calories;
	}

	public Long getHealthprofile_id() {
		return healthprofile_id;
	}

	public void setHealthprofile_id(Long healthprofile_id) {
		this.healthprofile_id = healthprofile_id;
	}

	public Long getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Long person_id) {
		this.person_id = person_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getBmi() {
		return weight / (height * height);
	}
	
	public Integer getSteps() {
		return steps;
	}

	public void setSteps(Integer steps) {
		this.steps = steps;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}
	
	public String toString(){
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		if (healthprofile_id != null)
			return healthprofile_id + ") " + weight + "kg, " + height + "m, on " + df.format(date) + " : (" + steps + " steps -> " + calories + " calories)";
		else 
			return weight + "kg, " + height + "m, on " + df.format(date) + " : (" + steps + " steps -> " + calories + " calories)";
	}

}
