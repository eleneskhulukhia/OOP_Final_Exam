package finalexam.task4;

import java.io.IOException;

public class FirmTester {

    public static void main(String[] args) {
        AccountingFirm firm = new AccountingFirm("123 Main St", "123456789");

        firm.addInvoice("INV001");
        firm.addInvoice("INV002");

        System.out.println("Firm invoices after adding: " + firm.getInvoices());

        try {
            firm.saveInvoicesToFile("invoices.dat");
            firm.deleteInvoice("INV001");
            System.out.println("Firm invoices after deleting: " + firm.getInvoices());

            firm.loadInvoicesFromFile("invoices.dat");
            System.out.println("Firm invoices after loading from file: " + firm.getInvoices());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
