package com.example.springboot.Elrandemo.impl;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.Writer;

public class CsvGreetingCardImpl implements Card{

    final Logger LOGGER = LoggerFactory.getLogger(CsvGreetingCardImpl.class);

    @Override
    public void create(String greetingCardContent,String fileName) throws Exception {
            Writer writer = null;
            writer = new FileWriter(fileName);
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(greetingCardContent);
            writer.close();
    }
}
