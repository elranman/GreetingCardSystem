package com.example.springboot.Elrandemo.domain;

import org.springframework.web.multipart.MultipartFile;

public class GreetingCard {
    private int greetingCardId;
    private String cardContent;
    private MultipartFile attachmentCard;

    public GreetingCard() {
    }

    public GreetingCard(int greetingCardId, String cardContent, MultipartFile attachmentCard) {
        this.greetingCardId = greetingCardId;
        this.cardContent = cardContent;
        this.attachmentCard = attachmentCard;
    }

    public int getGreetingCardId() {
        return greetingCardId;
    }

    public void setGreetingCardId(int greetingCardId) {
        this.greetingCardId = greetingCardId;
    }

    public String getCardContent() {
        return cardContent;
    }

    public void setCardContent(String cardContent) {
        this.cardContent = cardContent;
    }

    public MultipartFile getAttachmentCard() {
        return attachmentCard;
    }

    public void setAttachmentCard(MultipartFile attachmentCard) {
        this.attachmentCard = attachmentCard;
    }

    @Override
    public String toString() {
        return "GreetingCard{" +
                "greetingCardId=" + greetingCardId +
                ", cardContent='" + cardContent + '\'' +
                ", attachmentCard=" + attachmentCard +
                '}';
    }
}
