package learn.memories.data;

import learn.memories.models.Memory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemoryFileRepository implements MemoryRepository {

    private final String filePath;
    private final String delimiter = "~";

    public MemoryFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Memory> findAll() throws DataAccessException {
        List<Memory> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            for(String line = reader.readLine(); line != null; line = reader.readLine()) {
                Memory m = lineToMemory(line);
                if (m != null) {
                    result.add(m);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Something happened.");
        } catch (IOException e) {
            throw new DataAccessException("Could not open file path + file path", e);
        }

        return result;
    }

    @Override
    public Memory findById(int memoryId) throws DataAccessException {
        List<Memory> all = findAll();
        for (Memory memory : all) {
            if (memory.getId() == memoryId) {
                return memory;
            }
        }
        return null;
    }

    @Override
    public List<Memory> findShareable(boolean shareable) throws DataAccessException {
        List<Memory> result = new ArrayList<>();
        for (Memory memory : findAll()) {
            if (memory.isShareable() == shareable) {
                result.add(memory);
            }
        }
        return result;
    }

    @Override
    public Memory add(Memory memory) throws DataAccessException {
        List<Memory> all = findAll();
        int nextId = getNextId(all);
        memory.setId(nextId);
        all.add(memory);
        writeToFile(all);
        return memory;
    }

    @Override
    public boolean update(Memory memory) throws DataAccessException {
        List<Memory> all = findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getId() == memory.getId()) {
                all.set(i, memory);
                writeToFile(all);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(int memoryId) throws DataAccessException {
        List<Memory> all = findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getId() == memoryId) {
                all.remove(i);
                writeToFile(all);
                return true;
            }
        }
        return false;
    }


    //Helper methods
    private Memory lineToMemory(String line) {
        String[] fields = line.split(delimiter);

        return new Memory(
                Integer.parseInt(fields[0]),
                fields[1],
                fields[2],
                "true".equals(fields[3])
        );
    }

    private String memoryToLine(Memory memory) {
        StringBuilder result = new StringBuilder(100);
        result.append(memory.getId()).append(delimiter);
        result.append(cleanField(memory.getFrom())).append(delimiter);
        result.append(cleanField(memory.getContent())).append(delimiter);
        result.append(memory.isShareable()).append(delimiter);
        return result.toString();
    }

    private String cleanField(String field) {
        return field.replace("/r", "").replace("/n", "");
    }

    private int getNextId(List<Memory> memories) {
        int maxId = 0;
        for (Memory memory : memories) {
            if (maxId < memory.getId()) {
                maxId = memory.getId();
            }
        }
        return maxId + 1;
    }

    private void writeToFile(List<Memory> memories) throws DataAccessException {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (Memory memory : memories) {
                writer.println(memoryToLine(memory));
            }
        } catch (IOException e) {
            throw new DataAccessException("Could not open file path + file path", e);
        }
    }
}
