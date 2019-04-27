package ActionsClasses;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Decoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        String decodeType;
        try {
            for (;;){
                System.out.println("для выхода нажмите ctrl + D\nСписок доступных кодировок: " +
                        "iso-8859-5, utf-8");
                System.out.print("введите строку: ");
                if (!scanner.hasNextLine()){
                    return;
                }
                line = scanner.nextLine();

                System.out.print("введите кодировку: ");
                if (!scanner.hasNextLine()){
                    return;
                }
                decodeType = scanner.nextLine();

                if (!line.equals("") && !decodeType.equals("")){
                    Parser.parseFile(new File("encodings.xml"), decodeType);
                    DecoderSelector.select(line,decodeType.trim().toLowerCase());
                }else continue;
            }

        }catch (InputMismatchException e){
            e.printStackTrace();
        }finally {
            scanner.close();
        }
    }
}
