package com.vmware.talentboost.springbootfinaltask.dto.DtoForTags;

public class ImaggaTagDto {
    private double confidence;
    private ImaggaTagValueDto tag;

    public double getConfidence() {
        return confidence;
    }

    public ImaggaTagValueDto getTag() {
        return tag;
    }

    public void setTag(ImaggaTagValueDto tag) {
        this.tag = tag;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
