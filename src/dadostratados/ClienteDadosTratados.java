/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadostratados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conecta;
import modelos.Cliente;

/**
 *
 * @author rober
 */
/*Classe em que estão escritos os métodos responsáveis pela estabelecido da 
comunicarão entre o Objeto Cliente e o banco de dados, seja para output em casos
de consultas ou para input, em caso de inserção no banco.
 */
public class ClienteDadosTratados {

    private Connection con;

    public ClienteDadosTratados() {

        /*O atributo 'con' receberá uma nova conexão com o banco de dados.
        O método 'getConnection' conecta-se ao banco e retorna um objeto.*/
        this.con = new Conecta().getConnection();
    }

    //Método que vai cadastrar um objeto do tipo Cliente, da camada modelo.
    public void cadastrarCliente(Cliente obj) {
        try {

            /*Comando insert do MySQL, sendo atribuído a um tipo String;
            Fará o input de uma nova ocorrência de cliente lá no banco.*/
            String sql = "insert into tb_clientes (nome,cpf,email,contato,endereco,complemento,bairro,cidade,uf)\n"
                    + "values(?,?,?,?,?,?,?,?,?)";

            /*A aplicação precisa de um objeto que, ao mesmo tempo em que se conecta ao banco,
            prepare o comando SQL insert, o qual para o Java não passa de uma String.
            Só assim, os dados do objeto cliente passado como parâmetros serão setados
            no comando SQL insert.*/
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getContato());
            stmt.setString(5, obj.getEndereco());
            stmt.setString(6, obj.getComplemento());
            stmt.setString(7, obj.getBairro());
            stmt.setString(8, obj.getCidade());
            stmt.setString(9, obj.getUf());

            /*executar o comando sql já com os valores setados*/
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    public void atualizarCliente(Cliente obj) {
        try {

            /*Comando insert do MySQL, sendo atribuído a um tipo String;
            Fará a atualização dos dados de uma ocorrência de cliente lá no banco.*/
            String sql = "update tb_clientes set nome=?,cpf=?,email=?,contato=?,endereco=?,complemento=?,bairro=?,cidade=?,uf=? where id=?";

            /*A aplicação precisa de um objeto que, ao mesmo tempo em que se conecta ao banco,
            prepare o comando SQL update, o qual para o Java não passa de uma String.
            Só assim, os dados do objeto cliente passado como parâmetros serão setados
            no comando SQL update.*/
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getContato());
            stmt.setString(5, obj.getEndereco());
            stmt.setString(6, obj.getComplemento());
            stmt.setString(7, obj.getBairro());
            stmt.setString(8, obj.getCidade());
            stmt.setString(9, obj.getUf());
            stmt.setInt(10, obj.getId());

            /*executar o comando sql já com os valores setados*/
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    public void excluirCliente(Cliente obj) {
        try {

            /*Comando delete do MySQL, sendo atribuído a um tipo String;
            Fará a exclusão de uma ocorrência de cliente lá no banco.*/
            String sql = "delete from tb_clientes where id = ?";

            /*A aplicação precisa de um objeto que, ao mesmo tempo em que se conecta ao banco,
            prepare o comando SQL delete, o qual para o Java não passa de uma String.
            Só assim, os dados do objeto cliente passado como parâmetros serão setados
            no comando SQL delete.*/
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            /*executar o comando sql já com os valores setados*/
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    //Método consultar cliente por nome.
    public Cliente consultarPorCpf(String cpf) {
        try {
            /*Query do MySQL sendo atribuída a um tipo String.*/
            String sql = "select * from tb_clientes where cpf = ?";

            /*Objeto para receber o resultado da conexão ao banco, seguinda da declaração SQL preparada.*/
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);

            /*O objeto stmt prepara a query, mas não armazena o resultado, ou seja, o java
            precisará de um objeto que armazene o resultado dessa consulta ao banco de dados.*/
            ResultSet rs = stmt.executeQuery();
            Cliente obj = new Cliente();

            /*O comando next() nesta condicional resultará em um valor booleano, 
            para a ocorrência ou não do cliente procurado.
             */
            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setContato(rs.getString("contato"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("uf"));

            }
            return obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }

    }

    public List<Cliente> listarPorNome(String nome) {
        try {
            List<Cliente> lista = new ArrayList<>();
            
            /*Query do MySQL sendo atribuída a um tipo String.*/
            String sql = "select * from tb_clientes where nome like ?";

            /*Objeto para receber o resultado da conexão ao banco, seguinda da declaração SQL preparada.*/
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            /*O objeto stmt prepara a query, mas não armazena o resultado, ou seja, o java
            precisará de um objeto que armazene o resultado dessa consulta ao banco de dados.*/
            ResultSet rs = stmt.executeQuery();


            /*O comando next() nesta condicional resultará em um valor booleano, 
            para a ocorrência ou não do cliente procurado.
             */
            while (rs.next()) {
                Cliente obj = new Cliente();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setContato(rs.getString("contato"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("uf"));
                
                lista.add(obj);
            }
            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }

    }


    /*Tal método retornará uma lista de clientes*/
    public List<Cliente> listarClientes() {
        try {

            //criar lista
            List<Cliente> lista = new ArrayList<>();

            /*Query do MySQL sendo atribuída a um tipo String.*/
            String sql = "select * from tb_clientes";

            /*Objeto para receber o resultado da conexão ao banco, seguinda da declaração SQL preparada.*/
            PreparedStatement stmt = con.prepareStatement(sql);

            /*O objeto stmt prepara a query, mas não armazena o resultado, ou seja, o java
            precisará de um objeto que armazene o resultado dessa consulta ao banco de dados.*/
            ResultSet rs = stmt.executeQuery();

            /*O comando next() neste laço fará com que a toda ocorrência da Query,
            um objeto Cliente seja criado, a ele atribuído os dados da ocorrência
             */
            while (rs.next()) {
                Cliente obj = new Cliente();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setContato(rs.getString("contato"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("uf"));

                lista.add(obj);
            }
            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

}
