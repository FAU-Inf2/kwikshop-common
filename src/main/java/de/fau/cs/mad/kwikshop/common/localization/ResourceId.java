package de.fau.cs.mad.kwikshop.common.localization;

public enum ResourceId {

    Group_CoffeeAndTea(1),
    Group_HealthAndHygiene(2),
    Group_PetSupplies(3),
    Group_Household(4),
    Group_BreadAndPastries(5),
    Group_Beverages(6),
    Group_SweetsAndSnacks(7),
    Group_BabyFoods(8),
    Group_Pasta(9),
    Group_Dairy(10),
    Group_FruitsAndVegetables(11),
    Group_MeatAndFish(12),
    Group_IngredientsAndSpices(13),
    Group_FrozenAndConvenience(14),
    Group_Tobacco(15),
    Group_Other(16);

    private final int id;

    ResourceId(int id) {
        this.id = id;
    }

    public int toInt() {
        return id;
    }

    public static ResourceId fromInt(int value) {
        ResourceId[] values = ResourceId.values();
        return values[value -1];
    }

}
