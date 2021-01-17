package entity;

/**
 * @author apple
 * @date 2021/1/17 上午10:10
 * @description
 */
public class FileSystem {

    private String fileId;
    private String fileName;
    private String filePath;

    public FileSystem() {
    }

    public FileSystem(String fileId, String fileName, String filePath) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "FileSystem{" +
                "fileId='" + fileId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
