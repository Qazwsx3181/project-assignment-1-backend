package se.jensenyh.javacourse.saltmerch.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SizeContainer
{
    // todo: needs fields: String size, int stock
    @JsonProperty
    public String size;
    @JsonProperty
    public int stock;
    // todo: all fields should be public and annotated with @JsonProperty
    
    // todo: needs 2 constructors:
    //  1. empty constructor

    public SizeContainer() {
    }

    //  2. constructor with size and stock

    public SizeContainer(String size, int stock) {
        this.size = size;
        this.stock = stock;
    }
}
