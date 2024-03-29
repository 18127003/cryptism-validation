package dang.micro.cryptism.validation.validator.impl;


import dang.micro.cryptism.validation.utils.ValidateObject;
import dang.micro.cryptism.validation.utils.exceptions.ValidationException;
import dang.micro.cryptism.validation.validator.ChainPrototype;
import dang.micro.cryptism.validation.validator.Validator;
import dang.micro.cryptism.validation.violation.ViolationContext;

public class ValidatorChain<T> implements ChainPrototype<T> {
    private Validator<T> head;
    private Validator<T> tail;

    @Override
    public void processValidation(ValidateObject<T> value, ViolationContext context) throws ValidationException {
        if (head == null) return;
        head.processValidation(value, context);
    }

    @Override
    public void validateAndThrow(T value) {

    }

    public ValidatorChain(){}

    public ValidatorChain(ValidatorChain<T> source){
        if(source.head!=null) {
            head = source.head.cloneValidator();
            var newChainTemp = head;
            var temp = source.head.getNext();
            while (temp != source.tail && temp != null) {
                var validator = temp.cloneValidator();
                newChainTemp = newChainTemp.setNext(validator);
                temp = temp.getNext();
            }
            if(source.tail != source.head){
                tail = newChainTemp.setNext(source.tail.cloneValidator());
            } else {
                tail = head;
            }
        }
    }

//    @Override
    public Validator<T> find(Class<Validator<T>> target) {
        var temp = head;
        while (temp != null){
            if(temp.getClass().equals(target)){
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    // add from top
    @Override
    public ValidatorChain<T> insert(Validator<T> add){
        if (head != null) {
            add.setNext(head);
        } else {
            tail = add;
        }
        head = add;
        return this;
    }

    // add from bottom
    @Override
    public ValidatorChain<T> appendValidator(Validator<T> validator){
        if (tail != null){
            tail.setNext(validator);
        } else {
            head = validator;
        }
        tail = validator;
        return this;
    }

    @Override
    public boolean isNotEmpty() {
        return head != null || tail != null;
    }

    @Override
    public ChainPrototype<T> cloneChain() {
        return new ValidatorChain<T>(this);
    }
}
