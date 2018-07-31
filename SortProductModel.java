package com.toko.dates;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SortProductModel {
    public static void main(String[] args) {

        List<ProductModel> object=createProduts();
        System.out.println("Before :"+object);
        List<ProductModel> productName= object.stream().sorted((product1, product2) ->product1.getName().compareTo(product2.getName())).collect(Collectors.toList());
        System.out.println("Product Name :"+productName);
        object.sort(Comparator.comparing(ProductModel::getPrice));
        System.out.println("Product Price :"+object);
        object.sort(Comparator.comparing(productModel -> productModel.getRating()));
        System.out.println("Product Rating :"+object);

        System.out.println("***************************************** Reverse ************************************************");

        Comparator<ProductModel> reverseByName=Comparator.comparing(ProductModel::getName);
        Collections.sort(object,reverseByName.reversed());
        System.out.println("Reverse By Name :"+object);

        Comparator<ProductModel> reverseByPrice=Comparator.comparing(ProductModel::getPrice);
        Collections.sort(object,reverseByPrice.reversed());
        System.out.println("Reverse By Price :"+object);

        Comparator<ProductModel> reverseByRating=Comparator.comparing(ProductModel::getRating);
        Collections.sort(object,reverseByRating.reversed());
        System.out.println("Reverse By Rating :"+object);





    }

    private static List<ProductModel> createProduts() {
        ProductModel model1=new ProductModel("Apple",45000.0,4);
        ProductModel model2=new ProductModel("Samsung",58000.0,3);
        ProductModel model3=new ProductModel("Nokia",89653.20,5);
        ProductModel model4=new ProductModel("Lava",15263.56,2);
        ProductModel model5=new ProductModel("Karboon",14756.30,1);
        List<ProductModel> obj=new LinkedList<>();
        obj.add(model1);
        obj.add(model2);
        obj.add(model3);
        obj.add(model4);
        obj.add(model5);
        return obj;
    }

}

class ProductModel
{
    String name;
    double price;
    int rating;

    public ProductModel(final String name, final double price, final int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(final int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ProductModel{" + "name='" + name + '\'' + ", price=" + price + ", rating=" + rating + '}';
    }
}