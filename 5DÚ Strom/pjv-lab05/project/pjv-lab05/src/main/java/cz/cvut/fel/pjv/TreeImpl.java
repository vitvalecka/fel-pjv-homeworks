package cz.cvut.fel.pjv;

public class TreeImpl implements Tree
{
    private NodeImpl root;
    
    
    private NodeImpl indexToNode(int[] values, int index)
    {
        NodeImpl newNode = new NodeImpl(values[index]);
        return newNode;
    }
    
    private int findCenter(int[] values)
    {
        int numberOfElements = values.length;
        int center = numberOfElements / 2;
        return center;
    }
    
    private int findCenter(int[] values, int start, int end)
    {
        if (start == end)
        {
            return start;
        }
        
        int numberOfElements = end - start + 1;
        int relativeCenter = numberOfElements / 2;
        
        int center = relativeCenter + start;
        
        if (center < values.length)
        {
            return center;
        }
        else
        {
            return -1;
        }
    }
    
    private void createSubTree(NodeImpl head, int[] values, int start, int end, boolean left)
    {
        int center = findCenter(values, start, end);
        
        if (center == -1)
        {
            return;
        }
        
        if (left)
        {
            head.left = indexToNode(values, center);
            head = head.left;
        }
        else
        {
            head.right = indexToNode(values, center);
            head = head.right;
        }
        
        if (start != end)
        {
            if ((center - 1) >= start)
            {
                createSubTree(head, values, start, center - 1, true);
            }
            if ((center + 1) <= end)
            {
                createSubTree(head, values, center + 1, end, false);
            }
        }
    }
    
    @Override
    public void setTree(int[] values)
    {
        if (values == null)
        {
            return;
        }
        
        int numberOfValues = values.length;
        
        if (numberOfValues == 0)
        {
            return;
        }
        
        if (numberOfValues == 1)
        {
            root = indexToNode(values, 0);
            return;
        }
        else if (numberOfValues == 2)
        {
            root = indexToNode(values, 0);
            root.left = indexToNode(values, 1);
        }
        
        int center = findCenter(values);
        root = indexToNode(values, center);
        
        createSubTree(root, values, 0, center - 1, true);
        createSubTree(root, values, center + 1, numberOfValues - 1, false);
    }

    @Override
    public Node getRoot()
    {
        return root;
    }
    
    private String nodeToString(int level, NodeImpl node)
    {
        int i = 0;
        String margin = "";
        while (i < level)
        {
            margin = margin + " ";
            i++;
        }
        return margin + "- " + node.getValue() + "\n";
    }
    
    private String subTreeToString(int level, NodeImpl node)
    {
        String foo = nodeToString(level, node);
        
        if (node.left != null)
        {
            foo = foo + subTreeToString(level + 1, node.left);
        }
        
        if (node.right != null)
        {
            foo = foo + subTreeToString(level + 1, node.right);
        }
        
        return foo;
    }
    
    @Override
    public String toString()
    {
        if (root == null)
        {
            return "";
        }
        
        return subTreeToString(0, root);
    }
}
