package com.training.shoppingCart.exception;




import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {


    String resourceName;
    String fieldName;
    long fieldValue;

    public ResourceNotFoundException(String resourcename, String fieldname, long fieldvalue)
    {

        super(String.format("%s not found with %s: %s" , resourcename , fieldname , fieldvalue ));
        this.resourceName = resourcename;
        this.fieldName = fieldname;
        this.fieldValue= fieldvalue;

    }





}
