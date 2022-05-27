package controller;

import model.Task;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TaskController {
    public void save(Task task){
        String sql = "INSERT INTO tasks (" +
                "idProject, " +
                "name, " +
                "description, " +
                "status, " +
                "notes, " +
                "deadLine, " +
                "createdAt, " +
                "updatedAt) VALUES (?,?,?,?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,task.getProjectID());
            statement.setString(2,task.getName());
            statement.setString(3,task.getDescription());
            statement.setBoolean(4,task.getStatus());
            statement.setString(5,task.getNotes());
            statement.setDate(6, new Date(task.getDeadLine().getTime()));
            statement.setDate(7,new Date(task.getCreatedAt().getTime()));
            statement.setDate(8,new Date(task.getUpdatedAt().getTime()));
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa" +
                    ex.getMessage(), ex);
        }finally {
            ConnectionFactory.closeConnection(connection);
        }


    }

    public void update(Task task){

    }

    public void removeById(Task taskId){
        String sql = "DELETE FROM tasks WHERE ID = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            //substitui o primero ? pelo parametro a ser executado
            statement.sqlInt(1,taskId);

        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar a tarefa");
        }finally {
            ConnectionFactory.closeConnection(connection);
        }

    }

    public List<Task> getAll(int projectId){
        return null;
    }



}
