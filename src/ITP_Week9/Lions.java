package ITP_Week9;

public class Lions extends Animal{

    public Lions(int _amountOfFemales, int _amountOfMales, String _favouriteFood, String _animalName) {
        super(_amountOfFemales, _amountOfMales, _favouriteFood, _animalName);
    }

    @Override
    public void makeSound(){
        System.out.println("Roar");
    }

}
