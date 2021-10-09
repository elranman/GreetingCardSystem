package com.example.springboot.Elrandemo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullFields;

import java.util.List;

public class GreetingCardRequest {
    @NonNull
    private String basedOnTemplateName;
    @NonNull
    private List<String> parameters;
    @NonNull
    private String fileFormat;

    public GreetingCardRequest() {
    }

    @JsonCreator
    public GreetingCardRequest(@JsonProperty("basedOnTemplateName") String basedOnTemplateName,
                               @JsonProperty("parameters") List<String> parameters,
                               @JsonProperty("fileFormat") String fileFormat) {
        this.basedOnTemplateName = basedOnTemplateName;
        this.parameters = parameters;
        this.fileFormat = fileFormat;
    }

    public String getBasedOnTemplateName() {
        return basedOnTemplateName;
    }

    public void setBasedOnTemplateName(String basedOnTemplateName) {
        this.basedOnTemplateName = basedOnTemplateName;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    @Override
    public String toString() {
        return "GreetingCardRequest{" +
                "basedOnTemplateName='" + basedOnTemplateName + '\'' +
                ", parameters=" + parameters +
                ", fileFormat='" + fileFormat + '\'' +
                '}';
    }
}
