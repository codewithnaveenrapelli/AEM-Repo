package com.debug.code.core.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;



@Component(service = Servlet.class)
@SlingServletResourceTypes(resourceTypes = "aem-debugcode/components/page",
        selectors = "list", extensions = {"txt", "json"})
public class AccessComponentsServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

        ResourceResolver rr = request.getResourceResolver();
        String pagePath = request.getParameter("pagePath");
        if (pagePath == null) {
            pagePath = "/content/aem-debugcode/us/en";
        }
        PageManager pm = rr.adaptTo(PageManager.class);
        Page page = pm.getPage(pagePath);
        Iterator<Page> childPages = page.listChildren();
        JsonArrayBuilder jab = Json.createArrayBuilder();
        while (childPages.hasNext()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            Page selectedPage = childPages.next();
            job.add("title", selectedPage.getTitle());
            job.add("path", selectedPage.getPath());
            jab.add(job);
        }
        response.getWriter().write(jab.build().toString());
    }
}
