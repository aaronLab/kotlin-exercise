package net.aaronlab.todo.repository

import net.aaronlab.todo.database.ToDo
import net.aaronlab.todo.database.TodoDataBase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.time.LocalDateTime

@Service
class TodoRepositoryImpl : TodoRepository {

    @Autowired
    lateinit var todoDataBase: TodoDataBase

    override fun save(todo: ToDo): ToDo? {

        return todo.index?.let { index ->
            // Update
            findOne(index)?.apply {
                this.title = todo.title
                this.description = todo.description
                this.schedule = todo.schedule
                this.updatedAt = LocalDateTime.now()
            }
        } ?: kotlin.run {
            // Insert
            todo.apply {
                this.index = ++todoDataBase.index
                this.createdAt = LocalDateTime.now()
                this.updatedAt = LocalDateTime.now()
            }.run {
                todoDataBase.todoList.add(todo)
                this
            }
        }

    }

    override fun saveAll(todoList: MutableList<ToDo>): Boolean {
        return try {

            todoList.forEach {
                save(it)
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun delete(index: Int): Boolean {
        return findOne(index)?.let {
            todoDataBase.todoList.remove(it)
            true
        } ?: kotlin.run {
            false
        }
    }

    override fun findOne(index: Int): ToDo? {
        return todoDataBase.todoList.first { it.index == index }
    }

    override fun findAll(): MutableList<ToDo> {
        return todoDataBase.todoList
    }

}