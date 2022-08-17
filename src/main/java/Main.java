import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog("Danny", 6, 56, new HashSet<>(Arrays.asList("eat", "run", "sleep")));
        DomesticCat cat = new DomesticCat("Garfield", 8, 90, new HashSet<>(Arrays.asList("sleep", "watch Tv", "eat")));

        Human mother1 = new Human("Arzu","Ismayilova",1975, 90, null);
        Human father1 = new Human("Senan","Ismayilov",1975, 94, null);
        Human mother2 = new Human("Rima", "Quliyeva", 1980);
        Human father2 = new Human("Rasim", "Quliyev", 1980);
        Human mother3 = new Human("Esmira", "Eliyeva", 1981);
        Human father3 = new Human("Azer", "Eliyev", 1981);
        Human child1 = new Human("Elnur","Ismayilov",2000,94, null);
        Human child2 = new Human("Emil","Ismayilov",1996,92, null);
        Human child3 = new Human("Elvin","Quliyev",1996,92, null);
        Human child4 = new Human("Eldar","Selimov",2015,92, null);

        FamilyController familyController = new FamilyController();

        familyController.createNewFamily(mother1, father1);
        familyController.createNewFamily(mother2, father2);
        familyController.createNewFamily(mother3, father3);

        familyController.getFamilyById(0).addChild(child1);
        familyController.getFamilyById(0).addChild(child2);
        familyController.getFamilyById(1).addChild(child3);
        familyController.bornChild(familyController.getFamilyById(1), "Asim", "Valide");
        familyController.adoptChild(familyController.getFamilyById(1), child4);
        familyController.addPet(dog, 0);
        familyController.addPet(cat, 0);

        System.out.println(familyController.getPets(0));
        System.out.println(familyController.getAllFamilies());
        System.out.println(familyController.getFamiliesBiggerThan(4));
        System.out.println(familyController.getFamiliesLessThan(5));
        System.out.println(familyController.countFamiliesWithMemberNumber(2));
        System.out.println(familyController.count());

        familyController.displayAllFamilies();
        familyController.deleteAllChildrenOlderThan(2);
        familyController.displayAllFamilies();
        familyController.deleteFamilyByIndex(0);
        familyController.displayAllFamilies();

    }
}
