package net.aaronlab.todo.database

data class TodoDataBase(
    var index: Int = 0,
    var todoList: MutableList<ToDo> = mutableListOf()
) {

    fun init() {
        this.index = 0
        this.todoList = mutableListOf()
        println("[DEBUG] todo database init")
    }

}