package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class RecipesActivity extends AppCompatActivity {

    private TextView recipeNameTextView;
    private TextView recipeIngredientsTextView;
    private TextView recipeDescriptionTextView;
    private Button btnOpenMainMenu;
    double getKcalValue = 0.0;
    Recipe firstRecipe =
            new Recipe("Easy Butter Chicken",
                    2200.0,
                    "-2 lb boneless, skinless chicken breast (910 g), cubed\n" +
                            "-salt, to taste\n" +
                            "-pepper, to taste\n" +
                            "-2 teaspoons chili powder, divided\n" +
                            "-½ teaspoon turmeric\n" +
                            "-6 tablespoons butter, divided\n" +
                            "-1 ½ cups yellow onion (225 g), diced\n" +
                            "-3 teaspoons garam masala\n" +
                            "-1 teaspoon cumin\n" +
                            "-1 teaspoon cayenne pepper\n" +
                            "-1 tablespoon ginger, grated\n" +
                            "-3 cloves garlic, minced\n" +
                            "-1 cinnamon, 3 inch (8 cm) stick\n" +
                            "-14 oz tomato sauce (395 g)\n" +
                            "-1 cup water (240 mL)\n" +
                            "-1 cup heavy cream (240 mL)\n" +
                            "-rice, for serving\n" +
                            "-fresh cilantro, chopped for garnish",
                    "In a large bowl, season the chicken breast with salt, pepper, 1 teaspoon of chili powder, and the teaspoon of turmeric. Let sit for 15 minutes to marinate." +
                            "Melt 2 tablespoons of butter in a large pot over medium heat. Brown the chicken, then remove from the pot." +
                            "Melt another 2 tablespoons of butter in the pot, then add the onion, garam masala, remaining teaspoon of chili powder, the cumin, ginger, garlic, cayenne, cinnamon, salt and pepper. Cook until fragrant." +
                            "Add the tomato sauce and bring to a simmer." +
                            "Add the water and cream and return to a simmer." +
                            "Return the chicken to the pot, cover, and simmer for another 10-15 minutes." +
                            "Stir in the last 2 tablespoons of butter and season with more salt and pepper to taste." +
                            "Serve the chicken over rice and garnish with cilantro." +
                            "Enjoy!");

    Recipe secondRecipe =
    new Recipe("Easy beef and broccoli",
            1800.0,
            "-2/3 cup reduced sodium soy sauce\n" +
                    "-1/2 cup chicken stock\n" +
                    "-1/4 cup honey\n" +
                    "-2 tablespoons rice wine vinegar\n" +
                    "-2 tablespoons brown sugar, packed\n" +
                    "-3 cloves garlic, minced\n" +
                    "-1 tablespoon sesame oil\n" +
                    "-1 tablespoon cornstarch\n" +
                    "-1 teaspoon Sriracha, or more, to taste\n" +
                    "-1 teaspoon ground ginger\n" +
                    "-1/4 teaspoon red pepper flakes\n" +
                    "-1 tablespoon olive oil\n" +
                    "-1 pound flank steak, thinly sliced across the grain\n" +
                    "-1 head broccoli, cut into florets",
            "In a medium bowl, whisk together soy sauce, chicken stock, honey, vinegar, brown sugar, garlic, sesame oil, cornstarch, Sriracha, ginger, red pepper flakes and 1/4 cup water; set aside.\n" +
                    "Heat olive oil in a large skillet over medium high heat. Add steak and cook, flipping once, until browned, about 3-4 minutes.\n" +
                    "Stir in broccoli and soy sauce mixture until tender and slightly thickened, about 3-4 minutes.\n" +
                    "Serve immediately.");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        String KcalValueToString = getIntent().getStringExtra("KcalValueToString");
        double KcalValueToDouble = Double.parseDouble(KcalValueToString);
        System.out.println(KcalValueToDouble);
        getKcalValue = KcalValueToDouble;

        recipeNameTextView = (TextView) findViewById(R.id.RecipeName);
        recipeIngredientsTextView = (TextView) findViewById(R.id.RecipeIngredients);
        recipeDescriptionTextView = (TextView) findViewById(R.id.RecipeDescription);
        btnOpenMainMenu = (Button) findViewById(R.id.btnBackToMainMenu);

        btnOpenMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainMenuActivityOnClick();
            }
        });

        printCorrectRecipe();
    }

    private void openMainMenuActivityOnClick(){
        Intent mainMenuActivity = new Intent(this, MainMenuActivity.class);
        startActivity(mainMenuActivity);
    }

    private void printCorrectRecipe() {
        if(getKcalValue >= 2000.0) {
            System.out.println(firstRecipe.toString());
            recipeNameTextView.setText(firstRecipe.name);
            recipeIngredientsTextView.setText(firstRecipe.ingredients);
            recipeDescriptionTextView.setText(firstRecipe.description);
        }
        if(getKcalValue < 2000.0) {
            System.out.println(secondRecipe.toString());
            recipeNameTextView.setText(secondRecipe.name);
            recipeIngredientsTextView.setText(secondRecipe.ingredients);
            recipeDescriptionTextView.setText(secondRecipe.description);
        }
    }
}