//Java program to encrypt and decrypt a string using caesar cipher
import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(int shift,String plainText){

        plainText.toLowerCase();
        String cipherText="";
        for(char c : plainText.toCharArray()){
            if(Character.isLetter(c)){
               char ch = (char)((((int)c +shift)-97)%26+97);
               cipherText+= ch;
            }
            else if(c == ' '){
                cipherText+= ' ';
            }
        }
        return cipherText;
    }

    public static String decrypt(int shift,String cipherText){

        cipherText.toLowerCase();
        String plainText="";
        char ch;
        for(char c : cipherText.toCharArray()){
            if(Character.isLetter(c)){
                if(((int)c-shift)<97)
                {
                     ch =(char)(((int)c-shift-97+26)%26+97);    //97+26 to rotate the string round
                }
                else
                {
                     ch =(char)(((int)c -shift-97)%26+97);
                }
               plainText+= ch;
            }
            else if(c == ' '){
               plainText+= ' ';
            }
        }
        return plainText;
    }

    public static void main(String []args){
        String plainText;
        String cipherText;
        int shift;
        System.out.print("Enter Your plaintext : ");
        plainText = new Scanner(System.in).nextLine();
        System.out.print("Enter the Shift value : ");
        shift = new Scanner(System.in).nextInt();
        cipherText = encrypt(shift,plainText);
        System.out.println("The Encrypted String is : "+cipherText);
        System.out.println("The decrypted String is : "+decrypt(shift,cipherText));


    }
}
