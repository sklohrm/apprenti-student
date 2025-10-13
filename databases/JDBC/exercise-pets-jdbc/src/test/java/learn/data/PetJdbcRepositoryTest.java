package learn.pets.data;

import learn.data.PetJdbcRepository;
import learn.models.Pet;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PetJdbcRepositoryTest {

    PetJdbcRepository repository = new PetJdbcRepository();

    @Test
    void shouldAddPet() {
        Pet pet = new Pet();
        pet.setName("Charlie");
        pet.setType("Parrot");

        Pet actual = repository.add(pet);

        assertNotNull(actual);
        assertTrue(actual.getPetId() > 0);
    }

    @Test
    void shouldFindAllPets() {
        List<Pet> pets = repository.findAll();
        assertNotNull(pets);
        assertTrue(pets.size() > 0);
    }

    @Test
    void shouldUpdatePet() {
        Pet pet = repository.findAll().get(0);
        pet.setName("Updated Name");

        assertTrue(repository.update(pet));
        assertEquals("Updated Name", repository.findAll().get(0).getName());
    }

    @Test
    void shouldDeletePet() {
        Pet pet = new Pet();
        pet.setName("Temp Pet");
        pet.setType("Lizard");
        Pet added = repository.add(pet);

        assertTrue(repository.deleteById(added.getPetId()));
    }
}
