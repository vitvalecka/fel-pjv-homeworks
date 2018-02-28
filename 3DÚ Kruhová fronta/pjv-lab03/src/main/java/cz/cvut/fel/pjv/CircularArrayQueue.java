package cz.cvut.fel.pjv;

/**
 * Implementation of the {@link Queue} backed by fixed size array.
 */
public class CircularArrayQueue implements Queue
{
    public static final int DEFAULT_SIZE = 5;
    public static final int INITIAL_POSITION_START = 0;
    public static final int INITIAL_POSITION_END = -1;
    
    private String[] caqArray;
    private int start;
    private int end;
    private int capacity;
            
    /**
     * Creates the queue with capacity set to the value of 5.
     */
    public CircularArrayQueue()
    {
        caqArray = new String[DEFAULT_SIZE];
        start = INITIAL_POSITION_START;
        end = INITIAL_POSITION_END;
        capacity = DEFAULT_SIZE;
    }

    /**
     * Creates the queue with given {@code capacity}. The capacity represents maximal number of elements that the
     * queue is able to store.
     * @param capacity of the queue
     */
    public CircularArrayQueue(int capacity)
    {
        caqArray = new String[capacity];
        start = INITIAL_POSITION_START;
        end = INITIAL_POSITION_END;
        this.capacity = capacity;
    }

    @Override
    public int size()
    {
        if (end == -1)
        {
            return 0;
        }
        else if (start <= end)
        {
            return end - start + 1;
        }
        else
        {
            return capacity - start + end + 1;
        }
    }

    @Override
    public boolean isEmpty()
    {
        return end == -1;
    }

    @Override
    public boolean isFull()
    {
        return size() == capacity;
    }

    @Override
    public boolean enqueue(String obj)
    {
        if ((obj == null) || (isFull()))
        {
            return false;
        }
        else
        {
            if (isEmpty())
            {
                end = start;
            }
            else if (end == (capacity - 1))
            {
                end = 0;
            }
            else
            {
                end++;
            }
            
            caqArray[end] = obj;
            return true;
        }
    }

    @Override
    public String dequeue()
    {
        String foo;
        
        if (isEmpty())
        {
            foo = null;
        }
        else if ((size() == 1) && (start != (capacity - 1)))
        {
            foo = caqArray[start];
            start++;
            end = -1;
        }
        else if ((size() == 1) && (start == (capacity - 1)))
        {
            foo = caqArray[start];
            start = 0;
            end = -1;
        }
        else if (start == (capacity - 1))
        {
            foo = caqArray[start];
            start = 0;
        }
        else
        {
            foo = caqArray[start];
            start++;
        }
        
        return foo;
    }

    @Override
    public void printAllElements()
    {
        if (isEmpty())
        {
            return;
        }
        
        int i = start;
        
        while (true)
        {
            System.out.println(caqArray[i]);
            
            if (i == end)
            {
                return;
            }
            else if (i == (capacity - 1))
            {
                i = 0;
            }
            else
            {
                i++;
            }
        }
    }
}
