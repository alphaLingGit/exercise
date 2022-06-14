package com.exercise.design.pattern.mix.observerMediator;

public class Commoner extends EventCustomer{


    public Commoner() {
        super(ProductEventType.NEW_PRODUCT);
    }

    @Override
    public void exec(ProductEvent event) {
        Product product = event.getSource();
        ProductEventType type = event.getType();
        System.out.println("平民处理事件：" + product.getName() + "创建，事件类型=" + type);
    }
}
