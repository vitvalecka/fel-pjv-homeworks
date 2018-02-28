package cz.cvut.fel.pjv;

public class NodeImpl implements Node
{
    private int value;
    protected NodeImpl left = null;
    protected NodeImpl right = null;
    public NodeImpl(int value)
    {
        this.value = value;
    }
    
    @Override
    public Node getLeft()
    {
        return left;
    }

    @Override
    public Node getRight()
    {
        return right;
    }

    @Override
    public int getValue()
    {
        return value;
    }
}
