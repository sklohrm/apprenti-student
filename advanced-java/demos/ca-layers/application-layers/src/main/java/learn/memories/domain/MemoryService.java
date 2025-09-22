package learn.memories.domain;

import learn.memories.data.DataAccessException;
import learn.memories.data.MemoryRepository;
import learn.memories.models.Memory;

import java.util.List;

public class MemoryService {

    private final MemoryRepository repository;

    public MemoryService(MemoryRepository repository) {
        this.repository = repository;
    }

    public List<Memory> findShareableMemories() throws DataAccessException {
        return repository.findShareable(true);
    }

    public List<Memory> findPrivateMemories() throws DataAccessException {
        return repository.findShareable(false);
    }

    public MemoryResult add(Memory memory) throws DataAccessException {
        MemoryResult result = validate(memory);

        // Add specific validation
        if (memory.getId() > 0) {
            result.addErrorMessage("Memory ID should not be set.");
        }

        if (result.isSuccess()) {
            memory = repository.add(memory);
            result.setMemory(memory);
        }

        return result;
    }

    public MemoryResult update(Memory memory) throws DataAccessException {
        MemoryResult result = validate(memory);

        // Update specific validation
        if (memory.getId() <= 0) {
            result.addErrorMessage("Memory ID is required.");
        }

        if (result.isSuccess()) {
            if (repository.update(memory)) {
                result.setMemory(memory);
            } else {
                result.addErrorMessage("Memory ID " + memory.getId() + " was not found.");
            }
        }

        return result;
    }

    public MemoryResult deleteById(int memoryId) throws DataAccessException {
        MemoryResult result = new MemoryResult();
        Memory memoryToDelete = repository.findById(memoryId);

        if (!repository.deleteById(memoryId)) {
            result.addErrorMessage("Memory " + memoryId + " not found.");
        } else {
            result.setMemory(memoryToDelete);
        }

        return result;
    }

    private MemoryResult validate(Memory memory) {
        MemoryResult memoryResult = new MemoryResult();

        if(memory == null) {
            memoryResult.addErrorMessage("Memory cannot be Null.");
            return memoryResult;
        }

        if (memory.getFrom() == null || memory.getFrom().isEmpty()) {
            memoryResult.addErrorMessage("`From` field is required.");
        }

        if (memory.getContent() == null || memory.getContent().isEmpty()) {
            memoryResult.addErrorMessage("`Content` field is required.");
        }

        return memoryResult;
    }

}
