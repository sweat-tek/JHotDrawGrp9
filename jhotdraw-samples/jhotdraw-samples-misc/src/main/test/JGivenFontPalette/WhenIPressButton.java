package JGivenFontPalette;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.gui.JFontChooser;
import org.jhotdraw.gui.action.ButtonFactory;
import org.jhotdraw.gui.action.FontChooserHandler;
import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.*;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

import static org.jhotdraw.draw.AttributeKeys.FONT_FACE;

public class WhenIPressButton extends Stage<WhenIPressButton> {


    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;
    private JPopupMenu jPopUpMenu;
    @ProvidedScenarioState
    private Set<Figure> textFigures;
    private FontChooserHandler fontChooserHandler;
    private JButton boldButton;
    private JButton italicButton;
    private JButton underlineButton;
    private JFontChooser jFontChooser;
    private ResourceBundleUtil labels;

    @BeforeStage
    public void before(){
        jPopUpMenu = new JPopupMenu();
        jFontChooser = new JFontChooser();
        labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        fontChooserHandler = new FontChooserHandler(editor, FONT_FACE, jFontChooser, jPopUpMenu);
        boldButton = ButtonFactory.createFontStyleBoldButton(editor, labels);
        italicButton = ButtonFactory.createFontStyleItalicButton(editor, labels);
        underlineButton = ButtonFactory.createFontStyleUnderlineButton(editor, labels);
        textFigures = new HashSet<>(editor.getActiveView().getSelectedFigures());
    }

    WhenIPressButton IChangeFontFace(){
        jFontChooser.setSelectedFont(new Font("Verdana", Font.PLAIN, 14));
        fontChooserHandler.applySelectedFontToFigures();
        return this;
    }

    WhenIPressButton IChangeFontSize(){
        jFontChooser.setSelectedFont(new Font("Verdana", Font.PLAIN, 16));
        fontChooserHandler.applySelectedFontToFigures();
        return this;
    }
    WhenIPressButton boldFontButtonPressed(){
        boldButton.doClick();
        return this;
    }
    WhenIPressButton italicFontButtonPressed(){
        jFontChooser.setSelectedFont(new Font("Verdana", Font.ITALIC, 16));
        fontChooserHandler.applySelectedFontToFigures();
        return this;
    }
    WhenIPressButton underlineFontButtonPressed(){
        underlineButton.doClick();
        return this;
    }



}
