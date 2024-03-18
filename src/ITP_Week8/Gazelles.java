package ITP_Week8;

public class Gazelles {
    public String get_favouriteFood() {
        return _favouriteFood;
    }

    public void set_favouriteFood(String _favouriteFood) {
        this._favouriteFood = _favouriteFood;
    }

    public int get_amountOfFemales() {
        return _amountOfFemales;
    }

    public void set_amountOfFemales(int _amountOfFemales) {
        this._amountOfFemales = _amountOfFemales;
    }

    public int get_amountOfMales() {
        return _amountOfMales;
    }

    public void set_amountOfMales(int _amountOfMales) {
        this._amountOfMales = _amountOfMales;
    }
    private String _favouriteFood;
    private int _amountOfFemales;
    private int _amountOfMales;
    public int get_amountOfAnimal() {
        return (_amountOfMales + _amountOfFemales);
    }

    public Gazelles(int amountOfFemales, int amountOfMales, String favouriteFood) {
        _amountOfFemales = amountOfFemales;
        _amountOfMales = amountOfMales;
        _favouriteFood = favouriteFood;
    }
}

