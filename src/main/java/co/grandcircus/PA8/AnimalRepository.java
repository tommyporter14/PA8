package co.grandcircus.PA8;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimalRepository extends MongoRepository<Animal, String>{

	List<Animal> findAll();
	Optional<Animal> findById(String id);

}
