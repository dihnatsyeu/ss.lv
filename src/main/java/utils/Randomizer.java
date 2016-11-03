package utils;

import language_pack.LanguageElement;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

public class Randomizer {
    
    
    public static LanguageElement randomItemFromList(Class<? extends LanguageElement> cls) {
       List<LanguageElement> allOptions = LanguageElement.getValues(cls);
       int randomIndex = new Random().nextInt(allOptions.size());
       return allOptions.get(randomIndex);
    }
    
    public static String randomString(int length) {
        byte[] array = new byte[length];
        return new String(array, Charset.forName("UTF-8"));
    }
    
    
    public static Integer randomInteger(int startIndex, int endIndex) {
        return new Random().nextInt((endIndex - startIndex) +1) + startIndex;
    }
}
