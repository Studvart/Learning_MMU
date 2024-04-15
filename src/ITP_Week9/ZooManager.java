package ITP_Week9;

public class ZooManager {
    public static void main(String[] args) {

        Animal lions = new Lions(2,4,"Meat","Lion");
        Animal gazelles = new Gazelles(2,2,"Grass","Gazelle");
        Animal pigs = new Pigs(4,2,"Apples","Pig");
        ProcessManager processManager = new ProcessManager();

        processManager.manageProcess((Lions) lions, (Gazelles) gazelles, (Pigs) pigs);
        lions.set_amountOfFemales(lions.get_amountOfFemales() + 3);

        System.out.printf("""
                \n
                Manchester council have just received 3 additional lions.
                They now have %d lions.
                Of which %d are female lions
                and %d male lions.
                """, lions.get_amountOfAnimal() , lions.get_amountOfFemales(), lions.get_amountOfMales());

    }

}
