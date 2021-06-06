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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conecta;
import modelos.Cliente;
import modelos.Venda;

/**
 *
 * @author rober
 */
public class VendaDadosTratados {

    private Connection con;

    public VendaDadosTratados() {
        this.con = new Conecta().getConnection();
    }

    //Cadastrar Venda
    public void cadastrar(Venda objV) {

        try {
            //Declaração SQL para inserção de ocorrência(s) na tabela 'tb_vendas'.
            String sql = "insert into tb_vendas (cliente_id, data_venda, total_venda, "
                    + "observacoes) values(?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, objV.getCliente().getId());
            stmt.setString(2, objV.getDataVenda());
            stmt.setDouble(3, objV.getTotalVenda());
            stmt.setString(4, objV.getObs());

            stmt.execute();
            stmt.close();
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }

    //Retornar última venda
    public int retornarUltimaVenda() {
        try {
            int idVenda = 0;

            //Declaração SQL para obter-se a última ocorrência registrada.
            String sql = "select max(id) id from tb_vendas";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Venda objV = new Venda();

                objV.setId(rs.getInt("id"));

                idVenda = objV.getId();
            }
            return idVenda;
            
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Erro: "+e);
            throw new RuntimeException(e);
        }

    }
    
    /*Filtrar vendas feita em um determinado intervalo de tempo;
    Passar por parâmetro as datas inicial e final*/
    public List<Venda> listarPorPeriodo(LocalDate dataI, LocalDate dataF){
        try{
            List<Venda> lista = new ArrayList<>();
            
            //Comando SQL para buscar as vendas no banco
            String sql = "select v.id, v.data_venda, c.nome, v.total_venda, v.observacoes "
                    + "from tb_vendas as v inner join tb_clientes as c on (v.cliente_id = c.id) "
                    + "where v.data_venda between ? and ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dataI.toString());
            stmt.setString(2, dataF.toString());
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Venda objV = new Venda();
                Cliente objC = new Cliente();
                
                objV.setId(rs.getInt("v.id"));
                objV.setDataVenda(rs.getString("v.data_venda"));
                objC.setNome(rs.getString("c.nome"));
                objV.setTotalVenda(rs.getDouble("v.total_venda"));
                objV.setObs(rs.getString("v.observacoes"));
                
                objV.setCliente(objC);
                lista.add(objV);
                
            }
            
            return lista;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: "+e);
            return null;
        }
    }
    
    public double totalVendaPorData(LocalDate data_venda){
        try{
            double total = 0;
            String sql = "select sum(total_venda) as total from tb_vendas where data_venda = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, data_venda.toString());
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                total = rs.getDouble("total");
            }
            return total;
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
