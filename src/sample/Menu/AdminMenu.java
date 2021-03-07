package sample.Menu;

import sample.Data.interfaces.IDB;
import sample.Menu.interfaces.IAdminMenu;
import sample.entities.Drugs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminMenu extends Menu implements IAdminMenu {
    private IDB db;

    public AdminMenu(IDB db){
        this.db=db;
    }
    @Override
    public boolean CreateDrug(String name, String type, String destiny, double price, String manufacturer, Date production_date, Date expiration_date, boolean validaty) {
        Connection con = null;
        try{
            con= db.getConnection();    //getting connection with database

            PreparedStatement st=con.prepareStatement("INSERT INTO drugs(name,type,destiny,price,manufacturer,production_date,expiration_date,validaty) VALUES (?,?,?,?,?,?,?,?)");  //sql query

            st.setString(1,name);
            st.setString(2,type);
            st.setString(3,destiny);
            st.setDouble(4,price);
            st.setString(5,manufacturer);
            st.setDate(6,production_date);
            st.setDate(7,expiration_date);
            st.setBoolean(8,validaty);

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close();    //closing connection with database
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean UpdatePrice(double price,int id) {
        Connection con = null;
        try{
            con= db.getConnection();    //getting connection with database

            PreparedStatement st=con.prepareStatement("UPDATE drugs SET price=? WHERE id=?");  //sql query

            st.setDouble(1, price);
            st.setInt(2, id);

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close();    //closing connection with database
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;

    }

    @Override
    public boolean UpdateManufacturer(String manufacturer,int id) {
        Connection con = null;
        try{
            con= db.getConnection();    //getting connection with database

            PreparedStatement st=con.prepareStatement("UPDATE drugs SET manufacturer=? WHERE id=?");  //sql query

            st.setString(1, manufacturer);
            st.setInt(2, id);

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close();    //closing connection with database
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;

    }

    @Override
    public boolean DeleteDrug(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM drugs WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            st.execute();

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();  //closing connection with database
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
}
