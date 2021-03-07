package sample.Menu;

import sample.Data.interfaces.IDB;
import sample.Menu.interfaces.IUserMenu;
import sample.Menu.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserMenu extends Menu implements IUserMenu{

    private IDB db;
    public UserMenu(IDB db){
        this.db=db;
    }
    @Override
    public boolean PurchaseDrug(String name, String drugName, String address, String email, String phoneNumber) {

        Connection con=null;
        try {
            con = db.getConnection();  //getting connection with database
            String sql = "INSERT INTO orders(name,drugName,address,email,phoneNumber) VALUES(?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,name);
            st.setString(2,drugName);
            st.setString(3,address);
            st.setString(4,email);
            st.setString(5,phoneNumber);

            st.execute();

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean CancelOrder(int order_id) {
        Connection con = null;
        try {
            con = db.getConnection();  //getting connection with database
            String sql = "DELETE FROM orders WHERE order_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, order_id);

            st.execute();

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }



    @Override
    public boolean GiveFeedback(String feedback,String name) {
        Connection con = null;
        try {
            con = db.getConnection();  //getting connection with database
            String sql = "INSERT INTO feedbacks(feedback,name) values (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,feedback);
            st.setString(2,name);

            st.execute();

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;

    }

    @Override
    public boolean UsePromocode() {
        Connection con = null;

        try{
            con= db.getConnection();    //getting connection with database

            PreparedStatement st=con.prepareStatement("UPDATE drugs SET price=price*0.85");  //sql query


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
}
