package sample.entities;

import java.sql.Date;

public class Drugs {
    private String name;
    private int id;
    private String type;
    private String destiny;
    private double price;
    private String manufacturer;
    private Date production_date;
    private Date expiration_date;
    private boolean validaty;


    public Drugs(){

    }
    public Drugs(String name, int id, String type, String destiny, double price, String manufacturer, Date production_date, Date expiration_date, boolean validaty) {
      setName(name);
      setId(id);
      setDestiny(destiny);
      setType(type);
      setPrice(price);
      setManufacturer(manufacturer);
      setProduction_date(production_date);
      setexpiration_date(expiration_date);
      setValidaty(validaty);
    }
    public Drugs(String name, String type, String destiny, double price, String manufacturer, Date production_date, Date expiration_date, boolean validaty) {
        setName(name);
        setDestiny(destiny);
        setType(type);
        setPrice(price);
        setManufacturer(manufacturer);
        setProduction_date(production_date);
        setexpiration_date(expiration_date);
        setValidaty(validaty);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    public Date getexpiration_date() {
        return expiration_date;
    }

    public void setexpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public boolean isValidaty() {
        return validaty;
    }

    public void setValidaty(boolean validaty) {
        this.validaty = validaty;
    }

    @Override
    public String toString() {
        return "Name: "+name+'\n'+
                "ID: "+id+'\n'+
                "type: "+type+'\n'+
                "Destiny: "+destiny+'\n'+
                "Price: "+ price+'\n'+
                "Manufacturer: "+manufacturer+'\n'+
                "Production Date: "+production_date+'\n'+
                "Expiration Date: "+expiration_date+'\n'+
                "Validaty: "+validaty+'\n';

    }
}
