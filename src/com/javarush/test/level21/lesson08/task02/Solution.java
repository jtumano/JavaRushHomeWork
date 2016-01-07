package com.javarush.test.level21.lesson08.task02;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", null);
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);

        for (int i = 0; i < tree.branches.length; i++)
        {
            System.out.println(tree.branches[i].hashCode());
        }
        for (int i = 0; i < clone.branches.length; i++)
        {
            System.out.println(clone.branches[i].hashCode());
        }
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        @Override
        protected Tree clone() throws CloneNotSupportedException
        {
            if (this.branches == null) {
                Tree tree = new Tree(new String(getName()),null);
                return tree;
            }
            else
            {
                Tree tree = new Tree(new String(getName()),this.branches.clone());
                return tree;
            }
        }

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }
    }
}
