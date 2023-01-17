package demo.test1.service.impl;

import demo.test1.api.Actors;
import demo.test1.model.Product;

import demo.test1.model.Wholesaler;
import demo.test1.service.impl.ProductOp;
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

public class WholesalerOp implements Actors {
    public static ArrayList<Wholesaler> wholesaler = new ArrayList<>();

    WholesalerOp() {
        String prod_fileName = "/Users/kowreesh/Downloads/Wholesaler.csv";
        File prod_file = new File(prod_fileName);
        List<List<String>> whole = new ArrayList<>();
        Scanner whole_inputStream;
        try {
            whole_inputStream = new Scanner(prod_file);

            while (whole_inputStream.hasNext()) {
                String prod_line = whole_inputStream.next();
                String[] values = prod_line.split(",");
                whole.add(Arrays.asList(values));
            }
            whole_inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("hello1");
            e.printStackTrace();
        }
        for (int i = 0; i < whole.size(); i++) {
            wholesaler.add(new Wholesaler(Integer.parseInt(whole.get(i).get(0)), whole.get(i).get(1)));
        }
    }

    @Override
    public void load() {
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

    public Wholesaler disp_wholesaler(int id) {
        Wholesaler ans = null;
        for (Wholesaler temp_whole : wholesaler) {
            if (temp_whole.w_id == id) {
                ans = temp_whole;
            }
        }
        return ans;
    }

    public Wholesaler add_wholesaler(Wholesaler add_whole) {
        wholesaler.add(add_whole);
        return add_whole;
    }

    @Autowired
    ProductOp prod;
    public String allocate_wholesaler(int w_id, int p_id, int product_quantity) {
//        ArrayList<Product> billing_section = new ArrayList<>();
        boolean check_product_id = true;
        String ret="Succesfully added in wholesaler";
        for (Wholesaler temp_whole : wholesaler) {
            if (temp_whole.w_id == w_id) {
//                while (check_product_id) {
                    for (Product temp_product : ProductOp.product) {
                        if (temp_product.id == p_id) {
                            check_product_id = false;
                            boolean is_quantity = true;
//                            while (is_quantity) {
                                if (product_quantity >= 0 && temp_product.stock >= product_quantity) {
                                    is_quantity = false;
                                    if (temp_whole.whole_productlist.isEmpty()) {
                                        int wholesaler_price = temp_product.price + 5000;
                                        Product add_prod = new Product(temp_product.id, temp_product.name, product_quantity, wholesaler_price, temp_product.gst);
                                        temp_whole.whole_productlist.add(add_prod);
                                        prod.mang_warehouse(p_id,product_quantity);
                                    } else {
                                        boolean flag = true;
                                        for (Product prod1 : temp_whole.whole_productlist) {
                                            if (prod1.id == p_id) {
                                                flag = false;
                                                prod1.stock = prod1.stock + product_quantity;
                                                prod.mang_warehouse(p_id,product_quantity);
                                            }
                                        }
                                        if (flag) {
                                            int wholesaler_price = temp_product.price + 5000;
                                            Product add_prod = new Product(temp_product.id, temp_product.name, product_quantity, wholesaler_price, temp_product.gst);
                                            temp_whole.whole_productlist.add(add_prod);
                                            prod.mang_warehouse(p_id,product_quantity);
                                        }
                                    }
//                                    if (billing_section.isEmpty()) {
//                                        Producer add_prod = new Producer(temp_product.id, temp_product.name, product_quantity, temp_product.price, temp_product.gst);
//                                        billing_section.add(add_prod);
//                                        System.out.println("*** Add to bill ***");
//                                    } else {
//                                        boolean flag = true;
//                                        for (Producer prod1 : billing_section) {
//                                            if (prod1.id == choose_product) {
//                                                flag = false;
//                                                prod1.stock = prod1.stock + product_quantity;
//                                                System.out.println("*** Add to bill ***");
//                                            }
//                                        }
//                                        if (flag) {
//                                            Producer add_prod = new Producer(temp_product.id, temp_product.name, product_quantity, temp_product.price, temp_product.gst);
//                                            billing_section.add(add_prod);
//                                            System.out.println("*** Add to bill ***");
//                                        }
//                                    }

                                } else {
                                    ret="Availability stock is :" + temp_product.stock;
                                }
//                            }
                        }
                    }
                    if (check_product_id) {
                        ret="Enter the Valid Product id:";
                    }
//                }
            }

        }
        return ret;
    }
    public void mang_stock_wholesaler(int w_id,int p_id,int val){
        for(Wholesaler temp_whole: wholesaler){
            if(temp_whole.w_id == w_id){
                for(Product temp_product:temp_whole.whole_productlist){
                    if (temp_product.id == p_id){
                        temp_product.stock=temp_product.stock-val;
                    }
                }
            }
        }

    }
}
