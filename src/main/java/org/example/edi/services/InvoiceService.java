package org.example.edi.services;
import org.example.edi.repository.InventoryRepository;
import org.example.edi.repository.InvoiceRepository;
import org.example.edi.tables.Invoice;
import org.example.edi.tables.Order;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice createInvoice(Order order,int totalAmount) {
        Invoice invoice = new Invoice();

        invoice.setOrder(order);
        invoice.setTotalAmount(totalAmount);
        invoice.setCreatedAt();

        return invoice;
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findByOrderId(id).orElseThrow(() -> new RuntimeException("Invoice not found"));
    }
}