package learn.memories.data;

import learn.memories.models.Memory;

import java.util.ArrayList;
import java.util.List;

public class MemoryRepositoryDouble implements MemoryRepository {

    private List<Memory> memories = new ArrayList<>();

    public MemoryRepositoryDouble() {
        memories.add(new Memory(1, "From 1", "Content 1", true));
        memories.add(new Memory(2, "From 2", "Content 2", true));
        memories.add(new Memory(3, "From 3", "Content 3", false));
    }

    @Override
    public List<Memory> findAll() throws DataAccessException {
        return new ArrayList<>(memories);
    }

    @Override
    public Memory findById(int memoryId) throws DataAccessException {
        for (Memory memory : memories) {
            if (memory.getId() == memoryId) {
                return memory;
            }
        }
        return null;
    }

    @Override
    public List<Memory> findShareable(boolean shareable) throws DataAccessException {
        List<Memory> result = new ArrayList<>();
        for (Memory memory : memories) {
            if (memory.isShareable() == shareable) {
                result.add(memory);
            }
        }
        return result;
    }

    @Override
    public Memory add(Memory memory) throws DataAccessException {
        return memory;
    }

    @Override
    public boolean update(Memory memory) throws DataAccessException {
        return findById(memory.getId()) != null;
    }

    @Override
    public boolean deleteById(int memoryId) throws DataAccessException {
        return findById(memoryId) != null;
    }
}
