package entity;

import java.util.List;

/**
 * Created by admin on 2015/7/26.
 */
public class Item {
    private String name;
    private String year;
    private boolean isAvailable;

    public Item(String name, String year, boolean isAvailable) {
        this.name = name;
        this.year = year;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    public boolean checkoutItem(String type,String name){
        if((this.isAvailable()) && this.name.equals(name)){
            this.setIsAvailable(false);
            System.out.println("Thank You! Enjoy the "+type+"!");
            return true;
        }
        else return false;
    }

    public boolean returnItem(String type,String name){
        if((!this.isAvailable()) && this.name.equals(name)){
            this.setIsAvailable(true);
            System.out.println("Thank you for returning the "+type+"!");
            return true;
        }
        else return false;
    }
}
