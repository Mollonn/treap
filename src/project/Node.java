package project;

import java.util.Random;


public class Node
{



        Node left, right;
        int priority, element;

        //конструкторы
        public Node()
        {
            this.element = 0;
            this.left = this;
            this.right = this;
            this.priority = Integer.MAX_VALUE;
        }

        public Node(int ele)
        {
            this(ele, null, null);
        }

        public Node(int ele, Node left, Node right)
        {
            this.element = ele;
            this.left = left;
            this.right = right;
            this.priority = new Random().nextInt( );
        }
}
