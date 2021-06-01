package com.exercise.design.pattern.mix.observerMediator;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

/**
 * 事件观察者
 */
public class EventDispatch implements Observer {

    private static final EventDispatch dispatch = new EventDispatch();

    private final Vector<EventCustomer> customers = new Vector<>();

    private EventDispatch() {}

    public static EventDispatch getEventDispatch() {
        return dispatch;
    }

    public void registerCustomer(EventCustomer customer) {
        customers.add(customer);
    }

    @Override
    public void update(Observable o, Object arg) {
        Product product = (Product) arg;
        ProductEvent event = (ProductEvent) o;
        for (EventCustomer customer : customers) {
            for (ProductEventType type : customer.getCustomType()) {
                if (type.getValue() == event.getType().getValue()) {
                    customer.exec(event);
                }
            }
        }
    }
}
