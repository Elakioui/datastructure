package linear;

import java.util.HashSet;
import java.util.Set;

public class CharacterFinder {


    public static char firstRepeatedCharacter(String value){

        // a v e r y g o a d g i r l

        Set<Character> charactersNotRepeated = new HashSet<>();

        for (Character c : value.toCharArray()){

            if(charactersNotRepeated.contains(c))
                return c;

            charactersNotRepeated.add(c);

        }

        return Character.MIN_VALUE;

    }

    public static char firstNotRepeatedCharacter(String value){

        char[] listOfCaracters = value.toCharArray();



        char firstNotRepeated = listOfCaracters[0];
        int i = 1;
        int j = 0;

        while(i < listOfCaracters.length){
            if(firstNotRepeated != listOfCaracters[i]){
                i++;
            }
            else {
                firstNotRepeated = listOfCaracters[j++];
                i = j + 1;
            }
        }

        return firstNotRepeated;
    }
}
