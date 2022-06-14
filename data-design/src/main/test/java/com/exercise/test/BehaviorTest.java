package com.exercise.test;

import com.exercise.design.pattern.behavior.memento.Caretaker;
import com.exercise.design.pattern.behavior.memento.Originator;
import com.exercise.design.pattern.behavior.observer.ConcreteObserver;
import com.exercise.design.pattern.behavior.observer.ConcreteSubject;
import com.exercise.design.pattern.behavior.observer.Observer;
import com.exercise.design.pattern.behavior.state.Context;
import com.exercise.design.pattern.behavior.visitor.ConcreteVisitor;
import com.exercise.design.pattern.behavior.visitor.ObjectStructure;
import com.exercise.design.pattern.mix.commandChain.Invoker;
import com.exercise.design.pattern.mix.factoryStrategy.Card;
import com.exercise.design.pattern.mix.factoryStrategy.DeductionFacade;
import com.exercise.design.pattern.mix.factoryStrategy.Trade;
import com.exercise.design.pattern.mix.observerMediator.*;
import com.exercise.design.pattern.mix.strategyComposite.User;
import com.exercise.design.pattern.mix.strategyComposite.UserByAgeThan;
import com.exercise.design.pattern.mix.strategyComposite.UserByNameLike;
import com.exercise.design.pattern.mix.strategyComposite.UserProvider;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BehaviorTest {

    @Test
    public void ObserverTest() {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();
        subject.attach(observer);
        subject.change();
    }

    @Test
    public void MementoTest() {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());
        originator.restoreMemento(caretaker.getMemento());
    }

    @Test
    public void visitorTest() {
        ObjectStructure structure = new ObjectStructure();
        structure.createElements();
        ConcreteVisitor visitor = new ConcreteVisitor();
        structure.action(visitor);
    }

    @Test
    public void stateTest() {
        Context context = new Context();
        context.handle1();
        context.handle2();
    }

    @Test
    public void commandChainTest() throws IOException {
        Invoker invoker = new Invoker();
        while (true) {
            System.out.print("# ");
            String input = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            if(input.equals("quit") || input.equals("exit")) {
                return;
            }
            System.out.println(invoker.exec(input));
        }
    }

    @Test
    public void factoryStrategyTest() throws IOException {
        Card card = new Card("100010", 300.0, 500.0);
        System.out.println("===========IC卡初始信息==============");
        card.showCard();
        String choice = "N";
        while (!choice.equalsIgnoreCase("y")) {
            Trade trade = new Trade();
            System.out.print("请输入交易编号：");
            trade.setTradeNo((new BufferedReader(new InputStreamReader(System.in))).readLine());
            System.out.print("请输入交易金额：");
            trade.setAmount(Double.parseDouble((new BufferedReader(new InputStreamReader(System.in))).readLine()));
            DeductionFacade.deduct(card, trade);
            card.showCard();
            System.out.print("是否退出系统?(Y/N)");
            choice = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        }
    }

    @Test
    public void observerMediator() throws CloneNotSupportedException {
        EventDispatch dispatch = EventDispatch.getEventDispatch();
        dispatch.registerCustomer(new Beggar());
        dispatch.registerCustomer(new Commoner());
        dispatch.registerCustomer(new Nobleman());
        ProductManager manager = new ProductManager();
        Product product = manager.createProduct("IBM笔记本电脑");
        manager.editProduct(product, "Dell笔记本电脑");
        manager.cloneProduct(product);
        manager.abandonProduct(product);
        // FIXME: 2021/6/1 未获取到预期结果。。。
    }

    @Test
    public void strategyCompositeTest() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("张三", 23));
        userList.add(new User("李四", 61));
        userList.add(new User("王五", 65));
        userList.add(new User("张丽", 35));
        userList.add(new User("李鹏", 72));
        userList.add(new User("王艳", 18));
        userList.add(new User("王小二", 14));
        userList.add(new User("李张", 32));
        UserProvider provider = new UserProvider(userList);
        System.out.println("姓张");
        for (User user : provider.findUser(new UserByNameLike("张%"))) {
            System.out.println(user);
        }
        System.out.println("年龄大于60");
        for (User user : provider.findUser(new UserByAgeThan(60))) {
            System.out.println(user);
        }
        System.out.println("年龄大于30的张姓");
        for (User user : provider.findUser(new UserByNameLike("%张%").and(new UserByAgeThan(30)))) {
            System.out.println(user);
        }
        System.out.println("年龄小于20");
        for (User user : provider.findUser(new UserByAgeThan(20).not())) {
            System.out.println(user);
        }
    }
}
