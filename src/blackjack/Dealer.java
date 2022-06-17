/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author mahmo
 */
public class Dealer {
    private byte[] cards;
    private byte number_of_cards;
    private Cards_Deck card;
    private boolean second_card_flipped;

    Dealer(Cards_Deck card) {
        cards = new byte[11];
        cards[0] = card.Next_card();
        cards[1] = card.Next_card();
        second_card_flipped = true;
        number_of_cards = 2;
        this.card = card;
    }
    public void Hit()
    {
        cards[number_of_cards++] = card.Next_card();
    }
    public int get_cards_value()
        {
            int value = 0;
            if(second_card_flipped)
            {
                value = ((cards[0]/4)+1);
                if(value > 10)
                {
                    value = 10;
                }
                if(value == 1)
                {
                    value = 11;
                }
            }
            else
            {
                byte ones = 0;
                byte temp;
                for(byte counter = 0;counter < number_of_cards;counter++)
                {
                    temp = (byte)((cards[counter]/4)+1);
                    if(temp > 10)
                    {
                        temp = 10;
                    }
                    if(temp == 1)
                    {
                        ones++;
                    }
                    else
                    {
                        value += temp;
                    }
                }
                value += ones;
                if(ones > 0 && value <= 11)
                {
                    value += 10;
                } 
            }
            return value;
        }
    public byte[] get_cards()
    {
        return cards;
    }
    public byte get_last_hit()
    {
        return cards[number_of_cards-1];
    }
    public byte get_number_of_cards()
    {
        return number_of_cards;
    }
    public void second_card_not_flipped()
    {
        second_card_flipped = false;
    }
    public boolean check_blackjack()
    {
        int value = 0;
        byte ones = 0;
        byte temp;
        for(byte counter = 0;counter < number_of_cards;counter++)
        {
            temp = (byte)((cards[counter]/4)+1);
            if(temp > 10)
            {
                temp = 10;
            }
            if(temp == 1)
            {
                ones++;
            }
            else
            {
                value += temp;
            }
        }
        value += ones;
        if(ones > 0 && value <= 11)
        {
            value += 10;
        }
        if(value == 21)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
