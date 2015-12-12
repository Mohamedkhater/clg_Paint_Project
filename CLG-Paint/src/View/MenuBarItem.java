/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.LinkedList;

/**
 *
 * @author Ahmed
 */
public class MenuBarItem
{
    private String menuParentName;
    private LinkedList<String> childrenNames;

    
    public MenuBarItem(String name)
    {
        this.menuParentName= name;
    }
    
    public void AddSubmenus(String name)
    {
        getChildrenNames().add(name);
    }
    public void AddSubmenus(String[] name)
    {
        for(String s : name)
        {
            getChildrenNames().add(s);
        }
    }

    /**
     * @return the menuParentName
     */
    public String getMenuParentName()
    {
        return menuParentName;
    }

    /**
     * @param menuParentName the menuParentName to set
     */
    public void setMenuParentName(String menuParentName)
    {
        this.menuParentName = menuParentName;
    }

    /**
     * @return the childrenNames
     */
    
    public LinkedList<String> getChildrenNames()
    {
        return childrenNames;
    }
}
