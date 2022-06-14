package github.rebelhero.loadbalance.impl;

import github.rebelhero.loadbalance.AbstractLoadBalance;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 轮询
 * @author rebelhero
 * @date 2020/12/3
 */
public class RoundLoadBalance extends AbstractLoadBalance {

    private final AtomicInteger num;

    RoundLoadBalance() {
        num = new AtomicInteger(0);
    }

    @Override
    protected String doChoose(List<String> childrenNodes) {
        return childrenNodes.get(num.getAndIncrement() % childrenNodes.size());
    }
}
