package dang.micro.cryptism.validation.utils;


import dang.micro.cryptism.validation.validator.ChainPrototype;

public class AddChainRequest<T> {
    String field;
    ChainPrototype<T> chain;

    public AddChainRequest(String field, ChainPrototype<T> chain){
        this.field = field;
        this.chain = chain;
    }

    public AddChainRequest(ChainPrototype<T> chain){
        this.chain = chain;
    }

    public String getField() {
        return field;
    }

    public ChainPrototype<T> getChain() {
        return chain;
    }
}
