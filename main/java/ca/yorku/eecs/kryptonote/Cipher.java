package ca.yorku.eecs.kryptonote;

public class Cipher
{
    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String key;

     public Cipher (String S)
     {
         this.key = S;
     }

     private String makePad(String note)
     {
         String pad;
         for (pad = this.key; pad.length() < note.length(); pad += this.key);

         return pad;
     }

     public String encrypt(String note)
     {
         String pad = makePad(note);
         String result = "";
         for (int i = 0; i < note.length(); i++)

         {
             String c = note.substring(i, i + 1);
             int position = ALPHABET.indexOf(c);
             int shift = Integer.parseInt(pad.substring(i, i + 1));
             int newPosition = (position + shift) % ALPHABET.length();
             result = result + ALPHABET.substring(newPosition, newPosition + 1);
         }

         return result;
     }

     public String decrypt(String note)
     {
         String pad = makePad(note);
         String result = "";
         for (int j = 0; j < note.length(); j++)

         {
             String c = note.substring(j, j + 1);
             int position = ALPHABET.indexOf(c);
             int shift = Integer.parseInt(pad.substring(j, j + 1));
             int newPosition = (position - shift) % ALPHABET.length();
             result = result + ALPHABET.substring(newPosition, newPosition + 1);
         }

         return result;

     }
}
