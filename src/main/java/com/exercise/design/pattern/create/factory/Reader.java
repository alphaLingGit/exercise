package com.exercise.design.pattern.create.factory;

public interface Reader {

    void read();

    default void test() {
        new GifReaderFactory().getReader().read();
        new JpgReaderFactory().getReader().read();
        new PngReaderFactory().getReader().read();
    }

}
