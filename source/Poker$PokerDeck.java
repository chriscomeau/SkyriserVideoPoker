import java.util.Random;
import java.util.Vector;

class Poker$PokerDeck
{
  private static final int kCardPerDeck = 52;
  private int nextCard;
  private Vector list;
  private int kNumDecks;
  private final Poker this$0;
  
  public Poker$PokerDeck(Poker paramPoker)
  {
    this.this$0 = paramPoker;this.kNumDecks = 1;
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
          Poker.PokerCard localPokerCard = new Poker.PokerCard(this.this$0);
          
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
