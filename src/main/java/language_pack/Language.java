package language_pack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Language {
    LV, RU;
    
    
    public static Language getOpposite(Language language) {
        
        List<Language> options = Arrays.asList(Language.values());
        List<Language> required = options.stream()
                .filter(option -> !option.equals(language))
                .collect(Collectors.toList());
        
        return required.get(0);
                
    }
}
