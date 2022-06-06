package main;

import controller.ProjectController;
import model.Project;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProjectController projectController = new ProjectController();
        Project projetc = new Project();
        projetc.setName("teste1");
        projetc.setDescription("teste descrição");


        List<Project> projectList = projectController.getAll();
        System.out.println(projectList.size());

    }
}
