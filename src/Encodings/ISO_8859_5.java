package Encodings;

import ActionsClasses.*;

public class ISO_8859_5 {
    public void decDecode(String string){
        System.out.print("DEC: ");
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++){
            String str = Character.toString(chars[i]);
            System.out.print(Parser.isoDecMap.get(str));
        }
    }

    public void hexDecode(String string){
        System.out.print("\nHEX: ");
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++){
            String str = Character.toString(chars[i]);
            System.out.print(Parser.isoHexMap.get(str));
        }
    }

    public void octDecode(String string){
        System.out.print("\nOCT: ");
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++){
            String str = Character.toString(chars[i]);
            System.out.print(Parser.isoOctMap.get(str));
        }
        System.out.println();
    }
}
