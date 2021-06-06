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
import modelos.ItemVenda;
import modelos.Produto;
import modelos.Venda;

/**
 *
 * @author rober
 */
public class ItensVendaDadosTratados {

    private Connection con;

    public ItensVendaDadosTratados() {
        this.con = new Conecta().getConnection();
    }

    //Cadastrar itens da venda, item a item.
    public void cadastrarItem(ItemVenda itemV) {
        try {
            String sql = "insert into tb_itensvendas (venda_id, produto_id, qtd, subtotal) "
                    + "values (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, itemV.getVenda().getId());
            stmt.setInt(2, itemV.getProduto().getId());
            stmt.setInt(3, itemV.getQtd());
            stmt.setDouble(4, itemV.getSubTotal());
            
            stmt.execute();
            stmt.close();
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }
    
    //Listar itens da venda por meio do Id da venda.
    public List<ItemVenda> listarItensDaVenda(int id){
        List<ItemVenda> lista = new ArrayList<>();
        
        try{
            
            String sql = "select p.descricao, i.qtd, p.preco, i.subtotal from "
                    + "tb_itensvendas as i inner join tb_produtos as p on (i.produto_id = p.id) "
                    + "where i.venda_id=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                ItemVenda objItem = new ItemVenda();                                
                Produto objP = new Produto();
                                
                objP.setDescricao(rs.getString("p.descricao"));
                objItem.setQtd(rs.getInt("i.qtd"));
                objP.setPreco(rs.getDouble("p.preco"));
                objItem.setSubTotal(rs.getDouble("i.subtotal"));                                
                objItem.setProduto(objP);
                
                lista.add(objItem);
            }
            return lista;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: "+e);
            return null;
        }
        
    }
}
