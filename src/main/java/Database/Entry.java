package Database;

import java.sql.Timestamp;

public class Entry {

    long id;
    String name;
    String websiteURL;
    int status;
    Timestamp creationDate;

    public Entry(long id, String name, String websiteURL, int status, Timestamp creationDate) {
        this.id = id;
        this.name = name;
        this.websiteURL = websiteURL;
        this.status = status;
        this.creationDate = creationDate;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", websiteURL='" + websiteURL + '\'' +
                ", status=" + status +
                ", creationDate=" + creationDate +
                '}';
    }
}
