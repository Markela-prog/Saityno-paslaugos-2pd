package lt.eif.viko.emarkevicius.CasinoSOAP.requests;

import lt.eif.viko.emarkevicius.CasinoSOAP.PlayerEndpoint;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPlayerByIdRequest", propOrder = {
        "id"
})
@XmlRootElement(namespace = PlayerEndpoint.NAMESPACE_URI, name = "getPlayerByIdRequest")
public class GetPlayerByIdRequest {

    @XmlElement(required = true)
    private Integer id;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
