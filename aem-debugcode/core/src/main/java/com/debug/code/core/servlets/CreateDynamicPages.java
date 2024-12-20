package com.debug.code.core.servlets;

import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Create Page Servlet",
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.paths=" + "/bin/createDynamicPages"
        })
public class CreateDynamicPages extends SlingAllMethodsServlet {

        private static final Logger log = LoggerFactory.getLogger(CreateDynamicPages.class);

        @Override
        protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
                throws IOException {


                log.info("----------< Executing Create Page Servlet >----------");


                try (ResourceResolver resourceResolver = request.getResourceResolver()) {

                        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
                        if (pageManager == null) {
                                log.error("PageManager is not available");
                                response.getWriter().write("Error: PageManager is not available");
                                return;
                        }
                        String parentPath = request.getParameter("parentPath");
                        String pageName = request.getParameter("pageName");
                        String templatePath = "/conf/aem-debugcode/Generic/settings/wcm/templates/generic-template";
                        String pageTitle = request.getParameter("pageTitle");

                        if (parentPath == null || pageName == null || pageTitle == null) {
                                response.getWriter().write("Error: Missing required parameters");
                                return;
                        }

                        Page newPage = pageManager.create(parentPath, pageName, templatePath, pageTitle);

                        if (newPage != null) {
                                log.info("Page created successfully: {}", newPage.getPath());
                                response.getWriter().write("Page created successfully: " + newPage.getPath());
                        } else {
                                log.error("Failed to create page");
                                response.getWriter().write("Error: Failed to create page");
                        }

                } catch (Exception e) {
                        log.error("Error while creating page: {}", e.getMessage(), e);
                        response.getWriter().write("Error: " + e.getMessage());
                }
        }
}






