
public class HexcodeInsert {
		public int valueInsert(String sub,String memory[],int row)
		{
			int num,k,ln,t=1;
			ln=sub.length();
			if(ln==4)
			{
				num=Microprocessor.convert(sub);
				if(num>16383||num<8192)
					return(0);	
			}
			for(k=0;k<ln;k+=2)
			{
				char ch1=sub.charAt(k);
				memory[row+t]=memory[row+t]+ch1;
				char ch2=sub.charAt(k+1);
				memory[row+t]=memory[row+t]+ch2;
				t++;
			}
			return(1);
		}
		public int stringInsert(String str,String memory[],int row)
		{
			int i,j=0,k,x;
			char ch1='\0';
			String s[]=new String[10];
			for(i=0;i<10;i++)
				s[i]="";
			for(i=0;i<str.length();i++)
			{
				ch1=str.charAt(i);
				if(ch1==' ')
					j++;
				else
					s[j]=s[j]+ch1;
			}
			if(j>3)
				return(0);
			else
			{
				switch(j)
				{
				case 0: 
						switch(s[0])
						{
						case "NOP": memory[row]="00";
									return(1);
						case "HLT": memory[row]="76";
									return(1);
						case "DAA": memory[row]="27";
									return(1);
						case "CMA": memory[row]="2F";
									return(1);
						case "STC": memory[row]="37";
									return(1);
						case "CMC": memory[row]="3F";
									return(1);
						case "XCHG": memory[row]="EB";
									return(1);
						case "RLC": memory[row]="07";
									return(1);
						case "RRC": memory[row]="0F";
									return(1);
						case "RAL": memory[row]="17";
									return(1);
						case "RAR": memory[row]="1F";
									return(1);
						case "PCHL":memory[row]="E9";
									return(1);
						case "XTHL":memory[row]="E3";
									return(1);
						case "SPHL":memory[row]="F9";
									return(1);
						case "RET": memory[row]="C9";
									return(1);
						case "RC":  memory[row]="D8";
									return(1);
						case "RNC": memory[row]="D0";
									return(1);
						case "RZ":  memory[row]="C8";
									return(1);
						case "RNZ": memory[row]="C0";
									return(1);
						case "RPE": memory[row]="E8";
									return(1);
						case "RPO": memory[row]="E0";
									return(1);
						case "RP":  memory[row]="F0";
									return(1);
						case "RM":  memory[row]="F8";
									return(1);
						default: return(0);
						}
				case 1:
						switch(s[0])
						{
						case "LDA": memory[row]="3A";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "STA": memory[row]="32";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "INX":
									switch(s[1])
									{
									case "B": memory[row]="03";
												return(1);
									case "D": memory[row]="13";
												return(1);
									case "H": memory[row]="23";
												return(1);
									case "SP":memory[row]="33"; 
												return(1);
									default: return(0);
									}
						case "INR":
									switch(s[1])
									{
									case "B": memory[row]="04";
												return(1);
									case "C": memory[row]="0C";
												return(1);
									case "D": memory[row]="14";
												return(1);
									case "E": memory[row]="1C";
												return(1);
									case "H": memory[row]="24";
												return(1);
									case "L": memory[row]="2C";
												return(1);
									case "M": memory[row]="34";
												return(1);
									default:	return(0);
									}
						case "DCR":
									switch(s[1])
									{
									case "B": memory[row]="05";
												return(1);
									case "C": memory[row]="0D";
												return(1);
									case "D": memory[row]="15";
												return(1);
									case "E": memory[row]="1D";
												return(1);
									case "H": memory[row]="25";
												return(1);
									case "L": memory[row]="2D";
												return(1);
									case "M": memory[row]="35";
												return(1);
									default: return(0);
									}
						case "DAD":
									switch(s[1])
									{
									case "B": memory[row]="09";
												return(1);
									case "D": memory[row]="19";
												return(1);
									case "H": memory[row]="29";
												return(1);
									default: return(0);
									}
						case "LDAX":
									switch(s[1])
									{
									case "B": memory[row]="0A";
												return(1);
									case "D": memory[row]="1A";
												return(1);
									default: return(0);
									}
						case "DCX":
									switch(s[1])
									{
									case "B": memory[row]="0B";
												return(1);
									case "D": memory[row]="1B";
												return(1);
									case "H": memory[row]="2B";
												return(1);
									case "SP": memory[row]="3B";
												return(1);
									default: return(0);
									}
						case "SHLD": memory[row]="22";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "LHLD": memory[row]="2A";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "MOV": 
									switch(s[1])
									{
									case "B,B":memory[row]="40";
												return(1);
									case "B,C":memory[row]="41";
												return(1);
									case "B,D":memory[row]="42";
												return(1);
									case "B,E":memory[row]="43";
												return(1);
									case "B,H":memory[row]="44";
												return(1);
									case "B,L":memory[row]="45";
												return(1);
									case "B,M":memory[row]="46";
												return(1);
									case "B,A":memory[row]="47";
												return(1);
									case "C,B":memory[row]="48";
												return(1);
									case "C,C":memory[row]="49";
												return(1);
									case "C,D":memory[row]="4A";
												return(1);
									case "C,E":memory[row]="4B";
												return(1);
									case "C,H":memory[row]="4C";
												return(1);
									case "C,L":memory[row]="4D";
												return(1);
									case "C,M":memory[row]="4E";
												return(1);
									case "C,A":memory[row]="4F";
												return(1);
									case "D,B":memory[row]="50";
												return(1);
									case "D,C":memory[row]="51";
												return(1);
									case "D,D":memory[row]="52";
												return(1);
									case "D,E":memory[row]="53";
												return(1);
									case "D,H":memory[row]="54";
												return(1);
									case "D,L":memory[row]="55";
												return(1);
									case "D,M":memory[row]="56";
												return(1);
									case "D,A":memory[row]="57";
												return(1);
									case "E,B":memory[row]="58";
												return(1);
									case "E,C":memory[row]="59";
												return(1);
									case "E,D":memory[row]="5A";
												return(1);
									case "E,E":memory[row]="5B";
												return(1);
									case "E,H":memory[row]="5C";
												return(1);
									case "E,L":memory[row]="5D";
												return(1);
									case "E,M":memory[row]="5E";
												return(1);
									case "E,A":memory[row]="5F";
												return(1);
									case "H,B":memory[row]="60";
												return(1);
									case "H,C":memory[row]="61";
												return(1);
									case "H,D":memory[row]="62";
												return(1);
									case "H,E":memory[row]="63";
												return(1);
									case "H,H":memory[row]="64";
												return(1);
									case "H,L":memory[row]="65";
												return(1);
									case "H,M":memory[row]="66";
												return(1);
									case "H,A":memory[row]="67";
												return(1);
									case "L,B":memory[row]="68";
												return(1);
									case "L,C":memory[row]="69";
												return(1);
									case "L,D":memory[row]="6A";
												return(1);
									case "L,E":memory[row]="6B";
												return(1);
									case "L,H":memory[row]="6C";
												return(1);
									case "L,L":memory[row]="6D";
												return(1);
									case "L,M":memory[row]="6E";
												return(1);
									case "L,A":memory[row]="6F";
												return(1);
									case "M,B":memory[row]="70";
												return(1);
									case "M,C":memory[row]="71";
												return(1);
									case "M,D":memory[row]="72";
												return(1);
									case "M,E":memory[row]="73";
												return(1);
									case "M,H":memory[row]="74";
												return(1);
									case "M,L":memory[row]="75";
												return(1);
									case "M,A":memory[row]="77";
												return(1);
									case "A,B":memory[row]="78";
												return(1);
									case "A,C":memory[row]="79";
												return(1);
									case "A,D":memory[row]="7A";
												return(1);
									case "A,E":memory[row]="7B";
												return(1);
									case "A,H":memory[row]="7C";
												return(1);
									case "A,L":memory[row]="7D";
												return(1);
									case "A,M":memory[row]="7E";
												return(1);
									case "A,A":memory[row]="7F";
												return(1);
									default: return(0);
									}
						case "ADD":
									switch(s[1])
									{
									case "B":memory[row]="80";
												return(1);
									case "C":memory[row]="81";
												return(1);
									case "D":memory[row]="82";
												return(1);
									case "E":memory[row]="83";
												return(1);
									case "H":memory[row]="84";
												return(1);
									case "L":memory[row]="85";
												return(1);
									case "M":memory[row]="86";
												return(1);
									case "A":memory[row]="87";
												return(1);
									default: return(0);
									}
						case "ADC":
									switch(s[1])
									{
									case "B":memory[row]="88";
												return(1);
									case "C":memory[row]="89";
												return(1);
									case "D":memory[row]="8A";
												return(1);
									case "E":memory[row]="8B";
												return(1);
									case "H":memory[row]="8C";
												return(1);
									case "L":memory[row]="8D";
												return(1);
									case "M":memory[row]="8E";
												return(1);
									case "A":memory[row]="8F";
												return(1);
									default: return(0);
									}
						case "SUB":
									switch(s[1])
									{
									case "B":memory[row]="90";
												return(1);
									case "C":memory[row]="91";
												return(1);
									case "D":memory[row]="92";
												return(1);
									case "E":memory[row]="93";
												return(1);
									case "H":memory[row]="94";
												return(1);
									case "L":memory[row]="95";
												return(1);
									case "M":memory[row]="96";
												return(1);
									case "A":memory[row]="97";
												return(1);
									default: return(0);
									}
						case "SBB":
									switch(s[1])
									{
									case "B":memory[row]="98";
											  	return(1);
									case "C":memory[row]="99";
												return(1);
									case "D":memory[row]="9A";
												return(1);
									case "E":memory[row]="9B";
												return(1);
									case "H":memory[row]="9C";
												return(1);
									case "L":memory[row]="9D";
												return(1);
									case "M":memory[row]="9E";
												return(1);
									case "A":memory[row]="9F";
												return(1);
									default: return(0);
									}
						case "ANA":
									switch(s[1])
									{
									case "B":memory[row]="A0";
												return(1);
									case "C":memory[row]="A1";
												return(1);
									case "D":memory[row]="A2";
												return(1);
									case "E":memory[row]="A3";
												return(1);
									case "H":memory[row]="A4";
												return(1);
									case "L":memory[row]="A5";
												return(1);
									case "M":memory[row]="A6";
												return(1);
									case "A":memory[row]="A7";
												return(1);
									default: return(0);
									}
						case "XRA":
									switch(s[1])
									{
									case "B":memory[row]="A8";
												return(1);
									case "C":memory[row]="A9";
												return(1);
									case "D":memory[row]="AA";
												return(1);
									case "E":memory[row]="AB";
												return(1);
									case "H":memory[row]="AC";
												return(1);
									case "L":memory[row]="AD";
												return(1);
									case "M":memory[row]="AE";
												return(1);
									case "A":memory[row]="AF";
												return(1);
									default: return(0);
									}
						case "ORA":
									switch(s[1])
									{
									case "B":memory[row]="B0";
												return(1);
									case "C":memory[row]="B1";
												return(1);
									case "D":memory[row]="B2";
												return(1);
									case "E":memory[row]="B3";
												return(1);
									case "H":memory[row]="B4";
												return(1);
									case "L":memory[row]="B5";
												return(1);
									case "M":memory[row]="B6";
												return(1);
									case "A":memory[row]="B7";
												return(1);
									default: return(0);
									}
						case "CMP":
									switch(s[1])
									{
									case "B":memory[row]="B8";
												return(1);
									case "C":memory[row]="B9";
												return(1);
									case "D":memory[row]="BA";
												return(1);
									case "E":memory[row]="BB";
												return(1);
									case "H":memory[row]="BC";
												return(1);
									case "L":memory[row]="BD";
												return(1);
									case "M":memory[row]="BE";
												return(1);
									case "A":memory[row]="BF";
												return(1);
									default: return(0);
									}
						case "STAX":
									switch(s[1])
									{
									case "B":memory[row]="02";
												return(1);
									case "D":memory[row]="12";
												return(1);
									default: return(0);
									}
						case "PUSH":
									switch(s[1])
									{
									case "B":memory[row]="C5";
												return(1);
									case "D":memory[row]="D5";
												return(1);
									case "H":memory[row]="E5";
												return(1);
									case "PSW":memory[row]="F5";
												return(1);
									default: return(0);
									}
						case "POP":
									switch(s[1])
									{
									case "B":memory[row]="C1";
												return(1);
									case "D":memory[row]="D1";
												return(1);
									case "H":memory[row]="E1";
												return(1);
									case "PSW":memory[row]="F1";
												return(1);
									default: return(0);
									}
						case "JC": memory[row]="DA";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "JNC":
									memory[row]="D2";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "JZ":
									memory[row]="CA";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "JNZ":
									memory[row]="C2";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "JPE":
									memory[row]="EA";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "JPO":
									memory[row]="E2";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "JP":
									memory[row]="F2";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "JM":
									memory[row]="FA";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "JMP":
									memory[row]="C3";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "CALL":
									memory[row]="CD";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "CC":
									memory[row]="DC";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "CNC":
									memory[row]="D4";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "CZ":
									memory[row]="CC";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "CNZ":
									memory[row]="C4";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "CPE":
									memory[row]="EC";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "CPO":
									memory[row]="E4";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "CP":
									memory[row]="F4";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "CM":
									memory[row]="FC";
									if(s[1].length()!=4)
										return(0);
									else
									{
										for(k=0;k<4;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										if(x==0)
											return(0);
										else
											return(3);
									}
						case "ACI":
									memory[row]="CE";
									if(s[1].length()!=2)
										return(0);
									else
									{
										for(k=0;k<2;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										return(2);
									}
						case "SUI":
									memory[row]="D6";
									if(s[1].length()!=2)
										return(0);
									else
									{
										for(k=0;k<2;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										return(2);
									}
						case "SBI":
									memory[row]="DE";
									if(s[1].length()!=2)
										return(0);
									else
									{
										for(k=0;k<2;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										return(2);
									}
						case "ANI":
									memory[row]="E6";
									if(s[1].length()!=2)
										return(0);
									else
									{
										for(k=0;k<2;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										return(2);
									}
						case "XRI":
									memory[row]="EE";
									if(s[1].length()!=2)
										return(0);
									else
									{
										for(k=0;k<2;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										return(2);
									}
						case "ORI":
									memory[row]="F6";
									if(s[1].length()!=2)
										return(0);
									else
									{
										for(k=0;k<2;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										return(2);
									}
						case "CPI":
									memory[row]="FE";
									if(s[1].length()!=2)
										return(0);
									else
									{
										for(k=0;k<2;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										return(2);
									}
						case "ADI":
									memory[row]="C6";
									if(s[1].length()!=2)
										return(0);
									else
									{
										for(k=0;k<2;k++)
										{
											ch1=s[1].charAt(k);
											if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
												return(0);
										}
										x=valueInsert(s[1],memory,row);
										return(2);
									}
						default: return(0);	
						}
				case 2:
						switch(s[0])
						{
						case "MVI":
									switch(s[1])
									{
									case "A":
										memory[row]="3E";
												if(s[2].length()!=2)
													return(0);
												else
												{
													for(k=0;k<2;k++)
													{
														ch1=s[2].charAt(k);
														if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
															return(0);
													}
													x=valueInsert(s[2],memory,row);
													return(2);
												}
									case "B":
												memory[row]="06";
												if(s[2].length()!=2)
													return(0);
												else
												{
													for(k=0;k<2;k++)
													{
														ch1=s[2].charAt(k);
														if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
															return(0);
													}
													x=valueInsert(s[2],memory,row);
													return(2);
												}
									case "C":
												memory[row]="0E";
												if(s[2].length()!=2)
													return(0);
												else
												{
													for(k=0;k<2;k++)
													{
														ch1=s[2].charAt(k);
														if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
															return(0);
													}
													x=valueInsert(s[2],memory,row);
													return(2);
												}
									case "D":
												memory[row]="16";
												if(s[2].length()!=2)
													return(0);
												else
												{
													for(k=0;k<2;k++)
													{
														ch1=s[2].charAt(k);
														if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
															return(0);
													}
													x=valueInsert(s[2],memory,row);
													return(2);
												}
									case "E":
												memory[row]="1E";
												if(s[2].length()!=2)
													return(0);
												else
												{
													for(k=0;k<2;k++)
													{
														ch1=s[2].charAt(k);
														if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
															return(0);
													}
													x=valueInsert(s[2],memory,row);
													return(2);
												}
									case "H":
												memory[row]="26";
												if(s[2].length()!=2)
													return(0);
												else
												{
													for(k=0;k<2;k++)
													{
														ch1=s[2].charAt(k);
														if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
															return(0);
													}
													x=valueInsert(s[2],memory,row);
													return(2);
												}
									case "L":
												memory[row]="2E";
												if(s[2].length()!=2)
													return(0);
												else
												{
													for(k=0;k<2;k++)
													{
														ch1=s[2].charAt(k);
														if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
															return(0);
													}
													x=valueInsert(s[2],memory,row);
													return(2);
												}
									case "M":
												memory[row]="36";
												if(s[2].length()!=2)
													return(0);
												else
												{
													for(k=0;k<2;k++)
													{
														ch1=s[2].charAt(k);
														if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
															return(0);
													}
													x=valueInsert(s[2],memory,row);
													return(2);
												}
									default: return(0);
									}
						case "LXI":
									switch(s[1])
									{
									case "B":
										memory[row]="01";
												if(s[2].length()!=4)
													return(0);
												else
												{
													for(k=0;k<4;k++)
													{
														ch1=s[2].charAt(k);
														if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
															return(0);
													}
													x=valueInsert(s[2],memory,row);
													return(3);
												}
									case "D":
												memory[row]="11";
												if(s[2].length()!=4)
													return(0);
												else
												{
													for(k=0;k<4;k++)
													
														ch1=s[2].charAt(k);
														if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
															return(0);
													}
													x=valueInsert(s[2],memory,row);
													return(3);
												}
									case "H":
												memory[row]="21";
												if(s[2].length()!=4)
													return(0);
												else
												{
													for(k=0;k<4;k++)
													{
														ch1=s[2].charAt(k);
														if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
															return(0);
													}
													x=valueInsert(s[2],memory,row);
													return(3);
												}
									case "SP": memory[row]="31";
												if(s[2].length()!=4)
													return(0);
												else
												{
													for(k=0;k<4;k++)
													{
														ch1=s[2].charAt(k);
														if(ch1!='0'&&ch1!='1'&&ch1!='2'&&ch1!='3'&&ch1!='4'&&ch1!='5'&&ch1!='6'&&ch1!='7'&&ch1!='8'&&ch1!='9'&&ch1!='A'&&ch1!='B'&&ch1!='C'&&ch1!='D'&&ch1!='E'&&ch1!='F')
															return(0);
													}
													x=valueInsert(s[2],memory,row);
													return(3);
												}

									default: return(0);
									}
						default:return(0);
						}
				}
								
			}
		
}

