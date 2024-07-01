package finalexam.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountingFirm implements LegalEntity {
    private String address;
    private String vatNumber;
    private List<String> invoices = new ArrayList<>(); // Simplified to a list of invoice numbers

    public AccountingFirm(String address, String vatNumber) {
        this.address = address;
        this.vatNumber = vatNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public void addInvoice(String invoiceNumber) {
        invoices.add(invoiceNumber);
    }

    public boolean deleteInvoice(String invoiceNumber) {
        return invoices.remove(invoiceNumber);
    }

    public List<String> getInvoices() {
        return new ArrayList<>(invoices);
    }

    public void saveInvoicesToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(invoices);
        }
    }

    public void loadInvoicesFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            invoices = (List<String>) ois.readObject();
        }
    }

    @Override
    public String toString() {
        return "AccountingFirm{" +
                "address='" + address + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                ", invoices=" + invoices +
                '}';
    }
}
