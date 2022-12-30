package org.jhotdraw.gui.fontchooser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class FontsListDictionary {

    String web = "Arial,Arial Black,Comic Sans MS,Georgia,Impact,Times New Roman,Trebuchet MS,Verdana,Webdings";
    String system = "Dialog,DialogInput,Monospaced,SansSerif,Serif";
    String serif = "Adobe Caslon Pro,Adobe Garamond Pro,American Typewriter,Arno Pro,Baskerville,Baskerville Old Face,Bell MT,Big Caslon,Bodoni SvtyTwo ITC TT,Bodoni SvtyTwo OS ITC TT,Bodoni SvtyTwo SC ITC TT,Book Antiqua,Bookman Old Style,Calisto MT,Chaparral Pro,Century,Century Schoolbook,Cochin,Footlight MT Light,Garamond,Garamond Premier Pro,Georgia,Goudy Old Style,Hoefler Text,Lucida Bright,Lucida Fax,Minion Pro,Palatino,Times,Times New Roman,Palatino Linotype,Bitstream Vera Serif Bold,Bodoni MT,Bodoni MT Black,Bodoni MT Condensed,Californian FB,Cambria,Cambria Math,Centaur,Constantia,High Tower Text,Perpetua,Poor Richard,Rockwell Condensed,Slimbach-Black,Slimbach-BlackItalic,Slimbach-Bold,Slimbach-BoldItalic,Slimbach-Book,Slimbach-BookItalic,Slimbach-Medium,Slimbach-MediumItalic,Sylfaen,Andalus,Angsana New,AngsanaUPC,Arabic Typesetting,Cambria,Cambria Math,Constantia,DaunPenh,David,DilleniaUPC,EucrosiaUPC,Frank Ruehl,IrisUPC,Iskoola Pota,JasmineUPC,KodchiangUPC,Narkisim";
    String sansSerif = "Abadi MT Condensed Extra Bold,Abadi MT Condensed Light,Al Bayan,AppleGothic,Arial,Arial Black,Arial Narrow,Arial Rounded MT Bold,Arial Unicode MS,Bell Gothic Std,Blair MdITC TT,Century Gothic,Frutiger,Futura,Geneva,Gill Sans,Gulim,Helvetica,Helvetica Neue,Lucida Grande,Lucida Sans,Microsoft Sans Serif,Myriad Pro,News Gothic,Tahoma,Trebuchet MS,Verdana,Franklin Gothic Medium,Lucida Sans Unicode,Agency FB,Berlin Sans FB,Berlin Sans FB Demi Bold,Bitstream Vera Sans Bold,Calibri,Candara,Corbel,Estrangelo Edessa,Eras Bold ITC,Eras Demi ITC,Eras Light ITC,Eras Medium ITC,Franklin Gothic Book,Franklin Gothic Demi,Franklin Gothic Demi Cond,Franklin Gothic Heavy,Franklin Gothic Medium Cond,Gill Sans MT,Gill Sans MT Condensed,Gill Sans MT Ext Condensed Bold,Maiandra GD,MS Reference Sans...,Tw Cen MT,Tw Cen MT Condensed,Tw Cen MT Condensed Extra Bold,Aharoni,Browallia New,BrowalliaUPC,Calibri,Candara,Corbel,Cordia New,CordiaUPC,DokChampa,Dotum,Estrangelo Edessa,Euphemia,Freesia UPC,Gautami,Gisha,Kalinga,Kartika,Levenim MT,LilyUPC,Malgun Gothic,Meiryo,Miriam,Segoe UI";
    String script = "Apple Chancery,Bickham Script Pro,Blackmoor LET,Bradley Hand ITC TT,Brush Script MT,Brush Script Std,Chalkboard,Charlemagne Std,Comic Sans MS,Curlz MT,Edwardian Script ITC,Footlight MT Light,Giddyup Std,Handwriting - Dakota,Harrington,Herculanum,Kokonor,Lithos Pro,Lucida Blackletter,Lucida Calligraphy,Lucida Handwriting,Marker Felt,Matura MT Script Capitals,Mistral,Monotype Corsiva,Party LET,Papyrus,Santa Fe LET,Savoye LET,SchoolHouse Cursive B,SchoolHouse Printed A,Skia,Snell Roundhand,Tekton Pro,Trajan Pro,Zapfino,Blackadder ITC,Bradley Hand ITC,Chiller,Freestyle Script,French Script MT,Gigi,Harlow Solid Italic,Informal Roman,Juice ITC,Kristen ITC,Kunstler Script,Magneto Bold,Maiandra GD,Old English Text,Palace Script MT,Parchment,Pristina,Rage Italic,Ravie,Script MT Bold,Tempus Sans ITC,Viner Hand ITC,Vivaldi Italic,Vladimir Script,Segoe Print,Segoe Script";
    String monospaced = "Andale Mono,Courier,Courier New,Letter Gothic Std,Lucida Sans Typewriter,Monaco,OCR A Std,Orator Std,Prestige Elite Std,Lucida Console,Bitstream Vera S...,Consolas,OCR A Extended,OCR B,Consolas,DotumChe,Miriam Fixed,Rod";
    String decorative = "Academy Engraved LET,Arial Black,Bank Gothic,Bauhaus 93,Bernard MT Condensed,Birch Std,Blackoak Std,BlairMdITC TT,Bordeaux Roman Bold LET,Braggadocio,Britannic Bold,Capitals,Colonna MT,Cooper Black,Cooper Std,Copperplate,Copperplate Gothic Bold,Copperplate Gothic Light,Cracked,Desdemona,Didot,Eccentric Std,Engravers MT,Eurostile,Gill Sans Ultra Bold,Gloucester MT Extra Condensed,Haettenschweiler,Hobo Std,Impact,Imprint MT Shadow,Jazz LET,Kino MT,Matura MT Script Capitals,Mesquite Std,Modern No. 20,Mona Lisa Solid ITC TT,MS Gothic,Nueva Std,Onyx,Optima,Perpetua Titling MT,Playbill,Poplar Std,PortagoITC TT,Princetown LET,Rockwell,Rockwell Extra Bold,Rosewood Std,Santa Fe LET,Stencil,Stencil Std,Stone Sans ITC TT,Stone Sans OS ITC TT,Stone Sans Sem ITC TT,Stone Sans Sem OS ITCTT,Stone Sans Sem OS ITC TT,Synchro LET,Wide Latin,Algerian,Bodoni MT Black,Bodoni MT Poster Compressed,Broadway,Castellar,Elephant,Felix Titling,Franklin Gothic Heavy,Gill Sans MT Ext Condensed Bold,Gill Sans Ultra Bold Condensed,Goudy Stout,Jokerman,Juice ITC,Magneto,Magneto Bold,Niagara Engraved,Niagara Solid,Poor Richard,Ravie,Rockwell Condensed,Showcard Gothic,Slimbach-Black,Slimbach-BlackItalic,Snap ITC";
    String symbols = "Apple Symbols,Blackoack Std,Bodoni Ornaments ITC TT,EuropeanPi,Monotype Sorts,MT Extra,Symbol,Type Embellishments One LET,Webdings,Wingdings,Wingdings 2,Wingdings 3,Zapf Dingbats,Bookshelf Symbol";

    ArrayList<String> webList = new ArrayList<>(Arrays.asList(web.split(",")));
    ArrayList<String> systemList = new ArrayList<>(Arrays.asList(system.split(",")));
    ArrayList<String> serifList = new ArrayList<>(Arrays.asList(serif.split(",")));
    ArrayList<String> sansSerifList = new ArrayList<>(Arrays.asList(sansSerif.split(",")));
    ArrayList<String> scriptList = new ArrayList<>(Arrays.asList(script.split(",")));
    ArrayList<String> monospacedList = new ArrayList<>(Arrays.asList(monospaced.split(",")));
    ArrayList<String> decorativeList = new ArrayList<>(Arrays.asList(decorative.split(",")));
    ArrayList<String> symbolsList = new ArrayList<>(Arrays.asList(symbols.split(",")));

    public Map<String, ArrayList<String>> fontsList;

    public static FontsListDictionary instance = null;

    private FontsListDictionary(){
        fontsList = Map.ofEntries(
                entry("web", webList),
                entry("system", systemList),
                entry("serif",serifList),
                entry("sansSerif", sansSerifList),
                entry("script",scriptList),
                entry("monospaced",monospacedList),
                entry("decorative",decorativeList),
                entry("symbols",symbolsList)
        );
    }

    public static FontsListDictionary getInstance(){
        if(instance == null){
            instance = new FontsListDictionary();
        }
        return instance;
    }
}
