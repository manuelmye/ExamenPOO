package data;

import items.items;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class itemsData {
    Connection cn = ConnectionBd.connectSQLite();
    public void create(Items items) {
        String sql = " INSERT INTO items(nombre, categoria, familia, precio) " +
                " VALUES(?, ?, ?, ?) ";
        int i = 0;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(++i, items.getNombre());
            ps.setString(++i, items.getCategoria());
            ps.setInt(++i, items.getPrecio());
            int rsId = ps.executeUpdate();
            System.out.println("rsId: " + rsId);
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
    public List<Items> list() {
        List<Items> list = new ArrayList<Items>();
        String sql = "SELECT * FROM items";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Items items = new Items();
                items.setId(rs.getInt("id"));
                items.setNombre(rs.getString("nombre"));
                items.setCategoria(rs.getString("categoria"));
                items.setPrecio(rs.getInt("precio"));
                list.add(items);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return list;
    }
    public Items get(int id) {
        Items items = new Items();
        String sql = "SELECT * FROM items WHERE id = " + id + "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                items.setId(rs.getInt("id"));
                items.setNombre(rs.getString("nombre"));
                items.setCategoria(rs.getString("categoria"));
                items.setPrecio(rs.getInt("precio"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return items;
    }
    public void update(Items items) {
        String sql = " UPDATE items SET " +
                "nombre = ?, " +
                "categoria = ?, " +
                "precio = ? " +
                "WHERE id = ? ";
        int i = 0;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(++i, items.getNombre());
            ps.setString(++i, items.getCategoria());
            ps.setInt(++i, items.getPrecio());
            ps.setInt(++i, items.getId());
            int rsId = ps.executeUpdate();
            if (rsId > 0) {
                System.out.println("Successfully!");
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
    public void delete(int id) {
        String sql = "DELETE FROM items WHERE id = ?";
        int res =0;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            res = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}
