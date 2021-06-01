package com.exercise.design.pattern.mix.observerMediator;

/**
 * 产品管理类（工厂类）
 */
public class ProductManager {

    private boolean isPermittedCrete;

    public Product createProduct(String name) {
        isPermittedCrete = true;
        Product product = new Product(this, name);
        new ProductEvent(product, ProductEventType.NEW_PRODUCT);
        return product;
    }

    public void abandonProduct(Product product) {
        new ProductEvent(product, ProductEventType.DEL_PRODUCT);
        product = null;
    }

    public void editProduct(Product product, String name) {
        product.setName(name);
        new ProductEvent(product, ProductEventType.EDIT_PRODUCT);
    }

    public Product cloneProduct(Product product) throws CloneNotSupportedException {
        new ProductEvent(product, ProductEventType.CLONE_PRODUCT);
        return product.clone();
    }

    public boolean isCreateProduct() {
        return isPermittedCrete;
    }

}
