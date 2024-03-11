package com.LaundryRoom.app.Handlers.Employee;

import com.LaundryRoom.app.Database.DAO.LaundryDAO;
import com.LaundryRoom.app.Database.DAO.ServiceDAO;
import com.LaundryRoom.app.Models.Laundry;
import com.LaundryRoom.app.Models.Service;
import com.LaundryRoom.app.Templating.Renderer;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class OrderHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> modelData = new HashMap<>();
        List<String> laundry_list = context.formParams("laundry");
        List<String> service_list = context.formParams("service");

        List<Object> test_laundry = new ArrayList<>();
        List<Object> price_laundry = new ArrayList<>();

        List<Object> test_service = new ArrayList<>();
        List<Object> price_service = new ArrayList<>();

        List<Integer> total_price = new ArrayList<>();


        int totalPrice = 0;

        for (var laundryId : laundry_list) {
            Laundry laundry = LaundryDAO.get(Integer.parseInt(laundryId));
            test_laundry.add(laundry.getName());
            price_laundry.add(laundry.getPrice());
            total_price.add(laundry.getPrice());
        }

        for (var serviceId : service_list) {
            Service service = ServiceDAO.get(Integer.parseInt(serviceId));
            test_service.add(service.getName());
            price_service.add(service.getPrice());
            total_price.add(service.getPrice());
        }

        for (Integer selectedPrice : total_price) {
            totalPrice += selectedPrice;
        }

        modelData.put("totalPrice", totalPrice);


        modelData.put("laundry", test_laundry);
        modelData.put("laundryprice", price_laundry);


        modelData.put("service", test_service);
        modelData.put("serviceprice", price_service);


        String html_content = Renderer.render("employee/order_form.ftl", modelData);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.useFastMode().withHtmlContent(html_content,"").toStream(os).run();
        context.contentType("application/pdf");
        context.result(os.toByteArray());
    }
}
