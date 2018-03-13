package com.todoapp.todo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task implements Serializable, Comparable<Task> {
    @Id
    @GeneratedValue
    int id;
    @Column
    String text;
    @Column
    boolean checked;

    public Task(){
        text="null";
        checked=false;
    }

    public Task(String text, boolean checked){
        this.text=text;
        this.checked=checked;
    }
    @Override
    public int compareTo(Task o) {
        return text.equals(o.text)?0:-1;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String toString() {
        return text;
    }
}
