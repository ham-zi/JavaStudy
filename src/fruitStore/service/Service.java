package fruitStore.service;

import fruitStore.vo.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Service {

    List<Fruit>fruits = new ArrayList<>();

    public void registerFruit(Fruit fruit) {
        fruits.add(fruit);
    }

    public void removeFruit() {

    }

    public List<Fruit> getFruits(){
        return fruits;
    }

    public Fruit findSellingFruit(String fruit) {
        for (Fruit f : fruits) {
            if (f.getName().equals(fruit)) {
                return f;
            }
        }
        return null;
    }

    public int availableSelling(int hasCount, int sellCount){
        if(hasCount>=sellCount) {
            return 1;
        }else {return 0;}
    }

    public void soldOutCheck(Fruit fruit){
        if(fruit.countIsZero() ==1){
            fruits.remove(fruit);
        }
    }


}
