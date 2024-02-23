import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size = 0;
    private final Resume[] storage = new Resume[10000];

    private Integer findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(storage[i].uuid, uuid)) {
                return i;
            }
        }
        return null;
    }

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        Integer resumeIndex = findIndex(uuid);
        if (resumeIndex != null) {
            return storage[resumeIndex];
        } else {
            return null;
        }

    }

    void delete(String uuid) {
        Integer resumeIndex = findIndex(uuid);
        if (resumeIndex != null) {
            if (resumeIndex != size - 1) {
                storage[resumeIndex] = storage[size - 1];
            }
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;
    }
}
