package ITP_Week9;

public class ProcessManager {
    public void manageProcess(Animal lions, Animal gazelles, Animal pigs) {

        System.out.printf("""
                Manchester council currently has %d lions.
                Manchester council currently has %d gazelles.
                Manchester council currently has %d pigs.
                """, lions.get_amountOfAnimal() , gazelles.get_amountOfAnimal(), pigs.get_amountOfAnimal());

        System.out.printf("""
                There are currently %d female lions and %d male lions.
                MThere are currently %d female gazelles and %d male gazelles.
                There are currently %d female pigs and %d male pigs.
                """, lions.get_amountOfFemales(), lions.get_amountOfMales(), gazelles.get_amountOfFemales(), gazelles.get_amountOfMales(), pigs.get_amountOfFemales(), pigs.get_amountOfMales());

        System.out.printf("""
                The lions like to eat %s.
                The gazelles like to eat %s.
                The pigs like to eat %s.
                """, lions.get_favouriteFood(), gazelles.get_favouriteFood(), pigs.get_favouriteFood());
    }
}
