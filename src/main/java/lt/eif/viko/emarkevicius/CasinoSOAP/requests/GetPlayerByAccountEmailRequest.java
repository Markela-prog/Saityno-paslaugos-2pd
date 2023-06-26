package lt.eif.viko.emarkevicius.CasinoSOAP.requests;

import jakarta.xml.bind.annotation.XmlElement;

public class GetPlayerByAccountEmailRequest {
    private String accountEmail;

    public String getAccountEmail() {
        return accountEmail;
    }

    @XmlElement(name = "accountEmail")
    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }
}
