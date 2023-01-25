import java.util.Objects;
import java.util.Random;

public class FileData {
    private String fileName;
    private int byteSize;

    private String filePath;

    public FileData(String fileName, int byteSize, String filePath) {
        this.fileName = fileName;
        this.byteSize = byteSize;
        this.filePath = filePath;
    }
    public FileData(String fileName, String filePath) {
        this.fileName = fileName;
        Random random = new Random();
        this.byteSize = random.nextInt(0, 98123756);
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getByteSize() {
        return byteSize;
    }

    public void setByteSize(int byteSize) {
        this.byteSize = byteSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileData fileData = (FileData) o;
        return Objects.equals(fileName, fileData.fileName) && Objects.equals(filePath, fileData.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, byteSize, filePath);
    }


    @Override
    public String toString() {
        return "\nFileData{" +
                "fileName='" + fileName + '\'' +
                ", byteSize=" + byteSize +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
