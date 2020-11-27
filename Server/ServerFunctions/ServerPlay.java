package Server.ServerFunctions;

//if returning from a black card, send its value as "colourchosen_11_" where color chosen is that of the users choosing
public class ServerPlay {

	public static int color(String[]played, String[] pile) {
		if(played[0].equals("black"))
			return 2;
		else if(played[0].equals(pile[0]))
			return 1;
		else
			return 0;
	}
	
	public static int number(String[]played, String[] pile) {
		if(played[1].equals(pile[1]))
			return 1;
		else
			return 0;
	}
	
	public static String[] readCard(String card) {
		String temp="";
		String[] c=new String[2];
		int i=0;
		while(card.charAt(i) != '_') {
			temp+=card.charAt(i);
			i++;
		}
		c[0]=temp;
		temp="";
		i++;
		while(card.charAt(i) != '_') {
			temp+=card.charAt(i);
			i++;
		}
		c[1]=temp;
		return c;
	}
	
	public static String checkCard(String played, String pile) {
		
		String[] play=readCard(played);
		String[] pil=readCard(pile);
		int i=color(play,pil);
		if(i==2)
			return play[1];
		else if(i==1) {
			if(play[1].equals("picker")||play[1].equals("reverse")||play[1].equals("skip"))
				return play[1];
			else
				return "true";
		}
		else {
			i=number(play,pil);
			if(i==1)
				return "true";
			else
				return "false";
		}
		
	}
	
	public static void main (String [] args){
		String a="red_1_";
		String b="blue_1_";
		String c="red_0_";
		String d="green_7_";
		String e="black_yes_";
		String m= checkCard(a,b);
		System.out.println(checkCard(e,a));
	}
	
	
}
