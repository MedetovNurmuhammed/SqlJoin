package databasa;

import model.Laptop;
import model.Mymodels;
import model.Phone;

import java.util.ArrayList;
import java.util.List;

public class Databasa {
    private List<Laptop>laptops = new ArrayList<>();
    private List<Phone>phones = new ArrayList<>();
    //экооно тен иштейт
     public<T> Boolean add(T type){


if ((myinstancof(type,Laptop.class))){
   return laptops.add((Laptop)type);

     }else if (myinstancof(type,Phone.class)){

   return phones.add((Phone) type);
}throw new RuntimeException("НЕ правильно!");


     }

     public <T> Boolean remove(T type){
         if (type instanceof Laptop){

             return laptops.add((Laptop)type);
         }else if (type instanceof Phone){

             return phones.add((Phone) type);
         }throw new RuntimeException("инв ремов!");


     }
     private<T> Boolean myinstancof(T type,Class<? extends Mymodels>c){

         return c.isInstance(type);
         }
         public List<Laptop>laptopList(){
         return laptops;
         }
         public List<Phone>phoneList(){
         return phones;
         }
//         public List getall(Class<?> classtype){
//       boolean instance =  classtype.isInstance(Laptop.class);
//       return instance ? laptops:phones;
//
//         }
     }

