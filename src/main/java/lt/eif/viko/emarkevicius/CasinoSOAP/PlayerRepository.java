package lt.eif.viko.emarkevicius.CasinoSOAP;

import jakarta.annotation.PostConstruct;
import lt.viko.eif.emarkevicius.casino.model.Account;
import lt.viko.eif.emarkevicius.casino.model.Player;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * The PlayerRepository class is responsible for managing player data in the casino.
 * It provides methods for retrieving player information based on different criteria.
 */
@Component
public class PlayerRepository {

    private static final List<Player> players = new ArrayList<>();

    /**
     * Initializes the player data with sample players.
     *
     * This method is automatically called after the PlayerRepository bean is created.
     * It is annotated with @PostConstruct.
     */
    @PostConstruct
    public void initData() {
        Account account1 = new Account(1,"DD.John@gmail.com", "15dw2q3" ,20, 610, 0);
        Account account2 = new Account(2,"gambler@gmail.com", "fass543" ,22, 200, 10);
        Account account3 = new Account(4,"tailor@gmail.com", "tt31^#.2sx" ,31, 5118, 90);

        Player player1 = new Player(1, "DD_JOHN", account1);
        Player player2 = new Player(2,"Gambler", account2);
        Player player3 = new Player(3, "Tailor", account3);


        players.add(player1);
        players.add(player2);
        players.add(player3);
    }

    /**
     * Retrieves a player by ID.
     * @param id the ID of the player
     * @return the player with the specified ID, or null if not found
     */
    public Player findPlayerById(Integer id) {
        Assert.isTrue(id > 0, "Player ID must be greater than zero");
        return players.stream().filter(player -> player.getId() == id).findFirst().orElse(null);
    }

    /**
     * Retrieves a player by name.
     * @param name the name of the player
     * @return the player with the specified name, or null if not found
     */
    public Player findPlayerByName(String name) {
        Assert.notNull(name, "Player's name must not be null");
        return players.stream().filter(player -> player.getName().equals(name)).findFirst().orElse(null);
    }

    /**
     * Retrieves a player by account email.
     * @param email the email of the player's account
     * @return the player with the specified account email, or null if not found
     */
    public Player findPlayerByAccountEmail(String email) {
        Assert.notNull(email, "Account email must not be null");
        return players.stream()
                .filter(player -> player.getAccount().getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    /**
     * Retrieves a list of all players.
     * @return a list of all players
     */
    public List<Player> getAllPlayers() {
        return players;
    }
    
}
