import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.*; // test
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JFrame
{
	private JList leftlist;
	private JList rightlist;
	private JButton movebutton;
	private JButton movebuttonright;
	private static String[] foods = {"noodles","chicken","beef","apple","orange"};
	//
	private static String[] foods2 = {}; // test
	private static LinkedList<String> foodslist = new LinkedList<String>(Arrays.asList(foods)); // test
	private static LinkedList<String> foodslist2 = new LinkedList<String>(Arrays.asList(foods2)); // test
	//

	public GUI()
	{
		super("Title");
		setLayout(new FlowLayout());
		
		leftlist = new JList(foods);
		leftlist.setVisibleRowCount(7);
		leftlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(leftlist));
		
		movebutton = new JButton("Move -->");
		movebutton.addActionListener(
			new ActionListener()
			{
				// String[] temp;
				public void actionPerformed(ActionEvent event)
				{
					// rightlist.setListData(leftlist.getSelectedValues());
					int[] indx = leftlist.getSelectedIndices();
					
					foodslist = new LinkedList<String>(Arrays.asList(foods));
					foodslist2 = new LinkedList<String>(Arrays.asList(foods2));
					
					Arrays.sort(indx);
					for(int x =0; x < indx.length; x++)
					{
						if (x>0) {
							indx[x] -= x;
						}
						// System.out.println(indx[x]);
						foodslist2.add(foodslist.get(indx[x]));
						//System.out.println(foodslist.get(x));
						foodslist.remove(indx[x]);
					}
					
					/*
					Arrays.sort(indx);
					for(int x = indx.length-1; x >=0; x--)
					{
						// System.out.println(indx[x]);
						foodslist2.add(foodslist.get(indx[x]));
						//System.out.println(foodslist.get(x));
						foodslist.remove(indx[x]);
					}
					*/
														
					foods = foodslist.toArray(new String[foodslist.size()]);
					foods2 = foodslist2.toArray(new String[foodslist2.size()]);
					
					// System.out.printf("left to right foods %s\n" , foods);
					// System.out.printf("left to right foods2 %s\n" , foods2);
					// System.out.println("left to right foodslist " + foodslist);
					// System.out.println("left to right foodslist2 " + foodslist2);
					
					leftlist.setListData(foods);
					rightlist.setListData(foods2);
					
					
				}
			}
		);
		add(movebutton);
		// add(movebutton, BorderLayout.CENTER);
		
		movebuttonright = new JButton("Move <--");
		movebuttonright.addActionListener(
			new ActionListener()
			{
				// String[] temp;
				public void actionPerformed(ActionEvent event)
				{
					// rightlist.setListData(leftlist.getSelectedValues());
					int[] indx = rightlist.getSelectedIndices();
					
					foodslist = new LinkedList<String>(Arrays.asList(foods));
					foodslist2 = new LinkedList<String>(Arrays.asList(foods2));
					
					Arrays.sort(indx);
					for(int x =0; x < indx.length; x++)
					{
						if (x>0) {
							indx[x] -= x;
							// System.out.println(indx[x]);
						}
						// System.out.println(x);
						foodslist.add(foodslist2.get(indx[x]));
						//System.out.println(foodslist.get(x));
						foodslist2.remove(indx[x]);
					}
					
					
					foods = foodslist.toArray(new String[foodslist.size()]);
					foods2 = foodslist2.toArray(new String[foodslist2.size()]);
					
					// System.out.println("right to left foods " + foods);
					// System.out.println("right to left foods2 " + foods2);
					// System.out.println("right to left foodslist " + foodslist);
					// System.out.println("right to left foodslist2 " + foodslist2);
													
					leftlist.setListData(foods);
					rightlist.setListData(foods2);
					
					
				}
			}
		);
		
		add(movebuttonright);
		// add(movebuttonright, BorderLayout.SOUTH);
		
		rightlist = new JList();
		rightlist.setVisibleRowCount(7);
		rightlist.setFixedCellWidth(100);
		rightlist.setFixedCellHeight(15);
		rightlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(rightlist));
		
	}
}
