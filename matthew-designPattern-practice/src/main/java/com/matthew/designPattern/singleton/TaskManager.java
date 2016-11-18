package com.matthew.designPattern.singleton;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-09 16:48
 */
public class TaskManager {
    private static TaskManager  taskManager=null;
    private TaskManager(){};
    public static  TaskManager getInstance(){
        if(taskManager ==  null){
            taskManager = new TaskManager();
        }
        return taskManager;
    }
}
