package sample.controller;

import sample.Menu.interfaces.IAdminMenu;
import sample.Menu.interfaces.IMenu;
import sample.Menu.interfaces.IUserMenu;
import sample.entities.Drugs;

import java.sql.Date;
import java.util.List;

public class Controller {



    private final IAdminMenu AdminRepositories;
    private final IMenu MenuRepositories;
    private final IUserMenu UserRepositories;


    public Controller(IAdminMenu adminRepositories, IMenu MenuRepositories,IUserMenu UserRepositories){

        this.AdminRepositories = adminRepositories;
        this.MenuRepositories=MenuRepositories;
        this.UserRepositories=UserRepositories;
    }





    public List<Drugs> GetAllDrugs() {
        List<Drugs> drug= MenuRepositories.GetAllDrugs(); // Getting all the drugs from the list
        return drug;
    }
    public String getDrugById(int id) {
        String result =MenuRepositories.GetDrugById(id).toString(); //  Getting drug from the list by id

        return result;
    }
    public  List<Drugs> getDrugByName(String name)
    {
        List<Drugs> drug=MenuRepositories.GetDrugByName(name); // Getting drug from the list by name
        return drug;
    }
    public  List<Drugs> getDrugByType(String type)
    {
        List<Drugs> drug=MenuRepositories.GetDrugByType(type) ; // Getting drug from the list by type
        return drug;
    }
    public  List<Drugs> getDrugByDestiny(String destiny)
    {
        List<Drugs> drug=MenuRepositories.GetDrugByDestiny(destiny); // Getting drug from the list by destiny
        return drug;
    }
    public  List<Drugs> getDrugByManufacturer(String manufacturer)
    {
        List<Drugs> drug=MenuRepositories.GetDrugByManufacturer(manufacturer); // Getting drug from the list by manufacturer
        return drug;
    }
    public  List<Drugs> getDrugProDate(Date production_date)
    {
        List<Drugs> drug=MenuRepositories.GetDrugByProDate(production_date); // Getting drug from the list by production_date
        return drug;
    }
    public  List<Drugs> getDrugExpDate(Date expiration_date)
    {
        List<Drugs> drug=MenuRepositories.GetDrugByExpDate(expiration_date); // Getting drug from the list by expiration_date
        return drug;
    }

    public  List<Drugs> getDrugByPrice(double price1, double price2)
    {
        List<Drugs> drug=MenuRepositories.GetDrugByPrice(price1, price2); // Getting drug from the list by price
        return drug;
    }
    public  List<Drugs> getDrugByValidaty(boolean validaty)
    {
        List<Drugs> drug=MenuRepositories.GetDrugByValidaty(validaty); // Getting drug from the list validaty
        return drug;
    }

    public String createDrug(String name, String type, String destiny, double price, String manufacturer, Date production_date, Date expiration_date, boolean validaty){

        boolean created=AdminRepositories.CreateDrug(name, type, destiny, price, manufacturer, production_date, expiration_date, validaty); // In this method creating  drugs by name, type, destiny , price, manufacturer, production_date, expiration_date, validaty

        return (created ? "Drug was created successfully!" : "Drug creation was failed! ");
    }
    public String updateDrugPrice(double price1,int id){

        boolean created=AdminRepositories.UpdatePrice(price1,id); // In this method updating drug by price and id

        return (created ? "Drug was updated successfully!" : "Drug update was failed! ");
    }

    public String deleteDrug(int id){

        boolean created=AdminRepositories.DeleteDrug(id);// Deleting drug by id

        return (created ? "Drug was deleted successfully!" : "Drug delete was failed! ");
    }

    public String purchaseDrug(String name, String drugName, String address, String email, String phoneNumber){
        boolean created=UserRepositories.PurchaseDrug(name, drugName, address, email, phoneNumber); // In this method the user can buy drug. To make  a purchase, the user must enter his name, and the name of the drug, address, email, and phone number
        return (created ? "Congratulations You have bought drug! All information about order and payment sent to your E-Mail." : "We can't sell to you this drug. ");

    }

    public String usePromocode(){
        boolean got;

        got=UserRepositories.UsePromocode(); // In this method the user can get promocode codes for all drugs for 10%
        return (got?"Congratulations you got 10% off to every drug that exist in list!":"Wrong");

    }

    public void GiveFeedback(String feed,String name){
        UserRepositories.GiveFeedback(feed,name); // User can give a purchase feedback

    }
    public void cancelOrder(int id){
        UserRepositories.CancelOrder(id);   // In this method user can cancel order
    }






}
