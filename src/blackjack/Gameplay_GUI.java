/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package blackjack;

import static blackjack.BET_SCREEN_GUI.gameplay;
import static blackjack.FIRST_SCREEN_GUI.Deck;
import static blackjack.FIRST_SCREEN_GUI.Sound;
import static blackjack.FIRST_SCREEN_GUI.Sound_stat;
import static blackjack.FIRST_SCREEN_GUI.data;
import static blackjack.FIRST_SCREEN_GUI.player1;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * @author mahmo
 */
public class Gameplay_GUI extends javax.swing.JFrame {

    /**
     * Creates new form Gameplay_GUI
     */
    private void dealer_turn()
    {
        new Thread(){
            @Override
            public void run() {
                try {
                        Thread.sleep(1500);
                    } 
                catch (InterruptedException ex) {}
                dealer.second_card_not_flipped();
                dealer_cards[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck/"+Byte.toString(dealer_card_value[1])+".png")));
                dealer_card.add(dealer_cards[1], 0);
                dealer_label.setText("Dealer: "+Integer.toString(dealer.get_cards_value()));
                validate();
                repaint();
                if(player1.hands[active_hand].get_cards_value() <= 21 || number_of_splitted != 0)
                {
                    byte counter = 2;
                    while(dealer.get_cards_value() < 17)
                    {
                       try {
                          Thread.sleep(1500);
                       } 
                       catch (InterruptedException ex) {}
                       Sound.cardss();
                       dealer.Hit();
                       dealer_card_value[counter] = dealer.get_last_hit();
                       dealer_cards[counter] = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck/"+Byte.toString(dealer_card_value[counter])+".png")));
                       dealer_card.add(dealer_cards[counter], 0);
                       dealer_label.setText("Dealer: "+Integer.toString(dealer.get_cards_value()));
                       validate();
                       repaint();
                    }   
                }
                Check_result();
            }
        }.start();
    }
    private void Check_result()
    {
        boolean play, deal, blackjack = false;
        while(active_hand >= 0)
        {
            player_card.removeAll();
            player_card_value = player1.hands[active_hand].get_cards();
            for(byte counter = 0; counter < player1.hands[active_hand].get_number_of_cards();counter++)
            {
                player_cards[counter] = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck/"+Byte.toString(player_card_value[counter])+".png")));
                player_card.add(player_cards[counter]);
            }
            card_value.setText(Integer.toString(Deck.Remaining_cards()));
            bank_label.setText("Bank: "+Long.toString(player1.get_bank_value()));
            player_label.setText("Player: "+Integer.toString(player1.hands[active_hand].get_cards_value()));
            dealer_label.setText("Dealer: "+Integer.toString(dealer.get_cards_value()));
            bet_label.setText("$"+Long.toString(player1.hands[active_hand].get_Bet()));
            validate();
            repaint();
            try {
            Thread.sleep(1500);
            } 
            catch (InterruptedException ex) {}
            if(player1.hands[active_hand].get_cards_value() == dealer.get_cards_value())
            {
                push = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/PUSH.gif")));
                both_stat.add(push);
                Sound.push();
                player1.hands[active_hand].push();
            }
            else
            {
                if(player1.hands[active_hand].get_cards_value() <= 21)
                {
                    play = true;
                }
                else
                {
                    play = false;
                }
                if(dealer.get_cards_value() == 21 && dealer.get_number_of_cards() == 2)
                {
                    blackjack = true;
                    deal = true;
                }
                else if(dealer.get_cards_value() <= 21)
                {
                    deal = true;
                }
                else
                {
                    deal = false;
                }
                if(play && deal)
                {
                    if(blackjack)
                    {
                        dealer_ = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/BLACK_JACK.gif")));
                        dealer_stat.add(dealer_);
                        sound.lose();
                    }
                    else
                    {
                        if(player1.hands[active_hand].get_cards_value() > dealer.get_cards_value())
                        {
                            deal = false;
                        }
                        else
                        {
                            play = false;
                        }
                        if(play)
                        {
                            player_ = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/YOU_WIN.gif")));
                            player_stat.add(player_);
                            player1.hands[active_hand].Bet_Won();
                            Sound.win();
                        }
                        else
                        {
                            dealer_ = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/DEALER_WINS.gif")));
                            dealer_stat.add(dealer_);
                            Sound.lose();
                        }
                    }
                }
                else
                {
                    if(blackjack)
                    {
                        dealer_ = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/BLACK_JACK.gif")));
                        player_ = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/BUST.gif")));
                        Sound.busted();
                    }
                    else
                    {
                        if(play)
                        {
                            player_ = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/YOU_WIN.gif")));
                            player1.hands[active_hand].Bet_Won();
                            Sound.win();
                        }
                        else
                        {
                            player_ = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/BUST.gif")));
                            Sound.busted();
                        }
                        if(deal)
                        {
                            dealer_ = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/DEALER_WINS.gif")));
                        }
                        else
                        {
                            dealer_ = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/BUST.gif")));
                        }
                    }
                    player_stat.add(player_);
                    dealer_stat.add(dealer_);
                }
            }
            validate();
            repaint();
            active_hand--;
            try {
            Thread.sleep(1500);
            } 
            catch (InterruptedException ex) {}
            bank_label.setText("Bank: "+Long.toString(player1.get_bank_value()));
            try {
            Thread.sleep(1500);
            } 
            catch (InterruptedException ex) {}
            player_stat.removeAll();
            dealer_stat.removeAll();
            both_stat.removeAll();
            validate();
            repaint();
        }
        new BET_SCREEN_GUI().setVisible(true);
        this.dispose();
    }
    private javax.swing.JLabel player_;
    javax.swing.JLabel dealer_;
    javax.swing.JLabel push;
    private boolean switch_hands()
    {
        if(active_hand < number_of_splitted)
        {
            active_hand++;
            return true;
        }
        else
        {
            return false;
        }
    }
    private void update()
    {
        card_value.setText(Integer.toString(Deck.Remaining_cards()));
        bank_label.setText("Bank: "+Long.toString(player1.get_bank_value()));
        player_label.setText("Player: "+Integer.toString(player1.hands[active_hand].get_cards_value()));
        dealer_label.setText("Dealer: "+Integer.toString(dealer.get_cards_value()));
        bet_label.setText("$"+Long.toString(player1.hands[active_hand].get_Bet()));
        Toolkit tkit = Toolkit.getDefaultToolkit();
        if(player1.get_bank_value() < player1.hands[active_hand].get_Bet() || !first_turn)
        {
            double_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/x22.png")));
            double_button.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/default.png")).getImage(), new Point(0, 0), "default_m"));
            double_enable = false;
        }
        else
        {
            double_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/x2.png")));
            double_button.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
            double_enable = true;
        }
        if(player1.hands[active_hand].get_cards_value() < 21)
        {            
            Hit_button.setVisible(true);
            Stand_button.setVisible(true);
        }
        else
        {
            Hit_button.setVisible(false);
            Stand_button.setVisible(false);
        }
        if(((player_card_value[0]/4)+1 == (player_card_value[1]/4)+1 && (player1.hands[active_hand].get_number_of_cards() > 1)) || number_of_splitted == 3)
        {
            Split_button.setVisible(true);
        }
        else
        {
            Split_button.setVisible(false);
        }
    }
    public Gameplay_GUI() {
        dealer = new Dealer(Deck);
        player_card_value = new byte[11];
        dealer_card_value = new byte [11];
        player_cards = new javax.swing.JLabel[11];
        dealer_cards = new javax.swing.JLabel[11];
        splitted_cards = new javax.swing.JLabel[3];
        player_card_value = player1.hands[0].get_cards();
        initComponents();
        new Thread(){
            @Override
            public void run() {
                Toolkit tkit = Toolkit.getDefaultToolkit();
                setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/default.png")).getImage(), new Point(0, 0), "default_m"));
                Insurance_button.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                Hit_button.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                Split_button.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                Stand_button.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                double_button.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                exit_button.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                unmuted.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
            }
        }.start();
        center_screen();
        player_cards[0] = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck/"+Byte.toString(player_card_value[0])+".png")));
        player_card.add(player_cards[0]);
        player_cards[1] = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck/"+Byte.toString(player_card_value[1])+".png")));
        player_card.add(player_cards[1]);
        dealer_card_value = dealer.get_cards();
        dealer_cards[0] = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck/"+Byte.toString(dealer_card_value[0])+".png")));
        dealer_cards[1] = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck/flipped_card.png")));
        dealer_card.add(dealer_cards[1]);
        dealer_card.add(dealer_cards[0]);
        if(player1.hands[0].get_cards_value() == 21)
        {
            new Thread(){
            @Override
            public void run() {
                Insurance_button.setVisible(false);
                Stand_button.setVisible(false);
                Split_button.setVisible(false);
                Hit_button.setVisible(false);
                try {
                        Thread.sleep(1500);
                    } 
                catch (InterruptedException ex) {}
                player_ = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/BLACK_JACK.gif")));
                player_stat.add(player_);
                validate();
                repaint();
                Sound.blackjack();
                try {
                        Thread.sleep(1500);
                    } 
                catch (InterruptedException ex) {}
                dealer.second_card_not_flipped();
                dealer_cards[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck/"+Byte.toString(dealer_card_value[1])+".png")));
                dealer_card.add(dealer_cards[1], 0);
                dealer_label.setText("Dealer: "+Integer.toString(dealer.get_cards_value()));
                validate();
                repaint();
                try {
                        Thread.sleep(1500);
                    } 
                catch (InterruptedException ex) {}
                if(dealer.get_cards_value() == 21)
                {
                    dealer_ = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/BLACK_JACK.gif")));
                    dealer_stat.add(dealer_);
                }
                else if(dealer.get_cards_value() > 21)
                {
                    dealer_ = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/BUST.gif")));
                    dealer_stat.add(dealer_);
                    player1.hands[0].BlackJack();
                }
                else
                {
                    player1.hands[0].BlackJack();
                }
                validate();
                repaint();
                player1.hands[0].push();
                bank_label.setText("Bank: "+Long.toString(player1.get_bank_value()));
                try {
                        Thread.sleep(1500);
                    } 
                catch (InterruptedException ex) {}
                gameplay.dispose();
                new BET_SCREEN_GUI().setVisible(true);
                }
            }.start();
        }
        else
        {
            new Thread(){
                @Override
                public void run() {
                    update();
                }   
            }.start();
            if((dealer_card_value[0]/4)+1 != 1 || player1.get_bank_value() < player1.hands[0].get_Bet()/2)
            {
                Insurance_button.setVisible(false);
            }
        }
        if(!Sound_stat)
        {
            unmuted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/mute.png")));
        }
        else
        {
            unmuted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/volume.png")));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        both_stat = new javax.swing.JPanel();
        dealer_stat = new javax.swing.JPanel();
        player_stat = new javax.swing.JPanel();
        left_buttons = new javax.swing.JPanel();
        Insurance_button = new javax.swing.JButton();
        Hit_button = new javax.swing.JButton();
        right_buttons = new javax.swing.JPanel();
        Split_button = new javax.swing.JButton();
        Stand_button = new javax.swing.JButton();
        Splitted = new javax.swing.JPanel();
        dealer_card = new javax.swing.JPanel();
        player_card = new javax.swing.JPanel();
        bet_panel = new javax.swing.JPanel();
        bet_label = new javax.swing.JLabel();
        exit_button = new javax.swing.JButton();
        double_button = new javax.swing.JButton();
        unmuted = new javax.swing.JToggleButton();
        bottom_labels = new javax.swing.JPanel();
        bank_label = new javax.swing.JLabel();
        player_label = new javax.swing.JLabel();
        dealer_label = new javax.swing.JLabel();
        card_value = new javax.swing.JLabel();
        card_logo = new javax.swing.JLabel();
        background_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BlackJack");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/blackjack/Pictures/Logo/blackjack_logo.png")));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        both_stat.setOpaque(false);
        getContentPane().add(both_stat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1067, 108));

