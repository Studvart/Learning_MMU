package ITP_Week9;

public class Pigs extends Animal{

    public Pigs(int _amountOfFemales, int _amountOfMales, String _favouriteFood, String _animalName) {
        super(_amountOfFemales, _amountOfMales, _favouriteFood, _animalName);
    }

    @Override
    public void makeSound(){
        System.out.println("Oink");
    }

}

