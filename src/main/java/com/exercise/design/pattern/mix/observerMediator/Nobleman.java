package com.exercise.design.pattern.mix.observerMediator;

public class Nobleman extends EventCustomer{


    public Nobleman() {
        super(ProductEventType.EDIT_PRODUCT);
        super.addEventType(ProductEventType.CLONE_PRODUCT);
    }

    @Override
    public void exec(ProductEvent event) {
        Product product = event.getSource();
        ProductEventType type = event.getType();
        if (type.getValue() == ProductEventType.CLONE_PRODUCT.getValue()) {
            System.out.println("贵族处理事件：" + product.getName() + "克隆，事件类型=" + type);
        } else {
            System.out.println("贵族处理事件：" + product.getName() + "修改，事件类型=" + type);
        }
    }
}
