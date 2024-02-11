package model;

public class User {
    private String createdAt;
    private String name;
    private String id;
    private String job;

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getJob() {
        return job;
    }
}
