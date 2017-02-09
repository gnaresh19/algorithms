package com.fp.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fp.app.FileDecorator;
import com.fp.service.FileTraversal;

public class FileTraversalImpl implements FileTraversal {

    final Map<Integer, List<File>> breadthFirstMap = new HashMap<Integer, List<File>>();
    final Logger log = Logger.getLogger(FileTraversalImpl.class);

    public void breadthFristFileTraversal(String fileName, Integer height) throws IOException {

        if (fileName != null && fileName.length() > 0) {
            File dir = new File(fileName);
            if(!dir.exists()){
                throw new FileNotFoundException("Invalid FileName passed"); 
            }
            List<File> list = new ArrayList<File>();
            list.add(dir);
            if (breadthFirstMap.get(height) == null) {
                breadthFirstMap.put(height, list);
            } else {
                List<File> existingList = breadthFirstMap.get(height);
                if (existingList != null) {
                    existingList.add(dir);
                    breadthFirstMap.put(height, existingList);
                }
            }

            if (dir.isDirectory()) {
                File files[] = dir.listFiles();
                for (File f : files) {
                    breadthFristFileTraversal(f.getPath(), height + 1);
                }
            }

        } else {
            log.error(" FileName passed in as EMPTY ");
            throw new FileNotFoundException("FileName passed in as EMPTY ");

        }

    }

    public void printDepthFirstFileTraversal(String fileName, boolean printLastDateModifiedAndSizeOfFile)
            throws IOException {

        if (fileName != null && fileName.length() > 0) {
            File dir = new File(fileName);
            if(!dir.exists()){
                throw new FileNotFoundException("Invalid FileName passed"); 
            }
            File files[] = dir.listFiles();
            if (files != null && files.length > 0) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isFile()) {
                        printFile(files[i], printLastDateModifiedAndSizeOfFile);
                    } else if (files[i].isDirectory()) {
                        printFile(files[i], printLastDateModifiedAndSizeOfFile);
                        printDepthFirstFileTraversal(files[i].getAbsolutePath(), printLastDateModifiedAndSizeOfFile);
                    }
                }
            } 
        } else {
            log.error(" FileName passed in as EMPTY ");
            throw new FileNotFoundException("FileName passed in as EMPTY ");
        }
    }

    public void printBreadthFirstFileTraversal(String fileName, Integer height,
            boolean printLastDateModifiedAndSizeOfFile) throws IOException {
        breadthFristFileTraversal(fileName, height);
        for (Map.Entry<Integer, List<File>> entry : breadthFirstMap.entrySet()) {
            log.info(" Level => " + entry.getKey());
            for (File file : entry.getValue()) {
                printFile(file, printLastDateModifiedAndSizeOfFile);
            }
        }

    }

    private void printFile(File file, boolean printLastDateModifiedAndSizeOfFile) {
        if (printLastDateModifiedAndSizeOfFile) {
            FileDecorator.printFileNameLastModifiedAndSize(file);
        } else {
            FileDecorator.printFileName(file);
        }
    }

}
