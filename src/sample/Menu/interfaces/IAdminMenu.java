package sample.Menu.interfaces;

import sample.entities.Drugs;

import java.sql.Date;

public interface IAdminMenu {
    boolean CreateDrug(String name, String type, String destiny, double price, String manufacturer, Date production_date, Date expiration_date, boolean validaty);
    boolean UpdatePrice(double price,int id);
    boolean UpdateManufacturer(String manufacturer,int id);
    boolean DeleteDrug(int id);
}
