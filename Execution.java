
public class Execution {
		int A,F,B,C,D,E,H,L,SP,PC,TOP,cy=0,sf=0,zf=0,ac=0,pf=0,t,te,i,num=0,num1=0,z=0;
		int a1[]=new int[8];
		int a2[]=new int[8];
		char ch1;
		public void dad(int b,int c,int h,int l)
		{
			if((l+c)>255)
			{
				L=(l+c)%256;
				if((h+b+1)>255)
					cy=1;
				H=h+b+1;
				if(H>255)
					cy=1;
				H=H%256;
			}
			else
			{
				L=l+c;
				if((h+b)>255)
					cy=1;
				H=(h+b)%256;
			}
		}
		public int adc(int num,int a)
		{
			String str;
			char ch;
			int res=num+a;
			int i,c=0;
			if(res>255)
			{
				res=res%256;
				cy=1;
				
			}
			else
				cy=0;
			if(res==0)
				zf=1;
			else
				zf=0;
			sf=0;
			str=Integer.toBinaryString(res);
			for(i=0;i<str.length();i++)
			{
				ch=str.charAt(i);
				if(ch=='1')
					c++;
			}
			if(c%2==0)
				pf=1;
			else
				pf=0;
			str=Microprocessor.decitohexa(num);
			if(str.length()<2)
				str="0"+str;
			str="0x"+str.charAt(1);
			num=Integer.decode(str);
			str=Microprocessor.decitohexa(a);
			if(str.length()<2)
				str="0"+str;
			str="0x"+str.charAt(1);
			a=Integer.decode(str);
			if(a+num>15)
				ac=1;
			else
				ac=0;
			return res;
		}
		public int add(int num,int a)
		{
			String str;
			char ch;
			int res=num+a;
			int i,c=0;
			if(res>255)
			{
				res=res%256;
				cy=1;
			}
			else
				cy=0;
			if(res==0)
				zf=1;
			else
				zf=0;
			sf=0;
			str=Integer.toBinaryString(res);
			for(i=0;i<str.length();i++)
			{
				ch=str.charAt(i);
				if(ch=='1')
					c++;
			}
			if(c%2==0)
				pf=1;
			else
				pf=0;
			str=Microprocessor.decitohexa(num);
			if(str.length()<2)
				str="0"+str;
			str="0x"+str.charAt(1);
			num=Integer.decode(str);
			str=Microprocessor.decitohexa(a);
			if(str.length()<2)
				str="0"+str;
			str="0x"+str.charAt(1);
			a=Integer.decode(str);
			if(a+num>15)
				ac=1;
			else
				ac=0;
			return res;
		}
		public int addnflag(int num,int a)
		{
			int res=num+a;
			res=res%256;
			return res;
		}
		public int addncy(int num,int a)
		{
			String str;
			char ch;
			int res=num+a;
			int i,c=0;
			res=res%256;
			if(res==0)
				zf=1;
			else
				zf=0;
			sf=0;
			str=Integer.toBinaryString(res);
			for(i=0;i<str.length();i++)
			{
				ch=str.charAt(i);
				if(ch=='1')
					c++;
			}
			if(c%2==0)
				pf=1;
			else
				pf=0;
			str=Microprocessor.decitohexa(num);
			if(str.length()<2)
				str="0"+str;
			str="0x"+str.charAt(1);
			num=Integer.decode(str);
			str=Microprocessor.decitohexa(a);
			if(str.length()<2)
				str="0"+str;
			str="0x"+str.charAt(1);
			a=Integer.decode(str);
			if(a+num>15)
				ac=1;
			else
				ac=0;
			return res;
		}
		public int sub(int num,int a)
		{
			String str;
			char ch;
			int res=num-a;
			int i,c=0;
			if(res<0)
			{
				sf=1;
				cy=1;
			}
			else
			{
				sf=0;
				cy=0;
			}
			if(res==0)
				zf=1;
			else
				zf=0;
			str=Integer.toBinaryString(res);
			for(i=0;i<str.length();i++)
			{
				ch=str.charAt(i);
				if(ch=='1')
					c++;
			}
			if(c%2==0)
				pf=1;
			else
				pf=0;	
			ac=0;
			if(res<0)
				res=res*-1;
			return res;
		}
		public int subncy(int num,int a)
		{
			System.out.println("CAME IN SUBNCY RES IS ");
			String str;
			char ch;
			int res=num-a;
			int i,c=0;
			if(res<0)
				sf=1;
			else
				sf=0;
			if(res==0)
				zf=1;
			else
				zf=0;
			str=Integer.toBinaryString(res);
			for(i=0;i<str.length();i++)
			{
				ch=str.charAt(i);
				if(ch=='1')
					c++;
			}
			if(c%2==0)
				pf=1;
			else
				pf=0;	
			ac=0;
			if(res<0)
				res=res*-1;
			System.out.println("res after subncy is "+res);
			return res;
		}
		public int sbb(int num,int a)
		{
			String str;
			char ch;
			int res=num-a-cy;
			int i,c=0;
			if(res<0)
			{
				sf=1;
				cy=1;
			}
			else
			{
				sf=0;
				cy=0;
			}
			if(res==0)
				zf=1;
			else
				zf=0;
			str=Integer.toBinaryString(res);
			for(i=0;i<str.length();i++)
			{
				ch=str.charAt(i);
				if(ch=='1')
					c++;
			}
			if(c%2==0)
				pf=1;
			else
				pf=0;	
			ac=0;
			if(res<0)
				res=res*-1;
			return res;
		}
		public void dcx(int b,int c)
		{
			if(c>0)
				C=C-1;
			else
			{
				C=255;
				B=B-1;
			}
		}
		public void bit(String s1,String s2)
		{
			//System.out.println("string 1 is "+s1+"string 2 is "+s2);
			String t="",st1,st2;
			int n1,n2,i=0,j,k=0,ln1,ln2;
			if(s1.length()<2)
				s1="0"+s1;
			if(s2.length()<2)
				s2="0"+s2;
			char ch1,ch2;
			for(j=0;j<2;j++)
			{
				ch1=s1.charAt(j);
				ch2=s2.charAt(j);
				st1="0x"+ch1;
				st2="0x"+ch2;
				n1=Integer.decode(st1);
				n2=Integer.decode(st2);
				st1=Integer.toBinaryString(n1);
				ln1=st1.length();
				if(ln1==1)
					st1="000"+st1;
				if(ln1==2)
					st1="00"+st1;
				if(ln1==3)
					st1="0"+st1;
				st2=Integer.toBinaryString(n2);
				ln2=st2.length();
				if(ln2==1)
					st2="000"+st2;
				if(ln2==2)
					st2="00"+st2;
				if(ln2==3)
					st2="0"+st2;
				//System.out.print(st1+" ");
				for(i=0;i<st1.length();i++)
				{
					ch1=st1.charAt(i);
					t="0x"+ch1;
					a1[i+k]=Integer.decode(t);
					ch2=st2.charAt(i);
					t="0x"+ch2;
					a2[i+k]=Integer.decode(t);
				}
				k=4;
			}
		}
		public void ana()
		{
			for(int i=0;i<8;i++)
			{
				a1[i]=a1[i]&a2[i];
			}
			A=(a1[0]*8+a1[1]*4+a1[2]*2+a1[3])*16+(a1[4]*8+a1[5]*4+a1[6]*2+a1[7]);
		}
		public void xra()
		{
			for(int i=0;i<8;i++)
			{
				a1[i]=a1[i]^a2[i];
			}
			A=(a1[0]*8+a1[1]*4+a1[2]*2+a1[3])*16+(a1[4]*8+a1[5]*4+a1[6]*2+a1[7]);
		}
		public void ora()
		{
			for(int i=0;i<8;i++)
			{
				a1[i]=a1[i]|a2[i];
			}
			A=(a1[0]*8+a1[1]*4+a1[2]*2+a1[3])*16+(a1[4]*8+a1[5]*4+a1[6]*2+a1[7]);
		}
		public void cma()
		{
			for(int i=0;i<8;i++)
			{
				if(a1[i]==1)
					a1[i]=0;
				else
					a1[i]=1;
			}
			A=(a1[0]*8+a1[1]*4+a1[2]*2+a1[3])*16+(a1[4]*8+a1[5]*4+a1[6]*2+a1[7]);
		}
		public void rlc()
		{
			cy=a1[0];
			for(int i=0;i<7;i++)
			{
				a1[i]=a1[i+1];
			}
			a1[7]=cy;
			A=(a1[0]*8+a1[1]*4+a1[2]*2+a1[3])*16+(a1[4]*8+a1[5]*4+a1[6]*2+a1[7]);
		}
		public void ral()
		{
			int t=cy;
			cy=a1[0];
			for(int i=0;i<7;i++)
			{
				a1[i]=a1[i+1];
			}
			a1[7]=t;
			A=(a1[0]*8+a1[1]*4+a1[2]*2+a1[3])*16+(a1[4]*8+a1[5]*4+a1[6]*2+a1[7]);
		}
		public void rrc()
		{
			cy=a1[7];
			for(int i=7;i>0;i--)
			{
				a1[i]=a1[i-1];
			}
			a1[0]=cy;
			A=(a1[0]*8+a1[1]*4+a1[2]*2+a1[3])*16+(a1[4]*8+a1[5]*4+a1[6]*2+a1[7]);
		}
		public void rar()
		{
			int t=cy;
			cy=a1[7];
			for(int i=7;i>0;i--)
			{
				a1[i]=a1[i-1];
			}
			a1[0]=t;
			A=(a1[0]*8+a1[1]*4+a1[2]*2+a1[3])*16+(a1[4]*8+a1[5]*4+a1[6]*2+a1[7]);
		}
		public void valueInsert(String sub,String memory[],int row)
		{
			int k,t=0;
			//num=Microprocessor.convert(sub);
			for(k=0;k<4;k+=2)
			{
				char ch1=sub.charAt(k);
				memory[row-t]=memory[row-t]+ch1;
				char ch2=sub.charAt(k+1);
				memory[row-t]=memory[row-t]+ch2;
				t--;
			}
			TOP=TOP-2;
		}
		public void show()
		{
			System.out.println("A is "+Microprocessor.decitohexa(A));
			System.out.println("B is "+Microprocessor.decitohexa(B));
			System.out.println("C is "+Microprocessor.decitohexa(C));
			System.out.println("D is "+Microprocessor.decitohexa(D));
			System.out.println("E is "+Microprocessor.decitohexa(E));
			System.out.println("H is "+Microprocessor.decitohexa(H));
			System.out.println("L is "+Microprocessor.decitohexa(L));
			System.out.println("SP is "+Microprocessor.decitohexa(SP));
			System.out.println("PC is "+Microprocessor.decitohexa(PC));
			System.out.println("CY is "+Microprocessor.decitohexa(cy));
			System.out.println("ZF is "+Microprocessor.decitohexa(zf));
			System.out.println("PF is "+Microprocessor.decitohexa(pf));
			System.out.println("AC is "+Microprocessor.decitohexa(ac));
			System.out.println("SF is "+Microprocessor.decitohexa(sf));
		}
		public int execute(String memory[],int row)
		{
			String s1,s2;
			SP=row;
			PC=row;
			while(true)
			{
			String str=memory[SP];
			//System.out.println(str+"hioiiiii");
			String str1="",str2="";
			switch(str)
			{
				case "00": 	PC=SP+1;
							SP=PC;
							break;
				case "01": //LXI B
							PC=SP+3;
							str1="0x"+memory[SP+1];
							str2="0x"+memory[SP+2];
							B=Integer.decode(str1);
							C=Integer.decode(str2);
							SP=PC;
							break;
				case "02": //STAX B		
							PC=SP+1;
							str1=Microprocessor.decitohexa(B)+Microprocessor.decitohexa(C);
							str1="0x"+str1;
							row=Integer.decode(str1);
							str2=Microprocessor.decitohexa(A);
							memory[row]=str2;
							SP=PC;
							break;
				case "03": //INX B
							PC=SP+1;
							C=addnflag(C,1);
							if(C==0)
								B=addnflag(B,1);
							SP=PC;
							break;
				case "04": //INR B
							PC=SP+1;
							B=addncy(B,1);
							SP=PC;
							break;
				case "05": //DCR B
							PC=SP+1;
							B=subncy(B,1);
							SP=PC;
							break;
				case "06": //MVI B
							PC=SP+2;
							str1="0x"+memory[SP+1];
							B=Integer.decode(str1);
							//System.out.println("b is "+B);
							SP=PC;
							break;
				case "07": //RLC
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(A);
							bit(s1,s2);
							rlc();
							SP=PC;
							break;
				case "08": //
				case "09": //DAD B
							PC=SP+1;
							dad(B,C,H,L);
							SP=PC;
							break;
				case "0A": //LDAX B
							PC=SP+1;
							str1=Microprocessor.decitohexa(B)+Microprocessor.decitohexa(C);
							str1="0x"+str1;
							row=Integer.decode(str1);
							str2="0x"+memory[row];
							A=Integer.decode(str2);
							SP=PC;
							break;
				case "0B": //DCX B	
							PC=SP+1;
							dcx(B,C);
							SP=PC;
							break;
				case "0C": //INR C
							PC=SP+1;
							C=addncy(C,1);
							SP=PC;
							break;
				case "0D": //DCR C
					System.out.println("CAME IN DCR C CASE");
							PC=SP+1;
							C=subncy(C,1);
							SP=PC;
							break;
				case "0E": //MVI C
							PC=SP+2;
							str1="0x"+memory[SP+1];
							C=Integer.decode(str1);
							SP=PC;
							break;
				case "0F": //RRC
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(A);
							bit(s1,s2);
							rrc();
							SP=PC;
							break;
				case "10": //
				case "11": //LXI D
							PC=SP+3;
							str1="0x"+memory[SP+1];
							str2="0x"+memory[SP+2];
							D=Integer.decode(str1);
							E=Integer.decode(str2);
							SP=PC;
							break;
				case "12": //STAX D
							PC=SP+1;
							str1=Microprocessor.decitohexa(D)+Microprocessor.decitohexa(E);
							str1="0x"+str1;
							row=Integer.decode(str1);
							str2=Microprocessor.decitohexa(A);
							memory[row]=str2;
							SP=PC;
							break;
				case "13": //INX D
							PC=SP+1;
							E=addnflag(E,1);
							if(E==0)
								D=addnflag(D,1);
							SP=PC;
							break;
				case "14": //INR D	
							PC=SP+1;
							D=addncy(D,1);
							SP=PC;
							break;
				case "15": //DCR D
							PC=SP+1;
							D=subncy(D,1);
							SP=PC;
							break;
				case "16": //MVI D
							PC=SP+2;
							str1="0x"+memory[SP+1];
							D=Integer.decode(str1);
							SP=PC;
							break;
				case "17": //RAL
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(A);
							bit(s1,s2);
							ral();
							SP=PC;
							break;
				case "18": //
				case "19": //DAD D
							PC=SP+1;
							dad(D,E,H,L);
							SP=PC;
							break;
				case "1A": //LDAX D
							PC=SP+1;
							str1=Microprocessor.decitohexa(D)+Microprocessor.decitohexa(E);
							str1="0x"+str1;
							row=Integer.decode(str1);
							str2="0x"+memory[row];
							A=Integer.decode(str2);
							SP=PC;
							break;
				case "1B": //DCX D
							PC=SP+1;
							dcx(D,E);
							SP=PC;
							break;
				case "1C": //INR E
							PC=SP+1;
							E=addncy(E,1);
							SP=PC;
							break;
				case "1D": //DCR E
							PC=SP+1;
							E=subncy(E,1);
							SP=PC;
							break;
				case "1E": //MVI E
							PC=SP+2;
							str1="0x"+memory[SP+1];
							E=Integer.decode(str1);
							SP=PC;
							break;
				case "1F": //RAR
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(A);
							bit(s1,s2);
							rar();
							SP=PC;
							break;
				case "20": //RIM
				case "21": //LXI H
							PC=SP+3;
							str1="0x"+memory[SP+1];
							str2="0x"+memory[SP+2];
							H=Integer.decode(str1);
							L=Integer.decode(str2);
							SP=PC;
							break;
				case "22": //SHLD
							PC=SP+3;
							str1="0x"+memory[SP+1]+memory[SP+2];
							row=Integer.decode(str1);
							str1=Microprocessor.decitohexa(L);
							memory[row]=str1;
							str1=Microprocessor.decitohexa(H);
							memory[row+1]=str1;
							SP=PC;
							break;
				case "23": //INX H
							PC=SP+1;
							L=addnflag(L,1);
							if(L==0)
								H=addnflag(H,1);
							SP=PC;
							break;
				case "24": //INR H	
							PC=SP+1;
							H=addncy(H,1);
							SP=PC;
							break;
				case "25": //DCR H
							PC=SP+1;
							H=subncy(H,1);
							SP=PC;
							break;
				case "26": //MVI H
							PC=SP+2;
							str1="0x"+memory[SP+1];
							H=Integer.decode(str1);
							SP=PC;
							break;
				case "27": //DAA
						/*	str1=Microprocessor.decitohexa(A);
							for(i=0;i<str1.length();i++)
							{
								ch1=str1.charAt(i);
								if(ch1=='A'||ch1=='B'||ch1=='C'||ch1=='D'||ch1=='E'||ch1=='F')
								{
									System.out.println("Not Possible");
									z=1;
									break;
								}
							}
							if(z==0)
							{
								num=A%10;
								if(num>9)
								{
									num+=6;
									num-=16;
								}
								num1=A/10;
								if(num>9)
									num1+=1;
								num=num*10+num1;
								A=num;
							}*/
							break;
				case "28": //
				case "29": //DAD H
							PC=SP+1;
							dad(H,L,H,L);
							SP=PC;
							break;
				case "2A": //LHLD
							PC=SP+3;
							str1="0x"+memory[SP+1]+memory[SP+2];
							row=Integer.decode(str1);
							str1="0x"+memory[row];
							L=Integer.decode(str1);
							str1="0x"+memory[row+1];
							H=Integer.decode(str1);
							SP=PC;
							break;
				case "2B": //DCX H
							PC=SP+1;
							dcx(H,L);
							SP=PC;
							break;
				case "2C": //INR L
							PC=SP+1;
							L=addncy(L,1);
							SP=PC;
							break;
				case "2D": //DCR L
							PC=SP+1;
							L=subncy(L,1);
							SP=PC;
							break;
				case "2E": //MVI L
							PC=SP+2;
							str1="0x"+memory[SP+1];
							L=Integer.decode(str1);
							SP=PC;
							break;
				case "2F": //CMA
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(A);
							bit(s1,s2);
							cma();
							SP=PC;
							break;
				case "30": //SIM
				case "31": //LXI SP
							PC=SP+3;
							str1="0x"+memory[SP+1]+memory[SP+2];
							//System.out.println("value by lxi sp for top  is "+str1);
							TOP=Integer.decode(str1);
							SP=PC;
							break;
				case "32": //STA
							PC=SP+3;
							str1="0x"+memory[SP+1]+memory[SP+2];
							row=Integer.decode(str1);
							str1=Microprocessor.decitohexa(A);
							memory[row]=str1;
							SP=PC;
							break;
				case "33": //INX SP
							PC=PC+1;
							SP=(SP+1)%65535;
							SP=PC;
							break;
				case "34": //INR M	
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							str1="0x"+memory[row];
							t=Integer.decode(str1);
							t=addncy(t,1);
							str1=Microprocessor.decitohexa(t);
							memory[row]=str1;
							SP=PC;
							break;
				case "35": //DCR M
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							str1="0x"+memory[row];
							t=subncy((Integer.decode(str1)),1);
							str1=Microprocessor.decitohexa(t);
							memory[row]=str1;
							SP=PC;
							break;
				case "36": //MVI M
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							memory[row]=memory[SP+1];
							SP=PC;
							break;
				case "37": //STC
							PC=SP+1;
							cy=1;
							SP=PC;
							break;
				case "38": //
				case "39": //DAD SP
				case "3A": //LDA
							PC=SP+3;
							str1="0x"+memory[SP+1]+memory[SP+2];
							row=Integer.decode(str1);
							str1="0x"+memory[row];
							A=Integer.decode(str1);
							SP=PC;
							break;
				case "3B": //DCX SP
							PC=SP+1;
							SP=SP-1;
							SP=PC;
							break;
				case "3C": //INR A
							PC=SP+1;
							A=addncy(A,1);
							SP=PC;
							break;
				case "3D": //DCR A
							PC=SP+1;
							A=subncy(A,1);
							SP=PC;
							break;
				case "3E": //MVI A
							PC=SP+2;
							str1="0x"+memory[SP+1];
							A=Integer.decode(str1);
							//System.out.println("a is "+A);
							SP=PC;
							break;
				case "3F": //CMC
							PC=SP+1;
							if(cy==0)
								cy=1;
							else
								cy=0;
							SP=PC;
							break;
				case "40": //MOV B,B
							PC=SP+1;
							//B=B;
							SP=PC;
							break;
				case "41": //MOV B,C
							PC=SP+1;
							B=C;
							SP=PC;
							break;
				case "42": //MOV B,D
							PC=SP+1;
							B=D;
							SP=PC;
							break;
				case "43": //MOV B,E
							PC=SP+1;
							B=E;
							SP=PC;
							break;
				case "44": //MOV B,H	
							PC=SP+1;
							B=H;
							SP=PC;
							break;
				case "45": //MOV B,L
							PC=SP+1;
							B=L;
							SP=PC;
							break;
				case "46": //MOV B,M
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							str1="0x"+memory[row];
							B=Integer.decode(str1);
							SP=PC;
							break;
				case "47": //MOV B,A
							PC=SP+1;
							B=A;
							SP=PC;
							break;
				case "48": //MOV C,B
							PC=SP+1;
							C=B;
							SP=PC;
							break;
				case "49": //MOV C,C
							PC=SP+1;
							//C=C;
							SP=PC;
							break;
				case "4A": //MOV C,D
							PC=SP+1;
							C=D;
							SP=PC;
							break;
				case "4B": //MOV C,E
							PC=SP+1;
							C=E;
							SP=PC;
							break;
				case "4C": //MOV C,H
							PC=SP+1;
							C=H;
							SP=PC;
							break;
				case "4D": //MOV C,L
							PC=SP+1;
							C=B;
							SP=PC;
							break;
				case "4E": //MOV C,M
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							str1="0x"+memory[row];
							C=Integer.decode(str1);
							SP=PC;
							break;
				case "4F": //MOV C,A
							PC=SP+1;
							C=A;
							SP=PC;
							break;
				case "50": //MOV D,B
							PC=SP+1;
							D=B;
							SP=PC;
							break;
				case "51": //MOV D,C
							PC=SP+1;
							D=C;
							SP=PC;
							break;
				case "52": //MOV D,D
							PC=SP+1;
							//D=D;
							SP=PC;
							break;
				case "53": //MOV D,E
							PC=SP+1;
							D=E;
							SP=PC;
							break;
				case "54": //MOV D,H	
							PC=SP+1;
							D=H;
							SP=PC;
							break;
				case "55": //MOV D,L
							PC=SP+1;
							D=L;
							SP=PC;
							break;
				case "56": //MOV D,M
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							str1="0x"+memory[row];
							D=Integer.decode(str1);
							SP=PC;
							break;
				case "57": //MOV D,A
							PC=SP+1;
							D=A;
							SP=PC;
							break;
				case "58": //MOV E,B
							PC=SP+1;
							E=B;
							SP=PC;
							break;
				case "59": //MOV E,C
							PC=SP+1;
							E=C;
							SP=PC;
							break;
				case "5A": //MOV E,D
							PC=SP+1;
							E=D;
							SP=PC;
							break;
				case "5B": //MOV E,E
							PC=SP+1;
							//E=E;
							SP=PC;
							break;
				case "5C": //MOV E,H
							PC=SP+1;
							E=H;
							SP=PC;
							break;
				case "5D": //MOV E,L
							PC=SP+1;
							E=L;
							SP=PC;
							break;
				case "5E": //MOV E,M
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							str1="0x"+memory[row];
							E=Integer.decode(str1);
							SP=PC;
							break;
				case "5F": //MOV E,A
							PC=SP+1;
							E=A;
							SP=PC;
							break;
				case "60": //MOV H,B
							PC=SP+1;
							H=B;
							SP=PC;
							break;
				case "61": //MOV H,C
							PC=SP+1;
							H=C;
							SP=PC;
							break;
				case "62": //MOV H,D
							PC=SP+1;
							H=D;
							SP=PC;
							break;
				case "63": //MOV H,E
							PC=SP+1;
							H=E;
							SP=PC;
							break;
				case "64": //MOV H,H		
							PC=SP+1;
							//H=H;
							SP=PC;
							break;
				case "65": //MOV H,L
							PC=SP+1;
							H=L;
							SP=PC;
							break;
				case "66": //MOV H,M
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							str1="0x"+memory[row];
							H=Integer.decode(str1);
							SP=PC;
							break;
				case "67": //MOV H,A
							PC=SP+1;
							H=A;
							SP=PC;
							break;
				case "68": //MOV L,B
							PC=SP+1;
							L=B;
							SP=PC;
							break;
				case "69": //MOV L,C
							PC=SP+1;
							L=C;
							SP=PC;
							break;
				case "6A": //MOV L,D
							PC=SP+1;
							L=D;
							SP=PC;
							break;
				case "6B": //MOV L,E
							PC=SP+1;
							L=E;
							SP=PC;
							break;
				case "6C": //MOV L,H
							PC=SP+1;
							L=H;
							SP=PC;
							break;
				case "6D": //MOV L,L
							PC=SP+1;
							//L=L;
							SP=PC;
							break;
				case "6E": //MOV L,M
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							str1="0x"+memory[row];
							L=Integer.decode(str1);
							SP=PC;
							break;
				case "6F": //MOV L,A
							PC=SP+1;
							L=A;
							SP=PC;
							break;
				case "70": //MOV M,B
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							str1=Microprocessor.decitohexa(B);
							memory[row]=str1;
							SP=PC;
							break;
				case "71": //MOV M,C
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							str1=Microprocessor.decitohexa(C);
							memory[row]=str1;
							SP=PC;
							break;
				case "72": //MOV M,D
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							str1=Microprocessor.decitohexa(D);
							memory[row]=str1;
							SP=PC;
							break;
				case "73": //MOV M,E
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							str1=Microprocessor.decitohexa(E);
							memory[row]=str1;
							SP=PC;
							break;
				case "74": //MOV M,H	
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							str1=Microprocessor.decitohexa(H);
							memory[row]=str1;
							SP=PC;
							break;
				case "75": //MOV M,L
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							str1=Microprocessor.decitohexa(L);
							memory[row]=str1;
							SP=PC;
							break;
				case "76": //HLT
							return(0);
				case "77": //MOV M,A
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							str1=Microprocessor.decitohexa(A);
							memory[row]=str1;
							SP=PC;
							break;
				case "78": //MOV A,B
							PC=SP+1;
							A=B;
							SP=PC;
							break;
				case "79": //MOV A,C
							PC=SP+1;
							A=C;
							SP=PC;
							break;
				case "7A": //MOV A,D
							PC=SP+1;
							A=D;
							SP=PC;
							break;
				case "7B": //MOV A,E
							PC=SP+1;
							A=E;
							SP=PC;
							break;
				case "7C": //MOV A,H
							PC=SP+1;
							A=H;
							SP=PC;
							break;
				case "7D": //MOV A,L
							PC=SP+1;
							A=L;
							SP=PC;
							break;
				case "7E": //MOV A,M
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							//System.out.println("value of string gen by m is "+str1);
							row=Integer.decode(str1);
							str1="0x"+memory[row];
							A=Integer.decode(str1);
							SP=PC;
							break;
				case "7F": //MOV A,A
							PC=SP+1;
							//A=A;
							SP=PC;
							break;
				case "80": //ADD B
							PC=SP+1;
							A=add(A,B);
							//System.out.println("A AFTER ADD  is "+A);
							SP=PC;
							break;
				case "81": //ADD C
							PC=SP+1;
							A=add(A,C);
							SP=PC;
							break;
				case "82": //ADD D
							PC=SP+1;
							A=add(A,D);
							SP=PC;
							break;
				case "83": //ADD E
							PC=SP+1;
							A=add(A,E);
							SP=PC;
							break;
				case "84": //ADD H		
							PC=SP+1;
							A=add(A,H);
							SP=PC;
							break;
				case "85": //ADD L
							PC=SP+1;
							A=add(A,L);
							SP=PC;
							break;
				case "86": //ADD M
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							str1="0x"+memory[row];
							t=Integer.decode(str1);
							A=add(A,t);
							SP=PC;
							break;
				case "87": //ADD A
							PC=SP+1;
							A=add(A,A);
							SP=PC;
							break;
				case "88": //ADC B
							PC=SP+1;
							A=A+cy;
							A=adc(A,B);
							SP=PC;
							break;
				case "89": //ADC C
							PC=SP+1;
							A=A+cy;
							A=adc(A,C);
							SP=PC;
							break;
				case "8A": //ADC D
							PC=SP+1;
							A=A+cy;
							A=adc(A,D);
							SP=PC;
							break;
				case "8B": //ADC E
							PC=SP+1;
							A=A+cy;
							A=adc(A,E);
							SP=PC;
							break;
				case "8C": //ADC H
							PC=SP+1;
							A=A+cy;
							A=adc(A,H);
							SP=PC;
							break;
				case "8D": //ADC L
							PC=SP+1;
							A=A+cy;
							A=adc(A,L);
							SP=PC;
							break;
				case "8E": //ADC M
							PC=PC+1;
							A=A+cy;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							t=Integer.decode("0x"+memory[row]);
							A=adc(A,t);
							SP=PC;
							break;
				case "8F": //ADC A
							PC=SP+1;
							A=A+cy;
							A=add(A,A);
							SP=PC;
							break;
				case "90": //SUB B
							PC=SP+1;
							A=sub(A,B);
							SP=PC;
							break;
				case "91": //SUB C
							PC=SP+1;
							A=sub(A,C);
							SP=PC;
							break;
				case "92": //SUB D
							PC=SP+1;
							A=sub(A,D);
							SP=PC;
							break;
				case "93": //SUB E
							PC=SP+1;
							A=sub(A,E);
							SP=PC;
							break;
				case "94": //SUB H		
							PC=SP+1;
							A=sub(A,H);
							SP=PC;
							break;
				case "95": //SUB L
							PC=SP+1;
							A=sub(A,L);
							SP=PC;
							break;
				case "96": //SUB M
							PC=PC+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							t=Integer.decode("0x"+memory[row]);
							A=sub(A,t);
							SP=PC;
							break;
				case "97": //SUB A
							PC=SP+1;
							A=sub(A,A);
							SP=PC;
							break;
				case "98": //SBB B
							PC=SP+1;
							A=A-cy;
							A=sbb(A,B);
							SP=PC;
							break;
				case "99": //SBB C
							PC=SP+1;
							A=A-cy;
							A=sbb(A,C);
							SP=PC;
							break;
				case "9A": //SBB D
							PC=SP+1;
							A=A-cy;
							A=sbb(A,D);
							SP=PC;
							break;
				case "9B": //SBB E
							PC=SP+1;
							A=A-cy;
							A=sbb(A,E);
							SP=PC;
							break;
				case "9C": //SBB H
							PC=SP+1;
							A=A-cy;
							A=sbb(A,H);
							SP=PC;
							break;
				case "9D": //SBB L
							PC=SP+1;
							A=A-cy;
							A=sbb(A,L);
							SP=PC;
							break;
				case "9E": //SBB M
							PC=PC+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							t=Integer.decode("0x"+memory[row]);
							A=sbb(A,t);
							SP=PC;
							break;
				case "9F": //SBB A
							PC=SP+1;
							A=A-cy;
							A=sbb(A,A);
							SP=PC;
							break;
				case "A0": //ANA B
							PC=SP+1;
							s1=Integer.toHexString(A);
							//s1=s1.toUpperCase();
							s2=Integer.toHexString(B);
							//s2=s2.toUpperCase();
							bit(s1,s2);
							ana();
							SP=PC;
							break;
				case "A1": //ANA C
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(C);
							bit(s1,s2);
							ana();
							break;
				case "A2": //ANA D
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(D);
							bit(s1,s2);
							ana();
							break;
				case "A3": //ANA E
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(E);
							bit(s1,s2);
							ana();
							break;
				case "A4": //ANA H		
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(C);
							bit(s1,s2);
							ana();
							break;
				case "A5": //ANA L
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(L);
							bit(s1,s2);
							ana();
							break;
				case "A6": //ANA M
							PC=SP+1;
							s1=Integer.toHexString(A);
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							t=Integer.decode("0x"+memory[row]);
							s2=Integer.toHexString(t);
							bit(s1,s2);
							ana();
							break;
				case "A7": //ANA A
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(A);
							bit(s1,s2);
							ana();
							break;
				case "A8": //XRA B
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(B);
							bit(s1,s2);
							xra();
							break;
				case "A9": //XRA C
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(C);
							bit(s1,s2);
							xra();
							break;
				case "AA": //XRA D
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(D);
							bit(s1,s2);
							xra();
							break;
				case "AB": //XRA E
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(E);
							bit(s1,s2);
							xra();
							break;
				case "AC": //XRA H
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(H);
							bit(s1,s2);
							xra();
							break;
				case "AD": //XRA L
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(L);
							bit(s1,s2);
							xra();
							break;
				case "AE": //XRA M
							PC=SP+1;
							s1=Integer.toHexString(A);
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							t=Integer.decode("0x"+memory[row]);
							s2=Integer.toHexString(t);
							bit(s1,s2);
							xra();
							break;
				case "AF": //XRA A
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(A);
							bit(s1,s2);
							xra();
							break;
				case "B0": //ORA B
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(B);
							bit(s1,s2);
							ora();
							break;
				case "B1": //ORA C
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(C);
							bit(s1,s2);
							ora();
							break;
				case "B2": //ORA D
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(D);
							bit(s1,s2);
							ora();
							break;
				case "B3": //ORA E
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(E);
							bit(s1,s2);
							ora();
							break;
				case "B4": //ORA H		
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(H);
							bit(s1,s2);
							ora();
							break;
				case "B5": //ORA L
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(L);
							bit(s1,s2);
							ora();
							break;
				case "B6": //ORA M
							PC=SP+1;
							s1=Integer.toHexString(A);
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							row=Integer.decode(str1);
							t=Integer.decode("0x"+memory[row]);
							s2=Integer.toHexString(L);
							bit(s1,s2);
							ora();
							break;
				case "B7": //ORA A
							PC=SP+1;
							s1=Integer.toHexString(A);
							s2=Integer.toHexString(A);
							bit(s1,s2);
							ora();
							break;
				case "B8": //CMP B
							PC=SP+1;
							t=A-B;
							if(t==0)
							{
								zf=1;
								sf=cy=0;
							}
							if(t>0)
								sf=cy=zf=0;
							if(t<0)
							{
								cy=sf=1;
								zf=0;
							}
							SP=PC;
							break;
				case "B9": //CMP C
							PC=SP+1;
							t=A-C;
							if(t==0)
							{
								zf=1;
								sf=cy=0;
							}
							if(t>0)
								sf=cy=zf=0;
							if(t<0)
							{
								cy=sf=1;
								zf=0;
							}
							SP=PC;
							break;
				case "BA": //CMP D
							PC=SP+1;
							t=A-D;
							if(t==0)
							{
								zf=1;
								sf=cy=0;
							}
							if(t>0)
								sf=cy=zf=0;
							if(t<0)
							{
								cy=sf=1;
								zf=0;
							}
							SP=PC;
							break;
				case "BB": //CMP E
							PC=SP+1;
							t=A-E;
							if(t==0)
							{
								zf=1;
								sf=cy=0;
							}
							if(t>0)
								sf=cy=zf=0;
							if(t<0)
							{
								cy=sf=1;
								zf=0;
							}
							SP=PC;
							break;
				case "BC": //CMP H
							PC=SP+1;
							t=A-H;
							if(t==0)
							{
								zf=1;
								sf=cy=0;
							}
							if(t>0)
								sf=cy=zf=0;
							if(t<0)
							{
								cy=sf=1;
								zf=0;
							}
							SP=PC;
							break;
				case "BD": //CMP L
							PC=SP+1;
							t=A-L;
							if(t==0)
							{
								zf=1;
								sf=cy=0;
							}
							if(t>0)
								sf=cy=zf=0;
							if(t<0)
							{
								cy=sf=1;
								zf=0;
							}
							SP=PC;
							break;
				case "BE": //CMP M
							PC=SP+1;
							str1="0x"+Microprocessor.decitohexa(H)+Microprocessor.decitohexa(L);
							//System.out.println("STRING VALUE OF INDEX IS "+str1);
							row=Integer.decode(str1);
							//System.out.println("ROW IS  "+row);
							te=Integer.decode("0x"+memory[row]);
							//System.out.println("A and te are "+A+" "+te);
							if(A>te)
								t=1;
							else if(A<te)
								t=-1;
							else
								t=0;
							//System.out.println("value of at t after is "+Microprocessor.decitohexa(t));
							if(t==0)
							{
								zf=1;
								sf=cy=0;
							}
							if(t>0)
								sf=cy=zf=0;
							if(t<0)
							{
								cy=sf=1;
								zf=0;
							}
							SP=PC;
							break;
				case "BF": //CMP A
							PC=SP+1;
							zf=1;
							cy=sf=0;
							SP=PC;
							break;
				case "C0": //RNZ
							if(zf==0)
							{
								str1="0x"+memory[TOP+1]+memory[TOP];
								TOP=TOP+2;
								SP=Integer.decode(str1);
								PC=SP;	
							}
							else
							{
								PC=SP+1;
								SP=PC;
							}
							break;
				case "C1": //POP B
							PC=PC+1;
							str1="0x"+memory[TOP];
							C=Integer.decode(str1);
							TOP=TOP+1;
							str1="0x"+memory[TOP];
							B=Integer.decode(str1);
							TOP=TOP+1;
							SP=PC;
							break;
				case "C2": //JNZ
							PC=SP+3;
							if(zf==0)
							{
								str1="0x"+memory[SP+1]+memory[SP+2];
								row=Integer.decode(str1);
								SP=row;
								PC=SP;
							}
							SP=PC;
							break;
				case "C3": //JMP
							PC=SP+3;
							str1="0x"+memory[SP+1]+memory[SP+2];
							row=Integer.decode(str1);
							SP=row;
							break;
				case "C4": //CNZ		
							PC=PC+3;
							if(zf==0)
							{
								str1=Microprocessor.decitohexa(PC);
								valueInsert(str1,memory,TOP);
								str1="0x"+memory[SP+1]+memory[SP+2];
								SP=Integer.decode(str1);
								PC=SP;
							}
							SP=PC;
							break;
				case "C5": //PUSH B
							PC=PC+1;
							TOP=TOP-1;
							str1=Microprocessor.decitohexa(B);
							//System.out.println("B TO PLACE AT TOP AS STRING IS "+str1+"TOP IS "+TOP);
							memory[TOP]=str1;
							TOP=TOP-1;
							str1=Microprocessor.decitohexa(C);
							memory[TOP]=str1;
							SP=PC;
							break;
				case "C6": //ADI 
							PC=SP+1;
							t=Integer.decode("0x"+memory[SP+1]);
							A=add(A,t);
							SP=PC;
							break;
				case "C7": //RST 0
				case "C8": //RZ
							if(zf==1)
							{
								str1="0x"+memory[TOP+1]+memory[TOP];
								TOP=TOP+2;
								SP=Integer.decode(str1);
								PC=SP;	
							}
							else
							{
								PC=SP+1;
								SP=PC;
							}
							break;
				case "C9": //RET 
							str1="0x"+memory[TOP+1]+memory[TOP];
							TOP=TOP+2;
							SP=Integer.decode(str1);
							PC=SP;
							break;
				case "CA": //JZ
							PC=SP+3;
							if(zf==1)
							{
								str1="0x"+memory[SP+1]+memory[SP+2];
								row=Integer.decode(str1);
								SP=row;
								PC=SP;
							}
							SP=PC;
							break;
				case "CB": //
				case "CC": //CZ
							PC=PC+3;
							if(zf==1)
							{
								str1=Microprocessor.decitohexa(PC);
								valueInsert(str1,memory,TOP);
								str1="0x"+memory[SP+1]+memory[SP+2];
								SP=Integer.decode(str1);
								PC=SP;
							}
							SP=PC;
							break;
				case "CD": //CALL
							PC=PC+3;
							str1=Microprocessor.decitohexa(PC);
							valueInsert(str1,memory,TOP);
							str1="0x"+memory[SP+1]+memory[SP+2];
							SP=Integer.decode(str1);
							PC=SP;
							break;
				case "CE": //ACI
							PC=SP+1;
							A=A+cy;
							t=Integer.decode("0x"+memory[SP+1]);
							A=adc(A,t);
							SP=PC;
							break;
				case "CF": //RST 1
				case "D0": //RNC
							if(cy==0)
							{
								str1="0x"+memory[TOP+1]+memory[TOP];
								TOP=TOP+2;
								SP=Integer.decode(str1);
								PC=SP;	
							}
							else
							{
								PC=SP+1;
								SP=PC;
							}
							break;
				case "D1": //POP D
							PC=PC+1;
							str1="0x"+memory[TOP];
							E=Integer.decode(str1);
							TOP=TOP+1;
							str1="0x"+memory[TOP];
							D=Integer.decode(str1);
							TOP=TOP+1;
							SP=PC;
							break;
				case "D2": //JNC
							PC=SP+3;
							if(cy==0)
							{
								str1="0x"+memory[SP+1]+memory[SP+2];
								row=Integer.decode(str1);
								SP=row;
								PC=SP;
							}
							SP=PC;
							break;
				case "D3": //OUT
				case "D4": //CNC	
							PC=PC+3;
							if(cy==0)
							{
								str1=Microprocessor.decitohexa(PC);
								valueInsert(str1,memory,TOP);
								str1="0x"+memory[SP+1]+memory[SP+2];
								SP=Integer.decode(str1);
								PC=SP;
							}
							SP=PC;
							break;
				case "D5": //PUSH D
							PC=PC+1;
							TOP=TOP-1;
							str1=Microprocessor.decitohexa(D);
							memory[TOP]=str1;
							TOP=TOP-1;
							str1=Microprocessor.decitohexa(E);
							memory[TOP]=str1;
							SP=PC;
							break;
				case "D6": //SUI
							PC=SP+1;
							t=Integer.decode("0x"+memory[SP+1]);
							A=sub(A,t);
							SP=PC;
							break;
				case "D7": //RST 2
				case "D8": //RC
							if(cy==1)
							{
								str1="0x"+memory[TOP+1]+memory[TOP];
								TOP=TOP+2;
								SP=Integer.decode(str1);
								PC=SP;	
							}
							else
							{
								PC=SP+1;
								SP=PC;
							}
							break;
				case "D9": //
				case "DA": //JC
							PC=SP+3;
							if(cy==1)
							{
								str1="0x"+memory[SP+1]+memory[SP+2];
								row=Integer.decode(str1);
								SP=row;
								PC=SP;
							}
							SP=PC;
							break;
				case "DB": //IN
				case "DC": //CC
							PC=PC+3;
							if(cy==1)
							{
								str1=Microprocessor.decitohexa(PC);
								valueInsert(str1,memory,TOP);
								str1="0x"+memory[SP+1]+memory[SP+2];
								SP=Integer.decode(str1);
								PC=SP;
							}
							SP=PC;
							break;
				case "DD": //
				case "DE": //SBI
							PC=SP+1;
							A=A-cy;
							t=Integer.decode("0x"+memory[SP+1]);
							A=sbb(A,t);
							SP=PC;
							break;
				case "DF": //RST 3
				case "E0": //RPO
							if(pf==0)
							{
								str1="0x"+memory[TOP+1]+memory[TOP];
								TOP=TOP+2;
								SP=Integer.decode(str1);
								PC=SP;	
							}
							else
							{
								PC=SP+1;
								SP=PC;
							}
							break;
				case "E1": //POP H
							PC=PC+1;
							str1="0x"+memory[TOP];
							L=Integer.decode(str1);
							TOP=TOP+1;
							str1="0x"+memory[TOP];
							H=Integer.decode(str1);
							TOP=TOP+1;
							SP=PC;
							break;
				case "E2": //JPO
							PC=SP+3;
							if(pf==0)
							{
								str1="0x"+memory[SP+1]+memory[SP+2];
								row=Integer.decode(str1);
								SP=row;
								PC=SP;
							}
							SP=PC;
							break;
				case "E3": //XTHL
				case "E4": //CPO	
							PC=PC+3;
							if(pf==0)
							{
								str1=Microprocessor.decitohexa(PC);
								valueInsert(str1,memory,TOP);
								str1="0x"+memory[SP+1]+memory[SP+2];
								SP=Integer.decode(str1);
								PC=SP;
							}
							SP=PC;
							break;
				case "E5": //PUSH H
							PC=PC+1;
							TOP=TOP-1;
							str1=Microprocessor.decitohexa(H);
							memory[TOP]=str1;
							TOP=TOP-1;
							str1=Microprocessor.decitohexa(L);
							memory[TOP]=str1;
							SP=PC;
							break;
				case "E6": //ANI
							PC=PC+2;
							s1=Integer.toHexString(A);
							bit(s1,memory[SP+1]);
							ana();
							SP=PC;
							break;
				case "E7": //RST 4
				case "E8": //RPE
							if(pf==1)
							{
								str1="0x"+memory[TOP+1]+memory[TOP];
								TOP=TOP+2;
								SP=Integer.decode(str1);
								PC=SP;	
							}
							else
							{
								PC=SP+1;
								SP=PC;
							}
							break;
				case "EA": //JPE
							PC=SP+3;
							if(pf==1)
							{
								str1="0x"+memory[SP+1]+memory[SP+2];
								row=Integer.decode(str1);
								SP=row;
								PC=SP;
							}
							SP=PC;
							break;
				case "EC": //CPE
							PC=PC+3;
							if(pf==1)
							{
								str1=Microprocessor.decitohexa(PC);
								valueInsert(str1,memory,TOP);
								str1="0x"+memory[SP+1]+memory[SP+2];
								SP=Integer.decode(str1);
								PC=SP;
							}
							SP=PC;
							break;
				case "EE": //XRI 
							PC=PC+2;
							s1=Integer.toHexString(A);
							bit(s1,memory[SP+1]);
							xra();
							SP=PC;
							break;
				case "F0": //RP
							if(sf==0)
							{
								str1="0x"+memory[TOP+1]+memory[TOP];
								TOP=TOP+2;
								SP=Integer.decode(str1);
								PC=SP;	
							}
							else
							{
								PC=SP+1;
								SP=PC;
							}
							break;
				case "F2": //JP
							PC=SP+3;
							if(sf==0)
							{
								str1="0x"+memory[SP+1]+memory[SP+2];
								row=Integer.decode(str1);
								SP=row;
								PC=SP;
							}
							SP=PC;
							break;
				case "F4": //CP
							PC=PC+3;
							if(sf==0)
							{
								str1=Microprocessor.decitohexa(PC);
								valueInsert(str1,memory,TOP);
								str1="0x"+memory[SP+1]+memory[SP+2];
								SP=Integer.decode(str1);
								PC=SP;
							}
							SP=PC;
							break;
				case "F6": //ORI
							PC=PC+2;
							s1=Integer.toHexString(A);
							bit(s1,memory[SP+1]);
							ora();
							SP=PC;
							break;
				case "F8": //RM
							if(sf==1)
							{
								str1="0x"+memory[TOP+1]+memory[TOP];
								TOP=TOP+2;
								SP=Integer.decode(str1);
								PC=SP;	
							}
							else
							{
								PC=SP+1;
								SP=PC;
							}
							break;
				case "FA": //JM
							PC=SP+3;
							if(sf==1)
							{
								str1="0x"+memory[SP+1]+memory[SP+2];
								row=Integer.decode(str1);
								SP=row;
								PC=SP;
							}
							SP=PC;
							break;
				case "FC": //CM
							PC=PC+3;
							if(sf==1)
							{
								str1=Microprocessor.decitohexa(PC);
								valueInsert(str1,memory,TOP);
								str1="0x"+memory[SP+1]+memory[SP+2];
								SP=Integer.decode(str1);
								PC=SP;
							}
							SP=PC;
							break;
				case "FF": //CPI
							PC=SP+1;
							t=Integer.decode("0x"+memory[SP+1]);
							t=A-t;
							if(t==0)
							{
								zf=1;
								sf=cy=0;
							}
							if(t>0)
								sf=cy=zf=0;
							if(t<0)
							{
								cy=sf=1;
								zf=0;
							}
							SP=PC;
							break;
				
			}
			//System.out.println("value of SP AND PC ARE "+Microprocessor.decitohexa(SP)+" "+Microprocessor.decitohexa(PC));
			
			//System.out.println("MEM top are "+memory[TOP]+memory[TOP+1]);
			
			}
		}
}
