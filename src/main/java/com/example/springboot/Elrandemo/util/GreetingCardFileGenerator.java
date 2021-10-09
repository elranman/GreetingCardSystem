package com.example.springboot.Elrandemo.util;

import com.example.springboot.Elrandemo.constants.CardTypes;
import com.example.springboot.Elrandemo.exceptions.GreetCardFileFormatNotSupportedException;
import com.example.springboot.Elrandemo.impl.Card;
import com.example.springboot.Elrandemo.impl.CsvGreetingCardImpl;
import com.example.springboot.Elrandemo.impl.TextGreetingCardImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class GreetingCardFileGenerator {

    final static Logger LOGGER = LoggerFactory.getLogger(GreetingCardFileGenerator.class);

    public static void generateFileByType(String greetingCardContent, String fileType) throws Exception {

        CardTypes cardTypes = valueFromEnum(fileType);
        //cardTypes = Optional.ofNullable(cardTypes).orElse(CardTypes.NONE);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-HH_mm_ss");
        Card card = null;

        switch(cardTypes){
            case TEXT:
                LOGGER.debug("Let's create txt format");
                card = new TextGreetingCardImpl();
                card.create(greetingCardContent,cardTypes + dtf.format(LocalDateTime.now()));
                break;
            case CSV:
                LOGGER.debug("Let's create csv format");
                card = new CsvGreetingCardImpl();
                card.create(greetingCardContent,cardTypes + dtf.format(LocalDateTime.now()));
                break;
            case PDF:
                LOGGER.debug("Let's create pdf format");
                //TODO: [Elran] will need to be implemented in the future.
            default:
                LOGGER.debug("there is no matching file type handling in the system currently!!");
                throw new GreetCardFileFormatNotSupportedException("File type: " + fileType + " is not supported yet!!");
        }
    }

    private static CardTypes valueFromEnum(String fileType) {
       for(CardTypes card : CardTypes.values()){
           if (card.name().equals(fileType))
               return card;
        }
        return CardTypes.NONE;
    }

}
