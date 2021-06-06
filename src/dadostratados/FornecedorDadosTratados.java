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
import modelos.Fornecedor;

/**
 *
 * @author rober
 */
/*Objetivo da Classe: guardar os métodos que serão executados em qualquer tipo de request que envolva
dados persistentes dos fornecedores.
 */
public class FornecedorDadosTratados {

    /*Função do obj: receber a conexão com o banco quando um obj 'FornecedorDadosTratados'
    instanciado.*/
    private Connection con;

    public FornecedorDadosTratados() {

        
        /*O método 'getConnection' conecta-se ao banco e retorna um objeto.*/
        this.con = new Conecta().getConnection();
    }

    /*Função do método: cadastrar um nova ocorrência de Fornecedor junto ao banco, 
    com base nos dados do obj passado como parâmetro.*/
    public void cadastrar(Fornecedor obj) {
        try {

            /*Declaração SQL atribuída a um tipo String;
            Função da declaração: inserir uma nova ocorrência junto ao banco, a nível SQL.*/
            String sql = "insert into tb_fornecedores (nome,cnpj,email,contato,endereco,complemento,bairro,cidade,uf)\n"
                    + "values(?,?,?,?,?,?,?,?,?)";

            /*
            Objetivo do obj: receber o resultado da conexão ao banco e preparar a declaração 
            SQL para receber os dados do objeto passado como parâmetro.*/
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getContato());
            stmt.setString(5, obj.getEndereco());
            stmt.setString(6, obj.getComplemento());
            stmt.setString(7, obj.getBairro());
            stmt.setString(8, obj.getCidade());
            stmt.setString(9, obj.getUf());

            //Execução da declaração SQL a nível de banco.
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    /*Função do método: atualizar dados persistentes de uma ocorrência de Fornecedor, 
    com base nos dados do obj passado como parâmetro.*/
    public void atualizar(Fornecedor obj) {
        try {

            /*Declaração SQL atribuída a um tipo String;
            Função da declaração: atualizar os dados de uma ocorrência da tabela 'tb_fornecedores'.*/
            String sql = "update tb_fornecedores set nome=?,cnpj=?,email=?,contato=?,endereco=?,complemento=?,bairro=?,cidade=?,uf=? where id=?";

            /*Objetivo do obj: receber o resultado da conexão ao banco e preparar a declaração 
            SQL para receber os dados do objeto passado como parâmetro.*/
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getContato());
            stmt.setString(5, obj.getEndereco());
            stmt.setString(6, obj.getComplemento());
            stmt.setString(7, obj.getBairro());
            stmt.setString(8, obj.getCidade());
            stmt.setString(9, obj.getUf());
            stmt.setInt(10, obj.getId());

            //Execução da declaração SQL a nível de banco.
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    /*Função do método: deletar uma ocorrência da tabela 'tb_fornecedores',
    com base no obj passado como parâmetro.*/
    public void excluir(Fornecedor obj) {
        try {

            /*Declaração SQL atribuída a um tipo String;
            Função da declaração: deletar uma ocorrência da tabela 'tb_fornecedores'.*/
            String sql = "delete from tb_fornecedores where id = ?";

            /*Objetivo do obj: receber o resultado da conexão ao banco e preparar a declaração 
            SQL para receber os dados do objeto passado como parâmetro.*/
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            //Execução da declaração SQL.
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    /*Função do método: pesquisar por uma ocorrência da tabela 'tb_fornecedores',
    com base na String passado como parâmetro.*/
    public Fornecedor pesquisarPorCnpj(String cnpj) {
        try {

            /*Declaração SQL atribuída a um tipo String;
            Função da declaração: pesquisar uma ocorrência da tabela 'tb_fornecedores',
            com base no dado passado como parâmetro.*/
            String sql = "select * from tb_fornecedores where cnpj = ?";

            /*Objetivo do obj: armazenar o resultado da conexão ao banco e preparar a declaração 
            SQL para receber o tipo String passado como parâmetro.*/
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cnpj);

            /*Objetivo do obj: armazenar o conjunto de dados resultante da busca SQL
            feita no banco, que neste caso se resume a uma ocorrência específica.*/
            ResultSet rs = stmt.executeQuery();

            //Objetivo do obj: armazenar os dados da ocorrência buscados do banco.
            Fornecedor obj = new Fornecedor();

            /*Dependendo do resultado da busca pela ocorrência na tabela 'tb_fornecedores',
            o método 'next()' retornará um valor booleano.
            Valor TRUE: ocorrência foi encontrada e seus dados foram armazenados no obj 'ResultSet'.*/
            if (rs.next()) {

                /*Os dados da ocorrência serão setados no obj 'Fornecedor', criado
                fora do bloco.*/
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setContato(rs.getString("contato"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("uf"));

            }
            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fornecedor não encontrado!");
            return null;
        }

    }
    
    
    /*Função do método: pesquisar por uma ocorrência da tabela 'tb_fornecedores',
    com base na String passado como parâmetro.*/
    public Fornecedor pesquisarPorNome(String nome) {
        try {

            /*Declaração SQL atribuída a um tipo String;
            Função da declaração: pesquisar uma ocorrência da tabela 'tb_fornecedores',
            com base no dado passado como parâmetro.*/
            String sql = "select * from tb_fornecedores where nome = ?";

            /*Objetivo do obj: armazenar o resultado da conexão ao banco e preparar a declaração 
            SQL para receber o tipo String passado como parâmetro.*/
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            /*Objetivo do obj: armazenar o conjunto de dados resultante da busca SQL
            feita no banco, que neste caso se resume a uma ocorrência específica.*/
            ResultSet rs = stmt.executeQuery();

            //Objetivo do obj: armazenar os dados da ocorrência buscados do banco.
            Fornecedor obj = new Fornecedor();

            /*Dependendo do resultado da busca pela ocorrência na tabela 'tb_fornecedores',
            o método 'next()' retornará um valor booleano.
            Valor TRUE: ocorrência foi encontrada e seus dados foram armazenados no obj 'ResultSet'.*/
            if (rs.next()) {

                /*Os dados da ocorrência serão setados no obj 'Fornecedor', criado
                fora do bloco.*/
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setContato(rs.getString("contato"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("uf"));

            }
            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fornecedor não encontrado!");
            return null;
        }

    }


    /*Função do método: retornar uma lista de obj Fornecedores, com base em todas as 
    ocorrências da tabela 'tb_fornecedores'.*/
    public List<Fornecedor> listarTodos() {
        try {

            //criar lista
            List<Fornecedor> lista = new ArrayList<>();

            /*Declaração SQL atribuída a um tipo String;
            Função da declaração: buscar todas as ocorrências da tabela 'tb_fornecedores'.*/
            String sql = "select * from tb_fornecedores";

            /*Objetivo do obj: armazenar o resultado da conexão ao banco e preparar 
            a declaração SQL.*/
            PreparedStatement stmt = con.prepareStatement(sql);

            /*Objetivo do obj: armazenar o conjunto de dados resultante da busca SQL
            feita no banco, que neste caso trata-se de todas as ocorrência da tabela.*/
            ResultSet rs = stmt.executeQuery();

            /*O método 'next()' retornará true para cada ocorrência da tabela armazenada
            no obj 'ResultSet', e a cada laço de repetição, será criado um obj 'Fornecedor' e nele
            armazenado os dados da respectiva ocorrência.*/
            while (rs.next()) {
                Fornecedor obj = new Fornecedor();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
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

    public List<Fornecedor> listarPorNome(String nome) {

        try {

            //Criação da lista
            List<Fornecedor> lista = new ArrayList<>();

            /*Declaração SQL atribuída a um tipo String;
            Função da declaração: buscar todas as ocorrências da tabela 'tb_fornecedores',
            que possuem no atributo 'nome' o valor armazenado no tipo String passada como
            parâmetro.*/
            String sql = "select * from tb_fornecedores where nome like ?";

            /*Objetivo do obj: armazenar o resultado da conexão ao banco e preparar a declaração 
            SQL para receber o tipo String passado como parâmetro.*/
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            /*Objetivo do obj: armazenar o conjunto de dados resultante da busca SQL
            feita no banco.*/
            ResultSet rs = stmt.executeQuery();

            /*O método 'next()' retornará true para cada ocorrência da tabela armazenada
            no obj 'ResultSet', e a cada laço de repetição, será criado um obj 'Fornecedor' e nele
            armazenado os dados da respectiva ocorrência.*/
            while (rs.next()) {
                Fornecedor f = new Fornecedor();

                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCnpj(rs.getString("cnpj"));
                f.setEmail(rs.getString("email"));
                f.setContato(rs.getString("contato"));
                f.setEndereco(rs.getString("endereco"));
                f.setComplemento(rs.getString("complemento"));
                f.setBairro(rs.getString("bairro"));
                f.setCidade(rs.getString("cidade"));
                f.setUf(rs.getString("uf"));

                lista.add(f);
            }

            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }

    }

}
