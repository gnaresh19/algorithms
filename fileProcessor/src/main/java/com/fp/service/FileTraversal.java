package com.fp.service;

import java.io.IOException;

public interface FileTraversal {

    public void breadthFristFileTraversal(String fileName, Integer height) throws IOException;

    public void printBreadthFirstFileTraversal(String fileName, Integer height, boolean printLastDateModifiedAndSizeOfFile) throws IOException;
    
    public void printDepthFirstFileTraversal(String fileName,boolean printLastDateModifiedAndSizeOfFile) throws IOException;
}
