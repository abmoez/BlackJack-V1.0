/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

import static blackjack.FIRST_SCREEN_GUI.Sound_stat;
import jaco.mp3.player.MP3Player;
import java.io.File;

/**
 *
 * @author mahmo
 */
public class sound {
    private static boolean back= true;
    private static final File background1 = new File("sound/ROYALTY FREE Casino Background Music _ Stylish Music Royalty Free Funky _ Royalty Free Music.mp3");
    private static final File background2 = new File("sound/ROYALTY FREE Casino Background Music _ Stylish Music Royalty Free Funky _ Royalty Free Music_2.mp3");
    private static final File background3 = new File("sound/ROYALTY FREE Casino Background Music _ Stylish Music Royalty Free Funky _ Royalty Free Music_3.mp3");
    private static final File background4 = new File("sound/ROYALTY FREE Casino Background Music _ Stylish Music Royalty Free Funky _ Royalty Free Music_4.mp3");
    private static final File background5 = new File("sound/ROYALTY FREE Casino Background Music _ Stylish Music Royalty Free Funky _ Royalty Free Music_5.mp3");
    private static final File background6 = new File("sound/ROYALTY FREE Casino Background Music _ Stylish Music Royalty Free Funky _ Royalty Free Music_6.mp3");
    private static final File win = new File("sound/money or win.mp3");
    private static final File busted = new File("sound/Busted.mp3");
    private static final File push = new File("sound/Win.mp3");
    private static final File deal = new File("sound/deal.mp3");
    private static final File allin = new File("sound/Sound xD.mp3");
    private static final File start = new File("sound/Start.mp3");
    private static final File exit = new File("sound/Exit.mp3");
    private static final File lose = new File("sound/lose.mp3");
    private static final File money = new File("sound/chipsSettle.mp3");
    private static final File sound = new File("sound/click.mp3");
    private static final File split = new File("sound/Shuffle.mp3");
    private static final File hit = new File("sound/Hit.mp3");
    private static final File stay = new File("sound/cardDraw.mp3");
    private static final File doublee = new File("sound/Sound xD.mp3");
    private static final File insurance = new File("sound/Insurance.mp3");
    private static final File shuffle = new File("sound/Shuffle.mp3");
    private static final File cardss = new File("sound/cardDraw.mp3");
    private static final File blackjack = new File("sound/Black jack.mp3");
    private static final File buttoons = new File("sound/button.mp3");
    private static final File decks = new File("sound/deck.mp3");
    private static final File backmoney = new File("sound/chipsSettle.mp3");
    private static final MP3Player background = new MP3Player(background6,background2,background3,background4,background5,background1);
    private static final MP3Player win1 = new MP3Player(win);
    private static final MP3Player busted1 = new MP3Player(busted);
    private static final MP3Player push1 = new MP3Player(push);
    private static final MP3Player deal1 = new MP3Player(deal);
    private static final MP3Player allin1 = new MP3Player(allin);
    private static final MP3Player start1 = new MP3Player(start);
    private static final MP3Player exit1 = new MP3Player(exit);
    private static final MP3Player lose1 = new MP3Player(lose);
    private static final MP3Player money1 = new MP3Player(money);
    private static final MP3Player sound1 = new MP3Player(sound);
    private static final MP3Player split1 = new MP3Player(split);
    private static final MP3Player hit1 = new MP3Player(hit);
    private static final MP3Player stay1 = new MP3Player(stay);
    private static final MP3Player doublee1 = new MP3Player(doublee);
    private static final MP3Player insurance1 = new MP3Player(insurance);
    private static final MP3Player shuffle1 = new MP3Player(shuffle);
    private static final MP3Player cardss1 = new MP3Player(cardss);
    private static final MP3Player blackjack1 = new MP3Player(blackjack);
    private static final MP3Player buttoons1 = new MP3Player(buttoons);
    private static final MP3Player decks1 = new MP3Player(decks);
    private static final MP3Player backmoney1 = new MP3Player(backmoney);

    static void backgroundMusicPlay(){
          background.setShuffle(true);
          background.setRepeat(true);
          background.play();
          back = true;
      }
      public static void backgroundMusicPause(){
          background.pause();
          back = false;
      }
       public static void win(){
           win1.setRepeat(false);
           background.pause();
           win1.play();
           if(Sound_stat)
           {
                background.play();
           }
      }
       public static void busted(){
           busted1.setRepeat(false);
           background.pause();
           busted1.play();
           if(Sound_stat)
           {
                background.play();
           }
      }   
       public static void push(){
           push1.setRepeat(false);
           background.pause();
           push1.play();
           background.play();
      }
       public static void deal(){
           deal1.setRepeat(false);
           deal1.play();
      }  
       public static void allin(){
           allin1.setRepeat(false);
           allin1.play();
      }
       public static void start(){
           start1.setRepeat(false);
           start1.play();
      }
       public static void exit(){
           exit1.setRepeat(false);
           exit1.play();
           background.stop();
      }
       public static void lose(){
           lose1.setRepeat(false);
           background.pause();
           lose1.play();
           if(Sound_stat)
           {
                background.play();
           }
      }
       public static void money(){
           money1.setRepeat(false);
           money1.play();
      }
       public static void sound(){
           sound1.setRepeat(false);
           sound1.play();
      }
       public static void split(){
           split1.setRepeat(false);
           split1.play();
      }
       public static void hit(){
           hit1.setRepeat(false);
           hit1.play();
      }
       public static void stay(){
           stay1.setRepeat(false);
           stay1.play();
      }
       public static void doublee(){
           doublee1.setRepeat(false);
           doublee1.play();
      }
       public static void insurance(){
           insurance1.setRepeat(false);
           insurance1.play();
      }
       public static void shuffle(){
           shuffle1.setRepeat(false);
           shuffle1.play();
      }
       public static void cardss(){
           cardss1.setRepeat(false);
           cardss1.play();
      }
       public static void blackjack(){
           blackjack1.setRepeat(false);
           background.pause();
           blackjack1.play();
           if(Sound_stat)
           {
                background.play();
           }
      }
       public static void buttoons(){
           buttoons1.setRepeat(false);
           buttoons1.play();
      }
       public static void decks(){
           decks1.setRepeat(false);
           decks1.play();
      }
       public static void backmoney(){
           backmoney1.setRepeat(false);
           backmoney1.play();
      }
      public static boolean isMusicOn(){
          return !background.isPaused();
      }
}
