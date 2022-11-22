package org.jhotdraw.gui.fontchooser;

import java.util.Map;
import static java.util.Map.entry;

public class FontsDictionary {
    public Map<String, String> fonts;
    public static FontsDictionary instance = null;

    private FontsDictionary(){
        fonts = Map.ofEntries(
                entry("plain", "Plain"),
                entry("boldoblique", "Bold Oblique"),
                entry("bolditalic","Bold Italic"),
                entry("bookita", "Book Italic"),
                entry("bookit","Book Italic"),
                entry("demibold","Demi Bold"),
                entry("semiita","Semi Italic"),
                entry("italic","Italic"),
                entry("book","Book"),
                entry("bold","Bold"),
                entry("bol","Bold"),
                entry("oblique","Oblique"),
                entry("regular","Regular"),
                entry("semi","Semi")
        );
    }

    public static FontsDictionary getInstance(){
        if(instance == null){
            instance = new FontsDictionary();
        }
        return instance;
    }

}