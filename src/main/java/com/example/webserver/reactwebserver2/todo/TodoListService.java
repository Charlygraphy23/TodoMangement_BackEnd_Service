package com.example.webserver.reactwebserver2.todo;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TodoListService {

    private static List<Todo> todolist=new ArrayList<>();
    private static long counter=1;

    static {
        todolist.add(new Todo(counter++,"dip","Hello Prety Face", LocalDate.now().toString(),false));
        todolist.add(new Todo(counter++,"dip","Helarious", LocalDate.now().toString(),true));
        todolist.add(new Todo(counter++,"dip","Uncle Jak", LocalDate.now().toString(),false));
        todolist.add(new Todo(counter++,"dip","Charlygraphy23", LocalDate.now().toString(),false));
    }

    public List<Todo> getAllTodos(){
        return todolist;
    }

    public Todo getTodoById(Long id){
        for(int i=0;i<todolist.size();i++){
            if(id == todolist.get(i).getId()){
                System.out.print(todolist.get(i).getId());
                return  todolist.get(i);
            }
        }
        return null;
    }

    public void deleteTodobyId(Long id){
        Todo todo=getTodoById(id);
        todolist.remove(todo);
    }

    public void updateTodobyId(Todo todo){
        Todo to=getTodoById(todo.getId());
        todolist.remove(to);
        todolist.add(todo);
    }

    public Todo saveTodo(Todo todo){
        todo.setId(counter++);
        todolist.add(todo);
        return  todo;
    }

}
