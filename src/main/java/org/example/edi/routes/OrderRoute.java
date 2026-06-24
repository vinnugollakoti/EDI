//package org.example.edi.routes;
//
//import org.apache.camel.builder.RouteBuilder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class OrderRoute extends RouteBuilder {
//
//    @Override
//    public void configure() {
//        from("direct:process-order")
//                .log("Kafka request sent")
//                .to("kafka:orders");
//    }
//
//}
