package net.aaronlab.todo.repository

import net.aaronlab.todo.config.AppConfig
import net.aaronlab.todo.database.ToDo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [TodoRepositoryImpl::class, AppConfig::class])
class TodoRepositoryTest {

    @Autowired
    lateinit var todoRepositoryImpl: TodoRepositoryImpl

    @BeforeEach
    fun before() {
        todoRepositoryImpl.todoDataBase.init()
    }

    @Test
    fun saveTest() {
        val todo = ToDo().apply {
            this.title = "Test Schedule"
            this.description = "Test Description"
            this.schedule = LocalDateTime.now()
        }

        val result = todoRepositoryImpl.save(todo)

        Assertions.assertEquals(1, result?.index)
        Assertions.assertNotNull(result?.createdAt)
        Assertions.assertNotNull(result?.updatedAt)
        Assertions.assertEquals("Test Schedule", result?.title)
        Assertions.assertEquals("Test Description", result?.description)
    }

    @Test
    fun saveAllTest() {
        val todoList = mutableListOf(
            ToDo().apply {
                this.title = "Test Schedule"
                this.description = "Test Description"
                this.schedule = LocalDateTime.now()
            },
            ToDo().apply {
                this.title = "Test Schedule"
                this.description = "Test Description"
                this.schedule = LocalDateTime.now()
            },
            ToDo().apply {
                this.title = "Test Schedule"
                this.description = "Test Description"
                this.schedule = LocalDateTime.now()
            }
        )

        val result = todoRepositoryImpl.saveAll(todoList)

        Assertions.assertEquals(true, result)
    }

    @Test
    fun findOneTest() {
        val todoList = mutableListOf(
            ToDo().apply {
                this.title = "Title 1"
                this.description = "Description 1"
                this.schedule = LocalDateTime.now()
            },
            ToDo().apply {
                this.title = "Title 2"
                this.description = "Description 2"
                this.schedule = LocalDateTime.now()
            },
            ToDo().apply {
                this.title = "Title 3"
                this.description = "Description 3"
                this.schedule = LocalDateTime.now()
            }
        )

        todoRepositoryImpl.saveAll(todoList)

        val result = todoRepositoryImpl.findOne(2)
        println(result)

        Assertions.assertNotNull(result)
        Assertions.assertEquals("Title 2", result?.title)
        Assertions.assertEquals("Description 2", result?.description)
    }

    @Test
    fun updateTest() {
        val todo = ToDo().apply {
            this.title = "Test Schedule"
            this.description = "Test Description"
            this.schedule = LocalDateTime.now()
        }

        val insertTodo = todoRepositoryImpl.save(todo)

        val newTodo = ToDo().apply {
            this.index = insertTodo?.index
            this.title = "Update Title"
            this.description = "Update Description"
            this.schedule = LocalDateTime.now()
        }

        val result = todoRepositoryImpl.save(newTodo)

        Assertions.assertNotNull(result)
        Assertions.assertEquals(insertTodo?.index, result?.index)
        Assertions.assertEquals("Update Title", result?.title)
        Assertions.assertEquals("Update Description", result?.description)
    }

}