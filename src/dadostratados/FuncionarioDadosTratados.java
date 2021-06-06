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
import modelos.Funcionario;
import telas.FrmLogin;
import telas.FrmMenu;

/**
 *
 * @author rober
 */
/*Classe em que estão escritos os métodos responsáveis pela estabelecido da 
comunicarão entre o Objeto Cliente e o banco de dados, seja para output em casos
de consultas ou para input, em caso de inserção no banco.
 */
public class FuncionarioDadosTratados {

    private Connection con;

    public FuncionarioDadosTratados() {

        /*O atributo 'con' receberá uma nova conexão com o banco de dados.
        O método 'getConnection' conecta-se ao banco e retorna um objeto.*/
        this.con = new Conecta().getConnection();
    }

    //Método que vai cadastrar um objeto do tipo Cliente, da camada modelo.
    public void cadastrarFunc(Funcionario obj) {
        try {

            /*Comando insert do MySQL, sendo atribuído a um tipo String;
            Fará o input de uma nova ocorrência de cliente lá no banco.*/
            String sql = "insert into tb_funcionarios (nome,cpf,email,senha,cargo,nivel_acesso,contato,endereco,complemento,bairro,cidade,uf)\n"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?)";

            /*A aplicação precisa de um objeto que, ao mesmo tempo em que se conecta ao banco,
            prepare o comando SQL insert, o qual para o Java não passa de uma String.
            Só assim, os dados do objeto cliente passado como parâmetros serão setados
            no comando SQL insert.*/
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getSenha());//senhas
            stmt.setString(5, obj.getCargo());//cargo
            stmt.setString(6, obj.getNivel_acesso());//nivel_acesso
            stmt.setString(7, obj.getContato());
            stmt.setString(8, obj.getEndereco());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());

            /*executar o comando sql já com os valores setados*/
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    public void atualizarFunc(Funcionario obj) {
        try {

            /*Comando insert do MySQL, sendo atribuído a um tipo String;
            Fará a atualização dos dados de uma ocorrência de cliente lá no banco.*/
            String sql = "update tb_funcionarios set nome=?,cpf=?,email=?,senha=?,cargo=?,nivel_acesso=?,contato=?,endereco=?,complemento=?,bairro=?,cidade=?,uf=? where id=?";

            /*A aplicação precisa de um objeto que, ao mesmo tempo em que se conecta ao banco,
            prepare o comando SQL update, o qual para o Java não passa de uma String.
            Só assim, os dados do objeto cliente passado como parâmetros serão setados
            no comando SQL update.*/
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getSenha());
            stmt.setString(5, obj.getCargo());
            stmt.setString(6, obj.getNivel_acesso());
            stmt.setString(7, obj.getContato());
            stmt.setString(8, obj.getEndereco());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());
            stmt.setInt(13, obj.getId());

            /*executar o comando sql já com os valores setados*/
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    public void excluirFunc(Funcionario obj) {
        try {

            /*Comando delete do MySQL, sendo atribuído a um tipo String;
            Fará a exclusão de uma ocorrência de cliente lá no banco.*/
            String sql = "delete from tb_funcionarios where id = ?";

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

    //Método consultar funcionario por nome.
    public Funcionario consultarPorCpf(String cpf) {
        try {
            /*Query do MySQL sendo atribuída a um tipo String.*/
            String sql = "select * from tb_funcionarios where cpf = ?";

            /*Objeto para receber o resultado da conexão ao banco, seguinda da declaração SQL preparada.*/
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);

            /*O objeto stmt prepara a query, mas não armazena o resultado, ou seja, o java
            precisará de um objeto que armazene o resultado dessa consulta ao banco de dados.*/
            ResultSet rs = stmt.executeQuery();
            Funcionario obj = new Funcionario();

            /*O comando next() nesta condicional resultará em um valor booleano, 
            para a ocorrência ou não do cliente procurado.
             */
            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setContato(rs.getString("contato"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("uf"));

            }
            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
            return null;
        }

    }


    /*Função: retornar uma lista de funcionarios da fonte de dados*/
    public List<Funcionario> listarFuncionarios() {
        try {

            //criar lista
            List<Funcionario> lista = new ArrayList<>();

            /*Query do MySQL sendo atribuída a um tipo String.*/
            String sql = "select * from tb_funcionarios";

            /*Objeto para receber o resultado da conexão ao banco, seguinda da declaração SQL preparada.*/
            PreparedStatement stmt = con.prepareStatement(sql);

            /*O objeto stmt prepara a query, mas não armazena o resultado, ou seja, o java
            precisará de um objeto que armazene o resultado dessa consulta ao banco de dados.*/
            ResultSet rs = stmt.executeQuery();

            /*O comando next() neste laço fará com que a toda ocorrência da Query,
            um objeto Cliente seja criado, a ele atribuído os dados da ocorrência
             */
            while (rs.next()) {
                Funcionario obj = new Funcionario();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
    
    public List<Funcionario> listarPorNome(String nome) {
        try {

            //criar lista
            List<Funcionario> lista = new ArrayList<>();

            /*Query do MySQL sendo atribuída a um tipo String.*/
            String sql = "select * from tb_funcionarios where nome like ?";

            /*Objeto para receber o resultado da conexão ao banco, seguinda da declaração SQL preparada.*/
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            /*O objeto stmt prepara a query, mas não armazena o resultado, ou seja, o java
            precisará de um objeto que armazene o resultado dessa consulta ao banco de dados.*/
            ResultSet rs = stmt.executeQuery();

            /*O comando next() neste laço fará com que a toda ocorrência da Query,
            um objeto Cliente seja criado, a ele atribuído os dados da ocorrência
             */
            while (rs.next()) {
                Funcionario obj = new Funcionario();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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

    //Método efetuar Login
    public void efetuarLogin(String email, String senha) {
        try {
            //Comando SQL a ser preparado
            String sql = "select * from tb_funcionarios where email = ? and senha = ?";

            //Obj para receber a conexão ao banco junto com o comando SQL já preparado.
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            //A query será executada e o conjunto resultante armazenado no obj 'ResultSet'.
            ResultSet rs = stmt.executeQuery();

            /*Se a ocorrência de tb_funcionarios for encontrada, a partir do email e senha passados pelo par.,
            o login foi realizado com sucesso, e a tela de menu será exibida.*/
            if (rs.next()) {

                //Caso o Funcionário tenha nível de acesso Administrador
                if (rs.getString("nivel_acesso").equals("Administrador")) {

                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao sistema!");
                    FrmMenu tela = new FrmMenu();
                    
                    //antes de exibir a tela de menu, será setado o usuário que acessa o sistema.
                    tela.usuarioLogado = rs.getString("nome");                    
                    tela.setVisible(true);

                    //Caso o Funcionário tenha nível de acesso Usuário
                } else if (rs.getString("nivel_acesso").equals("Usuário")) {

                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao sistema!");
                    FrmMenu tela = new FrmMenu();                                        
                    
                    //antes de exibir a tela de menu, será setado o usuário que acessa o sistema.
                    tela.usuarioLogado = rs.getString("nome");                    
                    
                    //Desabilitar os menus
                    tela.menuPosicao.setEnabled(false);
                    tela.menuControleVendas.setEnabled(false);
                    
                    tela.setVisible(true);
                    
                }

            } else {
                //Dados incorretos
                JOptionPane.showMessageDialog(null, "Email ou senha incorretos!");
                new FrmLogin().setVisible(true);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

}
