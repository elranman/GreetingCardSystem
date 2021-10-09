package com.example.springboot.Elrandemo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class TextGreetingCardImpl implements Card{

    final Logger LOGGER = LoggerFactory.getLogger(TextGreetingCardImpl.class);

    @Override
    public void create(String greetingCardContent , String fileName) throws Exception {
        //in case of success
        LOGGER.debug("in creating a text greeting ticket");
        File f = new File(fileName + ".txt");
        InputStream in;
        if(f.exists()){
            in = new BufferedInputStream(new FileInputStream(f));

        }else{
            try(FileOutputStream fos = new FileOutputStream(f);
                BufferedOutputStream bos = new BufferedOutputStream(fos)) {
                //convert string to byte array
                byte[] bytes = greetingCardContent.getBytes();
                //write byte array to file
                bos.write(bytes);
                bos.close();
                fos.close();
                LOGGER.debug("Data written to file successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

