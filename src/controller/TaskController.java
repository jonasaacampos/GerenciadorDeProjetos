package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskController {
    public void save(Task task){

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
