package fruitStore.controller;

import fruitStore.service.Service;
import fruitStore.vo.Fruit;

import java.util.List;

public class Controller {
    Service sv = new Service();

    public void registerFruit(Fruit fruit) {
        sv.registerFruit(fruit);
    }

    public List<Fruit>getFruits(){
        return sv.getFruits();
    }

    public Fruit findFruit(String fruit) {
        return sv.findSellingFruit(fruit);
    }

    public int availableSelling(int hasCount, int sellCount){
        return sv.availableSelling(hasCount,sellCount);
    }

    public void soldOutCheck(Fruit fruit){
        sv.soldOutCheck(fruit);
    }
}
