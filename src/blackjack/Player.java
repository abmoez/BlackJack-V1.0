/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author mahmo
 */
public class Player {
    //String name;
    private long bank_value;
    private Cards_Deck card;
    public hand[] hands;
    private byte number_of_hands;
    public class hand{
        private long bet;
        private byte[] cards;
        private byte number_of_cards;
        hand()
        {
            cards = new byte[11];
            cards[0] = card.Next_card();
            cards[1] = card.Next_card();
            bet = 0;
            number_of_cards = 2;
        }
        hand(long bet, byte card_splitted)
        {
            cards = new byte[11];
            cards[0] = card_splitted;
            this.bet = bet;
            number_of_cards = 1;
        }
        public void Hit()
        {
            cards[number_of_cards++] = card.Next_card();
        }
        public void Insurance()
        {
            bank_value -= bet/2;
        }
        public void set_Bet(long number)
        {
            bet = number;
        }
        public void Insurance_won()
        {
            bank_value += (bet)+(bet/2);
        }
        public void BlackJack()
        {
            bank_value += bet*2 + (bet/2);
        }
        public void Bet_Won()
        {
            bank_value += bet*2;
        }
        public void double_bet()
        {
            bank_value -=bet;
            bet *=2;
        }
        public void push()
        {
            bank_value += bet;
        }
        public void split()
        {
            bank_value -= bet;
            hands[number_of_hands++] = new hand(bet, cards[1]);
            number_of_cards--;
        }
        public byte[] get_cards()
        {
            return cards;
        }
        public byte get_last_hit()
        {
            return cards[number_of_cards-1];
        }
        public long get_Bet()
        {
            return bet;
        }
        public byte get_number_of_cards()
        {
            return number_of_cards;
        }
        public int get_cards_value()
        {
            byte ones = 0;
            int value = 0;
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
            return value;
        }   
    }
    Player(Cards_Deck card)
    {
        this.card = card;
        bank_value = 1000;
        hands = new hand[4];
        number_of_hands = 1;
    }
    Player(Cards_Deck card, long bank_value)
    {
        this.card = card;
        this.bank_value = bank_value;
        hands = new hand[4];
        number_of_hands = 1;
    }
    public void increament_bank(long value)
    {
        bank_value += value;
    }
    public void decreament_bank(long value)
    {
        bank_value -= value;
    }
    public long get_bank_value()
    {
        return bank_value;
    }
    
}
