/*
 * 8085 Simulator
 */
import java.util.*;
public class Microprocessor {
		static String decitohexa(int num)
		{
			String s;
			s=Integer.toHexString(num);
			s=s.replace('a', 'A');
			s=s.replace('b', 'B');
			s=s.replace('c', 'C');
			s=s.replace('d', 'D');
			s=s.replace('e', 'E');
			s=s.replace('f', 'F');
			return(s);
		}
		static int convert(String str)
		{
			int i,ln,num=0,j=0;
			char ch;
			ln=str.length();
			for(i=ln-1;i>=0;i--)
			{
				ch=str.charAt(i);
				if(ch!='0'&&ch!='1'&&ch!='2'&&ch!='3'&&ch!='4'&&ch!='5'&&ch!='6'&&ch!='7'&&ch!='8'&&ch!='9'&&ch!='A'&&ch!='B'&&ch!='C'&&ch!='D'&&ch!='E'&&ch!='F')
					return(0);
			}
			for(i=ln-1;i>=0;i--)
			{
				ch=str.charAt(i);
				if(ch=='0')
					num+=0*Math.pow(16, j);
				if(ch=='1')
					num+=1*Math.pow(16, j);
				if(ch=='2')
					num+=2*Math.pow(16, j);
				if(ch=='3')
					num+=3*Math.pow(16, j);
				if(ch=='4')
					num+=4*Math.pow(16, j);
				if(ch=='5')
					num+=5*Math.pow(16, j);
				if(ch=='6')
					num+=6*Math.pow(16, j);
				if(ch=='7')
					num+=7*Math.pow(16, j);
				if(ch=='8')
					num+=8*Math.pow(16, j);
				if(ch=='9')
					num+=9*Math.pow(16, j);
				if(ch=='A')
					num+=10*Math.pow(16, j);
				if(ch=='B')
					num+=11*Math.pow(16, j);
				if(ch=='C')
					num+=12*Math.pow(16, j);
				if(ch=='D')
					num+=13*Math.pow(16, j);
				if(ch=='E')
					num+=14*Math.pow(16, j);
				if(ch=='F')
					num+=15*Math.pow(16, j);
				j++;
			}
			if(num>16383||num<8192)
				return(0);
			else
			return(num);
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sr=new Scanner(System.in);
			String str,s;
			char prog[][]=new char[500][50];
			HexcodeInsert ob=new HexcodeInsert();
			int i,j=0,inc,x=0,start,k;//res
			String memory[]=new String[20000];
			for(i=0;i<20000;i++)
				memory[i]="";
			System.out.println("Enter Starting Memory Location");
			do
			{
				str=sr.next();
				if(str.length()==4)
					i=convert(str);
				else
					i=0;
				if(i==0)
					System.out.println("Wrong Input...Enter again");	
			}while(i==0);
			start=i;
			j=0;
			System.out.println("Start Writing Program And Type QUIT To Stop");
			sr.nextLine();
			for(;;)
			{
				s=decitohexa(i);
				System.out.print(s+" :");
				str=sr.nextLine();
				if(str.equals("QUIT"))
					break;
				else
				{
					s=s+":";
					inc=ob.stringInsert(str, memory, i);
					if(inc!=0)
					{
						s=s+str;
						prog[j]=s.toCharArray();
						j++;
					}
					i+=inc;
				}
			}
			Execution ae=new Execution();
			do
			{
				System.out.println("PRESS 1 TO INPUT DATA AT MEMORY");
				System.out.println("PRESS 2 TO SEE DATA AT MEMORY");
				System.out.println("PRESS 3 TO EXECUTE THE CODE");
				System.out.println("PRESS 4 TO EXIT");
				String choice=sr.next();
				switch(choice)
				{
				case "1":  System.out.println("ENTER MEMORY LOCATION");
							do
							{
								str=sr.next();
								i=convert(str);
								if(i==0)
									System.out.println("Enter Memory Location Again");
							}while(i==0);
							do
							{
								s=Microprocessor.decitohexa(i);
								System.out.print(s+" :");
								str=sr.next();
								if(str.length()==2)
								{
									//k=ob.valueInsert(str, memory, i);
									memory[i]=str;
									//if(k==1)
										break;
								}
								else
									System.out.println("WRONG INPUT ENTER AGAIN");
							}while(true);
							break;
				
				case "2":	System.out.println("ENTER MEMORY LOCATION");
							do
							{
								str=sr.next();
								i=convert(str);
								if(i==0)
									System.out.println("Enter Memory Location Again");
							}while(i==0);
							//do
							//{
								s=Microprocessor.decitohexa(i);
								System.out.println(s+" :"+memory[i]);
								//i=i+1;
								//System.out.println("TYPE QUIT TO RESET OR PRESS ENTER");
								//str=sr.next();
								//if(str.equals("QUIT"))
									break;
							//}while(true);
							//break;	
				case "3": 
						  ae.execute(memory,start);
						  ae.show();
						  break;
				}
				if(choice.equals("4"))
					break;
			}while(true);
			sr.close();
	}

}
