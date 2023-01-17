package demo.test1.service.impl;

import demo.test1.api.Actors;
import demo.test1.model.Product;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service

public class ProductOp implements Actors {
    public static ArrayList<Product> product = new ArrayList<>();

    ProductOp(){
        String prod_fileName = "/Users/kowreesh/Downloads/Producer.csv";
        File prod_file = new File(prod_fileName);
        List<List<String>> prod = new ArrayList<>();
        Scanner prod_inputStream;
        try{
            prod_inputStream = new Scanner(prod_file);

            while (prod_inputStream.hasNext()) {
                String prod_line = prod_inputStream.next();
                String[] values = prod_line.split(",");
                prod.add(Arrays.asList(values));
            }
            prod_inputStream.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("hello1");
            e.printStackTrace();
        }
        for (int i = 0; i < prod.size(); i++) {
            product.add(new Product((Integer.parseInt(prod.get(i).get(0))),prod.get(i).get(1),Integer.parseInt(prod.get(i).get(2)),Integer.parseInt(prod.get(i).get(3)),Integer.parseInt(prod.get(i).get(4))));
        }
    }

    @Override
    public void load(){
//        String prod_fileName = "/Users/kowreesh/Downloads/Producer.csv";
//        File prod_file = new File(prod_fileName);
//        List<List<String>> prod = new ArrayList<>();
//        Scanner prod_inputStream;
//        try{
//            prod_inputStream = new Scanner(prod_file);
//
//            while (prod_inputStream.hasNext()) {
//                String prod_line = prod_inputStream.next();
//                String[] values = prod_line.split(",");
//                prod.add(Arrays.asList(values));
//            }
//            prod_inputStream.close();
//        }
//        catch(FileNotFoundException e) {
//            System.out.println("hello1");
//            e.printStackTrace();
//        }
//        for (int i = 0; i < prod.size(); i++) {
//            product.add(new Product((Integer.parseInt(prod.get(i).get(0))),prod.get(i).get(1),Integer.parseInt(prod.get(i).get(2)),Integer.parseInt(prod.get(i).get(3)),Integer.parseInt(prod.get(i).get(4))));
//        }
    }

    public Product disp_product(int id) {
        Product ans=null;
        for (Product prod : product) {
            if (prod.id == id) {
                ans=prod;
            }
        }return ans;
    }
    public Product add_product(Product add_prod) {
        product.add(add_prod);
        return add_prod;
    }
    public void mang_warehouse(int id,int val){
        for(Product temo_product: product) {
            if(temo_product.id == id) {
                temo_product.stock = temo_product.stock - val;
            }
        }
    }

}
