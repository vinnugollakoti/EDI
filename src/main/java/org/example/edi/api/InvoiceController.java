package org.example.edi.api;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.edi.services.InvoiceService;
import org.example.edi.tables.Invoice;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("getinvoicebyid/order/{id}")
    public Invoice getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }

    @GetMapping("/getallinvoices")
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }
}