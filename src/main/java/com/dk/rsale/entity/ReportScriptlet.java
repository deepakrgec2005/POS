package com.dk.rsale.entity;

public class ReportScriptlet extends net.sf.jasperreports.engine.JRDefaultScriptlet{
	public static String convertIntToWords(int value) {

       String s=Integer.toString(value);
       int len =s.length();
       String one[]= {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
       String twodigit[]= { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
       String twodigits[]= {"Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninty"};
       String amount="";
      int qu=0;
      int re=0;
       while(len>0)
       {
    	   
    	   if(len==9)
    	   {
    		   
    		   
    		    
    	   }
       }
       
	return s;
       
       
    }
}
