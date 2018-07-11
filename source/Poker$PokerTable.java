import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

class Poker$PokerTable
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
  private final Poker this$0;
  
  public Poker$PokerTable(Poker paramPoker, Applet paramApplet)
  {
    this.this$0 = paramPoker;
    this.deck = new Poker.PokerDeck(paramPoker);
    this.userHand = new Poker.PokerHand(paramPoker, paramApplet);
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
    this.deck = new Poker.PokerDeck(this.this$0);
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
    
    this.this$0.GetOffscreen().setColor(localColor);
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
      
      this.this$0.GetOffscreen().fillRect(i5, i6, m + 2 * i7, n + 2 * i7);
      break;
    case 6: 
      m = 40;
      n = 20;
      
      i5 = 20 - i7;
      i6 = 130 - i7;
      this.this$0.GetOffscreen().fillRect(i5, i6, m + 2 * i7, n + 2 * i7);
      break;
    case 7: 
      m = 40;
      n = 20;
      
      i5 = 130 - i7;
      i6 = 130 - i7;
      this.this$0.GetOffscreen().fillRect(i5, i6, m + 2 * i7, n + 2 * i7);
      break;
    case 8: 
      m = 40;
      n = 20;
      
      i5 = 180 - i7;
      i6 = 130 - i7;
      this.this$0.GetOffscreen().fillRect(i5, i6, m + 2 * i7, n + 2 * i7);
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
      this.this$0.GetOffscreen().drawImage(Poker.access$900(this.this$0), i, j, this.applet);
    } else if (this.tableState == 1) {
      this.this$0.GetOffscreen().drawImage(Poker.access$1000(this.this$0), i, j, this.applet);
    }
    i = 130;
    this.this$0.GetOffscreen().drawImage(Poker.access$1100(this.this$0), i, j, this.applet);
    i = 180;
    this.this$0.GetOffscreen().drawImage(Poker.access$1200(this.this$0), i, j, this.applet);
    if (this.tableState == 1)
    {
      i = 15;
      j = 110;
      this.this$0.GetOffscreen().setColor(localColor);
      
      str1 = this.userHand.GetResultString() + " (+" + this.userHand.GetResultWinString() + ")";
      this.this$0.GetOffscreen().drawString(str1, i, j);
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
          this.this$0.GetOffscreen().drawImage(Poker.access$1300(this.this$0), i, j, this.applet);
        } else if (Poker.PokerHand.access$800(this.userHand, i5).GetStatus() == 3) {
          this.this$0.GetOffscreen().drawImage(Poker.access$1400(this.this$0), i, j, this.applet);
        }
      }
    }
    i = 15;
    j = 20;
    this.this$0.GetOffscreen().setColor(localColor);
    this.this$0.GetOffscreen().drawString("Wallet: $ " + this.money, i, j);
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
    Poker.access$1502(this.this$0, new PokerTable(this.this$0, this.applet));
  }
  
  private void ShowHelp()
  {
    Poker.access$1500(this.this$0).SetGameState(2);
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
