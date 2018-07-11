import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Graphics;

class Poker$PokerCanvas
  extends Canvas
{
  private int screenWidth;
  private int screenHeight;
  private Applet applet;
  private final Poker this$0;
  
  public Poker$PokerCanvas(Poker paramPoker, Applet paramApplet)
  {
    this.this$0 = paramPoker;
    
    this.screenWidth = 240;
    this.screenHeight = 160;
    
    this.applet = paramApplet;
  }
  
  protected void keyPressed(int paramInt)
  {
    switch (Poker.PokerTable.access$000(Poker.access$1500(this.this$0)))
    {
    case 2: 
      Poker.access$1500(this.this$0).SetGameState(1);
      break;
    case 1: 
      switch (paramInt)
      {
      case 1: 
        Poker.access$1500(this.this$0).MoveSelection(-1);
        break;
      case 6: 
        Poker.access$1500(this.this$0).MoveSelection(1);
        break;
      case 10: 
      case 32: 
        Poker.access$1500(this.this$0).MakeSelection();
      }
      break;
    }
  }
  
  public void paint(Graphics paramGraphics)
  {
    this.this$0.SetGraphics(paramGraphics);
    switch (Poker.PokerTable.access$000(Poker.access$1500(this.this$0)))
    {
    case 3: 
      DrawWaitClick();
      break;
    case 2: 
      DrawIntro();
      break;
    case 1: 
      ClearScreen();
      
      Poker.access$1500(this.this$0).DrawSelection();
      
      Poker.access$1500(this.this$0).DrawHand();
      
      Poker.access$1500(this.this$0).DrawUI();
      break;
    }
  }
  
  private void ClearScreen()
  {
    this.this$0.GetOffscreen().drawImage(Poker.access$1600(this.this$0), 0, 0, this.applet);
  }
  
  private void DrawWaitClick()
  {
    this.this$0.GetOffscreen().drawImage(Poker.access$1700(this.this$0), 0, 0, this.applet);
  }
  
  private void DrawIntro()
  {
    this.this$0.GetOffscreen().drawImage(Poker.access$1800(this.this$0), 0, 0, this.applet);
  }
}
