package demo.test1.model;

import java.util.ArrayList;


public class Retailer {
    public  int r_id;
    String r_name;
    public ArrayList<Product> retail_productlist=new ArrayList<>();
    Retailer(){}

    public int getR_id() {
        return r_id;
    }

    public void setW_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setW_name(String r_name) {
        this.r_name = r_name;
    }

    public ArrayList<Product> getRetail_productlist() {
        return retail_productlist;
    }

    public void setWhole_productlist(ArrayList<Product> retail_productlist) {
        this.retail_productlist = retail_productlist;
    }

    public Retailer(int id, String name){
        this.r_id=id;
        this.r_name=name;
        this.retail_productlist= new ArrayList<Product>();
//        Product prod1=new Product(100,"iphone12",1000,45000,12);
//        Product prod2=new Product(101,"iphone13",1000,50000,15);
//        retail_productlist.add(prod1);
//        retail_productlist.add(prod2);
    }
}
