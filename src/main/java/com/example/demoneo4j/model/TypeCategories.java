package com.example.demoneo4j.model;

public enum TypeCategories {

    ART("Art"),
    MUSIC("Music"),
    PHOTOGRAPHY("Photography"),
    BIOGRAPHIES("Biographies"),
    MEMOIRS("Memoirs"),
    BUSINESS("Business"),
    INVESTIONH("Investionh"),
    CHILDRENS("Childrens"),
    COOKBOOKS("Cookbooks"),
    FOOD("Food"),
    WINE("Wine"),
    CRAFTS("Crafts"),
    HOBBIES("Hobbies"),
    EDUCATION("Education"),
    REFERENCE("Refference"),
    HEALTH("Health"),
    FITNESS("Fitness"),
    DIETING("Dieting"),
    HISTORY("History"),
    HOME("Home"),
    GARDEN("Garden"),
    HORROR("Horror"),
    HUMOR("Humor"),
    ENTERTAIMENT("Entertaiment"),
    LITERATURE("Literature"),
    FICTION("Fiction"),
    MEDICAL("Medical"),
    THRILLER("Thriller"),
    PARENTING("Parenting"),
    POLITICS("Polities"),
    ROMANCE("Romance"),
    SCIENCE("Science"),
    MATH("Math"),
    SCIFI("Sci-Fi"),
    FANTASY("Fantasy"),
    SPORTS("Sports"),
    TEEN("Teen"),
    TRAVEL("Travel"),
    CRIME("Crime"),
    WESTERN("Western");

    private String value;

    TypeCategories(final String value) {
        this.value = value;
    }

}
