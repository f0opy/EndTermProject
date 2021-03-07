package sample.Menu;

import sample.Data.interfaces.IDB;
import sample.Menu.interfaces.IMenu;
import sample.entities.Drugs;

import java.sql.*;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class Menu implements IMenu {
    private IDB db;

    public Menu(){

    }
    public Menu(IDB db){
        this.db = db;
    }

    @Override
    public Drugs GetDrugById(int id) {
        Connection con=null;
        try{
            con=db.getConnection();  //getting connection with database
            PreparedStatement st=con.prepareStatement("SELECT*FROM drugs WHERE id=?");

            st.setInt(1,id);

            ResultSet rs=st.executeQuery();

            if(rs.next()){
                Drugs drugs=new Drugs(rs.getString("name"),rs.getInt("id"),rs.getString("type"),
                        rs.getString("destiny"),rs.getDouble("price"),rs.getString("manufacturer"),
                        rs.getDate("production_date"),rs.getDate("expiration_date"),rs.getBoolean("validaty"));
                return drugs;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close(); //closing connection with database
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Drugs> GetDrugByName(String name) {
        Connection con = null;
        try{
            con= db.getConnection();  //getting connection with database


            PreparedStatement prst = con.prepareStatement("SELECT*FROM drugs WHERE name=?");
            prst.setString(1,name);

            ResultSet rs=prst.executeQuery();


            List<Drugs> drugs=new LinkedList<>();

            while(rs.next()){
                Drugs drug=new Drugs(rs.getString("name"),rs.getInt("id"),rs.getString("type"),
                        rs.getString("destiny"),rs.getDouble("price"),rs.getString("manufacturer"),
                        rs.getDate("production_date"),rs.getDate("expiration_date"),rs.getBoolean("validaty"));

                drugs.add(drug);
            }
            return drugs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close(); //closing connection with database
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Drugs> GetDrugByType(String type) {
        Connection con = null;
        try{
            con= db.getConnection();  //getting connection with database


            PreparedStatement prst = con.prepareStatement("SELECT*FROM drugs WHERE type=?");
            prst.setString(1,type);

            ResultSet rs=prst.executeQuery();


            List<Drugs> drugs=new LinkedList<>();

            while(rs.next()){
                Drugs drug=new Drugs(rs.getString("name"),rs.getInt("id"),rs.getString("type"),
                        rs.getString("destiny"),rs.getDouble("price"),rs.getString("manufacturer"),
                        rs.getDate("production_date"),rs.getDate("expiration_date"),rs.getBoolean("validaty"));

                drugs.add(drug);
            }
            return drugs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close(); //closing connection with database
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Drugs> GetDrugByDestiny(String destiny) {
        Connection con = null;
        try{
            con= db.getConnection();  //getting connection with database


            PreparedStatement prst = con.prepareStatement("SELECT*FROM drugs WHERE destiny=?");
            prst.setString(1,destiny);

            ResultSet rs=prst.executeQuery();


            List<Drugs> drugs=new LinkedList<>();

            while(rs.next()){
                Drugs drug=new Drugs(rs.getString("name"),rs.getInt("id"),rs.getString("type"),
                        rs.getString("destiny"),rs.getDouble("price"),rs.getString("manufacturer"),
                        rs.getDate("production_date"),rs.getDate("expiration_date"),rs.getBoolean("validaty"));

                drugs.add(drug);
            }
            return drugs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close(); //closing connection with database
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Drugs> GetDrugByManufacturer(String manufacturer) {
        Connection con = null;
        try{
            con= db.getConnection();  //getting connection with database


            PreparedStatement prst = con.prepareStatement("SELECT*FROM drugs WHERE manufacturer=?");
            prst.setString(1,manufacturer);

            ResultSet rs=prst.executeQuery();


            List<Drugs> drugs=new LinkedList<>();

            while(rs.next()){
                Drugs drug=new Drugs(rs.getString("name"),rs.getInt("id"),rs.getString("type"),
                        rs.getString("destiny"),rs.getDouble("price"),rs.getString("manufacturer"),
                        rs.getDate("production_date"),rs.getDate("expiration_date"),rs.getBoolean("validaty"));

                drugs.add(drug);
            }
            return drugs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close(); //closing connection with database
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Drugs> GetDrugByProDate(Date production_date) {
        Connection con = null;
        try{
            con= db.getConnection();  //getting connection with database


            PreparedStatement prst = con.prepareStatement("SELECT*FROM drugs WHERE production_date>?");
            prst.setDate(1,production_date);

            ResultSet rs=prst.executeQuery();


            List<Drugs> drugs=new LinkedList<>();

            while(rs.next()){
                Drugs drug=new Drugs(rs.getString("name"),rs.getInt("id"),rs.getString("type"),
                        rs.getString("destiny"),rs.getDouble("price"),rs.getString("manufacturer"),
                        rs.getDate("production_date"),rs.getDate("expiration_date"),rs.getBoolean("validaty"));

                drugs.add(drug);
            }
            return drugs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close(); //closing connection with database
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Drugs> GetDrugByExpDate(Date expiration_date) {
        Connection con = null;
        try{
            con= db.getConnection();  //getting connection with database


            PreparedStatement prst = con.prepareStatement("SELECT*FROM drugs WHERE expiration_date<?");
            prst.setDate(1,expiration_date);

            ResultSet rs=prst.executeQuery();


            List<Drugs> drugs=new LinkedList<>();

            while(rs.next()){
                Drugs drug=new Drugs(rs.getString("name"),rs.getInt("id"),rs.getString("type"),
                        rs.getString("destiny"),rs.getDouble("price"),rs.getString("manufacturer"),
                        rs.getDate("production_date"),rs.getDate("expiration_date"),rs.getBoolean("validaty"));

                drugs.add(drug);
            }
            return drugs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close(); //closing connection with database
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Drugs> GetDrugByPrice(double price1, double price2) {
        Connection con = null;
        try{
            con= db.getConnection();  //getting connection with database


            PreparedStatement prst = con.prepareStatement("SELECT*FROM drugs WHERE price BETWEEN ? and ?");
            prst.setDouble(1,price1);
            prst.setDouble(2,price2);

            ResultSet rs=prst.executeQuery();


            List<Drugs> drugs=new LinkedList<>();

            while(rs.next()){
                Drugs drug=new Drugs(rs.getString("name"),rs.getInt("id"),rs.getString("type"),
                        rs.getString("destiny"),rs.getDouble("price"),rs.getString("manufacturer"),
                        rs.getDate("production_date"),rs.getDate("expiration_date"),rs.getBoolean("validaty"));

                drugs.add(drug);
            }
            return drugs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close(); //closing connection with database
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Drugs> GetDrugByValidaty(boolean validaty) {
        Connection con = null;
        try{
            con= db.getConnection();  //getting connection with database


            PreparedStatement prst = con.prepareStatement("SELECT*FROM drugs Where validaty=?");
            prst.setBoolean(1,validaty);
            
            ResultSet rs=prst.executeQuery();
            
            List<Drugs> drugs=new LinkedList<>();

            while(rs.next()){
                Drugs drug=new Drugs(rs.getString("name"),rs.getInt("id"),rs.getString("type"),
                        rs.getString("destiny"),rs.getDouble("price"),rs.getString("manufacturer"),
                        rs.getDate("production_date"),rs.getDate("expiration_date"),rs.getBoolean("validaty"));

                drugs.add(drug);
            }
            return drugs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close(); //closing connection with database
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Drugs> GetAllDrugs() {
        Connection con = null;
        try{
            con= db.getConnection();  //getting connection with database


            PreparedStatement prst = con.prepareStatement("SELECT*FROM drugs");

            ResultSet rs=prst.executeQuery();

            List<Drugs> drugs=new LinkedList<>();

            while(rs.next()){
                Drugs drug=new Drugs(rs.getString("name"),rs.getInt("id"),rs.getString("type"),
                        rs.getString("destiny"),rs.getDouble("price"),rs.getString("manufacturer"),
                        rs.getDate("production_date"),rs.getDate("expiration_date"),rs.getBoolean("validaty"));

                drugs.add(drug);
            }
            return drugs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close(); //closing connection with database
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
