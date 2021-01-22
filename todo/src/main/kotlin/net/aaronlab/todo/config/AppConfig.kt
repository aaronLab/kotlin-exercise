package net.aaronlab.todo.config

import net.aaronlab.todo.database.TodoDataBase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean(initMethod = "init")
    fun todoDataBase(): TodoDataBase {
        return TodoDataBase()
    }

}