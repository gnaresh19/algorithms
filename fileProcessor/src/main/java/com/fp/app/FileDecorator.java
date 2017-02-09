package com.fp.app;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

/*
 * Used in decorating the File output
 */
public class FileDecorator {

    final static Logger log = Logger.getLogger(FileDecorator.class);
    
    public static void printFileName(File file){
        
        if(file.isDirectory()){
            log.info("  Directory = "+file.getName()+" ");
        }
        if(file.isFile()){
            log.info("      "+file.getName());
        }
    }

    public static void printFileNameLastModifiedAndSize(File file) {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        DecimalFormat df = new DecimalFormat("#.##");
        double bytes = file.length();
        double kilobytes = 0;
        double megabytes = 0;
        double gigabytes = 0;
        
        
        if(file.isDirectory()){
           
            if (bytes <= 1024) {
                log.info("  Directory = " + file.getName() + ", lastModified: " + sdf.format(file.lastModified()) + ", size: " + df.format(bytes) + " bytes");
            } else if (bytes > 1024 && bytes <= 1024*1024) {
                kilobytes = (bytes / 1024);
                log.info("  Directory = " + file.getName() + ", lastModified: " + sdf.format(file.lastModified()) + ", size: " + df.format(kilobytes) + " KB");
            } else if (bytes > 1024*1024 && bytes <= 1024*10124*1024) {
                megabytes = (bytes / (1024*1024));
                log.info("  Directory = " + file.getName() + ", lastModified: " + sdf.format(file.lastModified()) + ", size: " + df.format(megabytes) + " MB");
            } else if (bytes > 1024*1024*1024) {
                gigabytes = (megabytes / (1024*1024*1024));
                log.info("  Directory = " + file.getName() + ", lastModified: " + sdf.format(file.lastModified()) + ", size: " + df.format(gigabytes) + " GB");
            }
        }
        if(file.isFile()){
           
            if (bytes <= 1024) {
                log.info("      " + file.getName() + ", lastModified: " + sdf.format(file.lastModified()) + ", size: " + df.format(bytes) + " bytes");
            } else if (bytes > 1024 && bytes <= 1024*1024) {
                kilobytes = (bytes / 1024);
                log.info("      " + file.getName() + ", lastModified: " + sdf.format(file.lastModified()) + ", size: " + df.format(kilobytes) + " KB");
            } else if (bytes > 1024*1024 && bytes <= 1024*10124*1024) {
                megabytes = (bytes / (1024*1024));
                log.info("      " + file.getName() + ", lastModified: " + sdf.format(file.lastModified()) + ", size: " + df.format(megabytes) + " MB");
            } else if (bytes > 1024*1024*1024) {
                gigabytes = (megabytes / (1024*1024*1024));
                log.info("      " + file.getName() + ", lastModified: " + sdf.format(file.lastModified()) + ", size: " + df.format(gigabytes) + " GB");
            }
        }
       

    }
}
