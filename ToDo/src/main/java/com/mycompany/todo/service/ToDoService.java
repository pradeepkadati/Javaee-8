/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.todo.service;

import com.mycompany.todo.entity.Todo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author kadat
 */
@Transactional
public class ToDoService {
 
    @PersistenceContext
    EntityManager entityManager;
    
    public Todo createTodo(Todo todo){
       entityManager.persist(todo);
        return todo;
    }
    
    public Todo updateTodo(Todo todo){
       entityManager.merge(todo);
       return todo;
    }
    
    public Todo findTodoById(Long id){
      return  entityManager.find(Todo.class, id);
    }
    
    public List<Todo> getTodos(){
        
        return entityManager.createQuery("Select t from Todo t", Todo.class).getResultList();
    }
}
