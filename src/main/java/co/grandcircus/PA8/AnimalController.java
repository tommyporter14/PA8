package co.grandcircus.PA8;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {

	@ResponseBody
	@ExceptionHandler(AnimalNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String itemNotFoundHandler(AnimalNotFoundException ex) {
		return ex.getMessage();
	}
	
	@Autowired
	private AnimalRepository ar;
	
	@GetMapping("/animals")
	public List<Animal> showAll() {
		return ar.findAll();
	}
	
	@GetMapping("/animals/{id}")
	public Animal showById(@PathVariable("id") String id) {
		return ar.findById(id).orElseThrow(() -> new AnimalNotFoundException("Pet Not Found"));
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/animals")
	public Animal createAnimal(@RequestBody Animal animal) {
		ar.insert(animal);
		return animal;
	}
	
	@PutMapping("/animals/{id}")
	public Animal updateOne(@RequestBody Animal animal, @PathVariable("id") String id) {
		Animal a = ar.findById(id).get();
		a.setTraits(animal.getTraits());
		ar.save(a);
		return a;	
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/animals/{id}")
	public void deleteOne(@PathVariable("id") String id) {
		Animal a = ar.findById(id).get();
		a.setTraits(null);
		ar.save(a);
	}
	
	
}
