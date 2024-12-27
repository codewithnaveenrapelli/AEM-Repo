package com.debug.code.core.models.impl;

import com.debug.code.core.models.CustomButton;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = CustomButton.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = CustomButtonImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json", selector = "debugcode",
    options = {
            @ExporterOption(name="SerializationFeature.WRAP_ROOT_VALUE", value = "true"),
            @ExporterOption(name="MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
    })

@JsonRootName("buttonComponentDetails")
public class CustomButtonImpl implements CustomButton{

    static final String RESOURCE_TYPE = "aem-debugcode/components/customButton";

    @ValueMapValue
    String buttonText;

    @ValueMapValue
    String urlLink;

    @ValueMapValue
    String targetNewWindow;

    @ValueMapValue
    String anchorName;

    @ValueMapValue
    String assetLink;


    @JsonProperty(value = "button")
    @Override
    public String getButtonText() {
        return buttonText;
    }

    @Override
    public String getUrlLink() {
        return urlLink;
    }

    @Override
    public String getTargetNewWindow() {
        return targetNewWindow;
    }

    @Override
    public String getAnchorName() {
        return anchorName;
    }

    @Override
    public String getAssetLink() {
        return assetLink;
    }
}
