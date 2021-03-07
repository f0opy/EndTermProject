package sample.Menu.interfaces;

import sample.entities.Drugs;

import java.sql.Date;
import java.util.List;

public interface IMenu {
    List<Drugs> GetAllDrugs();
    Drugs GetDrugById(int id);
    List<Drugs> GetDrugByName(String name);
    List<Drugs> GetDrugByType(String type);
    List<Drugs> GetDrugByDestiny(String destiny);
    List<Drugs> GetDrugByManufacturer(String manufacturer);
    List<Drugs> GetDrugByProDate(Date production_date);
    List<Drugs> GetDrugByExpDate(Date expiration_date);
    List<Drugs> GetDrugByPrice(double price1, double price2);
    List<Drugs> GetDrugByValidaty(boolean validaty);



}
