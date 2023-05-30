import java.util.Scanner;  
public class GCD
{
public static void main(String[] args)   
{  
int a, b, gcd = 0;  
Scanner sc = new Scanner(System.in);  
System.out.print("Enter the First Number: ");  
a = sc.nextInt();     
System.out.print("Enter the Second Number: ");  
b = sc.nextInt();  
gcd = GCD(a, b);  
System.out.println("GCD of " + a + " and " + b + " =  " + gcd);  
}  
public static int GCD(int a, int b)  
{  
while(b != 0)  
{  
if(a > b)  
{  
a = a - b;  
}  
else  
{  
b = b - a;  
}  
}  
return a;  
}  
}  