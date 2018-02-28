package cz.cvut.fel.pjv;

public class Main
{
    public static void main(String[] args)
    {
        TreeImpl tree = new TreeImpl();
        
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        tree.setTree(array);
        System.out.println(tree);
    }
}
