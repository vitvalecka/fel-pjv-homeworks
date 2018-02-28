package cz.cvut.fel.pjv;

public class BruteForceAttacker extends Thief {
    
    private boolean jackpot = false;
    private int size;
    private char[] characters;
    
    private void generatePassword(char[] output, int possition)
    {
        if (possition == -1)
        {
            jackpot = tryOpen(output);
        }
        else
        {
            for (int i = 0; i < characters.length; i++)
            {
                output[possition] = characters[i];
                generatePassword(output, possition - 1);
                
                if (jackpot)
                {
                    return;
                }
            }
        }
    }
    
    @Override
    public void breakPassword(int sizeOfPassword)
    {        
        size = sizeOfPassword;        
        char[] password = new char[size];
        characters = getCharacters();
        
        if (size == 0)
        {
            tryOpen(password);
        }
        
        generatePassword(password, size - 1);
    }
    
}
