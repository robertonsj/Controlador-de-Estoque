/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author rober
 */

public class TestaConexao {
    public static void main(String[] args) {
        try {
            
      
            //Teste de conexão com o banco de dados usando um método da classe 'Conecta'.
            new Conecta().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Aconteceu o erro: "+erro);
        }
    }
}
