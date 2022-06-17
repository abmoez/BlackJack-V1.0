/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package blackjack;
import static blackjack.FIRST_SCREEN_GUI.Deck;
import static blackjack.FIRST_SCREEN_GUI.Sound;
import static blackjack.FIRST_SCREEN_GUI.Sound_stat;
import static blackjack.FIRST_SCREEN_GUI.data;
import static blackjack.FIRST_SCREEN_GUI.player1;
import static blackjack.FIRST_SCREEN_GUI.refresh_player;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * @author mahmo
 */

public class BET_SCREEN_GUI extends javax.swing.JFrame {

    /**
     * Creates new form BETGUI
     */
    private void check_forced()
    {
        Bet_value.setText(Long.toString(bet));
        bank_value_label.setText("Bank: "+Long.toString(player1.get_bank_value()));
        if(player1.get_bank_value() >= 1)
        {
            _1_.setVisible(true);
        }
        else
        {
            _1_.setVisible(false);
        }
        if(player1.get_bank_value() >= 5)
        {
            _5_.setVisible(true);
        }
        else
        {
            _5_.setVisible(false);
        }
        if(player1.get_bank_value() >= 25)
        {
            _25_.setVisible(true);
        }
        else
        {
            _25_.setVisible(false);
        }
        if(player1.get_bank_value() >= 50)
        {
            _50_.setVisible(true);
        }
        else
        {
            _50_.setVisible(false);
        }
        if(player1.get_bank_value() >= 100)
        {
            _100_.setVisible(true);
        }
        else
        {
            _100_.setVisible(false);
        }
        if(player1.get_bank_value() >= 500)
        {
            _500_.setVisible(true);
        }
        else
        {
            _500_.setVisible(false);
        }
        if(player1.get_bank_value() >= 1000)
        {
            _1k_.setVisible(true);
        }
        else
        {
            _1k_.setVisible(false);
        }
        if(player1.get_bank_value() >= 5000)
        {
            _5k_.setVisible(true);
        }
        else
        {
            _5k_.setVisible(false);
        }
        if(bet == 0)
        {
            deal_button.setVisible(false);
            deal_label.setVisible(false);
        }
        else
        {
            deal_button.setVisible(true);
            deal_label.setVisible(true);
        }
    }
    private void check()
    {
        if(player1.get_bank_value() != old_value)
        {
            Bet_value.setText(Long.toString(bet));
            bank_value_label.setText("Bank: "+Long.toString(player1.get_bank_value()));
            old_value = player1.get_bank_value();
            if(player1.get_bank_value() >= 1)
            {
                _1_.setVisible(true);
            }
            else
            {
                _1_.setVisible(false);
            }
            if(player1.get_bank_value() >= 5)
            {
                _5_.setVisible(true);
            }
            else
            {
                _5_.setVisible(false);
            }
            if(player1.get_bank_value() >= 25)
            {
                _25_.setVisible(true);
            }
            else
            {
                _25_.setVisible(false);
            }
            if(player1.get_bank_value() >= 50)
            {
                _50_.setVisible(true);
            }
            else
            {
                _50_.setVisible(false);
            }
            if(player1.get_bank_value() >= 100)
            {
                _100_.setVisible(true);
            }
            else
            {
                _100_.setVisible(false);
            }
            if(player1.get_bank_value() >= 500)
            {
                _500_.setVisible(true);
            }
            else
            {
                _500_.setVisible(false);
            }
            if(player1.get_bank_value() >= 1000)
            {
                _1k_.setVisible(true);
            }
            else
            {
                _1k_.setVisible(false);
            }
            if(player1.get_bank_value() >= 5000)
            {
                _5k_.setVisible(true);
            }
            else
            {
                _5k_.setVisible(false);
            }
            if(player1.get_bank_value() == 0)
            {
                all = 1;
                bet_all_toggle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/checked.png")));
            }
            else
            {
                all = 0;
                bet_all_toggle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/cancel.png")));
            }
            if(bet == 0)
            {
                deal_button.setVisible(false);
                deal_label.setVisible(false);
            }
            else
            {
                deal_button.setVisible(true);
                deal_label.setVisible(true);
            }
        }
    }
    public BET_SCREEN_GUI() {
        new Thread(){
            @Override
            public void run() {
                refresh_player();
            }
        }.start();
        initComponents();
        new Thread(){
            @Override
            public void run() {
                Toolkit tkit = Toolkit.getDefaultToolkit();
                setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/default.png")).getImage(), new Point(0, 0), "default_m"));
                _1_.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                _5_.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                _25_.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                _50_.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                _100_.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                _500_.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                _1k_.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                _1k_.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                Exit_BET.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                unmuted.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                deal_button.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                unbet_button.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
                bet_all_toggle.setCursor(tkit.createCustomCursor(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Cursors/hand.png")).getImage(), new Point(0, 0), "default_m"));
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                if(player1.get_bank_value() <= 0)
                {
                    Sound.shuffle();
                    BET_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Background/BET_wallpaper_darken.jpg")));
                    _1_.setVisible(false);
                    _5_.setVisible(false);
                    _25_.setVisible(false);
                    _50_.setVisible(false);
                    _100_.setVisible(false);
                    _500_.setVisible(false);
                    _1k_.setVisible(false);
                    _5k_.setVisible(false);
                    deal_label.setVisible(false);
                    deal_button.setVisible(false);
                    card_logo.setVisible(false);
                    card_value.setVisible(false);
                    jPanel1.setVisible(false);
                    jPanel3.setVisible(false);
                    shuffle_word.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/HOUSE_WINS.gif")));
                    shuffle_word.setVisible(true);
                    data.Write_encrypted("1000");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {}
                    System.exit(0);
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                check();
            }
        }.start();
        center_screen();
        if(!Sound_stat)
        {
            unmuted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/mute.png")));
        }
        else
        {
            unmuted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/volume.png")));
        }
        if(Deck.check_shuffle() && !first)
        {
            new Thread(){
                @Override
                public void run() {
                    Deck.Shuffle_Deck();
                }
            }.start();
            BET_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Background/BET_wallpaper_darken.jpg")));
            _1_.setVisible(false);
            _5_.setVisible(false);
            _25_.setVisible(false);
            _50_.setVisible(false);
            _100_.setVisible(false);
            _500_.setVisible(false);
            _1k_.setVisible(false);
            _5k_.setVisible(false);
            deal_label.setVisible(false);
            deal_button.setVisible(false);
            card_logo.setVisible(false);
            card_value.setVisible(false);
            jPanel1.setVisible(false);
            jPanel3.setVisible(false);
            shuffle_card.setVisible(true);
            shuffle_word.setVisible(true);
            new Thread(){
                @Override
                public void run() {
                    try{
                Thread.sleep(3800);
            }
            catch(InterruptedException e){}
            BET_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Background/BET_wallpaper.jpg")));
            deal_label.setVisible(true);
            deal_button.setVisible(true);
            card_logo.setVisible(true);
            card_value.setVisible(true);
            card_value.setText(Integer.toString(Deck.Remaining_cards()));
            jPanel1.setVisible(true);
            jPanel3.setVisible(true);
            unmuted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/volume.png")));
            check_forced();
            shuffle_card.setVisible(false);
            shuffle_word.setVisible(false);
                }
            }.start();
        }
        first = false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Exit_BET = new javax.swing.JButton();
        unmuted = new javax.swing.JToggleButton();
        shuffle_card = new javax.swing.JLabel();
        shuffle_word = new javax.swing.JLabel();
        card_logo = new javax.swing.JLabel();
        card_value = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Bet_value = new javax.swing.JLabel();
        unbet_button = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        _1_ = new javax.swing.JButton();
        bank_value_label = new javax.swing.JLabel();
        _25_ = new javax.swing.JButton();
        _100_ = new javax.swing.JButton();
        _1k_ = new javax.swing.JButton();
        _50_ = new javax.swing.JButton();
        _500_ = new javax.swing.JButton();
        _5_ = new javax.swing.JButton();
        _5k_ = new javax.swing.JButton();
        bet_all_toggle = new javax.swing.JToggleButton();
        bet_all_label = new javax.swing.JLabel();
        deal_button = new javax.swing.JButton();
        deal_label = new javax.swing.JLabel();
        BET_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BlackJack");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/blackjack/Pictures/Logo/blackjack_logo.png")));
        setUndecorated(true);
        setResizable(false);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Exit_BET.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/exit_BET.png"))); // NOI18N
        Exit_BET.setBorderPainted(false);
        Exit_BET.setContentAreaFilled(false);
        Exit_BET.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exit_BET.setFocusPainted(false);
        Exit_BET.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Exit_BET.setVerifyInputWhenFocusTarget(false);
        Exit_BET.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Exit_BET.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Exit_BETMouseEntered(evt);
            }
        });
        Exit_BET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_BETActionPerformed(evt);
            }
        });
        jPanel2.add(Exit_BET, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, 54));

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
        jPanel2.add(unmuted, new org.netbeans.lib.awtextra.AbsoluteConstraints(1028, 0, -1, -1));
        unmuted.getAccessibleContext().setAccessibleDescription("");

        shuffle_card.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        shuffle_card.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/Shuffle.gif"))); // NOI18N
        shuffle_card.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(shuffle_card, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 110, -1, 490));
        shuffle_card.setVisible(false);

        shuffle_word.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Logo/shuffle_word.gif"))); // NOI18N
        jPanel2.add(shuffle_word, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 5, -1, -1));
        shuffle_word.setVisible(false);

        card_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/playing-card.png"))); // NOI18N
        jPanel2.add(card_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 72, 20, -1));

        card_value.setBackground(new java.awt.Color(153, 0, 153));
        card_value.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        card_value.setForeground(new java.awt.Color(102, 0, 102));
        card_value.setText(Integer.toString(Deck.Remaining_cards()));
        jPanel2.add(card_value, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 72, -1, 24));

        jPanel3.setOpaque(false);

        Bet_value.setBackground(new java.awt.Color(204, 204, 204));
        Bet_value.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Bet_value.setForeground(new java.awt.Color(0, 102, 102));
        Bet_value.setText("Bank: "+Long.toString(player1.get_bank_value()));
        Bet_value.setToolTipText("");

        unbet_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/casino-chip.png"))); // NOI18N
        unbet_button.setBorderPainted(false);
        unbet_button.setContentAreaFilled(false);
        unbet_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        unbet_button.setFocusPainted(false);
        unbet_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                unbet_buttonMouseEntered(evt);
            }
        });
        unbet_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unbet_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(Bet_value)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(unbet_button)
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(unbet_button))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(Bet_value)))
                .addGap(16, 16, 16))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 330, 100));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setName(""); // NOI18N
        jPanel1.setOpaque(false);

        _1_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Coins/1.png"))); // NOI18N
        _1_.setBorderPainted(false);
        _1_.setContentAreaFilled(false);
        _1_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        _1_.setFocusPainted(false);
        _1_.setMargin(new java.awt.Insets(0, 0, 0, 0));
        _1_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                _1_MouseEntered(evt);
            }
        });
        _1_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _1_ActionPerformed(evt);
            }
        });

        bank_value_label.setBackground(new java.awt.Color(204, 204, 204));
        bank_value_label.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bank_value_label.setForeground(new java.awt.Color(102, 0, 51));
        bank_value_label.setText("Bank: "+Long.toString(player1.get_bank_value()));
        bank_value_label.setToolTipText("");
        bank_value_label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bank_value_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bank_value_labelMouseEntered(evt);
            }
        });

        _25_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Coins/25.png"))); // NOI18N
        _25_.setBorderPainted(false);
        _25_.setContentAreaFilled(false);
        _25_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        _25_.setFocusPainted(false);
        _25_.setMargin(new java.awt.Insets(0, 0, 0, 0));
        _25_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                _25_MouseEntered(evt);
            }
        });
        _25_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _25_ActionPerformed(evt);
            }
        });

        _100_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Coins/100.png"))); // NOI18N
        _100_.setBorderPainted(false);
        _100_.setContentAreaFilled(false);
        _100_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        _100_.setFocusPainted(false);
        _100_.setMargin(new java.awt.Insets(0, 0, 0, 0));
        _100_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                _100_MouseEntered(evt);
            }
        });
        _100_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _100_ActionPerformed(evt);
            }
        });

        _1k_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Coins/1k.png"))); // NOI18N
        _1k_.setBorderPainted(false);
        _1k_.setContentAreaFilled(false);
        _1k_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        _1k_.setFocusPainted(false);
        _1k_.setMargin(new java.awt.Insets(0, 0, 0, 0));
        _1k_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                _1k_MouseEntered(evt);
            }
        });
        _1k_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _1k_ActionPerformed(evt);
            }
        });

        _50_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Coins/50.png"))); // NOI18N
        _50_.setBorderPainted(false);
        _50_.setContentAreaFilled(false);
        _50_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        _50_.setFocusPainted(false);
        _50_.setMargin(new java.awt.Insets(0, 0, 0, 0));
        _50_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                _50_MouseEntered(evt);
            }
        });
        _50_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _50_ActionPerformed(evt);
            }
        });

        _500_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Coins/500.png"))); // NOI18N
        _500_.setBorderPainted(false);
        _500_.setContentAreaFilled(false);
        _500_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        _500_.setFocusPainted(false);
        _500_.setMargin(new java.awt.Insets(0, 0, 0, 0));
        _500_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                _500_MouseEntered(evt);
            }
        });
        _500_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _500_ActionPerformed(evt);
            }
        });

        _5_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Coins/5.png"))); // NOI18N
        _5_.setBorderPainted(false);
        _5_.setContentAreaFilled(false);
        _5_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        _5_.setFocusPainted(false);
        _5_.setMargin(new java.awt.Insets(0, 0, 0, 0));
        _5_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                _5_MouseEntered(evt);
            }
        });
        _5_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _5_ActionPerformed(evt);
            }
        });

        _5k_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Coins/5k.png"))); // NOI18N
        _5k_.setBorderPainted(false);
        _5k_.setContentAreaFilled(false);
        _5k_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        _5k_.setFocusPainted(false);
        _5k_.setMargin(new java.awt.Insets(0, 0, 0, 0));
        _5k_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                _5k_MouseEntered(evt);
            }
        });
        _5k_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _5k_ActionPerformed(evt);
            }
        });

        bet_all_toggle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/cancel.png"))); // NOI18N
        bet_all_toggle.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bet_all_toggle.setContentAreaFilled(false);
        bet_all_toggle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bet_all_toggle.setFocusPainted(false);
        bet_all_toggle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bet_all_toggleMouseEntered(evt);
            }
        });
        bet_all_toggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bet_all_toggleActionPerformed(evt);
            }
        });

        bet_all_label.setBackground(new java.awt.Color(51, 0, 51));
        bet_all_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bet_all_label.setForeground(new java.awt.Color(102, 0, 102));
        bet_all_label.setText("Bet all");
        bet_all_label.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bank_value_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(bet_all_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bet_all_toggle))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_25_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_1_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_100_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_1k_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_5k_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_50_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_5_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_500_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bank_value_label)
                        .addComponent(bet_all_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(bet_all_toggle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_5_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_1_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(_25_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(_100_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(_50_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(_500_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_1k_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_5k_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 59, 310, 540));

        deal_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/deal.png"))); // NOI18N
        deal_button.setBorderPainted(false);
        deal_button.setContentAreaFilled(false);
        deal_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deal_button.setFocusPainted(false);
        deal_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deal_buttonMouseEntered(evt);
            }
        });
        deal_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deal_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(deal_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(824, 360, -1, -1));

        deal_label.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        deal_label.setForeground(new java.awt.Color(255, 255, 255));
        deal_label.setText("Deal");
        jPanel2.add(deal_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 500, -1, -1));

        BET_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Background/BET_wallpaper.jpg"))); // NOI18N
        BET_wallpaper.setOpaque(true);
        jPanel2.add(BET_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

    private void Exit_BETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit_BETActionPerformed
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
    }//GEN-LAST:event_Exit_BETActionPerformed

    private void _5_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__5_ActionPerformed
        // TODO add your handling code here:
        player1.decreament_bank(5);
        bet +=5;
        check();
    }//GEN-LAST:event__5_ActionPerformed

    private void _25_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__25_ActionPerformed
        // TODO add your handling code here:
        player1.decreament_bank(25);
        bet +=25;
        check();
    }//GEN-LAST:event__25_ActionPerformed

    private void _50_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__50_ActionPerformed
        // TODO add your handling code here:
        player1.decreament_bank(50);
        bet +=50;
        check();
    }//GEN-LAST:event__50_ActionPerformed

    private void _100_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__100_ActionPerformed
        // TODO add your handling code here:
        player1.decreament_bank(100);
        bet +=100;
        check();
    }//GEN-LAST:event__100_ActionPerformed

    private void _1k_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__1k_ActionPerformed
        // TODO add your handling code here:
        player1.decreament_bank(1000);
        bet +=1000;
        check();
    }//GEN-LAST:event__1k_ActionPerformed

    private void _5k_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__5k_ActionPerformed
        // TODO add your handling code here:
        player1.decreament_bank(5000);
        bet +=5000;
        check();
    }//GEN-LAST:event__5k_ActionPerformed

    private void _500_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__500_ActionPerformed
        // TODO add your handling code here:
        player1.decreament_bank(500);
        bet +=500;
        check();
    }//GEN-LAST:event__500_ActionPerformed

    private void bet_all_toggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bet_all_toggleActionPerformed
        if(all == 0)
        {
            Sound.allin();
            bet_all_toggle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/checked.png")));
            all = 1;
            _1_.setVisible(false);
            _5_.setVisible(false);
            _25_.setVisible(false);
            _50_.setVisible(false);
            _100_.setVisible(false);
            _500_.setVisible(false);
            _1k_.setVisible(false);
            _5k_.setVisible(false);
            bet += player1.get_bank_value();
            player1.decreament_bank(player1.get_bank_value());
            Bet_value.setText(Long.toString(bet));
            bank_value_label.setText("Bank: "+Long.toString(player1.get_bank_value()));
            old_value = player1.get_bank_value();
            deal_button.setVisible(true);
            deal_label.setVisible(true);
        }
        else
        {
            Sound.backmoney();
            bet_all_toggle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Pictures/Others/cancel.png")));
            all = 0;
            player1.increament_bank(bet);
            bet = 0;
            check();
        }
    }//GEN-LAST:event_bet_all_toggleActionPerformed

    private void deal_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deal_buttonActionPerformed
        Sound.deal();
        player1.hands[0] = player1.new hand();
        player1.hands[0].set_Bet(bet);
        gameplay = new Gameplay_GUI();
        gameplay.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_deal_buttonActionPerformed

    private void _1_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__1_ActionPerformed
        // TODO add your handling code here:
        player1.decreament_bank(1);
        bet += 1;
        check();
    }//GEN-LAST:event__1_ActionPerformed

    private void unbet_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unbet_buttonActionPerformed
        if(bet >= 5000)
        {
            Sound.backmoney();
            bet -= 5000;
            player1.increament_bank(5000);
        }
        else if(bet >= 1000)
        {
            Sound.backmoney();
            bet -= 1000;
            player1.increament_bank(1000);
        }
        else if(bet >= 500)
        {
            Sound.backmoney();
            bet -= 500;
            player1.increament_bank(500);
        }
        else if(bet >= 100)
        {
            Sound.backmoney();
            bet -= 100;
            player1.increament_bank(100);
        }
        else if(bet >= 50)
        {
            Sound.backmoney();
            bet -= 50;
            player1.increament_bank(50);
        }
        else if(bet >= 25)
        {
            Sound.backmoney();
            bet -= 25;
            player1.increament_bank(25);
        }
        else if(bet >= 5)
        {
            Sound.backmoney();
            bet -= 5;
            player1.increament_bank(5);
        }
        else if( bet > 0)
        {
            Sound.backmoney();
            bet -=1;
            player1.increament_bank(1);
        }
        check();
    }//GEN-LAST:event_unbet_buttonActionPerformed

    private void bank_value_labelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bank_value_labelMouseEntered
        Sound.money();
    }//GEN-LAST:event_bank_value_labelMouseEntered

    private void unmutedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unmutedMouseEntered
        Sound.buttoons();
    }//GEN-LAST:event_unmutedMouseEntered

    private void Exit_BETMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Exit_BETMouseEntered
        Sound.buttoons();
    }//GEN-LAST:event_Exit_BETMouseEntered

    private void bet_all_toggleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bet_all_toggleMouseEntered
        Sound.buttoons();
    }//GEN-LAST:event_bet_all_toggleMouseEntered

    private void deal_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deal_buttonMouseEntered
        Sound.buttoons();
    }//GEN-LAST:event_deal_buttonMouseEntered

    private void unbet_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unbet_buttonMouseEntered
        Sound.money();
    }//GEN-LAST:event_unbet_buttonMouseEntered

    private void _1_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__1_MouseEntered
        Sound.money();
    }//GEN-LAST:event__1_MouseEntered

    private void _25_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__25_MouseEntered
        Sound.money();
    }//GEN-LAST:event__25_MouseEntered

    private void _100_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__100_MouseEntered
        Sound.money();
    }//GEN-LAST:event__100_MouseEntered

    private void _1k_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__1k_MouseEntered
        Sound.money();
    }//GEN-LAST:event__1k_MouseEntered

    private void _5k_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__5k_MouseEntered
        Sound.money();
    }//GEN-LAST:event__5k_MouseEntered

    private void _5_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__5_MouseEntered
        Sound.money();
    }//GEN-LAST:event__5_MouseEntered

    private void _500_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__500_MouseEntered
        Sound.money();
    }//GEN-LAST:event__500_MouseEntered

    private void _50_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__50_MouseEntered
        Sound.money();
    }//GEN-LAST:event__50_MouseEntered

    /**
     * @param args the command line arguments
     */
    private void center_screen() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    static boolean first = true;
    static byte all = 0;
    private long old_value;
    private long bet = 0;
    public static Gameplay_GUI gameplay;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BET_wallpaper;
    private javax.swing.JLabel Bet_value;
    private javax.swing.JButton Exit_BET;
    private javax.swing.JButton _100_;
    private javax.swing.JButton _1_;
    private javax.swing.JButton _1k_;
    private javax.swing.JButton _25_;
    private javax.swing.JButton _500_;
    private javax.swing.JButton _50_;
    private javax.swing.JButton _5_;
    private javax.swing.JButton _5k_;
    private javax.swing.JLabel bank_value_label;
    private javax.swing.JLabel bet_all_label;
    private javax.swing.JToggleButton bet_all_toggle;
    private javax.swing.JLabel card_logo;
    private javax.swing.JLabel card_value;
    private javax.swing.JButton deal_button;
    private javax.swing.JLabel deal_label;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel shuffle_card;
    private javax.swing.JLabel shuffle_word;
    private javax.swing.JButton unbet_button;
    private javax.swing.JToggleButton unmuted;
    // End of variables declaration//GEN-END:variables
}
