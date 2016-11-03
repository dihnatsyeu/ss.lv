package language_pack;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class LanguageElement {
    
    private String ruName;
    private String lvName;
    
    LanguageElement(String ruName, String lvName) {
        this.ruName = ruName;
        this.lvName = lvName;
    }
    
   public static List<LanguageElement> getValues(Class<? extends LanguageElement> cls) {
       List<Field> staticFields = Arrays.stream(cls.getDeclaredFields())
               .filter(field -> Modifier.isStatic(field.getModifiers()))
               .collect(Collectors.toList());
       List<LanguageElement> values = new ArrayList<>();
       staticFields.forEach(field -> {
           try {
               values.add(cls.cast(field.get(null)));
           } catch (IllegalAccessException e) {
               throw new AssertionError("Cannot get value of Collection:" + cls);
           }
       });
       return Collections.unmodifiableList(values);
   }
    
   String getRuName() {
        return new String(ruName.getBytes(Charset.forName("UTF-8")));
    }
   
    
   String getLvName() {
        return new String(lvName.getBytes(Charset.forName("UTF-8")));
    }
    
    
}
