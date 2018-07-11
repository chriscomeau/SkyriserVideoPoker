import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.PrintStream;
import java.util.Random;
import java.util.Vector;

public class Poker
  extends Applet
  implements Runnable, MouseListener, MouseMotionListener, KeyListener
{
  private int screenWidth;
  private int screenHeight;
  private static final int kFrameDelay = 1000;
  Thread t;
  private Poker.PokerCanvas canvas;
  private Poker.PokerTable table;
  private Graphics currentGraphics;
  private Image offscreenImage;
  private Graphics offscr;
  private Image imageIntroScreen;
  private Image imageTableBackground;
  private Image imageDrawButton;
  private Image imageDealButton;
  private Image imageHelpButton;
  private Image imageNewButton;
  private Image imageHoldButtonOn;
  private Image imageHoldButtonOff;
  private Image imageCardFront;
  private Image imageWaitClick;
  private Image imageSuitHeart;
  private Image imageSuitDiamond;
  private Image imageSuitSpade;
  private Image imageSuitClub;
  
  public void init()
  {
    addMouseListener(this);
    addMouseMotionListener(this);
    addKeyListener(this);
    
    this.screenWidth = 240;
    this.screenHeight = 160;
    
    this.offscreenImage = createImage(this.screenWidth, this.screenHeight);
    this.offscr = this.offscreenImage.getGraphics();
    try
    {
      this.imageIntroScreen = getImage(getDocumentBase(), "img/imageIntroScreen.gif");
      this.imageTableBackground = getImage(getDocumentBase(), "img/imageTableBackground.gif");
      this.imageDrawButton = getImage(getDocumentBase(), "img/imageDrawButton.gif");
      this.imageDealButton = getImage(getDocumentBase(), "img/imageDealButton.gif");
      this.imageHelpButton = getImage(getDocumentBase(), "img/imageHelpButton.gif");
      this.imageNewButton = getImage(getDocumentBase(), "img/imageNewButton.gif");
      this.imageHoldButtonOn = getImage(getDocumentBase(), "img/imageHoldButtonOn.gif");
      this.imageHoldButtonOff = getImage(getDocumentBase(), "img/imageHoldButtonOff.gif");
      this.imageCardFront = getImage(getDocumentBase(), "img/imageCardFront.gif");
      this.imageSuitHeart = getImage(getDocumentBase(), "img/imageSuitHeart.gif");
      this.imageSuitDiamond = getImage(getDocumentBase(), "img/imageSuitDiamond.gif");
      this.imageSuitSpade = getImage(getDocumentBase(), "img/imageSuitSpade.gif");
      this.imageSuitClub = getImage(getDocumentBase(), "img/imageSuitClub.gif");
      this.imageWaitClick = getImage(getDocumentBase(), "img/imageWaitClick.gif");
      
      prepareImage(this.imageIntroScreen, this);
      prepareImage(this.imageTableBackground, this);
      prepareImage(this.imageDrawButton, this);
      prepareImage(this.imageDealButton, this);
      prepareImage(this.imageHelpButton, this);
      prepareImage(this.imageNewButton, this);
      prepareImage(this.imageHoldButtonOn, this);
      prepareImage(this.imageHoldButtonOff, this);
      prepareImage(this.imageCardFront, this);
      prepareImage(this.imageSuitHeart, this);
      prepareImage(this.imageSuitDiamond, this);
      prepareImage(this.imageSuitSpade, this);
      prepareImage(this.imageSuitClub, this);
      prepareImage(this.imageWaitClick, this);
    }
    catch (Exception localException)
    {
      System.out.println("Could not load image filesre.");
      throw new RuntimeException("Unable to load Image: " + localException);
    }
    this.canvas = new Poker.PokerCanvas(this);
    this.table = new Poker.PokerTable(this);
    LoadGame();
    
    this.t = new Thread(this);
    this.t.start();
    
    repaint();
  }
  
  public void mouseMoved(MouseEvent paramMouseEvent) {}
  
  public void mouseEntered(MouseEvent paramMouseEvent) {}
  
  public void mouseExited(MouseEvent paramMouseEvent) {}
  
  public void mouseClicked(MouseEvent paramMouseEvent)
  {
    if (this.table.gameState == 3) {
      this.table.SetGameState(2);
    }
  }
  
  public void mousePressed(MouseEvent paramMouseEvent) {}
  
  public void mouseReleased(MouseEvent paramMouseEvent) {}
  
  public void mouseDragged(MouseEvent paramMouseEvent) {}
  
  public void keyTyped(KeyEvent paramKeyEvent) {}
  
  public void keyReleased(KeyEvent paramKeyEvent) {}
  
  public void keyPressed(KeyEvent paramKeyEvent)
  {
    int i = 0;
    
    int j = paramKeyEvent.getKeyCode();
    switch (j)
    {
    case 10: 
      i = 10;
      break;
    case 32: 
      i = 32;
      break;
    case 37: 
    case 38: 
      i = 1;
      break;
    case 39: 
    case 40: 
      i = 6;
    }
    this.canvas.keyPressed(i);
    if (i != 65535) {
      paramKeyEvent.consume();
    }
  }
  
  public void LoadGame() {}
  
  public void SaveGame() {}
  
  public void SetGraphics(Graphics paramGraphics)
  {
    this.currentGraphics = paramGraphics;
  }
  
  public Graphics GetGraphics()
  {
    return this.currentGraphics;
  }
  
  public Graphics GetOffscreen()
  {
    return this.offscr;
  }
  
  public void Swap()
  {
    GetGraphics().drawImage(this.offscreenImage, 0, 0, this);
  }
  
  public void run()
  {
    for (;;)
    {
      repaint();
      try
      {
        Thread.sleep(33L);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public void paint(Graphics paramGraphics)
  {
    this.canvas.paint(paramGraphics);
    Swap();
  }
  
  public void update(Graphics paramGraphics)
  {
    paint(paramGraphics);
  }
  
  public class Strings
  {
    private static final String kComboRoyalFlushString = "Royal Flush";
    private static final String kComboStraightFlushString = "Straight Flush";
    private static final String kComboFourOfAKindString = "Four-Of-A-Kind";
    private static final String kComboFullHouseString = "Full House";
    private static final String kComboFlushString = "Flush";
    private static final String kComboStraightString = "Straight";
    private static final String kComboThreeOfAKindString = "Three-Of-A-Kind";
    private static final String kComboTwoPairString = "Two Pairs";
    private static final String kComboHighPairString = "High Pair";
    private static final String kComboLowPairString = "Nothing (Low Pair)";
    private static final String kComboNothingString = "Nothing";
    private static final String kMoneyString = "Wallet";
    
    public Strings() {}
  }
  
  private class PokerCard
  {
    public static final int kFaceNone = 0;
    public static final int kFaceHeart = 1;
    public static final int kFaceClub = 2;
    public static final int kFaceDiamond = 3;
    public static final int kFaceSpade = 4;
    public static final int kValueNone = 0;
    public static final int kValueAce = 14;
    public static final int kValueKing = 13;
    public static final int kValueQueen = 12;
    public static final int kValueJack = 11;
    public static final String kStringAce = "A";
    public static final String kStringKing = "K";
    public static final String kStringQueen = "Q";
    public static final String kStringJack = "J";
    private static final int kStatusInDeck = 1;
    private static final int kStatusInHand = 2;
    private static final int kStatusDiscarded = 3;
    private int face;
    private int value;
    private int status;
    
    public PokerCard(int paramInt1, int paramInt2)
    {
      this.face = paramInt1;
      this.value = paramInt2;
      this.status = 1;
    }
    
    public PokerCard()
    {
      this.face = 0;
      this.value = -1;
    }
    
    public int GetValue()
    {
      return this.value;
    }
    
    public int GetFace()
    {
      return this.face;
    }
    
    public int GetStatus()
    {
      return this.status;
    }
    
    public void SetStatus(int paramInt)
    {
      this.status = paramInt;
    }
    
    public String GetValueString()
    {
      String str = "";
      switch (GetValue())
      {
      case 14: 
        str = "A";
        break;
      case 13: 
        str = "K";
        break;
      case 12: 
        str = "Q";
        break;
      case 11: 
        str = "J";
        break;
      default: 
        str = String.valueOf(GetValue());
      }
      return str;
    }
  }
  
  private class PokerDeck
  {
    private static final int kCardPerDeck = 52;
    private int nextCard;
    private Vector list;
    private int kNumDecks = 1;
    
    public PokerDeck()
    {
      InitDeck();
    }
    
    public void InitDeck()
    {
      this.list = new Vector();
      for (int i = 0; i < this.kNumDecks; i++) {
        for (int j = 0; j < 4; j++)
        {
          int k = 0;
          switch (j)
          {
          case 0: 
            k = 1;
            break;
          case 1: 
            k = 2;
            break;
          case 2: 
            k = 4;
            break;
          case 3: 
            k = 3;
          }
          for (int m = 0; m < 13; m++)
          {
            Poker.PokerCard localPokerCard = new Poker.PokerCard(Poker.this);
            
            Poker.PokerCard.access$102(localPokerCard, k);
            Poker.PokerCard.access$202(localPokerCard, m + 2);
            this.list.addElement(localPokerCard);
          }
        }
      }
      Shuffle();
      this.nextCard = 0;
      
      DumpDeck();
    }
    
    private void DumpDeck() {}
    
    public int Count()
    {
      return 52 - this.nextCard;
    }
    
    public void Shuffle()
    {
      Random localRandom = new Random();
      
      Vector localVector = new Vector();
      for (int i = 0; i < this.list.size(); i++) {
        localVector.addElement(this.list.elementAt(i));
      }
      this.list.removeAllElements();
      i = 0;
      while (localVector.size() > 0)
      {
        int j = localVector.size();
        if (j > 1)
        {
          i = localRandom.nextInt();
          if (i < 0) {
            i *= -1;
          }
          i %= (localVector.size() - 1);
        }
        else
        {
          i = 0;
        }
        this.list.addElement(localVector.elementAt(i));
        localVector.removeElementAt(i);
      }
    }
    
    public Poker.PokerCard GetCard()
    {
      if (this.nextCard >= 52) {
        this.nextCard = 0;
      }
      Poker.PokerCard localPokerCard = (Poker.PokerCard)this.list.elementAt(this.nextCard++);
      localPokerCard.SetStatus(3);
      return localPokerCard;
    }
  }
  
  private class PokerHand
  {
    private static final int kNumHandCards = 5;
    private static final int kComboRoyalFlush = 0;
    private static final int kComboStraightFlush = 1;
    private static final int kComboFourOfAKind = 2;
    private static final int kComboFullHouse = 3;
    private static final int kComboFlush = 4;
    private static final int kComboStraight = 5;
    private static final int kComboThreeOfAKind = 6;
    private static final int kComboTwoPair = 7;
    private static final int kComboHighPair = 8;
    private static final int kComboLowPair = 9;
    private static final int kComboNothing = 10;
    private static final int kComboRoyalFlushPoints = 800;
    private static final int kComboStraightFlushPoints = 50;
    private static final int kComboFourOfAKindPoints = 25;
    private static final int kComboFullHousePoints = 8;
    private static final int kComboFlushPoints = 5;
    private static final int kComboStraightPoints = 4;
    private static final int kComboThreeOfAKindPoints = 3;
    private static final int kComboTwoPairPoints = 2;
    private static final int kComboHighPairPoints = 1;
    private static final int kComboLowPairPoints = 0;
    private static final int kComboNothingPoints = 0;
    private Applet applet;
    private final Color kRedTextColor = Color.red;
    private final Color kBlackTextColor = Color.black;
    private final Color kBackgroundColor = Color.green;
    private final Color kCardColor = Color.white;
    private final Color kCardOutlineColor = Color.black;
    private Vector handCards;
    private Vector sortedHandCards;
    private int currentCombo;
    
    public PokerHand(Applet paramApplet)
    {
      this.handCards = new Vector();
      this.sortedHandCards = new Vector();
      this.currentCombo = 10;
      this.applet = paramApplet;
    }
    
    private Poker.PokerCard GetSortedCard(int paramInt)
    {
      return (Poker.PokerCard)this.sortedHandCards.elementAt(paramInt);
    }
    
    private Poker.PokerCard GetCard(int paramInt)
    {
      return (Poker.PokerCard)this.handCards.elementAt(paramInt);
    }
    
    public void SetCard(int paramInt, Poker.PokerCard paramPokerCard)
    {
      this.handCards.setElementAt(paramPokerCard, paramInt);
    }
    
    public void AddCard(Poker.PokerCard paramPokerCard)
    {
      this.handCards.addElement(paramPokerCard);
    }
    
    public String GetResultString()
    {
      String str = "";
      switch (this.currentCombo)
      {
      case 0: 
        str = "Royal Flush";
        break;
      case 1: 
        str = "Straight Flush";
        break;
      case 2: 
        str = "Four-Of-A-Kind";
        break;
      case 3: 
        str = "Full House";
        break;
      case 4: 
        str = "Flush";
        break;
      case 5: 
        str = "Straight";
        break;
      case 6: 
        str = "Three-Of-A-Kind";
        break;
      case 7: 
        str = "Two Pairs";
        break;
      case 8: 
        str = "High Pair";
        break;
      case 9: 
        str = "Nothing (Low Pair)";
        break;
      case 10: 
        str = "Nothing";
      }
      return str;
    }
    
    public String GetResultWinString()
    {
      String str = "";
      int i;
      switch (this.currentCombo)
      {
      case 0: 
        i = 800;
        break;
      case 1: 
        i = 50;
        break;
      case 2: 
        i = 25;
        break;
      case 3: 
        i = 8;
        break;
      case 4: 
        i = 5;
        break;
      case 5: 
        i = 4;
        break;
      case 6: 
        i = 3;
        break;
      case 7: 
        i = 2;
        break;
      case 8: 
        i = 1;
        break;
      case 9: 
        i = 0;
        break;
      default: 
        i = 0;
      }
      str = "" + i;
      
      return str;
    }
    
    public int GetCombo()
    {
      return this.currentCombo;
    }
    
    public void CheckCombo()
    {
      Sort();
      int i;
      if (IsRoyalFlush()) {
        i = 0;
      } else if (IsStraightFlush()) {
        i = 1;
      } else if (IsFourOfAKind()) {
        i = 2;
      } else if (IsFullHouse()) {
        i = 3;
      } else if (IsFlush()) {
        i = 4;
      } else if (IsStraight()) {
        i = 5;
      } else if (IsThreeOfAKind()) {
        i = 6;
      } else if (IsTwoPair()) {
        i = 7;
      } else if (IsHighPair()) {
        i = 8;
      } else if (IsLowPair()) {
        i = 9;
      } else {
        i = 10;
      }
      this.currentCombo = i;
    }
    
    public void Draw()
    {
      String str1 = "";
      int i = 15;
      int j = 30;
      int k = 50;
      int m = 5;
      int n = 2;
      int i1 = 10;
      int i2 = 32;
      for (int i3 = 0; i3 < 5; i3++)
      {
        String str2 = "";
        String str3 = "";
        int i4 = i + i3 * (j + i);
        int i5 = 40;
        
        Poker.this.GetOffscreen().drawImage(Poker.this.imageCardFront, i4, i5, this.applet);
        switch (GetCard(i3).GetFace())
        {
        case 1: 
          Poker.this.GetOffscreen().drawImage(Poker.this.imageSuitHeart, i4 + m, i5 + n, this.applet);
          break;
        case 3: 
          Poker.this.GetOffscreen().drawImage(Poker.this.imageSuitDiamond, i4 + m, i5 + n, this.applet);
          break;
        case 2: 
          Poker.this.GetOffscreen().drawImage(Poker.this.imageSuitClub, i4 + m, i5 + n, this.applet);
          break;
        case 4: 
          Poker.this.GetOffscreen().drawImage(Poker.this.imageSuitSpade, i4 + m, i5 + n, this.applet);
          break;
        }
        if ((GetCard(i3).GetFace() == 1) || (GetCard(i3).GetFace() == 3)) {
          Poker.this.GetOffscreen().setColor(this.kRedTextColor);
        } else {
          Poker.this.GetOffscreen().setColor(this.kBlackTextColor);
        }
        str2 = GetCard(i3).GetValueString();
        
        Poker.this.GetOffscreen().drawString(GetCard(i3).GetValueString(), i4 + i1, i5 + i2);
      }
    }
    
    public void Empty()
    {
      this.handCards.removeAllElements();
    }
    
    private void Sort()
    {
      Vector localVector = new Vector();
      int j = 0;
      for (int i = 0; i < this.handCards.size(); i++) {
        localVector.addElement(this.handCards.elementAt(i));
      }
      this.sortedHandCards.removeAllElements();
      while (localVector.size() > 0) {
        if (this.sortedHandCards.size() == 0)
        {
          this.sortedHandCards.addElement(localVector.elementAt(0));
          
          localVector.removeElementAt(0);
        }
        else
        {
          j = 0;
          for (i = 0; i < this.sortedHandCards.size(); i++) {
            if (((Poker.PokerCard)localVector.elementAt(0)).GetValue() <= GetSortedCard(i).GetValue())
            {
              this.sortedHandCards.insertElementAt(localVector.elementAt(0), i);
              localVector.removeElementAt(0);
              j = 1;
              break;
            }
          }
          if (j == 0)
          {
            this.sortedHandCards.addElement(localVector.elementAt(0));
            localVector.removeElementAt(0);
          }
        }
      }
    }
    
    private boolean IsRoyalFlush()
    {
      if (!IsFlush()) {
        return false;
      }
      if ((GetSortedCard(0).GetValue() == 10) && (GetSortedCard(1).GetValue() == 11) && (GetSortedCard(2).GetValue() == 12) && (GetSortedCard(3).GetValue() == 13) && (GetSortedCard(4).GetValue() == 14)) {
        return true;
      }
      return false;
    }
    
    private boolean IsStraightFlush()
    {
      if ((IsStraight()) && (IsFlush())) {
        return true;
      }
      return false;
    }
    
    private boolean IsFourOfAKind()
    {
      int i = 0;
      for (int m = 0; m < 5; m++)
      {
        i = 1;
        int j = GetSortedCard(m).GetValue();
        for (int n = m + 1; n < 5; n++)
        {
          int k = GetSortedCard(n).GetValue();
          if (k == j) {
            i++;
          }
        }
        if (i >= 4) {
          return true;
        }
      }
      return false;
    }
    
    private boolean IsFullHouse()
    {
      if ((GetSortedCard(0).GetValue() == GetSortedCard(1).GetValue()) && (GetSortedCard(1).GetValue() == GetSortedCard(2).GetValue()) && (GetSortedCard(3).GetValue() == GetSortedCard(4).GetValue())) {
        return true;
      }
      if ((GetSortedCard(2).GetValue() == GetSortedCard(3).GetValue()) && (GetSortedCard(3).GetValue() == GetSortedCard(4).GetValue()) && (GetSortedCard(0).GetValue() == GetSortedCard(1).GetValue())) {
        return true;
      }
      return false;
    }
    
    private boolean IsFlush()
    {
      if ((GetSortedCard(0).GetFace() == GetSortedCard(1).GetFace()) && (GetSortedCard(1).GetFace() == GetSortedCard(2).GetFace()) && (GetSortedCard(2).GetFace() == GetSortedCard(3).GetFace()) && (GetSortedCard(3).GetFace() == GetSortedCard(4).GetFace())) {
        return true;
      }
      return false;
    }
    
    private boolean IsStraight()
    {
      if ((GetSortedCard(1).GetValue() - GetSortedCard(0).GetValue() == 1) && (GetSortedCard(2).GetValue() - GetSortedCard(1).GetValue() == 1) && (GetSortedCard(3).GetValue() - GetSortedCard(2).GetValue() == 1) && (GetSortedCard(4).GetValue() - GetSortedCard(3).GetValue() == 1)) {
        return true;
      }
      return false;
    }
    
    private boolean IsThreeOfAKind()
    {
      if ((GetSortedCard(0).GetValue() == GetSortedCard(1).GetValue()) && (GetSortedCard(1).GetValue() == GetSortedCard(2).GetValue())) {
        return true;
      }
      if ((GetSortedCard(1).GetValue() == GetSortedCard(2).GetValue()) && (GetSortedCard(2).GetValue() == GetSortedCard(3).GetValue())) {
        return true;
      }
      if ((GetSortedCard(2).GetValue() == GetSortedCard(3).GetValue()) && (GetSortedCard(3).GetValue() == GetSortedCard(4).GetValue())) {
        return true;
      }
      return false;
    }
    
    private boolean IsTwoPair()
    {
      if ((GetSortedCard(0).GetValue() == GetSortedCard(1).GetValue()) && (GetSortedCard(2).GetValue() == GetSortedCard(3).GetValue())) {
        return true;
      }
      if ((GetSortedCard(0).GetValue() == GetSortedCard(1).GetValue()) && (GetSortedCard(3).GetValue() == GetSortedCard(4).GetValue())) {
        return true;
      }
      if ((GetSortedCard(1).GetValue() == GetSortedCard(2).GetValue()) && (GetSortedCard(3).GetValue() == GetSortedCard(4).GetValue())) {
        return true;
      }
      return false;
    }
    
    private boolean IsHighPair()
    {
      if (IsPairValue() >= 11) {
        return true;
      }
      return false;
    }
    
    private boolean IsLowPair()
    {
      if ((IsPairValue() > 0) && (IsPairValue() < 11)) {
        return true;
      }
      return false;
    }
    
    private boolean IsPair()
    {
      return IsPairValue() != 0;
    }
    
    private int IsPairValue()
    {
      int i;
      if (GetSortedCard(0).GetValue() == GetSortedCard(1).GetValue()) {
        i = GetSortedCard(0).GetValue();
      } else if (GetSortedCard(1).GetValue() == GetSortedCard(2).GetValue()) {
        i = GetSortedCard(1).GetValue();
      } else if (GetSortedCard(2).GetValue() == GetSortedCard(3).GetValue()) {
        i = GetSortedCard(2).GetValue();
      } else if (GetSortedCard(3).GetValue() == GetSortedCard(4).GetValue()) {
        i = GetSortedCard(3).GetValue();
      } else {
        i = 0;
      }
      return i;
    }
  }
  
  private class PokerTable
  {
    private static final int kStartMoney = 100;
    private static final int kMoneyLose = 1;
    private static final int kSelectionNone = 0;
    private static final int kSelectionCard1 = 1;
    private static final int kSelectionCard2 = 2;
    private static final int kSelectionCard3 = 3;
    private static final int kSelectionCard4 = 4;
    private static final int kSelectionCard5 = 5;
    private static final int kSelectionDeal = 6;
    private static final int kSelectionNew = 7;
    private static final int kSelectionHelp = 8;
    private static final int kNumLastSelection = 8;
    private static final int kTableStateDraw = 1;
    private static final int kTableStateDeal = 2;
    private static final int kGameStateGame = 1;
    private static final int kGameStateIntro = 2;
    private static final int kGameStateWaitClick = 3;
    private int money;
    private int currentSelection;
    private Poker.PokerDeck deck;
    private Poker.PokerHand userHand;
    private int tableState;
    private int gameState;
    private Applet applet;
    
    public PokerTable(Applet paramApplet)
    {
      this.deck = new Poker.PokerDeck(Poker.this);
      this.userHand = new Poker.PokerHand(Poker.this, paramApplet);
      this.applet = paramApplet;
      this.currentSelection = 6;
      this.money = 100;
      this.tableState = 1;
      this.gameState = 3;
      Deal();
    }
    
    public void SetGameState(int paramInt)
    {
      this.gameState = paramInt;
    }
    
    private void NewDeck()
    {
      this.deck = new Poker.PokerDeck(Poker.this);
    }
    
    public void Deal()
    {
      switch (this.tableState)
      {
      case 1: 
        RemoveMoney();
        
        NewDeck();
        
        this.userHand.Empty();
        for (int i = 0; i < 5; i++) {
          this.userHand.AddCard(this.deck.GetCard());
        }
        this.tableState = 2;
        break;
      case 2: 
        DealMissing();
        
        CheckCombo();
        this.tableState = 1;
        break;
      }
    }
    
    public void DealMissing()
    {
      for (int i = 0; i < 5; i++) {
        if (Poker.PokerHand.access$800(this.userHand, i).GetStatus() == 3) {
          this.userHand.SetCard(i, this.deck.GetCard());
        }
      }
    }
    
    public void DrawHand()
    {
      this.userHand.Draw();
    }
    
    public void CheckCombo()
    {
      this.userHand.CheckCombo();
      AddMoney();
    }
    
    public void RemoveMoney()
    {
      this.money -= 1;
    }
    
    public int GetMoney()
    {
      return this.money;
    }
    
    public void SetMoney(int paramInt)
    {
      this.money = paramInt;
    }
    
    public void AddMoney()
    {
      int i;
      switch (this.userHand.GetCombo())
      {
      case 0: 
        i = 800;
        break;
      case 1: 
        i = 50;
        break;
      case 2: 
        i = 25;
        break;
      case 3: 
        i = 8;
        break;
      case 4: 
        i = 5;
        break;
      case 5: 
        i = 4;
        break;
      case 6: 
        i = 3;
        break;
      case 7: 
        i = 2;
        break;
      case 8: 
        i = 1;
        break;
      case 9: 
        i = 0;
        break;
      default: 
        i = 0;
      }
      this.money += i;
    }
    
    public void DrawSelection()
    {
      Color localColor = Color.cyan;
      int i = 15;
      int j = 30;
      int k = 50;
      
      int i1 = 5;
      int i2 = 2;
      int i3 = 10;
      int i4 = 32;
      
      int i7 = 3;
      
      Poker.this.GetOffscreen().setColor(localColor);
      int m;
      int n;
      int i5;
      int i6;
      switch (this.currentSelection)
      {
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
        m = 30;
        n = 14;
        
        i5 = i + (this.currentSelection - 1) * (j + i) - i7;
        i6 = k + 40 + 10 - i7;
        
        Poker.this.GetOffscreen().fillRect(i5, i6, m + 2 * i7, n + 2 * i7);
        break;
      case 6: 
        m = 40;
        n = 20;
        
        i5 = 20 - i7;
        i6 = 130 - i7;
        Poker.this.GetOffscreen().fillRect(i5, i6, m + 2 * i7, n + 2 * i7);
        break;
      case 7: 
        m = 40;
        n = 20;
        
        i5 = 130 - i7;
        i6 = 130 - i7;
        Poker.this.GetOffscreen().fillRect(i5, i6, m + 2 * i7, n + 2 * i7);
        break;
      case 8: 
        m = 40;
        n = 20;
        
        i5 = 180 - i7;
        i6 = 130 - i7;
        Poker.this.GetOffscreen().fillRect(i5, i6, m + 2 * i7, n + 2 * i7);
        break;
      }
    }
    
    public void DrawUI()
    {
      Color localColor = Color.white;
      
      int k = 15;
      int m = 30;
      int n = 50;
      int i1 = 5;
      int i2 = 2;
      int i3 = 10;
      int i4 = 32;
      String str1 = "";
      
      int i = 20;
      int j = 130;
      if (this.tableState == 2) {
        Poker.this.GetOffscreen().drawImage(Poker.this.imageDrawButton, i, j, this.applet);
      } else if (this.tableState == 1) {
        Poker.this.GetOffscreen().drawImage(Poker.this.imageDealButton, i, j, this.applet);
      }
      i = 130;
      Poker.this.GetOffscreen().drawImage(Poker.this.imageNewButton, i, j, this.applet);
      i = 180;
      Poker.this.GetOffscreen().drawImage(Poker.this.imageHelpButton, i, j, this.applet);
      if (this.tableState == 1)
      {
        i = 15;
        j = 110;
        Poker.this.GetOffscreen().setColor(localColor);
        
        str1 = this.userHand.GetResultString() + " (+" + this.userHand.GetResultWinString() + ")";
        Poker.this.GetOffscreen().drawString(str1, i, j);
      }
      else if (this.tableState == 2)
      {
        for (int i5 = 0; i5 < 5; i5++)
        {
          String str2 = "";
          String str3 = "";
          i = k + i5 * (m + k);
          j = n + 40 + 10;
          if (Poker.PokerHand.access$800(this.userHand, i5).GetStatus() == 2) {
            Poker.this.GetOffscreen().drawImage(Poker.this.imageHoldButtonOn, i, j, this.applet);
          } else if (Poker.PokerHand.access$800(this.userHand, i5).GetStatus() == 3) {
            Poker.this.GetOffscreen().drawImage(Poker.this.imageHoldButtonOff, i, j, this.applet);
          }
        }
      }
      i = 15;
      j = 20;
      Poker.this.GetOffscreen().setColor(localColor);
      Poker.this.GetOffscreen().drawString("Wallet: $ " + this.money, i, j);
    }
    
    public void MakeSelection()
    {
      switch (this.currentSelection)
      {
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
        if (Poker.PokerHand.access$800(this.userHand, this.currentSelection - 1).GetStatus() == 2) {
          Poker.PokerHand.access$800(this.userHand, this.currentSelection - 1).SetStatus(3);
        } else if (Poker.PokerHand.access$800(this.userHand, this.currentSelection - 1).GetStatus() == 3) {
          Poker.PokerHand.access$800(this.userHand, this.currentSelection - 1).SetStatus(2);
        }
        break;
      case 6: 
        Deal();
        break;
      case 7: 
        NewGame();
        break;
      case 8: 
        ShowHelp();
        break;
      }
    }
    
    private void NewGame()
    {
      Poker.this.table = new PokerTable(Poker.this, this.applet);
    }
    
    private void ShowHelp()
    {
      Poker.this.table.SetGameState(2);
    }
    
    public void MoveSelection(int paramInt)
    {
      this.currentSelection += paramInt;
      if (this.tableState == 1)
      {
        if (this.currentSelection > 8) {
          this.currentSelection = 6;
        }
        if (this.currentSelection < 6) {
          this.currentSelection = 8;
        }
      }
      else if (this.tableState == 2)
      {
        if (this.currentSelection > 8) {
          this.currentSelection = 1;
        }
        if (this.currentSelection < 1) {
          this.currentSelection = 8;
        }
      }
    }
  }
  
  private class PokerCanvas
    extends Canvas
  {
    private int screenWidth;
    private int screenHeight;
    private Applet applet;
    
    public PokerCanvas(Applet paramApplet)
    {
      this.screenWidth = 240;
      this.screenHeight = 160;
      
      this.applet = paramApplet;
    }
    
    protected void keyPressed(int paramInt)
    {
      switch (Poker.PokerTable.access$000(Poker.this.table))
      {
      case 2: 
        Poker.this.table.SetGameState(1);
        break;
      case 1: 
        switch (paramInt)
        {
        case 1: 
          Poker.this.table.MoveSelection(-1);
          break;
        case 6: 
          Poker.this.table.MoveSelection(1);
          break;
        case 10: 
        case 32: 
          Poker.this.table.MakeSelection();
        }
        break;
      }
    }
    
    public void paint(Graphics paramGraphics)
    {
      Poker.this.SetGraphics(paramGraphics);
      switch (Poker.PokerTable.access$000(Poker.this.table))
      {
      case 3: 
        DrawWaitClick();
        break;
      case 2: 
        DrawIntro();
        break;
      case 1: 
        ClearScreen();
        
        Poker.this.table.DrawSelection();
        
        Poker.this.table.DrawHand();
        
        Poker.this.table.DrawUI();
        break;
      }
    }
    
    private void ClearScreen()
    {
      Poker.this.GetOffscreen().drawImage(Poker.this.imageTableBackground, 0, 0, this.applet);
    }
    
    private void DrawWaitClick()
    {
      Poker.this.GetOffscreen().drawImage(Poker.this.imageWaitClick, 0, 0, this.applet);
    }
    
    private void DrawIntro()
    {
      Poker.this.GetOffscreen().drawImage(Poker.this.imageIntroScreen, 0, 0, this.applet);
    }
  }
}
