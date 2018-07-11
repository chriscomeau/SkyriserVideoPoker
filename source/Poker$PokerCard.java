class Poker$PokerCard
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
  private final Poker this$0;
  
  public Poker$PokerCard(Poker paramPoker, int paramInt1, int paramInt2)
  {
    this.this$0 = paramPoker;
    
    this.face = paramInt1;
    this.value = paramInt2;
    this.status = 1;
  }
  
  public Poker$PokerCard(Poker paramPoker)
  {
    this.this$0 = paramPoker;
    
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
