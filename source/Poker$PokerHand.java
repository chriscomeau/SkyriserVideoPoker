import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

class Poker$PokerHand
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
  private final Color kRedTextColor;
  private final Color kBlackTextColor;
  private final Color kBackgroundColor;
  private final Color kCardColor;
  private final Color kCardOutlineColor;
  private Vector handCards;
  private Vector sortedHandCards;
  private int currentCombo;
  private final Poker this$0;
  
  public Poker$PokerHand(Poker paramPoker, Applet paramApplet)
  {
    this.this$0 = paramPoker;this.kRedTextColor = Color.red;this.kBlackTextColor = Color.black;this.kBackgroundColor = Color.green;this.kCardColor = Color.white;this.kCardOutlineColor = Color.black;
    
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
      
      this.this$0.GetOffscreen().drawImage(Poker.access$300(this.this$0), i4, i5, this.applet);
      switch (GetCard(i3).GetFace())
      {
      case 1: 
        this.this$0.GetOffscreen().drawImage(Poker.access$400(this.this$0), i4 + m, i5 + n, this.applet);
        break;
      case 3: 
        this.this$0.GetOffscreen().drawImage(Poker.access$500(this.this$0), i4 + m, i5 + n, this.applet);
        break;
      case 2: 
        this.this$0.GetOffscreen().drawImage(Poker.access$600(this.this$0), i4 + m, i5 + n, this.applet);
        break;
      case 4: 
        this.this$0.GetOffscreen().drawImage(Poker.access$700(this.this$0), i4 + m, i5 + n, this.applet);
        break;
      }
      if ((GetCard(i3).GetFace() == 1) || (GetCard(i3).GetFace() == 3)) {
        this.this$0.GetOffscreen().setColor(this.kRedTextColor);
      } else {
        this.this$0.GetOffscreen().setColor(this.kBlackTextColor);
      }
      str2 = GetCard(i3).GetValueString();
      
      this.this$0.GetOffscreen().drawString(GetCard(i3).GetValueString(), i4 + i1, i5 + i2);
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
