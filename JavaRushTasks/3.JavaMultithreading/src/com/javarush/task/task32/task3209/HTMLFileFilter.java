package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        //return (f.isDirectory() || f.getName().endsWith(".html") || f.getName().endsWith(".htm"));

        /*boolean result = false;
        if (f.isDirectory()) result = true;
        else if (f.getName().endsWith(".html")) result = true;
        else if (f.getName().endsWith(".htm")) result = true;
        return result;*/
        String s = f.getName();
        return (f.isDirectory() || s.substring(s.length()-5).equalsIgnoreCase(".html")|| s.substring(s.length()-4).equalsIgnoreCase(".htm"));
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
