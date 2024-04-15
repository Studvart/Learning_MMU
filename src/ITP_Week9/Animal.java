package ITP_Week9;

public class Animal {
    protected String _favouriteFood;
    protected int _amountOfFemales;
    protected int _amountOfMales;
    protected String _animalName;

    protected Animal(int amountOfFemales, int amountOfMales, String favouriteFood, String animalName) {
        _amountOfFemales = amountOfFemales;
        _amountOfMales = amountOfMales;
        _favouriteFood = favouriteFood;
        _animalName = animalName;
    }

    protected void makeSound() {
        System.out.println("Animal Sound");
    }

    protected String get_favouriteFood() {
        return _favouriteFood;
    }

    protected void set_favouriteFood(String _favouriteFood) {
        this._favouriteFood = _favouriteFood;
    }

    protected int get_amountOfFemales() {
        return _amountOfFemales;
    }

    protected void set_amountOfFemales(int _amountOfFemales) {
        this._amountOfFemales = _amountOfFemales;
    }

    protected int get_amountOfMales() {
        return _amountOfMales;
    }

    protected void set_amountOfMales(int _amountOfMales) {
        this._amountOfMales = _amountOfMales;
    }

    protected int get_amountOfAnimal() {
        return (_amountOfMales + _amountOfFemales);
    }
}

