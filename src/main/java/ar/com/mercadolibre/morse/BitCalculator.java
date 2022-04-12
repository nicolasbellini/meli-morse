package ar.com.mercadolibre.morse;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;
import java.util.stream.Collectors;

public class BitCalculator {
    public static int getDotMaxBitLength(String morseBitCoded1) {

        ArrayList<String>  unos = getRepetitions(morseBitCoded1, '0', '1');
        ArrayList<String>  ceros = getRepetitions(morseBitCoded1, '1', '0') ;

        List<String> puntos = unos.subList(0, unos.size() / 2);
        List<String> rasha = unos.subList(unos.size() / 2, unos.size());

        List<String> espLetra = ceros.subList(0, unos.size() / 2);
        List<String> espPalabra = ceros.subList(unos.size() / 2, unos.size());

        ArrayList<String> explodedArrray = explodeArray(morseBitCoded1);

        return 3;
    }

    private static ArrayList<String> getRepetitions(String bits, char noquiero, char quiero) {
        CharacterIterator itr = new StringCharacterIterator(bits);
        String current = "";
        Set<String> set = new HashSet<String>();

        for (int i = 0; i <  itr.getEndIndex(); i++) {
            if (itr.current() == noquiero) {
                set.add(current);
                current = "";
                itr.next();
            }
            else{
                current = current + quiero;
                itr.next();
            }

        }
        set.remove("");
        ArrayList<String> list = new ArrayList<String>(set);
        Collections.sort(list);

        return list;
    }

    private static ArrayList<String> explodeArray(String bits) {
        CharacterIterator itr = new StringCharacterIterator(bits);
        ArrayList<String> lista = new ArrayList<String>();
        Character old = itr.current();

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

/*    private static ArrayList<String> initDictionary(List<String> list) {
        HashMap<String, String> set =  Arrays.stream(list)
                .collect(Collectors.toMap(
                        // Key.
                        s -> Integer.valueOf(s.split(":")[0]),
                        // Value.
                        s -> s.split(":")[1]
                ));
    }*/
}

