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
    Group_Other(16),
    Unit_Piece(17),
    Unit_short_Piece(18),
    Unit_Bag(19),
    Unit_Bottle(20),
    Unit_Box(21),
    Unit_Pack(22),
    Unit_Dozen(23),
    Unit_Gram(24),
    Unit_short_Gram(25),
    Unit_Kilogram(26),
    Unit_short_Kilogram(27),
    Unit_Millilitre(28),
    Unit_short_Millilitre(29),
    Unit_Litre(30),
    Unit_short_Litre(31),
    Unit_Cup(32),
    Unit_Tablespoon(33),
    Unit_short_Tablespoon(34),
    Unit_Can(35),
    Unit_Teaspoon(36),
    Unit_short_Teaspoon(37),
    Unit_Piece_name(38),
    Unit_Bag_singular(39),
    Unit_Bottle_singular(40),
    Unit_Box_singular(41),
    Unit_Pack_singular(42),
    Unit_Dozen_singular(43),
    Unit_Gram_singular(44),
    Unit_Kilogram_singular(45),
    Unit_Millilitre_singular(46),
    Unit_Litre_singular(47),
    Unit_Cup_singular(48),
    Unit_Tablespoon_singular(49),
    Unit_Can_singular(50),
    Unit_Teaspoon_singular(51),
    Group_Can(52);

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
