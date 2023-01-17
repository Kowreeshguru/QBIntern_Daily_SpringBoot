package demo.test1.model;

import java.util.ArrayList;

public class Wholesaler {
    public int w_id;
    public String w_name;
    public ArrayList<Product> whole_productlist=new ArrayList<>();
    Wholesaler(){}

    public int getW_id() {
        return w_id;
    }

    public void setW_id(int w_id) {
        this.w_id = w_id;
    }

    public String getW_name() {
        return w_name;
    }

    public void setW_name(String w_name) {
        this.w_name = w_name;
    }

    public ArrayList<Product> getWhole_productlist() {
        return whole_productlist;
    }

    public void setWhole_productlist(ArrayList<Product> whole_productlist) {
        this.whole_productlist = whole_productlist;
    }

    public Wholesaler(int id, String name){

        this.w_id=id;
        this.w_name=name;
        this.whole_productlist= new ArrayList<Product>();
//        Product prod1=new Product(100,"iphone12",1000,45000,12);
//        Product prod2=new Product(101,"iphone13",1000,50000,15);
//        whole_productlist.add(prod1);
//        whole_productlist.add(prod2);
    }
}
