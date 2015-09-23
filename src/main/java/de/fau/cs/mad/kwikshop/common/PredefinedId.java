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

    Group_Can(31),

    ShoppingList_MyFirstShoppingList(100),
    ShoppingList_MyFirstShoppingList_Item1(100 + 1),
    ShoppingList_MyFirstShoppingList_Item2(100 + 2),
    ShoppingList_MyFirstShoppingList_Item3(100 + 3),
    ShoppingList_MyFirstShoppingList_Item4(100 + 4),
    ShoppingList_MyFirstShoppingList_Item5(100 + 5),
    ShoppingList_MyFirstShoppingList_Item6(100 + 6),


    Recipe_ChiliConCarne(200),
    Recipe_ChiliConCarne_Item1(200 + 1),
    Recipe_ChiliConCarne_Item2(200 + 2),
    Recipe_ChiliConCarne_Item3(200 + 3),
    Recipe_ChiliConCarne_Item4(200 + 4),
    Recipe_ChiliConCarne_Item5(200 + 5),
    Recipe_ChiliConCarne_Item6(200 + 6),


    Recipe_CarrotCake(300),
    Recipe_CarrotCake_Item1(300 + 1),
    Recipe_CarrotCake_Item2(300 + 2),
    Recipe_CarrotCake_Item3(300 + 3),
    Recipe_CarrotCake_Item4(300 + 4),
    Recipe_CarrotCake_Item5(300 + 5),
    Recipe_CarrotCake_Item6(300 + 6),
    Recipe_CarrotCake_Item7(300 + 7),

    Recipe_RhubarbTart(400),
    Recipe_RhubarbTart_Item1(400 + 1),
    Recipe_RhubarbTart_Item2(400 + 2),
    Recipe_RhubarbTart_Item3(400 + 3),
    Recipe_RhubarbTart_Item4(400 + 4),
    Recipe_RhubarbTart_Item5(400 + 5),
    Recipe_RhubarbTart_Item6(400 + 6),
    Recipe_RhubarbTart_Item7(400 + 7),
    Recipe_RhubarbTart_Item8(400 + 8),
    Recipe_RhubarbTart_Item9(400 + 9),


    Recipe_MadeiraCake(500),
    Recipe_MadeiraCake_Item1(500 + 1),
    Recipe_MadeiraCake_Item2(500 + 2),
    Recipe_MadeiraCake_Item3(500 + 3),
    Recipe_MadeiraCake_Item4(500 + 4),
    Recipe_MadeiraCake_Item5(500 + 5),
    Recipe_MadeiraCake_Item6(500 + 6),
    Recipe_MadeiraCake_Item7(500 + 7),

    Recipe_Spaghetti_Bolognese(600),
    Recipe_Spaghetti_Bolognese_Item1(600 + 1),
    Recipe_Spaghetti_Bolognese_Item2(600 + 2),
    Recipe_Spaghetti_Bolognese_Item3(600 + 3),
    Recipe_Spaghetti_Bolognese_Item4(600 + 4),
    Recipe_Spaghetti_Bolognese_Item5(600 + 5),
    Recipe_Spaghetti_Bolognese_Item6(600 + 6),
    Recipe_Spaghetti_Bolognese_Item7(600 + 7),
    Recipe_Spaghetti_Bolognese_Item8(600 + 8),
    Recipe_Spaghetti_Bolognese_Item9(600 + 9),
    Recipe_Spaghetti_Bolognese_Item10(600 + 10),
    Recipe_Spaghetti_Bolognese_Item11(600 + 11);



    private final int id;

    PredefinedId(int id) {
        this.id = id;
    }

    public int toInt() {
        return id;
    }


}
