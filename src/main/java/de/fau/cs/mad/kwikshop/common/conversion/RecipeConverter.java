package de.fau.cs.mad.kwikshop.common.conversion;

import de.fau.cs.mad.kwikshop.common.Recipe;
import de.fau.cs.mad.kwikshop.common.RecipeServer;

public class RecipeConverter implements ObjectConverter<Recipe, RecipeServer>{


    public RecipeServer convert(Recipe clientRecipe) {

        RecipeServer serverRecipe = new RecipeServer(
                clientRecipe.getServerId(),
                clientRecipe.getItems());

        serverRecipe.setName(clientRecipe.getName());
        serverRecipe.setScaleFactor(clientRecipe.getScaleFactor());
        serverRecipe.setScaleName(clientRecipe.getScaleName());
        serverRecipe.setLastModifiedDate(clientRecipe.getLastModifiedDate());

        return serverRecipe;
    }


}
