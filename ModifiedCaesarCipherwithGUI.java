import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.JTextField;

public class ModifiedCaesarCipherwithGUI {


	public static void main(String[] args) {
		
		String PlainText, kLine;
		
		
		PlainText = JOptionPane.showInputDialog("Enter Plain Text");
		
				
		kLine = JOptionPane.showInputDialog("Permute Key");
		
		///////////////
		StringTokenizer st = new StringTokenizer(kLine," ");
		int Size = 0;
		ArrayList<Integer> EncryptionKey = new ArrayList<Integer>();
		while(st.hasMoreElements())
			{	EncryptionKey.add(Integer.parseInt(st.nextToken()));
			 	Size++;
			}
		
		System.out.println("++++++++++++++ENCRYPTING+++++++++=+++++++++");
		System.out.println("PlainText                          : "+PlainText);
		PlainText = PlainText.replace(" ","");
		System.out.println("1st Formatting                     : "+PlainText);
		
		int keyS = Size;
		int PlainTextSize = PlainText.length();
		
		for(int m = PlainTextSize; m < 100000; m++)
		{
			if(m % Size == 0)
			{	
				break;
			}
			else
			{	
				PlainText = PlainText + "z";
				
			}
		}
		System.out.println("Final Formatted PlainText                : "+PlainText);
		
		ArrayList<String> ArrayList1 = new ArrayList<String>();
		ArrayList<String> ArrayList2 = new ArrayList<String>();
		System.out.println("After writing in Row by Row ");
		
		String str = "";
		for(int i=1; i < PlainText.length()+1; i++)
		{	
			str += PlainText.charAt(i-1);
			System.out.print(PlainText.charAt(i-1)+" ");
			if( i % Size == 0 && i != 0)
			{
				System.out.println();
				ArrayList1.add(str);
				str = "";
			}
		}
		System.out.println("After Permute the Text   ");
		
		for(int i = 0; i < ArrayList1.size(); i++)
		{	for(int j =0; j < EncryptionKey.size(); j++)
			{	System.out.print(ArrayList1.get(i).charAt(EncryptionKey.get(j)-1)+" ");
			}
			System.out.println();
		}
		String EncryptionRound1 = "";
		String EncryptionRound2 = "";
		
		System.out.println("After writing Column by Column         ");
		
		for(int i = 0; i < keyS; i++)
		{	
			for(int j =0; j < ArrayList1.size(); j++)
			{	EncryptionRound1 += ArrayList1.get(j).charAt(EncryptionKey.get(i)-1);
				System.out.print(ArrayList1.get(j).charAt(EncryptionKey.get(i)-1)+" ");
			}
			System.out.println();
		}
		System.out.println("\nRound One : "+EncryptionRound1);
		
		System.out.println("After writing Row by Row   ");
		
		for(int k=1; k < EncryptionRound1.length()+1; k++)
		{	
			str += EncryptionRound1.charAt(k-1);
			System.out.print(EncryptionRound1.charAt(k-1)+" ");
			if( k % Size == 0 && k != 0)
			{
				System.out.println();
				ArrayList2.add(str);
				str = "";
			}
		}
		
		
		System.out.println("After Permute the Text       ");
		
		for(int i = 0; i < ArrayList2.size(); i++)
		{	for(int j =0; j < EncryptionKey.size(); j++)
			{	System.out.print(ArrayList2.get(i).charAt(EncryptionKey.get(j)-1)+" ");
			}
			System.out.println();
		}

		System.out.println("After Writing Column byb Column ");
		
		for(int i = 0; i < keyS; i++)
		{	
			for(int j =0; j < ArrayList2.size(); j++)
			{	EncryptionRound2 += ArrayList2.get(j).charAt(EncryptionKey.get(i)-1);
				System.out.print(ArrayList2.get(j).charAt(EncryptionKey.get(i)-1)+" ");
			}
			System.out.println();
		}
		System.out.println("\n Round Two : "+EncryptionRound2);
		
		System.out.println("++++++++++++++++++++++++++ DECRYPTING ++++++++++++++++++++++");
		
		String EncryptedText = EncryptionRound2;
		System.out.println("Encrypted Text : "+EncryptedText);
		
		int[] Encryption_Key = new int[EncryptionKey.size()];
		int[] Decryption_key = new int[EncryptionKey.size()];
		System.out.print("Decryption Key : ");
		for(int i =0; i < EncryptionKey.size(); i++)
		{	Encryption_Key[i] = EncryptionKey.get(i);
			Decryption_key[EncryptionKey.get(i)-1] = i+1;
		}
		for(int i=0; i < Decryption_key.length; i++)
		{	System.out.print(Decryption_key[i]+" ");	}
		System.out.println();
		System.out.println("After Writing  Column by Column     ");
		
		int columnSize = Decryption_key.length;
		int SizeofRow = EncryptedText.length() / columnSize;
		ArrayList<String> al3 = new ArrayList<String>();
		
		String TemporaryString = "";
		
		for(int i =0; i < SizeofRow; i++)
		{
			for(int j = i; j < EncryptedText.length(); j += SizeofRow)
			{	TemporaryString += EncryptedText.charAt(j);
				System.out.print(EncryptedText.charAt(j)+" ");
			}
			System.out.println();
			al3.add(TemporaryString);
			TemporaryString = "";
		}

		System.out.println("After Permute the Text  ");
		String Round1Decryption = "";
		for(int i = 0; i < al3.size(); i++)
		{	
			for(int j =0; j < columnSize; j++)
			{	Round1Decryption += al3.get(i).charAt(Decryption_key[j]-1);
				System.out.print(al3.get(i).charAt(Decryption_key[j]-1)+" ");
			}
			System.out.println();
		}
		
		System.out.println("After Writing Row by Row ");
		
		System.out.println("Decryption Round1 : "+Round1Decryption);
		System.out.println();
		System.out.println("After Writing Column by Column ");
		
		al3 = new ArrayList<String>();
		
		for(int i =0; i < SizeofRow; i++)
		{
			for(int j = i; j < Round1Decryption.length(); j += SizeofRow)
			{	TemporaryString += Round1Decryption.charAt(j);
				System.out.print(Round1Decryption.charAt(j)+" ");
			}
			System.out.println();
			al3.add(TemporaryString);
			TemporaryString = "";
		}
		System.out.println("After Permute the Text  ");
		
		String DecryptionRound2 = "";
		for(int i = 0; i < al3.size(); i++)
		{	
			for(int j =0; j < columnSize; j++)
			{	DecryptionRound2 += al3.get(i).charAt(Decryption_key[j]-1);
				System.out.print(al3.get(i).charAt(Decryption_key[j]-1)+" ");
			}
			System.out.println();
		}
		
		System.out.println("After Writing Row by Row ");
		
		System.out.println("Final Decryption after  Round2 : "+DecryptionRound2);
		
		
		


		
	        String Text_to_Show = "Text After Formatting : "+ PlainText+ "\n \n After Round : "+ 
	        		EncryptionRound1 + "\n \n Final Decrypted Text "+ 
	        		EncryptionRound2 + "\n \n Decryption after round 1 :  "+ 
	        		Round1Decryption + "\n \n Final Decrypted Text : "+
	        		DecryptionRound2;
		
		
		
		//////////////////
		
		
		JOptionPane.showMessageDialog(null,Text_to_Show, "Modified Ceaser Cipher", JOptionPane.PLAIN_MESSAGE );
		
		System.exit(0);
		
	}
}