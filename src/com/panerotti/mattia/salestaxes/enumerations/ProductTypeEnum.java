package com.panerotti.mattia.salestaxes.enumerations;

public enum ProductTypeEnum {
	
	MEDICAL("Medical Product"),
    FOOD("Food Product"),
    BOOK("Book Product"),
	GOODS("Generic Product");

    private String description;

    ProductTypeEnum(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
}
