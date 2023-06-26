package lt.eif.viko.emarkevicius.CasinoSOAP.responses;

import lt.eif.viko.emarkevicius.CasinoSOAP.PlayerEndpoint;
import lt.viko.eif.emarkevicius.casino.model.Player;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = PlayerEndpoint.NAMESPACE_URI, name = "getPlayerByIdResponse")
public class GetPlayerByIdResponse {

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
