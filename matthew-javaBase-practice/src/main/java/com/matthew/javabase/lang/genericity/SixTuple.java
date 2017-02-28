package com.matthew.javabase.lang.genericity;

import java.util.Random;

/**
 * 原则，返回对象组
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-07-25 11:52
 */
public class SixTuple<A,B,C,D,E,F> extends TwoTuple<A,B>{
    public final C paramC;
    public final D paramD;
    public final E paramE;
    public final F paramF;

    public SixTuple(A paramA,B paramB,C paramC, D paramD, E paramE, F paramF) {
        super(paramA,paramB);
        this.paramC = paramC;
        this.paramD = paramD;
        this.paramE = paramE;
        this.paramF = paramF;
    }


    public static void main(String[] args) {
        SixTuple<Integer,Integer,Integer,String,String,String> sixTuple =new  SixTuple<Integer,Integer,Integer,String,String,String>(1,2,3,"4","5","6");
        System.out.println(sixTuple);
        Random random = new Random(47);
        System.out.println(random.nextInt(14));
    }

    @Override
    public String toString() {
        return "SixTuple{" +
                "paramA=" + super.first +
                ",paramB=" + super.second +
                ",paramC=" + paramC +
                ", paramD=" + paramD +
                ", paramE=" + paramE +
                ", paramF=" + paramF +
                '}';
    }
}
