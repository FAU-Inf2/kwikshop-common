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
    Unit_Teaspoon(30),

    ShoppingList_MyFirstShoppingList(31),
    ShoppingList_MyFirstShoppingList_Item1(32),
    ShoppingList_MyFirstShoppingList_Item2(33),
    ShoppingList_MyFirstShoppingList_Item3(34),
    ShoppingList_MyFirstShoppingList_Item4(35),
    ShoppingList_MyFirstShoppingList_Item5(36),
    ShoppingList_MyFirstShoppingList_Item6(37),


    Recipe_ChiliConCarne(38),
    Recipe_ChiliConCarne_Item1(32),
    Recipe_ChiliConCarne_Item2(33),
    Recipe_ChiliConCarne_Item3(34),
    Recipe_ChiliConCarne_Item4(35),
    Recipe_ChiliConCarne_Item5(36),
    Recipe_ChiliConCarne_Item6(37),


    Recipe_CarrotCake(38),
    Recipe_CarrotCake_Item1(39),
    Recipe_CarrotCake_Item2(40),
    Recipe_CarrotCake_Item3(41),
    Recipe_CarrotCake_Item4(42),
    Recipe_CarrotCake_Item5(43),
    Recipe_CarrotCake_Item6(44),
    Recipe_CarrotCake_Item7(45),

    Recipe_RhubarbTart(50),
    Recipe_RhubarbTart_Item1(51),
    Recipe_RhubarbTart_Item2(52),
    Recipe_RhubarbTart_Item3(53),
    Recipe_RhubarbTart_Item4(54),
    Recipe_RhubarbTart_Item5(55),
    Recipe_RhubarbTart_Item6(56),
    Recipe_RhubarbTart_Item7(57),
    Recipe_RhubarbTart_Item8(58),
    Recipe_RhubarbTart_Item9(59),


    Recipe_MadeiraCake(60),
    Recipe_MadeiraCake_Item1(61),
    Recipe_MadeiraCake_Item2(62),
    Recipe_MadeiraCake_Item3(63),
    Recipe_MadeiraCake_Item4(64),
    Recipe_MadeiraCake_Item5(65),
    Recipe_MadeiraCake_Item6(66),
    Recipe_MadeiraCake_Item7(67);


    private final int id;

    PredefinedId(int id) {
        this.id = id;
    }

    public int toInt() {
        return id;
    }


}
