package ActionsClasses;

import Encodings.*;

public class DecoderSelector {

    public static void select(String string, String decodeSystem){
        switch (decodeSystem){
            case "iso-8859-5":
                ISO_8859_5 iso_8859_5 = new ISO_8859_5();

                iso_8859_5.decDecode(string);
                iso_8859_5.hexDecode(string);
                iso_8859_5.octDecode(string);
                break;
            case "utf-8":
                UTF_8 utf_8 = new UTF_8();

                utf_8.decDecode(string);
                utf_8.hexDecode(string);
                utf_8.octDecode(string);
                break;
        }
    }
}
