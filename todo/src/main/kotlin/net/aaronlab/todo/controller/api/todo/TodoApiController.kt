package net.aaronlab.todo.controller.api.todo

import net.aaronlab.todo.model.http.TodoDto
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/todo")
class TodoApiController {

    // C
    @PostMapping(path = [""])
    fun create(@Valid @RequestBody todoDto: TodoDto) {
        print(todoDto)
    }

    // R

    @GetMapping(path = [""])
    fun read(@RequestParam(required = false) index: Int?) {
    }

    // U
    @PutMapping(path = [""])
    fun update(@Valid @RequestBody todoDto: TodoDto) {
    }

    // D
    @DeleteMapping(path = ["/{index}"])
    fun delete(@PathVariable(name = "index") _index: Int) {
    }

}