package ar.com.mercadolibre.morse;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BitCalculator {

    public static int getDotMaxBitLength(String morseBitCoded1) {

        final Pattern pattern = Pattern.compile("1+|0+", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(morseBitCoded1);
        ArrayList<String> all = new ArrayList<>();
        while (matcher.find()){
            all.add(matcher.group());
        }

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

