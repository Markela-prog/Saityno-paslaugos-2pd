package lt.eif.viko.emarkevicius.CasinoSOAP.responses;

import lt.viko.eif.emarkevicius.casino.model.Player;

public class GetPlayerByNameResponse {
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
