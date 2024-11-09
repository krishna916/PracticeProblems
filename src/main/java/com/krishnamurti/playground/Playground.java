package com.krishnamurti.playground;

public class Playground {


    public static void main(String[] args) {

        Parent p1 = new Parent();
        Parent p2 = new Child();

        p1.display();
        p2.display();

        p1.staticDisplay();
        p2.staticDisplay();

    }
}




class Parent {

    protected void display() {
        System.out.println("parent display");
    }

    public static void staticDisplay() {
        System.out.println("parent static display");
    }

}


class Child extends Parent {

    protected void display() {
        System.out.println("child display");
    }

    public static void staticDisplay() {
        System.out.println("child static display");
    }

}