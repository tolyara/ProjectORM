package transactions;

import java.sql.Connection;
import java.sql.SQLException;

import demo.MainClass;

public class Transaction implements ITransaction {

    private Connection connection;


    @Override
    public Connection getConnection() {
        return connection;
    }

    private void disableAutoCommit(){
        try {
             connection.setAutoCommit(false);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void enableAutoCommit(){
        try {
            connection.setAutoCommit(true);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void commit() {
        try {
            if (connection.getAutoCommit() == false) {
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rollback() {
        try {
            if(connection.getAutoCommit() == false){
                connection.rollback();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Connection close() {
        try {
            if(!connection.getAutoCommit())
                enableAutoCommit();

            if (!connection.isClosed() && connection != null) {
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}