package com.exercise.design.pattern.mix.observerMediator;

public class Beggar extends EventCustomer{


    public Beggar() {
        super(ProductEventType.DEL_PRODUCT);
    }

    @Override
    public void exec(ProductEvent event) {
        Product product = event.getSource();
        ProductEventType type = event.getType();
        System.out.println("乞丐处理事件：" + product.getName() + "销毁，事件类型=" + type);
    }
}
