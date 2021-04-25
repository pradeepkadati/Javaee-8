/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.todo.rest;

import com.mycompany.todo.entity.Todo;
import com.mycompany.todo.service.ToDoService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author kadat
 */
@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ToDoRest {

    @Inject
    ToDoService tds;

    @Path("new")
    @POST
    public Response createTodo(Todo todo) {
        tds.createTodo(todo);
        return Response.ok(todo).build();
    }

    @Path("update")
    @PUT
    public Response updateTodo(Todo todo) {
        tds.updateTodo(todo);
        return Response.ok(todo).build();
    }

    @Path("{id}")
    @GET
    public Todo findById(@PathParam("id") Long id) {
        return tds.findTodoById(id);
    }
    
    @Path("list")
    @GET
    public List<Todo> getTodos() {
        return tds.getTodos();
    }

    @Path("status")
    @POST
    public Response markAsComplete(@QueryParam("id") Long id){
        
        Todo todo = tds.findTodoById(id);
        todo.setCompleted(true);
        tds.updateTodo(todo);
        return Response.ok(todo).build();
    }
}
