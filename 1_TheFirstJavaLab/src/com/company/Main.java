package com.company;

import mainPackage.Apple;
import mainPackage.Cake;
import mainPackage.Cheese;

public class Main{
    public static void main(String[] args) throws Exception{
        Food[] breakfast=new Food[args.length];
        for(int i=0;i<args.length;i++){
            String[] parts=args[i].split("/");
            if(parts[0].equals("Cheese")){
                breakfast[i]=new Cheese();
            }else if(parts[0].equals("Apple")){
                breakfast[i]=new Apple(parts[1]);
            }else if(parts[0].equals("Cake")){
                breakfast[i]=new Cake(parts[1]);
            }
        }
        for(Food item:breakfast){
            item.consume();
        }

        Food food=new Cake("Caramel");
        //System.out.println(food + ": " + countFoods(breakfast, food));
        printFoods(breakfast);
        System.out.println("Best regards!");
    }

    static Integer countFoods(Food[] breakfast, Food food) {
        Integer count = 0;
        for(int i = 0; i < breakfast.length; i++) {
            if(food.equals(breakfast[i]))
            {
                count++;
            }
        }
        return count;
    }

    static void printFoods(Food[] breakfast){
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i = 0; i < breakfast.length; i++) {

             if (breakfast[i] instanceof Cheese){
                a++;
            }
             else if(breakfast[i] instanceof Apple){
                 b++;
             }
             else if(breakfast[i] instanceof Cake){
                 c++;
             }

        }
        System.out.println("Cheese - " + a);
        System.out.println("Apple - " + b);
        System.out.println("Cake - " + c);

    }
}