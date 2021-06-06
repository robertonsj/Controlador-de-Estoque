/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rober
 */
public class Conecta {
    
    
    /*O método getConnection retornará o que o DriverManager.getConnnection
    conseguir fazer.*/
    public Connection getConnection(){
        try {
            
            /*O DriverManager se conectará ao banco de dados.
            O java precisará de três informações para realizar a conexão, as strings de conexão.
            vai se conectar*/                  
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bd_vendas","usuario","123");
    
        
           //captura de erro, caso a conexão não seja possível
        } catch(Exception erro){
            throw new RuntimeException(erro);
        }
    }
    
}
