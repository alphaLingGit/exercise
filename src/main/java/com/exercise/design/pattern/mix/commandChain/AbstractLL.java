package com.exercise.design.pattern.mix.commandChain;

/**
 * 此类的实现返回固定的结果作为示例，若需真正实现，有以下三种思路：<br>
 * 1、通过java.io.File类自己封装类似UNIX的返回格式<br>
 * 2、通过java.lang.Runtime类的exec()方法执行DOS的dir命令，产生类似的ls结果，但是格式与UNIX不同，需要对结果进行处理<br>
 * 3、通过JNI(Java Native Interface)调用Windows的系统API<br>
 */
public abstract class AbstractLL extends CommandName{

    public final static String DEFAULT_PARAM = "";

}