        dealer_stat.setOpaque(false);
        getContentPane().add(dealer_stat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1067, 108));

        player_stat.setOpaque(false);
        getContentPane().add(player_stat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1067, 108));

        left_buttons.setOpaque(false);

        Insurance_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/unsurance.png"))); // NOI18N
        Insurance_button.setBorderPainted(false);
        Insurance_button.setContentAreaFilled(false);
        Insurance_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Insurance_button.setFocusPainted(false);
        Insurance_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Insurance_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Insurance_button.setRequestFocusEnabled(false);
        Insurance_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Insurance_buttonMouseEntered(evt);
            }
        });
        Insurance_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Insurance_buttonActionPerformed(evt);
            }
        });
        left_buttons.add(Insurance_button);

        Hit_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/joker.png"))); // NOI18N
        Hit_button.setBorderPainted(false);
        Hit_button.setContentAreaFilled(false);
        Hit_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Hit_button.setFocusPainted(false);
        Hit_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Hit_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Hit_button.setRequestFocusEnabled(false);
        Hit_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Hit_buttonMouseEntered(evt);
            }
        });
        Hit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hit_buttonActionPerformed(evt);
            }
        });
        left_buttons.add(Hit_button);

        getContentPane().add(left_buttons, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 295, 155, 135));

        right_buttons.setOpaque(false);

        Split_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/split.png"))); // NOI18N
        Split_button.setBorderPainted(false);
        Split_button.setContentAreaFilled(false);
        Split_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Split_button.setFocusPainted(false);
        Split_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Split_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Split_button.setRequestFocusEnabled(false);
        Split_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Split_buttonMouseEntered(evt);
            }
        });
        Split_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Split_buttonActionPerformed(evt);
            }
        });
        right_buttons.add(Split_button);

        Stand_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/hold.png"))); // NOI18N
        Stand_button.setBorderPainted(false);
        Stand_button.setContentAreaFilled(false);
        Stand_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Stand_button.setFocusPainted(false);
        Stand_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Stand_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Stand_button.setRequestFocusEnabled(false);
        Stand_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Stand_buttonMouseEntered(evt);
            }
        });
        Stand_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Stand_buttonActionPerformed(evt);
            }
        });
        right_buttons.add(Stand_button);

        getContentPane().add(right_buttons, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 295, 155, 135));

        Splitted.setOpaque(false);
        getContentPane().add(Splitted, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 290, 50, 240));

        dealer_card.setOpaque(false);
        getContentPane().add(dealer_card, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 40, 840, 108));

        player_card.setOpaque(false);
        getContentPane().add(player_card, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 430, 840, 108));

        bet_panel.setOpaque(false);

        bet_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bet_label.setForeground(new java.awt.Color(204, 255, 0));
        bet_label.setText("$"+Long.toString(player1.hands[active_hand].get_Bet()));
        bet_panel.add(bet_label);

        getContentPane().add(bet_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 540, 30));

        exit_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/exit_gameplay.png"))); // NOI18N
        exit_button.setBorderPainted(false);
        exit_button.setContentAreaFilled(false);
        exit_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit_button.setFocusPainted(false);
        exit_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_buttonMouseEntered(evt);
            }
        });
        exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(exit_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 6, 30, -1));

        double_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/x2.png"))); // NOI18N
        double_button.setBorderPainted(false);
        double_button.setContentAreaFilled(false);
        double_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        double_button.setFocusPainted(false);
        double_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        double_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        double_button.setRequestFocusEnabled(false);
        double_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                double_buttonMouseEntered(evt);
            }
        });
        double_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                double_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(double_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 335, 50, -1));

        unmuted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/volume.png"))); // NOI18N
        unmuted.setBorderPainted(false);
        unmuted.setContentAreaFilled(false);
        unmuted.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        unmuted.setFocusPainted(false);
        unmuted.setMargin(new java.awt.Insets(0, 0, 0, 0));
        unmuted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                unmutedMouseEntered(evt);
            }
        });
        unmuted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unmutedActionPerformed(evt);
            }
        });
        getContentPane().add(unmuted, new org.netbeans.lib.awtextra.AbsoluteConstraints(1028, 0, -1, -1));

        bottom_labels.setOpaque(false);
        bottom_labels.setLayout(new java.awt.GridLayout(1, 0));

        bank_label.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bank_label.setForeground(new java.awt.Color(0, 204, 204));
        bank_label.setText("Bank: "+Long.toString(player1.get_bank_value())
        );
        bank_label.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bank_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bank_labelMouseEntered(evt);
            }
        });
        bottom_labels.add(bank_label);

        player_label.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        player_label.setForeground(new java.awt.Color(0, 204, 204));
        player_label.setText("Player: "+Integer.toString(player1.hands[active_hand].get_cards_value()));
        player_label.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bottom_labels.add(player_label);

        dealer_label.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        dealer_label.setForeground(new java.awt.Color(0, 204, 204));
        dealer_label.setText("Dealer: "+Integer.toString(dealer.get_cards_value()));
        dealer_label.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bottom_labels.add(dealer_label);

        getContentPane().add(bottom_labels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 1067, 60));

        card_value.setBackground(new java.awt.Color(153, 0, 153));
        card_value.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        card_value.setForeground(new java.awt.Color(102, 0, 102));
        card_value.setText(Integer.toString(Deck.Remaining_cards()));
        getContentPane().add(card_value, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 72, -1, 24));

        card_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/playing-card.png"))); // NOI18N
        getContentPane().add(card_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 72, 20, -1));

        background_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Background/Gameplay_wallpaper.jpg"))); // NOI18N
        getContentPane().add(background_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unmutedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unmutedActionPerformed
        //right a code to mute
        if(Sound.isMusicOn())
        {
            unmuted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/mute.png")));
            Sound.backgroundMusicPause();
            Sound_stat = false;
        }
        else
        {
            unmuted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/volume.png")));
            Sound.backgroundMusicPlay();
            Sound_stat = true;
        }
    }//GEN-LAST:event_unmutedActionPerformed

    private void exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_buttonActionPerformed
        data.Write_encrypted(Long.toString(player1.get_bank_value()));
        new Thread(){
            @Override
            public void run() {
                Sound.exit();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {}
                System.exit(0);
            }
        }.start();
    }//GEN-LAST:event_exit_buttonActionPerformed

    private void Insurance_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Insurance_buttonActionPerformed
        player1.hands[active_hand].Insurance();
        update();
        Insurance_button.setVisible(false);
        Sound.insurance();
        if(dealer.check_blackjack())
        {
            new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(1500);
                    } 
                    catch (InterruptedException ex) {}
                    dealer.second_card_not_flipped();
                    dealer_cards[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck/"+Byte.toString(dealer_card_value[1])+".png")));
                    dealer_card.add(dealer_cards[1], 0);
                    dealer_label.setText("Dealer: "+Integer.toString(dealer.get_cards_value()));
                    validate();
                    repaint();
                    player1.hands[0].Insurance_won();
                    bank_label.setText("Bank: "+Long.toString(player1.get_bank_value()));
                    dealer_ = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/BLACK_JACK.gif")));
                    dealer_stat.add(dealer_);
                    try {
                        Thread.sleep(3000);
                    } 
                    catch (InterruptedException ex) {}
                    gameplay.dispose();
                    new BET_SCREEN_GUI().setVisible(true);
                }
            }.start();
        }
        else
        {
            push = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/INSURANCE_LOST.gif")));
            new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } 
                    catch (InterruptedException ex) {}
                    both_stat.add(push);
                    validate();
                    repaint();
                    try {
                        Thread.sleep(2000);
                    } 
                    catch (InterruptedException ex) {}
                    both_stat.removeAll();
                    validate();
                    repaint();
                }
            }.start();
        }
    }//GEN-LAST:event_Insurance_buttonActionPerformed

    private void Hit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hit_buttonActionPerformed
        player1.hands[active_hand].Hit();
        player_card_value[player1.hands[active_hand].get_number_of_cards()-1] = player1.hands[active_hand].get_last_hit();
        player_cards[player1.hands[active_hand].get_number_of_cards()-1] = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck/"+Byte.toString(player_card_value[player1.hands[active_hand].get_number_of_cards()-1])+".png")));
        player_card.add(player_cards[player1.hands[active_hand].get_number_of_cards()-1]);
        Sound.hit();
        validate();
        if(player1.hands[active_hand].get_cards_value() >= 21)
        {
            Hit_button.setVisible(false);
            Stand_button.setVisible(false);
        }
        first_turn = false;
        Insurance_button.setVisible(false);
        Split_button.setVisible(false);
        double_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/x22.png")));
        Toolkit tkit = Toolkit.getDefaultToolkit();
        double_button.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/default.png")).getImage(), new Point(0, 0), "default_m"));
        double_enable = false;
        update();
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {}
                if(player1.hands[active_hand].get_cards_value() >= 21)
                {
                    if(switch_hands())
                        {
                            first_turn = true;
                            player_card.removeAll();
                            splitted_cards[active_hand-1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck_smaller/"+Byte.toString(player1.hands[active_hand-1].get_last_hit())+".png")));
                            player_card_value = player1.hands[active_hand].get_cards();
                            player_cards[0] = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck/"+Byte.toString(player_card_value[0])+".png")));
                            player_card.add(player_cards[0]);
                            validate();
                            repaint();
                            update();
                        }
                    else
                    {
                        dealer_turn();
                    }
                }
                
            }
        }.start();
    }//GEN-LAST:event_Hit_buttonActionPerformed

    private void double_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_double_buttonActionPerformed
        if(double_enable)
        {
            Sound.doublee();
            new Thread()
            {
                @Override
                public void run() {
                    player1.hands[active_hand].double_bet();
                    player1.hands[active_hand].Hit();
                    player_card_value[player1.hands[active_hand].get_number_of_cards()-1] = player1.hands[active_hand].get_last_hit();
                    player_cards[player1.hands[active_hand].get_number_of_cards()-1] = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck/"+Byte.toString(player_card_value[player1.hands[active_hand].get_number_of_cards()-1])+".png")));
                    player_card.add(player_cards[player1.hands[active_hand].get_number_of_cards()-1]);
                    validate();
                    update();
                    double_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/x22.png")));
                    Toolkit tkit = Toolkit.getDefaultToolkit();
                    double_button.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/default.png")).getImage(), new Point(0, 0), "default_m"));
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {}
                    if(switch_hands())
                    {
                        first_turn = true;
                        player_card.removeAll();
                        splitted_cards[active_hand-1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck_smaller/"+Byte.toString(player1.hands[active_hand-1].get_last_hit())+".png")));
                        player_card_value = player1.hands[active_hand].get_cards();
                        player_cards[0] = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck/"+Byte.toString(player_card_value[0])+".png")));
                        player_card.add(player_cards[0]);
                        validate();
                        repaint();
                        update();
                    }
                    else
                    {
                        dealer_turn();
                    }
                }
            }.start();
            double_enable = false;
            Hit_button.setVisible(false);
            Stand_button.setVisible(false);
            Insurance_button.setVisible(false);
            Split_button.setVisible(false);
        }
    }//GEN-LAST:event_double_buttonActionPerformed

    private void Split_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Split_buttonActionPerformed
        Sound.split();
        player1.hands[active_hand].split();
        player_card.remove(player_cards[1]);
        player_cards[1] = null;
        splitted_cards[number_of_splitted] = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck_smaller/"+Byte.toString(player1.hands[number_of_splitted+1].get_last_hit())+".png")));
        Splitted.add(splitted_cards[number_of_splitted++]);
        player_card_value[1] = -1;
        validate();
        repaint();
        update();
        Split_button.setVisible(false);
    }//GEN-LAST:event_Split_buttonActionPerformed

    private void Stand_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Stand_buttonActionPerformed
        Sound.stay();
        Split_button.setVisible(false);
        Insurance_button.setVisible(false);
        Hit_button.setVisible(false);
        Stand_button.setVisible(false);
        if(switch_hands())
        {
            first_turn = true;
            player_card.removeAll();
            splitted_cards[active_hand-1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck_smaller/"+Byte.toString(player1.hands[active_hand-1].get_last_hit())+".png")));
            player_card_value = player1.hands[active_hand].get_cards();
            player_cards[0] = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Card_Deck/"+Byte.toString(player_card_value[0])+".png")));
            player_card.add(player_cards[0]);
            validate();
            repaint();
            update();
        }
        else
        {
            dealer_turn();
        }
    }//GEN-LAST:event_Stand_buttonActionPerformed

    private void unmutedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unmutedMouseEntered
        Sound.buttoons();
    }//GEN-LAST:event_unmutedMouseEntered

    private void Insurance_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Insurance_buttonMouseEntered
        Sound.buttoons();
    }//GEN-LAST:event_Insurance_buttonMouseEntered

    private void Hit_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Hit_buttonMouseEntered
        Sound.buttoons();
    }//GEN-LAST:event_Hit_buttonMouseEntered

    private void Split_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Split_buttonMouseEntered
        Sound.buttoons();
    }//GEN-LAST:event_Split_buttonMouseEntered

    private void Stand_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Stand_buttonMouseEntered
        Sound.buttoons();
    }//GEN-LAST:event_Stand_buttonMouseEntered

    private void double_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_double_buttonMouseEntered
        if(double_enable)
        {
            Sound.buttoons();
        }
    }//GEN-LAST:event_double_buttonMouseEntered

    private void exit_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_buttonMouseEntered
        Sound.buttoons();
    }//GEN-LAST:event_exit_buttonMouseEntered

    private void bank_labelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bank_labelMouseEntered
        Sound.money();
    }//GEN-LAST:event_bank_labelMouseEntered

    /**
     * @param args the command line arguments
     */
    private void center_screen() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    private boolean player_finished;
    private boolean first_turn = true;
    private byte number_of_splitted = 0;
    private boolean double_enable = true;
    private Dealer dealer;
    private byte active_hand = 0;
    private javax.swing.JLabel[] splitted_cards;
    private javax.swing.JLabel[] player_cards;
    private javax.swing.JLabel[] dealer_cards;
    private byte[] player_card_value;
    private byte[] dealer_card_value;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Hit_button;
    private javax.swing.JButton Insurance_button;
    private javax.swing.JButton Split_button;
    private javax.swing.JPanel Splitted;
    private javax.swing.JButton Stand_button;
    private javax.swing.JLabel background_wallpaper;
    private javax.swing.JLabel bank_label;
    private javax.swing.JLabel bet_label;
    private javax.swing.JPanel bet_panel;
    private javax.swing.JPanel both_stat;
    private javax.swing.JPanel bottom_labels;
    private javax.swing.JLabel card_logo;
    private javax.swing.JLabel card_value;
    private javax.swing.JPanel dealer_card;
    private javax.swing.JLabel dealer_label;
    private javax.swing.JPanel dealer_stat;
    private javax.swing.JButton double_button;
    private javax.swing.JButton exit_button;
    private javax.swing.JPanel left_buttons;
    private javax.swing.JPanel player_card;
    private javax.swing.JLabel player_label;
    private javax.swing.JPanel player_stat;
    private javax.swing.JPanel right_buttons;
    private javax.swing.JToggleButton unmuted;
    // End of variables declaration//GEN-END:variables
}
