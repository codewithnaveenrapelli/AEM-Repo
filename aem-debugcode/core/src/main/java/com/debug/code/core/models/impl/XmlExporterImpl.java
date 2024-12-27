package com.debug.code.core.models.impl;

import com.debug.code.core.models.XmlExporter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.*;

@Exporter(name = "customxml",extensions = "xml")
@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = XmlExporter.class,
        resourceType = XmlExporterImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@XmlRootElement(name = "xml-exporter")
public class XmlExporterImpl implements XmlExporter{

    static final String RESOURCE_TYPE="aem-debugcode/components/customXML";

    private static final Logger LOG = LoggerFactory.getLogger(XmlExporterImpl.class);

    @ValueMapValue
    String xmltitle;

    @ValueMapValue
    String xmldescription;

    @Override
    @XmlElement(name = "author-title")
    public String getTitle() {
        return xmltitle;
    }

    @Override
    @XmlElement(name = "author-description")
    public String getDescription() {
        return xmldescription;
    }

}
