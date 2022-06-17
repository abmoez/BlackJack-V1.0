/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;
import java.util.Random;

/**
 *
 * @author mahmo
 */
public class Cards_Deck {
    private byte[] Deck = null;
    private int iterator;
    private int shuffle;
    private int size;
    Cards_Deck()
    {
        Generate_Deck((byte)1);
    }
    Cards_Deck(byte number_of_Decks)
    {
        Generate_Deck(number_of_Decks);
    }
    private void Generate_Deck(byte number_of_Decks)
    {
        Random Rand = new Random(System.currentTimeMillis());
        shuffle = (Rand.nextInt()%16)+60;
        Deck = new byte[52*number_of_Decks];
        size = number_of_Decks*52;
        int counter;
        byte temp;
        boolean flag;
        int reached = 0;
        for(int count = 1 ;count <= number_of_Decks ;count++)
        {
            while(reached < 52*count)
            {
                temp = (byte)Rand.nextInt(52);
                flag = true;
                for(counter = size-(number_of_Decks+1-count)*52; counter < reached; counter++)
                {
                    if(Deck[counter] == temp)
                    {
                        flag =false;
                    }
                }
                if(flag)
                {
                    Deck[reached++] = temp;
                }
            }
            Rand.setSeed(System.currentTimeMillis());
        }
        iterator = size - 1;
    }
    public byte Next_card()
    {
        if(iterator >= 0)
        {
            return Deck[iterator--];
        }
        else
        {
            return -1;
        }
    }
    public int Remaining_cards()
    {
        return iterator + 1;
    }
    public void Shuffle_Deck()
    {
        byte[] newarr = new byte[size];
        int temp;
        Random rand = new Random(System.currentTimeMillis());
        for(int counter = 0;counter < size;)
        {
            temp = rand.nextInt(size);
            if(Deck[temp] != -1)
            {
                newarr[counter++] = Deck[temp];
                Deck[temp] = -1;
            }
        }
        Deck = newarr;
        iterator = size - 1;
    }
    public boolean check_shuffle()
    {
        return (shuffle >= iterator);
    }
}
