package com.example.springboot.Elrandemo.domain;

public class CardTemplate {

    private int templateId;
    private String templateContent;
    private String templateType;

    public CardTemplate() {
    }

    public CardTemplate(int templateId, String templateContent, String templateType) {
        this.templateId = templateId;
        this.templateContent = templateContent;
        this.templateType = templateType;
    }

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    @Override
    public String toString() {
        return "CardTemplate{" +
                "templateId=" + templateId +
                ", templateContent='" + templateContent + '\'' +
                ", templateType='" + templateType + '\'' +
                '}';
    }
}
