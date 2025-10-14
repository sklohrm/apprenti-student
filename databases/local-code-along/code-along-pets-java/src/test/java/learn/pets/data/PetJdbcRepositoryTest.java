package learn.pets.data;

import learn.pets.models.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PetJdbcRepositoryTest {

    PetJdbcRepository repo = new PetJdbcRepository();

    @BeforeEach
    void setup() {

    }

//    @Test
//    void shouldFindAll() {
//        List<Pet> pets = repo.findAll();
//        assertEquals(4, pets.size());
//    }

    @Test
    void shouldFindPetByName() {
        Pet pet = repo.findByName("Chloe");
        assertEquals("Chloe", pet.getName());
    }

    @Test
    void shouldFindPetById() {
        Pet pet = repo.findByName("Chloe");
        assertEquals(104, pet.getPetId());
    }

    @Test
    void shouldAdd() {
        Pet pet = new Pet();
        pet.setName("Chowder");
        pet.setType("Mongoose");
        Pet actual = repo.add(pet);
        System.out.println(actual);
        assertNotNull(actual);
        assertTrue(actual.getPetId() > 100);
    }

    @Test
    void shouldUpdateExisting() {
        Pet pet = new Pet();
        pet.setPetId(105);
        pet.setName("Sylvester");
        pet.setType("Salmon");
        assertTrue(repo.update(pet));
        assertEquals(pet, repo.findById(105));
    }

    @Test
    void shouldDelete() {
        assertTrue(repo.deleteById(105));
    }
}