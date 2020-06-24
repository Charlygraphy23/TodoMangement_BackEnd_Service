package com.example.webserver.reactwebserver2.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoListJpaController {

        @Autowired
        private TodoListService todoListService;

        @Autowired
        private TodoJpaRepository todoJpaRepository;


        @GetMapping(path = "/jpa/users/{username}/todos")
        public List<Todo> getTodos(@PathVariable String username){
    //        Collections.sort(todoListService.getAllTodos());
            return todoJpaRepository.findByUsername(username);
        }

    @GetMapping(path = "/jpa/users/{username}/todos/{id}")
        public Todo getTodobyID(@PathVariable String username , @PathVariable long id){
            return todoJpaRepository.findById(id).get();
        }

        @DeleteMapping(path = "/jpa/users/{username}/todos/{id}")
        public void deleteTodo(@PathVariable String username , @PathVariable long id){
                todoJpaRepository.deleteById(id);
        }

        @PutMapping(path = "/jpa/users/{username}/todos/{id}")
        public void updateTodoList(@PathVariable String username , @PathVariable long id , @RequestBody Todo todo){
            todo.setUsername(username);
            todoJpaRepository.save(todo);
        }

        @PostMapping(path = "/jpa/users/{username}/todos")
        public ResponseEntity<Void> saveTodo(@PathVariable String username, @RequestBody Todo todo){

                todo.setUsername(username);
                Todo createTodo= todoJpaRepository.save(todo);

                //servlet uri build using id
                // return uri that build

                URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(createTodo.getId()).toUri();
                return ResponseEntity.created(uri).build();
        }

}
