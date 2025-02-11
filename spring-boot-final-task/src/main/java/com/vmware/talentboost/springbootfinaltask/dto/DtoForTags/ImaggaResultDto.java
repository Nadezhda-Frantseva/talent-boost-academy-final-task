package com.vmware.talentboost.springbootfinaltask.dto.DtoForTags;

import java.util.List;

public class ImaggaResultDto {

    private List<ImaggaTagDto> tags;

    public List<ImaggaTagDto> getTags() {
        return tags;
    }
    public void setTags(List<ImaggaTagDto> tags){
        this.tags = tags;
    }

}
