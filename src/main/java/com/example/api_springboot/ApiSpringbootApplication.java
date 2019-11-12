package com.example.api_springboot;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApiSpringbootApplication {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:testdb";
    static final String USER = "sa";
    static final String PASS = "";    
    
    public static void main(String[] args) throws FileNotFoundException, IOException,  SQLException, ClassNotFoundException {
       
        Connection conn = null;
        Statement stmt = null;
              
        Class.forName("org.h2.Driver");
        
	SpringApplication.run(ApiSpringbootApplication.class, args); 
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/nomes.csv")));
        
        String linha = null;
        
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");
                
        while ((linha = reader.readLine()) != null) {
           String[] dadosUsuario = linha.split(",");
           long id = Long.parseLong(dadosUsuario[0]);
           String nome = (dadosUsuario[1]);
                 
           stmt = conn.createStatement();

           String sql = "INSERT INTO PESSOA (ID, NOME) VALUES ('"+id+"','"+nome+"')";
           
           stmt.executeUpdate(sql);
           stmt.close();
           
           System.out.println("id: " +id);
           System.out.println("nome: " + nome);
           
        }
        System.out.println("Dados Gravados no banco h2");
        reader.close();
              
	}


}
