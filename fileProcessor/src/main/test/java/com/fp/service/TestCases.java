package com.fp.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.fp.service.impl.FileTraversalImpl;

public class TestCases {

    final static Logger log = Logger.getLogger(FileTraversalImpl.class);

    @Test
    public void testBreadthFirstTraversal() throws IOException {

        FileTraversal traversal = new FileTraversalImpl();
        String path = System.getProperty("user.dir");
        log.info(" Current Directory " + path);

        Assert.assertNotNull(path);

        log.info("List of File Names using BreadthFirst FileTraversal");
        traversal.printBreadthFirstFileTraversal(path, 0, false);

        log.info("List all File Names, date modified, size using BreadthFirst FileTraversal");
        traversal.printBreadthFirstFileTraversal(path, 0, true);

    }

    @Test
    public void testDepthFirstTraversal() throws IOException {

        FileTraversal traversal = new FileTraversalImpl();
        String path = System.getProperty("user.dir");
        log.info(" Current Directory " + path);

        Assert.assertNotNull(path);

        log.info("List all File Names using DepthFirst File Traversal ");
        traversal.printDepthFirstFileTraversal(path, false);

        log.info("List all File Names, date modified, size using DepthFirst File Traversal ");
        traversal.printDepthFirstFileTraversal(path, true);

    }

    @Test
    public void testBreadthFirstTraversalNull() throws IOException {

        FileTraversal traversal = new FileTraversalImpl();

        try {
            traversal.printBreadthFirstFileTraversal(null, 0, false);
        } catch (FileNotFoundException exception) {
            Assert.assertTrue(exception.getMessage().equals("FileName passed in as EMPTY "));
        }

        try {
            traversal.printBreadthFirstFileTraversal(null, 0, true);
        } catch (FileNotFoundException exception) {
            Assert.assertTrue(exception.getMessage().equals("FileName passed in as EMPTY "));
        }

    }

    @Test
    public void testDepthFirstTraversalNull() throws IOException {

        FileTraversal traversal = new FileTraversalImpl();

        try {
            traversal.printDepthFirstFileTraversal(null, false);
        } catch (FileNotFoundException exception) {
            Assert.assertTrue(exception.getMessage().equals("FileName passed in as EMPTY "));
        }

        try {
            traversal.printDepthFirstFileTraversal(null, true);
        } catch (FileNotFoundException exception) {
            Assert.assertTrue(exception.getMessage().equals("FileName passed in as EMPTY "));
        }

    }

    @Test
    public void testBreadthFirstTraversalInvalidFileName() throws IOException {

        FileTraversal traversal = new FileTraversalImpl();

        try {
            traversal.printBreadthFirstFileTraversal("notexists/sjkdh", 0, false);
        } catch (FileNotFoundException exception) {
            Assert.assertTrue(exception.getMessage().equals("Invalid FileName passed"));
        }

        try {
            traversal.printBreadthFirstFileTraversal("notexists/sjkdh", 0, true);
        } catch (FileNotFoundException exception) {
            Assert.assertTrue(exception.getMessage().equals("Invalid FileName passed"));
        }

    }

    @Test
    public void testDepthFirstTraversalInvalidFileName() throws IOException {

        FileTraversal traversal = new FileTraversalImpl();

        try {
            traversal.printDepthFirstFileTraversal("notexists/sjkdh", false);
        } catch (FileNotFoundException exception) {
            Assert.assertTrue(exception.getMessage().equals("Invalid FileName passed"));
        }

        try {
            traversal.printDepthFirstFileTraversal("notexists/sjkdh", true);
        } catch (FileNotFoundException exception) {
            Assert.assertTrue(exception.getMessage().equals("Invalid FileName passed"));
        }

    }

}
