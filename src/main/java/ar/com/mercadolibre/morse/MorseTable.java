package ar.com.mercadolibre.morse;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class MorseTable {

    private static BidiMap<String, String> charMap = load(new DualHashBidiMap<>());

    public static BidiMap<String, String> getLetterToMorseMap(){
        return charMap.inverseBidiMap();
    }

    public static BidiMap<String, String> getMorseToLetterMap(){
        return charMap.inverseBidiMap().inverseBidiMap();
    }

    public static DualHashBidiMap<String, String> load(DualHashBidiMap<String, String> morseConvertionMap) {

        morseConvertionMap.put("A",".-");
        morseConvertionMap.put("B","-...");
        morseConvertionMap.put("C","-.-.");
        morseConvertionMap.put("D","-..");
        morseConvertionMap.put("E",".");
        morseConvertionMap.put("F","..-.");
        morseConvertionMap.put("G","--.");
        morseConvertionMap.put("H","....");
        morseConvertionMap.put("I","..");
        morseConvertionMap.put("J",".---");
        morseConvertionMap.put("K","-.-");
        morseConvertionMap.put("L",".-..");
        morseConvertionMap.put("M","--");
        morseConvertionMap.put("N","-.");
        morseConvertionMap.put("O","---");
        morseConvertionMap.put("P",".--.");
        morseConvertionMap.put("Q","--.-");
        morseConvertionMap.put("R",".-.");
        morseConvertionMap.put("S","...");
        morseConvertionMap.put("T","-");
        morseConvertionMap.put("U","..-");
        morseConvertionMap.put("V","...-");
        morseConvertionMap.put("W",".--");
        morseConvertionMap.put("X","-..-");
        morseConvertionMap.put("Y","-.--");
        morseConvertionMap.put("Z","--..");
        morseConvertionMap.put("0","-----");
        morseConvertionMap.put("1",".----");
        morseConvertionMap.put("2","..---");
        morseConvertionMap.put("3","...--");
        morseConvertionMap.put("4","....- ");
        morseConvertionMap.put("5",".....");
        morseConvertionMap.put("6","-....");
        morseConvertionMap.put("7","--...");
        morseConvertionMap.put("8","---..");
        morseConvertionMap.put("9","----.");
        morseConvertionMap.put(" ","");

        return morseConvertionMap;
    }
}
