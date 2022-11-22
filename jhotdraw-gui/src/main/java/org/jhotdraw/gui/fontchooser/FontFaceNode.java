/**
 * @(#)FontFaceNode.java
 *
 * Copyright (c) 2008 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.gui.fontchooser;

import java.awt.Font;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * A FontFaceNode is a MutableTreeNode which does not allow children.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public class FontFaceNode implements MutableTreeNode, Comparable<FontFaceNode>, Cloneable {

    private FontFamilyNode parent;
    private Font typeface;
    private String name;
    Map<String, String> fontsDictionary = FontsDictionary.getInstance().fonts;

    public FontFaceNode(Font typeface) {
        this.typeface = typeface;
        this.name = beautifyName(typeface.getPSName());
    }

    public String addSpacesToString(String name){
        StringBuilder buf = new StringBuilder();
        char prev = name.charAt(0);
        buf.append(prev);
        for (int i = 1; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (prev != ' ' && prev != '-'
                    && Character.isUpperCase(ch) && !Character.isUpperCase(prev)
                    || Character.isDigit(ch) && !Character.isDigit(prev)) {
                buf.append(' ');
            }
            buf.append(ch);
            prev = ch;
        }
        name = buf.toString();
        return name;
    }

    protected String beautifyName(String name) {
        // 'Beautify' the name
        int p = name.lastIndexOf('-');
        name = name.substring(p + 1);
        String lcName = name.toLowerCase();
        if (p != -1) {
            if(fontsDictionary.containsKey(lcName)){
                name = fontsDictionary.get(lcName);
            }
        } else {
            if(fontsDictionary.containsKey(lcName)){
                fontsDictionary.get(lcName);
            }else{
                name = "Plain";
            }
        }
        return addSpacesToString(name);
    }

    public void setName(String newValue) {
        this.name = newValue;
    }

    public String getName() {
        return name;
    }

    public Font getFont() {
        return typeface;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void insert(MutableTreeNode child, int index) {
        throw new UnsupportedOperationException("Not allowed.");
    }

    @Override
    public void remove(int index) {
        throw new UnsupportedOperationException("Not allowed.");
    }

    @Override
    public void remove(MutableTreeNode node) {
        throw new UnsupportedOperationException("Not allowed.");
    }

    @Override
    public void setUserObject(Object object) {
        throw new UnsupportedOperationException("Not allowed.");
    }

    @Override
    public void removeFromParent() {
        if (parent != null) {
            parent.remove(this);
        }
    }

    @Override
    public void setParent(MutableTreeNode newParent) {
        this.parent = (FontFamilyNode) newParent;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        throw new IndexOutOfBoundsException("" + childIndex);
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public int getIndex(TreeNode node) {
        return -1;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Enumeration<TreeNode> children() {
        return Collections.enumeration(Collections.EMPTY_LIST);
    }

    @Override
    public int compareTo(FontFaceNode that) {
        return this.name.compareTo(that.name);
    }

    @Override
    public FontFaceNode clone() {
        FontFaceNode that;
        try {
            that = (FontFaceNode) super.clone();
        } catch (CloneNotSupportedException ex) {
            InternalError error = new InternalError("Clone failed");
            error.initCause(ex);
            throw error;
        }
        that.parent = null;
        return that;
    }

    public boolean isEditable() {
        return false;
    }
}
