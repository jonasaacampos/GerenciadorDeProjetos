package model;

import java.util.Date;

public class Task {
    private int id;
    private int projectID;
    private String name;
    private String description;
    private String notes;
    private Boolean status;
    private Date deadLine;
    private Date createdAt;
    private Date updatedAt;

    public Task(){
        this.status = false;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Task(int id, int projectID, String name, String description, String notes, Boolean status, Date deadLine, Date createdAt, Date updatedAt) {
        this.id = id;
        this.projectID = projectID;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.status = status;
        this.deadLine = deadLine;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", ipProject=" + projectID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                ", status=" + status +
                ", deadLine=" + deadLine +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
