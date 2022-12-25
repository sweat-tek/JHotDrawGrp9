/**
 * @(#)DefaultFontModel.java
 *
 * Copyright (c) 2008 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.gui.fontchooser;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.*;
import javax.swing.tree.*;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * DefaultFontChooserModel with a predefined set of font collections.
 * <p>
 * Loading the fonts may take a lot of time. Therefore it is recommended to
 * create a Future during the startup of an application, and set the fonts in
 * the font chooser model when they are needed.
 * <p>
 * Example:
 * <pre>
 *   private static FutureTask&lt;Font[]&gt; future = new FutureTask&lt;Font[]&gt;(new Callable&lt;Font[]&gt;() {
 *
 *      public Font[] call() throws Exception {
 *          return GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
 *
 *       }
 *   });
 * </pre>
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public class DefaultFontChooserModel extends AbstractFontChooserModel {

    /**
     * Root node.
     */
    protected DefaultMutableTreeNode root;
    Map<String, ArrayList<String>> fontsList = FontsListDictionary.getInstance().fontsList;

    public DefaultFontChooserModel() {
        root = new DefaultMutableTreeNode();
    }

    public DefaultFontChooserModel(Font[] fonts){
        root = new DefaultMutableTreeNode();
        setFonts(fonts);
    }

    /**
     * Sets the fonts of the DefaultFontChooserModel.
     * <p>
     * Fires treeStructureChanged event on the root node.
     *
     * @param fonts
     */
    @SuppressWarnings("unchecked")
    public void setFonts(Font[] fonts){
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.gui.Labels");
        // collect families and sort them alphabetically
        ArrayList<FontFamilyNode> families = new ArrayList<>();
        HashMap<String, FontFamilyNode> familyMap = new HashMap<>();
        for (Font f : fonts) {
            String familyName = f.getFamily();
            FontFamilyNode family;
            if (familyMap.containsKey(familyName)) {
                family = familyMap.get(familyName);
            } else {
                family = new FontFamilyNode(familyName);
                familyMap.put(familyName, family);
            }
            family.add(new FontFaceNode(f));
        }
        families.addAll(familyMap.values());
        Collections.sort(families);

        // group families into collections
        root.removeAllChildren();
        root.add(new FontCollectionNode(labels.getString("FontCollection.allFonts"), (ArrayList<FontFamilyNode>) families.clone()));
        // Web-save fonts
        root.add(
                new FontCollectionNode(labels.getString("FontCollection.web"), collectFamiliesNamed(families, fontsList.get("web"))));
        // Java System fonts
        root.add(
                new FontCollectionNode(labels.getString("FontCollection.system"), collectFamiliesNamed(families, fontsList.get("system"))));
        // Serif fonts
        root.add(
                new FontCollectionNode(labels.getString("FontCollection.serif"), collectFamiliesNamed(families, fontsList.get("serif"))));
        // Sans Serif
        root.add(
                new FontCollectionNode(labels.getString("FontCollection.sansSerif"), collectFamiliesNamed(families, fontsList.get("sansSerif"))));
        // Scripts
        root.add(
                new FontCollectionNode(labels.getString("FontCollection.script"), collectFamiliesNamed(families, fontsList.get("script"))));
        // Monospaced
        root.add(
                new FontCollectionNode(labels.getString("FontCollection.monospaced"), collectFamiliesNamed(families, fontsList.get("monospaced"))));
        // Decorative
        root.add(
                new FontCollectionNode(labels.getString("FontCollection.decorative"), collectFamiliesNamed(families, fontsList.get("decorative"))));
        root.add(
                new FontCollectionNode(labels.getString("FontCollection.symbols"), collectFamiliesNamed(families, fontsList.get("symbols"))));

        // Collect font families, which are not in one of the other collections
        // (except the collection AllFonts).
        FontCollectionNode others = new FontCollectionNode(labels.getString("FontCollection.other"));
        HashSet<FontFamilyNode> otherFamilySet = new HashSet<>();
        otherFamilySet.addAll(families);
        for (int i = 1, n = root.getChildCount(); i < n; i++) {
            FontCollectionNode fcn = (FontCollectionNode) root.getChildAt(i);
            for (FontFamilyNode ffn : fcn.families()) {
                otherFamilySet.remove(ffn);
            }
        }
        ArrayList<FontFamilyNode> otherFamilies = new ArrayList<>();
        for (FontFamilyNode ffn : otherFamilySet) {
            otherFamilies.add(ffn.clone());
        }
        Collections.sort(otherFamilies);
        others.addAll(otherFamilies);
        root.add(others);
        fireTreeStructureChanged(this, new TreePath(root));
    }

    protected ArrayList<FontFamilyNode> collectFamiliesNamed(ArrayList<FontFamilyNode> families, ArrayList<String> fontsList) {
        ArrayList<FontFamilyNode> coll = new ArrayList<>();
        HashSet<String> nameMap = new HashSet<>();
        nameMap.addAll(fontsList);
        for (FontFamilyNode family : families) {
            String fName = family.getName();
            if (nameMap.contains(family.getName())) {
                coll.add(family.clone());
            }
        }
        return coll;
    }

    @Override
    public boolean isEditable(MutableTreeNode node) {
        boolean result = true;
        if (node instanceof FontFaceNode) {
            result &= ((FontFaceNode) node).isEditable();
            node = (MutableTreeNode) node.getParent();
        }
        if (result && (node instanceof FontFamilyNode)) {
            result &= ((FontFamilyNode) node).isEditable();
            node = (MutableTreeNode) node.getParent();
        }
        if (result && (node instanceof FontCollectionNode)) {
            result &= ((FontCollectionNode) node).isEditable();
        }
        return result;
    }

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object getChild(
            Object parent, int index) {
        return ((TreeNode) parent).getChildAt(index);
    }

    @Override
    public int getChildCount(Object parent) {
        return ((TreeNode) parent).getChildCount();
    }

    @Override
    public boolean isLeaf(Object node) {
        return ((TreeNode) node).isLeaf();
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        return ((TreeNode) parent).getIndex((TreeNode) child);
    }

    public static class UIResource extends DefaultFontChooserModel implements javax.swing.plaf.UIResource {
    }
}
