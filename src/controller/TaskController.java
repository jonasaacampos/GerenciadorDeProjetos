package controller;

import model.Task;
import util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
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
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar a tarefa " + ex.getMessage(), ex);
        } finally {
            //Fecha as conexoes
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
        }


    }

    public void update(Task task){
        String sql = "UPDATE tasks SET projectId = ?, name = ?, description = ?, status = ?, " +
                "notes = ?, deadline = ?, createdAt = ?, updatedAt = ? WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //Cria uma conex�o com o banco
            connection = ConnectionFactory.getConnection();
            //Cria um PreparedStatment, classe usada para executar a query
            statement = connection.prepareStatement(sql);

            statement.setInt     (1, task.getProjectID());
            statement.setString  (2, task.getName());
            statement.setString  (3, task.getDescription());
            statement.setBoolean (4, task.getStatus());
            statement.setString  (5, task.getNotes());
            statement.setDate    (6, new java.sql.Date(task.getDeadLine().getTime()));
            statement.setDate    (7, new java.sql.Date(task.getCreatedAt().getTime()));
            statement.setDate    (8, new java.sql.Date(task.getUpdatedAt().getTime()));
            statement.setInt     (9, task.getId());

            //Executa a sql para inser��o dos dados
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro em atualizar a tarefa", ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
        }

    }

    public void removeById(Task id) throws SQLException {
        String sql = "DELETE FROM tasks WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //cria conexão com database
            connection = ConnectionFactory.getConnection();
            //prepara a query
            statement = connection.prepareStatement(sql);
            //substitui o primero ? pelo parametro a ser executado
            statement.setObject(1, id);
            statement.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar a tarefa");
        }finally {
            ConnectionFactory.closeConnection(connection);
        }
    }

    public List<Task> getAll(){
        String sql = "SELECT * FROM tasks where idProject = ?";

        List<Task> tasks = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        //Classe que vai recuperar os dados do banco de dados
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            // retorno da execução da query
            resultSet = statement.executeQuery();

            //Enquanto existir dados no banco de dados, execute...
            while (resultSet.next()) {

                Task task = new Task();

                task.setId(resultSet.getInt("id"));
                task.setProjectID(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadLine(resultSet.getDate("deadline"));
                task.setStatus(resultSet.getBoolean("completed"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setCreatedAt(resultSet.getDate("updatedAt"));

                //Adiciono o contato recuperado, a lista de contatos
                tasks.add(task);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar as tarefas", ex);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
        }
        return tasks; // lista de tarefas criada e mostrada no banco de dados.
    }

}
