package demo.test1.service.impl;

import demo.test1.api.Actors;
import demo.test1.model.Product;
import demo.test1.model.Retailer;
import demo.test1.model.Wholesaler;
import demo.test1.service.impl.WholesalerOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service

public class RetailerOp implements Actors {
    public static ArrayList<Retailer> retailer = new ArrayList<>();
    RetailerOp(){
        String prod_fileName = "/Users/kowreesh/Downloads/Retailer.csv";
        File prod_file = new File(prod_fileName);
        List<List<String>> retail = new ArrayList<>();
        Scanner retail_inputStream;
        try{
            retail_inputStream = new Scanner(prod_file);

            while (retail_inputStream.hasNext()) {
                String prod_line = retail_inputStream.next();
                String[] values = prod_line.split(",");
                retail.add(Arrays.asList(values));
            }
            retail_inputStream.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("hello1");
            e.printStackTrace();
        }
        for (int i = 0; i < retail.size(); i++) {
            retailer.add(new Retailer(Integer.parseInt(retail.get(i).get(0)),retail.get(i).get(1)));
        }
    }

    @Override
    public void load(){
//        String prod_fileName = "/Users/kowreesh/Downloads/Wholesaler.csv";
//        File prod_file = new File(prod_fileName);
//        List<List<String>> whole = new ArrayList<>();
//        Scanner whole_inputStream;
//        try{
//            whole_inputStream = new Scanner(prod_file);
//
//            while (whole_inputStream.hasNext()) {
//                String prod_line = whole_inputStream.next();
//                String[] values = prod_line.split(",");
//                whole.add(Arrays.asList(values));
//            }
//            whole_inputStream.close();
//        }
//        catch(FileNotFoundException e) {
//            System.out.println("hello1");
//            e.printStackTrace();
//        }
//        for (int i = 0; i < whole.size(); i++) {
//            wholesaler.add(new Wholesaler(Integer.parseInt(whole.get(i).get(0)),whole.get(i).get(1)));
//        }
    }

    public Retailer disp_retailer(int id) {
        Retailer ans=null;
        for (Retailer temp_retail : retailer) {
            if (temp_retail.r_id == id) {
                ans=temp_retail;
            }
        }return ans;
    }
    public Retailer add_retailer(Retailer add_retail) {
        retailer.add(add_retail);
        return add_retail;
    }

    @Autowired
    WholesalerOp whole;

    public String allocate_retailer(int r_id,int w_id,int p_id, int product_quantity){
        boolean check_wholesaler_id=true;
        String ret="Successfully added to retailer";
        for(Retailer temp_retailer: retailer){
            if(temp_retailer.r_id == r_id){
//                while(check_wholesaler_id) {
                    for(Wholesaler temp_whole: WholesalerOp.wholesaler){
                        if(temp_whole.w_id == w_id) {
                            check_wholesaler_id = false;
                            ArrayList<Product> billing_section = new ArrayList<>();
//                            temp_whole.disp_whole_stock();
                            if (temp_whole.whole_productlist.isEmpty()) {
                                check_wholesaler_id = true;
                            } else {
//                                System.out.println("Enter the needed Product id:");
                                boolean check_product_id = true;
                                boolean check_product_id_avail = true;
//                                while (check_product_id) {
//                                    int choose_product = sc.nextInt();
//                            for (Producer temp_product : apple) {
//                                if (temp_product.id == choose_product) {
                                    for (Product whole_product : temp_whole.whole_productlist) {
                                        if (whole_product.id == p_id) {

//                                            System.out.println("Enter the needed Product quantity:");
                                            boolean is_quantity = true;
//                                            while (is_quantity) {
//                                                int product_quantity = sc.nextInt();
                                                int retailer_price = whole_product.price + 6000;
                                                if (product_quantity >= 0 && whole_product.stock >= product_quantity) {
                                                    is_quantity = false;
                                                    if (temp_retailer.retail_productlist.isEmpty()) {
//                                                        System.out.println("New product---Enter your price :");

                                                        Product add_prod = new Product(whole_product.id, whole_product.name, product_quantity, retailer_price, whole_product.gst);
                                                        temp_retailer.retail_productlist.add(add_prod);
                                                        whole.mang_stock_wholesaler(w_id,p_id,product_quantity);
                                                    } else {
                                                        boolean flag = true;
                                                        for (Product prod : temp_retailer.retail_productlist) {
                                                            if (prod.id == p_id) {
                                                                flag = false;
                                                                prod.stock = prod.stock + product_quantity;
                                                                whole.mang_stock_wholesaler(w_id,p_id,product_quantity);
                                                            }
                                                        }
                                                        if (flag) {

                                                            Product add_prod = new Product(whole_product.id, whole_product.name, product_quantity, retailer_price, whole_product.gst);
                                                            temp_retailer.retail_productlist.add(add_prod);
                                                            whole.mang_stock_wholesaler(w_id,p_id,product_quantity);
                                                        }
                                                    }

                                                } else {
                                                    ret ="Availability stock is :" + whole_product.stock;
                                                }
//                                            }
                                            check_product_id = false;
                                        }

                                    }

//                                }
//                            }
                                    if (check_product_id) {
                                        ret ="Enter the Valid Product id:";
                                    }
//                                }
                            }
                        }
                    }
                    if(check_wholesaler_id){
                        ret ="Enter the Valid Wholesaler id:";
                    }
//                }
            }
        }
        return ret;
    }
}
