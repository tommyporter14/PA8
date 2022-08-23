package co.grandcircus.PA8;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("animals")
public class Animal {

	@Id
	public String id;
	
	private String name;
	private String species;
	private int weight;
	private List<String> traits;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public List<String> getTraits() {
		return traits;
	}
	public void setTraits(List<String> traits) {
		this.traits = traits;
	}
	
	public Animal() {}
	
	public Animal(String name, String species, int weight, List<String> traits) {
		this.name = name;
		this.species = species;
		this.weight = weight;
		this.traits = traits;
	}
	
	
}
