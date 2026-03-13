/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10443421poe1;
import javax.swing.JOptionPane;

/**
 *
 * @author mkbph
 */
    public class Application {
    private static final int TASKS = 100;
    private static String[] taskName = new String[TASKS];
    private static String[] developerName;
    private static int taskNumber;
    private static String taskDescription;
    private static String developerDescription;
    private static int[] taskDuration = new int[TASKS];
    private static String[] taskID;
    private static String[] taskStatus = new String[TASKS];
    private static int taskNum = 0;
    
    public boolean menu(){ 
     int choice;
     
     do{
        choice = Integer.parseInt(JOptionPane.showInputDialog("Welcome to EasyKanBan" 
                                                               + "\nChoose an option:"
                                                               + "\n 1. Add Task"
                                                               + "\n 2. Show Report"
                                                               + "\n 3. Display Longest Task"
                                                               + "\n 4. Search Task Developer"
                                                               + "\n 5. Delete Task"
                                                               + "\n 6. Quit"));
        switch(choice)//it is used to make a menu with the three options
        {
             case 1 -> addTasks();
             case 2 -> showReport();
             case 3 -> displayLongestTask();
             case 4 -> searchtasksByDeveloper();
             case 5 -> deleteTaskByName();
             case 6 -> Quit();
        }
    } while(choice !=6);   
        return false;
}


    public void addTasks(){
    //The user chooses this to add tasks 
    int taskNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter how many tasks would you want to add?"));
    
    for ( int i =0; 1 < taskNumber; i++){
    if(taskNum >= TASKS){
        JOptionPane.showMessageDialog(null, "Full");
    }
    
    String developerName = JOptionPane.showInputDialog(null, "Please Enter Developer Name");
    String taskName = JOptionPane.showInputDialog(null, "Please enter Task Name" + (i + 1));
    String taskDescription = JOptionPane.showInputDialog(null, "Please enter a short description of the task" + (i + 1));
    String taskStatus = JOptionPane.showInputDialog(null, "What is the current task status, Please type it in: " + "\nTo Do" + "\nDone" + "\nDoing" + (i + 1));
    int taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the amount of hours" + (i + 1)));
    String taskID = generatetaskID(taskName, taskNumber, developerName);
    taskNum++;
    
    

   
    if (checkTaskDescription(taskDescription)) {
    JOptionPane.showMessageDialog(null, "Task Description is successfully captured");//Task Description meets requirements
    } 
    else {
    JOptionPane.showMessageDialog(null, "Task Description is invalid, please try again.");//Task Description does not meet requirements
    }
    JOptionPane.showInputDialog(null, "Please input hours: " + returnTotalHours(taskDuration));
    JOptionPane.showInputDialog(null, "Please input Task ID: " + createTaskID(taskName, taskNumber, taskDescription));
    JOptionPane.showMessageDialog(null, printTaskDetails(taskStatus, taskNumber, taskName, developerDescription, taskID, taskDuration));
}
}   
    public void showReport(){
    StringBuilder sb = new StringBuilder("All captured tasks:\n");

    for (int i = 0; i < taskNum; i++) {
    sb.append("Task Name: ").append(taskName[i])
    .append(", Developer: ").append(developerName[i])
    .append(", Task ID: ").append(taskID[i])
    .append(", Duration: ").append(taskDuration[i])
    .append(" hours, Status: ").append(taskStatus[i])
    .append("\n");
}

    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
        
    public void Quit(){
     JOptionPane.showMessageDialog(null,"Good-Bye");
     //the users clicks on "Quit" to exit
    }
    //the methods
    public boolean checkTaskDescription(String taskDescription){
    return taskDescription.length() <= 50;  
    } //checks the length of the task Description
       
    public String createTaskID(String taskName, int taskNumber, String developerDetails){
    return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3);
    } //makes a task id with task name, task number and developer details
    
    public String printTaskDetails(String taskStatus, int taskNumber, String taskName, String developerDescription, String taskID,int taskDuration){
    return "Task Status: " + taskStatus + "\n" + 
            "Task Number: " + taskNumber + "\n" +
            "Task Name: " + taskName + "\n" +
            "Developer Description: " + developerDescription + "\n" + 
            "Task ID: " + taskID + "\n" +
            "Task Duration: " + taskDuration;
    } //Prints out the details
    
    public int returnTotalHours(int taskDuration){
    return taskDuration; //returns the hours
    }
    
    public void displayLongestTask() {
    int maxDurationIndex = 0;

    for (int i = 1; i < taskNum; i++) {
    if (taskDuration[i] > taskDuration[maxDurationIndex]) {
    maxDurationIndex = i;
    }
     
    }
    }
    
    private void searchtasksByDeveloper() {
    String developer = JOptionPane.showInputDialog("Enter Developer's Name to search:");

    StringBuilder sb = new StringBuilder("Tasks assigned to " + developerName + ":\n");

    for (int i = 0; i < taskNum; i++) {
    if (developerName[i].equalsIgnoreCase(developer)) {
    sb.append("Task Name: ").append(taskName[i]).append(", Status: ").append(taskStatus[i]).append("\n");
    }
    }

    JOptionPane.showMessageDialog(null, sb.toString());

    }
    
    
    private static void deleteTaskByName() {
    String taskNameDelete = JOptionPane.showInputDialog("Enter Task Name to delete:");

        for (int i = 0; i < taskNum; i++) {
            if (taskName[i].equalsIgnoreCase(taskNameDelete)) {
                for (int j = i; j < taskNum - 1; j++) {
                    developerName[j] = developerName[j + 1];
                    taskName[j] = taskName[j + 1];
                    taskID[j] = taskID[j + 1];
                    taskDuration[j] = taskDuration[j + 1];
                    taskStatus[j] = taskStatus[j + 1];
                    
    developerName[taskNum - 1] = null;
    taskName[taskNum - 1] = null;
    taskID[taskNum - 1] = null;
    taskDuration[taskNum - 1] = 0;
    taskStatus[taskNum - 1] = null;
                }

                taskNum--;
                JOptionPane.showMessageDialog(null, "Task deleted successfully!");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Task not found!");
    }
    
    private String generatetaskID(String taskName, int taskNumber, String developerName) {
  String taskNameIni = taskName.substring(0,2). toUpperCase();
   String developerNameIni = developerName.substring(developerName.length() - 3).toUpperCase();
    return taskNameIni + ":" + taskNumber + ":" + developerNameIni;
    }     
    private static void displayDoneTasks(){
    StringBuilder sb = new StringBuilder("Tasks with status 'Done':\n");

        for (int i = 0; i < taskNum; i++) {
            if (taskStatus[i].equalsIgnoreCase("done")) {
                sb.append("Developer: ").append(developerName[i]).append(", Task Name: ").append(taskName[i]).append(", Duration: ").append(taskDuration[i]).append(" hours\n");
            }
        }        JOptionPane.showMessageDialog(null, sb.toString());
    }

}
        /*
        Reference List:
        Aaron Maenpaa, 2023. How do i compare Strings in java[Online]
        Available at: https://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
        [Accessed 30 April 2024]
        */
