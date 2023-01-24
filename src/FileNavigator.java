import java.util.*;

public class FileNavigator {
    /**
     * k = path, v = list of files
     */
    private final HashMap<String, ArrayList<FileData>> filesOnPath;

    {
        this.filesOnPath = new HashMap<>();
    }

    public void add(FileData file, String path) {
        if (Objects.isNull(path) || path.isEmpty()) {
            path = "";
        }
        if (Objects.isNull(file)) {
            return;
        }

        /* test for consistency */
        if (!file.getFilePath().equals(path)) {
            System.out.printf("Error! File paths in file '%s' do not match. Could not add!%n", file.getFileName());
            return;
        }

        if (filesOnPath.containsKey(path)) {
            filesOnPath.get(path).add(file);
            return;
        }
        filesOnPath.put(path, new ArrayList<>() {{add(file);}});
    }

    public ArrayList<FileData> find(String path) {
        if (Objects.isNull(path)) {
            return new ArrayList<>();
        }
        if (!filesOnPath.containsKey(path)) {
            return new ArrayList<>();
        }

        return filesOnPath.get(path);
    }

    public List<FileData> filterBySize(int maxSize) {
        System.out.println("filterBySize");

        ArrayList<FileData> filteredFiles = new ArrayList<>();

        for (ArrayList<FileData> fileDataArrayList : filesOnPath.values()) {
            for (FileData fileData : fileDataArrayList) {
                if (fileData.getByteSize() <= maxSize){
                    filteredFiles.add(fileData);
                }
            }
        }

        return filteredFiles;
    }

    public List<FileData> sortBySize() {
        System.out.println("sortBySize");
        if (filesOnPath.size() < 1) {
            return new ArrayList<>();
        }

        ArrayList<FileData> sort = new ArrayList<>();

        for (ArrayList<FileData> fileDataArrayList : filesOnPath.values()) {
            sort.addAll(fileDataArrayList);
        }
        if (sort.size() < 2) {
            return sort;
        }

        //сделал сначала через компаратор, ide предложила лямбду
        sort.sort((o1, o2) -> o1.getByteSize() - o2.getByteSize());

        return sort;
    }

    public void remove(String path) {
        if (Objects.isNull(path)) {
            return;
        }

        filesOnPath.remove(path);
    }

    public void printAll() {
        System.out.println(filesOnPath.entrySet());
    }
}
