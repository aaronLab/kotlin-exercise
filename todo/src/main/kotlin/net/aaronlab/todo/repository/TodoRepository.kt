package net.aaronlab.todo.repository

import net.aaronlab.todo.database.ToDo

interface TodoRepository {

    fun save(todo: ToDo): ToDo?
    fun saveAll(todoList: MutableList<ToDo>): Boolean

    fun delete(index: Int): Boolean

    fun findOne(index: Int): ToDo?
    fun findAll(): MutableList<ToDo>

}