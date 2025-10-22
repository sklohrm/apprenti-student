package learn.pets.controllers;

import learn.pets.data.PetJdbcRepository;
import learn.pets.models.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pet")
public class PetController {

    private final PetJdbcRepository repository;

    public PetController(PetJdbcRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Pet> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{petID}")
    public ResponseEntity<Pet> findById(@PathVariable int petID) {
        Pet pet = repository.findById(petID);
        if (pet == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @GetMapping("/name/{petName}")
    public ResponseEntity<Pet> findByName(@PathVariable String petName) {
        Pet pet = repository.findByName(petName);
        if (pet == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pet> add(@RequestBody Pet pet) {
        if (pet.getPetId() != 0) {
            return new ResponseEntity<>(null, HttpStatus.UNPROCESSABLE_ENTITY);
        }

        Pet result = repository.add(pet);
        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody Pet pet) {
        boolean success = repository.update(pet);
        Pet updatedPet = repository.findById(pet.getPetId());

        if (success) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            if (repository.findById(petID) == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/{petID}")
    public ResponseEntity<Void> deleteByID(@PathVariable int petID) {
        boolean success = repository.deleteById(petID);

        if (success) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}