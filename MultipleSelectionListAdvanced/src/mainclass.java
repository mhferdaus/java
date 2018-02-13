import javax.swing.JFrame;

public class mainclass
{
	public static void main(String[] args)
	{
		GUI go = new GUI();
		go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		go.setSize(500,200);
		go.setVisible(true);
	}
}
