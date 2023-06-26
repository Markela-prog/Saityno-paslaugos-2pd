package lt.eif.viko.emarkevicius.CasinoSOAP.responses;

import lt.viko.eif.emarkevicius.casino.model.Player;

import java.util.List;

public class GetAllPlayersResponse {
    private List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
