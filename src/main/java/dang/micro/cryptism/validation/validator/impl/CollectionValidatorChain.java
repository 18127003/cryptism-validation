package dang.micro.cryptism.validation.validator.impl;


import dang.micro.cryptism.validation.utils.AddChainRequest;
import dang.micro.cryptism.validation.utils.ValidateObject;
import dang.micro.cryptism.validation.validator.ChainPrototype;
import dang.micro.cryptism.validation.violation.ViolationContext;

import java.util.Collection;
import java.util.LinkedList;

public class CollectionValidatorChain<T> implements ChainPrototype<T> {
    Collection<ChainPrototype> chains;

    public CollectionValidatorChain(){chains = new LinkedList<>();}

    private void implicitAddChain(ChainPrototype chain){
        chains.add(chain);
    }

    @Override
    public ChainPrototype<T> cloneChain() {
        CollectionValidatorChain<T> clone = new CollectionValidatorChain<>();
        chains.forEach(chain->clone.implicitAddChain(chain.cloneChain()));
        return clone;
    }

    @Override
    public void processValidation(ValidateObject<T> value, ViolationContext context) {
        chains.forEach(chain->chain.processValidation(value, context));
    }

    @Override
    public void validateAndThrow(T value) {

    }

    @Override
    public ChainPrototype<T> addChain(AddChainRequest<T> chainRequest) {
        chains.add(chainRequest.getChain());
        return this;
    }

    @Override
    public boolean isNotEmpty() {
        return !chains.isEmpty();
    }
}
