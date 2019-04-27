package ActionsClasses;

import Encodings.*;

public class DecoderSelector {

    public static void select(String string, String decodeSystem){
        decDecode decDecode = string1 -> {
            System.out.print("DEC: ");
            char[] chars = string.toCharArray();
            for (int i = 0; i < chars.length; i++){
                String str = Character.toString(chars[i]);
                System.out.print(Parser.decMap.get(str));
            }
        };
        hexDecode hexDecode = string1 -> {
            System.out.print("\nHEX: ");
            char[] chars = string.toCharArray();
            for (int i = 0; i < chars.length; i++){
                String str = Character.toString(chars[i]);
                System.out.print(Parser.hexMap.get(str));
            }
        };
        octDecode octDecode = string1 -> {
            System.out.print("\nOCT: ");
            char[] chars = string.toCharArray();
            for (int i = 0; i < chars.length; i++){
                String str = Character.toString(chars[i]);
                System.out.print(Parser.octMap.get(str));
            }
            System.out.println();
        };
        switch (decodeSystem){
            case "iso-8859-5":
            case "utf-8":
                decDecode.decDecode(string);
                hexDecode.hexDecode(string);
                octDecode.octDecode(string);
                break;
        }
    }
}
