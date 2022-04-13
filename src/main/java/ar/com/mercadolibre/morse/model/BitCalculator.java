package ar.com.mercadolibre.morse.model;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

public class BitCalculator {

    private final BitContainer bitContainer;

    public BitCalculator(String morseBitCoded) {
        this.bitContainer = new BitContainer(morseBitCoded);
    }

    public static int getDotMaxBitLength(String morseBitCoded) {


        return 3;
    }


    private static ArrayList<String> explodeArray(String bits) {
        CharacterIterator itr = new StringCharacterIterator(bits);
        ArrayList<String> lista = new ArrayList<>();

        String word = "";

        for (int i = 0; i <  itr.getEndIndex(); i++) {
            char current = itr.current();
            char next = itr.next();

            if (next != current) {
                lista.add(word);
                word = "" + next;
            }
            else{
                word = word + itr.current();
            }

        }
        return lista;
    }

}

