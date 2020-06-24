package com.example.webserver.reactwebserver2.todo;


import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    private String tasks,tdate,username;
    private boolean isComplete;

    public Todo() {
    }

    public Todo(Long id,String username, String tasks, String tdate, boolean isComplete) {
        this.id = id;
        this.username=username;
        this.tasks = tasks;
        this.tdate = tdate;
        this.isComplete = isComplete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public String getDate() {
        return tdate;
    }

    public void setDate(String tdate) {
        this.tdate = tdate;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", tasks='" + tasks + '\'' +
                ", date='" + tdate + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }

    //    @Override
//    public int compareTo(Todo o) {
//        return Long.compare(this.getId(),o.getId());
//    }
}
