package fruitStore.controller;

import fruitStore.service.Service;
import fruitStore.vo.Fruit;

import java.util.List;

public class Controller {
    Service sv = new Service();

    public void registerFruit(String name,String variety, int price, int count) {
        sv.registerFruit(name, variety,price,count);
    }

    public List<Fruit>getFruits(){
        return sv.getFruits();
    }

    public Fruit findFruit(String fruit, String fruitVariety) {
        return sv.findSellingFruit(fruit,fruitVariety);
    }

    public int availableSelling(int hasCount, int sellCount){
        return sv.availableSelling(hasCount,sellCount);
    }

    public void soldOutCheck(Fruit fruit){
        sv.soldOutCheck(fruit);
    }
}
