package com.fp.app;

import org.apache.log4j.Logger;

import com.fp.service.FileTraversal;
import com.fp.service.impl.FileTraversalImpl;


public class Main {

    final static Logger log = Logger.getLogger(FileTraversalImpl.class);

    /*
     * Given an arbitrary directory in any file-sytem, the program should
        Output A:   Print out all file and directory names
        Output B: Output A along with size and date modified
        Demonstrate 1 and 2 using DFS and BFS
     */
    public static void main(String args[]) throws Exception{
        
        FileTraversal traversal = new FileTraversalImpl();
        
        /*
         * Change the input path to any directory or sub-direcotry name.
         * For demo purpose I am taking current directory.
         */
        //String path="/Users/fpmedala/workspace_luna/instantly";
       
        String path = System.getProperty("user.dir");
        log.info(" Current Directory "+path);
       
        log.info("List all File Names using DepthFirst File Traversal ");
        traversal.printDepthFirstFileTraversal(path,false);
        
        log.info("List of File Names using BreadthFirst FileTraversal");
        traversal.printBreadthFirstFileTraversal(path, 0, false);
        
        log.info("List all File Names, date modified, size using DepthFirst File Traversal ");
        traversal.printDepthFirstFileTraversal(path,true);
        
        log.info("List all File Names, date modified, size using BreadthFirst FileTraversal");
        traversal.printBreadthFirstFileTraversal(path, 0, true);
        
    }
}
