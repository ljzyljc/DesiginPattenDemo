package com.finance.desiginpattendemo.factory;

import com.finance.desiginpattendemo.factory.abstrat.FactoryBMW530;
import com.finance.desiginpattendemo.factory.abstrat.FactoryBMW750;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Jackie on 2018/6/21.
 */
public class TestFactory {

    public static void main(String[] args) {
        //---------工厂方法-----------------
//        FactoryBMW bmw530 = new FactoryBMW530();
//        bmw530.createBMW();
//
//        FactoryBMW bmw750 = new FactoryBMW750();
//        bmw750.createBMW();

        //--------抽象工厂------------------

//        FactoryBMW530 factoryBMW530 = new FactoryBMW530();
//        factoryBMW530.createEngine();
//        factoryBMW530.createCondition();
//
//        FactoryBMW750 factoryBMW750 = new FactoryBMW750();
//        factoryBMW750.createCondition();
//        factoryBMW750.createEngine();

//        Integer integer1 = 127;
//        Integer integer2 = 127;
//        System.out.println(integer1 == integer2); //true
//
//        Integer integer3 = 128;
//        Integer integer4 = 128;
//        System.out.println(integer3 == integer4);  //false
        LinkedList<Integer> linkedList = new LinkedList();
        for (int i= 0;i<10;i++){
            linkedList.add(i);
        }
        for (int i= 0;i<10;i++){
            System.out.println("----jackie---1---"+linkedList.get(i));
        }
        printListReverse2(linkedList);
    }

    public static void printListReverse2(LinkedList<Integer> list){
        Stack<Integer> stack = new Stack<>();
        while (list!=null && list.size()> 0){
            stack.push(list.getFirst());
            list.removeFirst();
        }
        while (!stack.isEmpty()){
            System.out.println("----jackie---2---"+stack.pop());
        }

    }


}
