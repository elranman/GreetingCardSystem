package com.example.springboot.Elrandemo.service;

import com.example.springboot.Elrandemo.domain.CardTemplate;
import com.example.springboot.Elrandemo.domain.GreetingCard;
import com.example.springboot.Elrandemo.domain.GreetingCardRequest;
import com.example.springboot.Elrandemo.util.GreetingCardFileGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CardTemplateService {

    final Logger LOGGER = LoggerFactory.getLogger(CardTemplateService.class);

    @Value("${db.isActive}")
    private boolean isUsingActualDB;
    //only for the purpose of this exercise , I'm keeping the data inside map instead of actual DB.
    HashMap<String,CardTemplate> cardTemplateMap = new HashMap<>();
    HashMap<Integer, GreetingCard> greetingCardsMap = new HashMap<>();

    private static int cardId = 100;

    public CardTemplateService() {
        cardTemplateMap.put("MAZAL TOV",
                             new CardTemplate(
                                     11111111,
                                     new StringBuilder("MAZAL TOV %s %s , It's your Birthday today").toString(),
                                     "MAZAL TOV"
                             ));

        cardTemplateMap.put("NEW BIRTH",
                            new CardTemplate(
                                    222222222,
                                    new StringBuilder("CONGRATOLATION for your new baby %s. we wishing you all the best. Sincerely %s %s ").toString(),
                                    "NEW BIRTH"
                            ));


        greetingCardsMap.put(99,
                         new GreetingCard(111,
                                        "MAZAL TOV Jhon Doe , It's your Birthday today",
                                        null
                                    )
        );
    }

    public Map<String,CardTemplate> getCardTemplates() {
            //using Mock DB for development purposes
            if(!isUsingActualDB){
                return cardTemplateMap;
            }else{
                //TODO:[Elran] need to be implemented farther on - to actual DB
                return null;
            }
    }

    public void createGreetingCard(GreetingCardRequest greetingCardRequest) throws Exception {
            if(!isUsingActualDB){
                String templateName = greetingCardRequest.getBasedOnTemplateName();
                CardTemplate cardTemplate = cardTemplateMap.get(templateName);
                if(cardTemplate != null){
                    String templateContent = cardTemplate.getTemplateContent();
                    List<String> parameters = greetingCardRequest.getParameters();
                    String greetingCardContent;
                    greetingCardContent = getContentByCardTypeAndParams(templateName, templateContent, parameters);
                    GreetingCardFileGenerator.generateFileByType(greetingCardContent, greetingCardRequest.getFileFormat());
                }
            }else{
                //TODO:[Elran] need to be implemented farther on - to actual DB
            }
    }

    private String getContentByCardTypeAndParams(String templateName, String templateContent, List<String> parameters) {
        String greetingCardContent;
        if("MAZAL TOV".equals(templateName)) {
            greetingCardContent = templateContent.formatted(parameters.get(0), parameters.get(1));
        }else if("NEW BIRTH".equals(templateName)){
            greetingCardContent = templateContent.formatted(parameters.get(0), parameters.get(1) , parameters.get(2));
        }else{  //for now only two templates defined. in case of a more general cases and more options of templates
                //might need to use a generic solution for building the String dynamically with the parameters.
            //for now not relevant.
            greetingCardContent = "";
        }
        return greetingCardContent;
    }

    /*
        my basic assumption:
        we need to keep the --templates-- on one Map or table
        and the --greetingCards-- on other one.
     */
    public void uploadGreetingCardByCardId(MultipartFile file) {

        if(!isUsingActualDB){
            greetingCardsMap.put(cardId++,new GreetingCard(cardId,"",file));
        }else{
            //TODO:[Elran] need to be implemented farther on - to actual DB
        }
    }
}
