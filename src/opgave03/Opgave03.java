package opgave03;

import opgave03.models.DropOutStack;

import java.util.NoSuchElementException;

public class Opgave03 {


    public static void main(String[] args) {

        DropOutStack<String> stack = new DropOutStack<>(3);

        try {
            stack.pop();
        } catch (NoSuchElementException e) {
            //ok
        }
        stack.push("Et");
        stack.push("To");
        System.out.println(stack.pop());
        stack.push("Tre");
        System.out.println(stack.peek());
        stack.push("Fire");
        System.out.println(stack.peek());
        System.out.println(stack.size());
        stack.push("Fem");
        System.out.println(stack.peek());
        System.out.println(stack.size());

    }

}
