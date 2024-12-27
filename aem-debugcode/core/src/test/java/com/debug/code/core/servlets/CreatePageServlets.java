//package com.debug.code.core.servlets;
//
//import com.day.cq.wcm.api.Page;
//import com.day.cq.wcm.api.PageManager;
//import org.apache.sling.api.SlingHttpServletRequest;
//import org.apache.sling.api.SlingHttpServletResponse;
//import org.apache.sling.api.resource.ResourceResolver;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import javax.jcr.Session;
//import java.io.PrintWriter;
//
//import static org.mockito.Mockito.*;
//
//class CreatePageServletTest {
//
//    @InjectMocks
//    private CreatePageServlet createPageServlet;
//
//    @Mock
//    private SlingHttpServletRequest request;
//
//    @Mock
//    private SlingHttpServletResponse response;
//
//    @Mock
//    private ResourceResolver resourceResolver;
//
//    @Mock
//    private PageManager pageManager;
//
//    @Mock
//    private Page newPage;
//
//    @Mock
//    private PrintWriter printWriter;
//
//    @Mock
//    private Session session;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testDoGet_PageCreatedSuccessfully() throws Exception {
//        // Mock request and response
//        when(request.getResourceResolver()).thenReturn(resourceResolver);
//        when(resourceResolver.adaptTo(Session.class)).thenReturn(session);
//        when(resourceResolver.adaptTo(PageManager.class)).thenReturn(pageManager);
//
//        // Mock PageManager to return a new Page
//        when(pageManager.create(
//                eq("/content/aem-debugcode/us/en"),
//                eq("new-page"),
//                eq("/conf/aem-debugcode/Generic/settings/wcm/templates/generic-template"),
//                eq("New Page")
//        )).thenReturn(newPage);
//
//        // Mock newPage path and response writer
//        when(newPage.getPath()).thenReturn("/content/aem-debugcode/us/en/new-page");
//        when(response.getWriter()).thenReturn(printWriter);
//
//        // Execute doGet method
//        createPageServlet.doGet(request, response);
//
//        // Verify interactions and output
//        verify(pageManager, times(1)).create(
//                "/content/aem-debugcode/us/en",
//                "new-page",
//                "/conf/aem-debugcode/Generic/settings/wcm/templates/generic-template",
//                "New Page"
//        );
//        verify(printWriter, times(1)).write("Page created successfully: /content/aem-debugcode/us/en/new-page");
//    }
//
//    @Test
//    void testDoGet_PageCreationFails() throws Exception {
//        // Mock request and response
//        when(request.getResourceResolver()).thenReturn(resourceResolver);
//        when(resourceResolver.adaptTo(Session.class)).thenReturn(session);
//        when(resourceResolver.adaptTo(PageManager.class)).thenReturn(pageManager);
//
//        // Mock PageManager to return null
//        when(pageManager.create(anyString(), anyString(), anyString(), anyString())).thenReturn(null);
//
//        // Mock response writer
//        when(response.getWriter()).thenReturn(printWriter);
//
//        // Execute doGet method
//        createPageServlet.doGet(request, response);
//
//        // Verify interactions and output
//        verify(pageManager, times(1)).create(
//                "/content/aem-debugcode/us/en",
//                "new-page",
//                "/conf/aem-debugcode/Generic/settings/wcm/templates/generic-template",
//                "New Page"
//        );
//        verify(printWriter, times(1)).write("Failed to create page");
//    }
//
//    @Test
//    void testDoGet_SessionNull() throws Exception {
//        // Mock request and response
//        when(request.getResourceResolver()).thenReturn(resourceResolver);
//        when(resourceResolver.adaptTo(Session.class)).thenReturn(null);
//
//        // Mock response writer
//        when(response.getWriter()).thenReturn(printWriter);
//
//        // Execute doGet method
//        createPageServlet.doGet(request, response);
//
//        // Verify interactions and output
//        verify(pageManager, never()).create(anyString(), anyString(), anyString(), anyString());
//        verify(printWriter, times(0)).write("Error: Session is null");
//    }
//}
