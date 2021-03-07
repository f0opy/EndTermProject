package sample.Menu.interfaces;

import sample.entities.Drugs;

import java.util.List;

public interface IUserMenu {
    boolean PurchaseDrug(String name, String drugName, String address, String email, String phoneNumber);
    boolean CancelOrder(int order_id);
    boolean GiveFeedback(String feedback,String name);
    boolean UsePromocode();


}
