package com.todoapp.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    TaskService taskService;

    @RequestMapping("/")
    public String mainPage(Model model){
        List<Task> list=taskService.getAll();
        model.addAttribute("todo", list);
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/records", method = RequestMethod.POST)
    public Task addTask(@RequestBody Task task, Model model){
        return taskService.save(task);
    }

    @ResponseBody
    @RequestMapping(value = "/records", method = RequestMethod.PUT)
    public Task updateTask(@RequestBody Task task, Model model){
        return taskService.save(task);
    }

    @ResponseBody
    @RequestMapping(value = "/records", method = RequestMethod.DELETE)
    public void deleteTask(@RequestBody Task task){
        taskService.delete(task);
    }
}
