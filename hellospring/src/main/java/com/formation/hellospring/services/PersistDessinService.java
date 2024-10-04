package com.formation.hellospring.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.hellospring.CustomDataSource;
import com.formation.hellospring.models.DessinModel;

@Service
public class PersistDessinService {
    @Autowired
    CustomDataSource dsDessins;

    private Connection cnx = null;

    public PersistDessinService(){
        System.out.println("PersistDessinService CTR");
    }

    private void checkConnection() {
        if(cnx == null) {
            try {
                cnx = dsDessins.localeDataSource.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<String> getAllDraw() {
        checkConnection();
        ArrayList<String> rsOutput = new ArrayList<>(); 

        try {
            Statement statement = cnx.createStatement();  
            String queryAll = "SELECT name, content FROM dessin";
            ResultSet result = statement.executeQuery(queryAll);
            while (result.next()) {
                rsOutput.add(result.getString("name"));
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
        return rsOutput;     
    }

    public DessinModel getDrawOnebyName(String name) {
        checkConnection();
    
        try {
            Statement statement = cnx.createStatement();
            String queryOnebyName = "SELECT name, content FROM dessin WHERE name = '" + name + "'";
            ResultSet result = statement.executeQuery(queryOnebyName);
            if (result.next()) {
                DessinModel dessin = new DessinModel();
                dessin.setAuteur("default");
                dessin.setId(0L);
                dessin.setNom(result.getString("name"));
                dessin.setContent(result.getString("content"));
                result.close();
                statement.close();
                return dessin;
            } else {
                result.close();
                statement.close();
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getDessinWithCircle() {
	    checkConnection();
	    ArrayList<String> lstOutput = new ArrayList<>();
	    try{
		    Statement statement = cnx.createStatement();
		
	    } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
	    return lstOutput;
    }

    public void createDraw(DessinModel dessinModel) {
        checkConnection();

        try {
            Statement statement = cnx.createStatement();  
            String createSQL = String.format("INSERT INTO dessin (name, content) VALUES ('%1$s', '%2$s')", dessinModel.getNom(), dessinModel.getContent());
            int nbRows = statement.executeUpdate(createSQL);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }      
    }
}
