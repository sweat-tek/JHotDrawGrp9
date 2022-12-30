import org.jhotdraw.gui.JFontChooser;
import org.jhotdraw.gui.fontchooser.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class DefaultFontChooserModelTest {

    DefaultFontChooserModel defaultFontChooserModel;
    JFontChooser jFontChoser;


    @Before
    public void setUp(){
        defaultFontChooserModel = new DefaultFontChooserModel();
        jFontChoser = new JFontChooser();
    }

    @Test
    public void collectFontFamiliesSortedTest(){
        ArrayList<FontFamilyNode> result = defaultFontChooserModel.collectFontFamiliesSorted(JFontChooser.getAllFonts());
        ArrayList<FontFamilyNode> expected = defaultFontChooserModel.collectFontFamiliesSorted(JFontChooser.getAllFonts());
        Collections.sort(expected);
        int expectedSize = 239;

        System.out.println("Checking the size");
        assertEquals(expectedSize, result.size());
        System.out.println("Compare lists");
        assertEquals(expected, result);
    }

    @Test
    public void collectFamiliesNamed(){
        ArrayList<FontFamilyNode> families = defaultFontChooserModel.collectFontFamiliesSorted(JFontChooser.getAllFonts());
        ArrayList<String> expected = FontsListDictionary.getInstance().fontsList.get("web");
        ArrayList<FontFamilyNode> listOfFont = defaultFontChooserModel.collectFamiliesNamed(families, expected);
        ArrayList<String> result = new ArrayList<>();

        for(FontFamilyNode font : listOfFont){
            result.add(font.getName());
        }
        assertEquals(expected, result);
    }


}
