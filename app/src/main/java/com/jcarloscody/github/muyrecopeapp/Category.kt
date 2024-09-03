package com.jcarloscody.github.muyrecopeapp

data class Category (val idCategory: String,
                     val strCategoryThumb: String,
                     val strCategory: String,
                     val strCategoryDescription: String,
    )


data class CategoriesResponse(
    val categories: List<Category>
)