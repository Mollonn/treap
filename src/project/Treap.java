package project;

public class Treap
{


        private Node root;
        private Node nil = new Node();

        //конструктор
        public  Treap()
        {
            root = nil;
        }

        //функция для проверки дерева на пустоту
        public boolean isEmpty()
        {
            return root == nil;
        }

        //удаление
        public void makeEmpty()
        {
            root = nil;
        }

        //функция для вставки информации
        public void insert(int ex)
        {
            root = insert(ex, root);
        }
        private Node insert(int X, Node parameter)
        {
            if (parameter == nil)
                return new Node(X, nil, nil);
            else if (X < parameter.element)
            {
                parameter.left = insert(X, parameter.left);
                if (parameter.left.priority < parameter.priority)
                {
                    Node L = parameter.left;
                    parameter.left = L.right;
                    L.right = parameter;
                    return L;
                }
            }
            else if (X > parameter.element)
            {
                parameter.right = insert(X, parameter.right);
                if (parameter.right.priority < parameter.priority)
                {
                    Node R = parameter.right;
                    parameter.right = R.left;
                    R.left = parameter;
                    return R;
                }
            }
            return parameter;
        }

        // функция для подсчета количества узлов
        public int countNodes()
        {
            return countNodes(root);
        }
        private int countNodes(Node parameter)
        {
            if (parameter == nil)
                return 0;
            else
            {
                int l = 1;
                l += countNodes(parameter.left);
                l += countNodes(parameter.right);
                return l;
            }
        }

        //функция для поиска элемента
        public boolean search(int val)
        {
            return search(root, val);
        }
        private boolean search(Node parameter, int val)
        {
            boolean found = false;
            while ((parameter != nil) && !found)
            {
                int rval = parameter.element;
                if (val < rval)
                    parameter = parameter.left;
                else if (val > rval)
                    parameter = parameter.right;
                else
                {
                    found = true;
                    break;
                }
                found = search(parameter, val);
            }
            return found;
        }


        //функция для обратного обхода
        public void postorder()
        {
            postorder(root);
        }
        private void postorder(Node r)
        {
            if (r != nil)
            {
                postorder(r.left);
                postorder(r.right);
                System.out.print(r.element +" ");
            }
        }




    //функция для симетричного обхода
        public void inorder()
        {
            inorder(root);
        }
        public void inorder(Node parameter)
        {
            if (parameter != nil)
            {
                inorder(parameter.left);
                System.out.print(parameter.element +" ");
                inorder(parameter.right);
            }
        }

        //функция для прямого обхода
        public void preorder()
        {
            preorder(root);
        }
        private void preorder(Node r)
        {
            if (r != nil)
            {
                System.out.print(r.element +" ");
                preorder(r.left);
                preorder(r.right);
            }
        }


}
