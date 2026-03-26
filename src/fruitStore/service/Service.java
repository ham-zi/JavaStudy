package fruitStore.service;

import fruitStore.repository.FruitRepository;
import fruitStore.repository.MemoryFruitRepository;
import fruitStore.vo.Fruit;
import java.util.List;

public class Service {
    FruitRepository repo = new MemoryFruitRepository();



    public void registerFruit(String name,String variety, int price, int count) {
        repo.registerFruit(name, variety,price,count);
    }

    public Fruit findSellingFruit(String fruit, String variety) {
        for (Fruit f : repo.getFruits()) {
            if (f.getName().equals(fruit) && f.getVariety().equals(variety)) {
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
            repo.removeFruit(fruit);
        }
    }
    public List<Fruit> getFruits(){
        return repo.getFruits();
    }

}
