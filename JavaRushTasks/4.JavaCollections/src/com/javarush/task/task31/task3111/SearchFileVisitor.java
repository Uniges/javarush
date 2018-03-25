package com.javarush.task.task31.task3111;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private List<Path> foundFiles = new ArrayList<>();
    private String partOfName, partOfContent;
    private int minSize, maxSize;

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean result = true;

        if (partOfName != null && result) if (!file.getFileName().toString().contains(partOfName)) result = false;
        if (partOfContent != null && result) {
            BufferedReader bufferedReader = Files.newBufferedReader(file);
            StringBuilder stringBuilder = new StringBuilder();
            String s;
            while ((s = bufferedReader.readLine()) != null) stringBuilder.append(s);
            if (!stringBuilder.toString().contains(partOfContent)) result = false;
        }
        if (minSize != 0 && result) if (attrs.size() < minSize) result = false;
        if (maxSize != 0 && result) if (attrs.size() > maxSize) result = false;

        if (result) foundFiles.add(file);

        return super.visitFile(file, attrs);
    }
}
