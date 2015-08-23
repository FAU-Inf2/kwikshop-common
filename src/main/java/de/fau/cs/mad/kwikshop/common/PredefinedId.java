package de.fau.cs.mad.kwikshop.common;

public enum PredefinedId {

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
    Group_Other(16),
    Unit_Piece(17),
    Unit_Bag(18),
    Unit_Bottle(19),
    Unit_Box(20),
    Unit_Pack(21),
    Unit_Dozen(22),
    Unit_Gram(23),
    Unit_Kilogram(24),
    Unit_Millilitre(25),
    Unit_Litre(26),
    Unit_Cup(27),
    Unit_Tablespoon(28),
    Unit_Can(29),
    Unit_Teaspoon(30);


    private final int id;

    PredefinedId(int id) {
        this.id = id;
    }

    public int toInt() {
        return id;
    }


}
