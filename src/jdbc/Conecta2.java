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
public class Conecta2 {
    private static final String USUARIO = "roberto";
    private static final String SENHA = "12três";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/bd_vendas";
    private static final String DRIVER = "jdbc.Driver";

    // Conectar ao banco
    public static Connection abrir() throws Exception {
        // Registrar o driver
        Class.forName(DRIVER);
        // Capturar a conexão
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        // Retorna a conexao aberta
        return conn;
    }
}
