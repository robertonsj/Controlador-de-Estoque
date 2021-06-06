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
import modelos.Produto;

/**
 *
 * @author rober
 */
public class ProdutoDadosTratados {

    Connection con;

    public ProdutoDadosTratados() {
        this.con = new Conecta().getConnection();
    }

    // Salva o produto junto à fonte de dados.
    public void cadastrar(Produto obj) {
        try {
            String sql = "insert into tb_produtos (descricao, preco, qtd_estoque, for_id)"
                    + " values (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtdEstoque());
            stmt.setInt(4, obj.getFornecedor().getId());

            //Executa a 'Declaração Preparada'.
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto cadastrado!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }

    // Retorna uma lista com todas as ocorrências de tb_produtos.
    public List<Produto> listarTodos() {
        try {
            List<Produto> lista = new ArrayList<>();
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome "
                    + "from tb_produtos as p inner join tb_fornecedores as f on "
                    + "(p.for_id = f.id)";

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto objP = new Produto();
                Fornecedor objF = new Fornecedor();

                objP.setId(rs.getInt("id"));
                objP.setDescricao(rs.getString("descricao"));
                objP.setPreco(rs.getDouble("preco"));
                objP.setQtdEstoque(rs.getInt("qtd_estoque"));
                objF.setNome(rs.getString("f.nome"));

                objP.setFornecedor(objF);

                lista.add(objP);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }

    }

    // Atualiza a ocorrência na tabela 'tb_produtos'.
    public void atualizar(Produto obj) {

        try {
            String sql = "update tb_produtos set descricao=?,preco=?,qtd_estoque=?,for_id=? "
                    + "where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtdEstoque());
            stmt.setInt(4, obj.getFornecedor().getId());
            stmt.setInt(5, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Atualização realizada!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }

    /*Função do método: pesquisar por uma ocorrência da tabela 'tb_produtos',
    com base na String passado como parâmetro.*/
    public Produto pesquisarPorDescricao(String descricao) {
        try {
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome "
                    + "from tb_produtos as p inner join tb_fornecedores as f on "
                    + "(p.for_id = f.id) where p.descricao = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, descricao);

            ResultSet rs = stmt.executeQuery();
            Produto objP = new Produto();
            Fornecedor objF = new Fornecedor();

            if (rs.next()) {                

                objP.setId(rs.getInt("p.id"));
                objP.setDescricao(rs.getString("p.descricao"));
                objP.setPreco(rs.getDouble("p.preco"));
                objP.setQtdEstoque(rs.getInt("p.qtd_estoque"));
                
                objF.setNome(rs.getString("f.nome"));
                
                objP.setFornecedor(objF);
            }
            return objP;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }

    }
    
    /*Função do método: pesquisar por uma ocorrência da tabela 'tb_produtos',
    com base no código passado como parâmetro.
    Método será implementado para a Tela de Vendas.*/
    public Produto pesquisarPorId(int id) {
        try {
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome "
                    + "from tb_produtos as p inner join tb_fornecedores as f on "
                    + "(p.for_id = f.id) where p.id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            //PAREI AQUI
            ResultSet rs = stmt.executeQuery();
            Produto objP = new Produto();
            Fornecedor objF = new Fornecedor();

            if (rs.next()) {                

                objP.setId(rs.getInt("p.id"));
                objP.setDescricao(rs.getString("p.descricao"));
                objP.setPreco(rs.getDouble("p.preco"));
                objP.setQtdEstoque(rs.getInt("p.qtd_estoque"));
                
                objF.setNome(rs.getString("f.nome"));
                
                objP.setFornecedor(objF);
            }
            return objP;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }

    }

    public void excluir(int codigo) {
        try {

            String sql = "delete from tb_produtos where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }

    public List<Produto> listarPorDescricao(String descricao) {
        try {
            List<Produto> lista = new ArrayList<>();

            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome "
                    + "from tb_produtos as p inner join tb_fornecedores as f on "
                    + "(p.for_id = f.id) where p.descricao like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, descricao);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                Produto p = new Produto();

                p.setId(rs.getInt("p.id"));
                p.setDescricao(rs.getString("p.descricao"));
                p.setPreco(rs.getDouble("p.preco"));
                p.setQtdEstoque(rs.getInt("p.qtd_estoque"));
                f.setNome(rs.getString("f.nome"));
                p.setFornecedor(f);

                lista.add(p);
            }
            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }

    }
    
    //Método irá retornar o estoque atual gravado no banco.
    public int retornarEstoqueAtual(int id){
        try{
            int qtd=0;
            String sql = "select qtd_estoque from tb_produtos where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                qtd = rs.getInt("qtd_estoque");                
            }
            return qtd;
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    //Método que dá baixa no estoque após venda.
    public void baixaEstoque(int id, int qtdPosVenda){
        
        try{
            
            String sql = "update tb_produtos set qtd_estoque = ? where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, qtdPosVenda);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            
        }
        
    }
}
