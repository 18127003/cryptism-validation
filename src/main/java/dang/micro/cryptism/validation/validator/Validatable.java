package dang.micro.cryptism.validation.validator;

import dang.micro.cryptism.validation.utils.exceptions.ValidationException;
import dang.micro.cryptism.validation.validator.impl.ValidationProvider;
import dang.micro.cryptism.validation.violation.Violation;

import java.util.Collection;
import java.util.Collections;

public interface Validatable {
    default Collection<Violation> validate(){
        ValidationProvider validationProvider = ValidationProvider.getInstance();
        try{
            var holder = validationProvider.wrapChain(this.getClass());
            return holder.validate(this);
        } catch (ValidationException e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}
