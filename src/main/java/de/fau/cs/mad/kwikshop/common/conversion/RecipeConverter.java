package de.fau.cs.mad.kwikshop.common.conversion;

import javax.inject.Inject;

import de.fau.cs.mad.kwikshop.common.Recipe;
import de.fau.cs.mad.kwikshop.common.RecipeServer;

public class RecipeConverter implements ObjectConverter<Recipe, RecipeServer>{


    @Inject
    public RecipeConverter() {

    }

    public RecipeServer convert(Recipe clientRecipe) {

        RecipeServer serverRecipe = new RecipeServer(
                clientRecipe.getServerId(),
                clientRecipe.getItems());

        serverRecipe.setName(clientRecipe.getName());
        serverRecipe.setScaleFactor(clientRecipe.getScaleFactor());
        serverRecipe.setScaleName(clientRecipe.getScaleName());
        serverRecipe.setLastModifiedDate(clientRecipe.getLastModifiedDate());
        serverRecipe.setPredefinedId(clientRecipe.getPredefinedId());

        return serverRecipe;
    }


}
