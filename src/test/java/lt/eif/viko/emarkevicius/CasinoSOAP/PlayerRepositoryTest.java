package lt.eif.viko.emarkevicius.CasinoSOAP;

import lt.viko.eif.emarkevicius.casino.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void testFindPlayerById() {
        // Arrange
        Integer playerId = 1;

        // Act
        Player player = playerRepository.findPlayerById(playerId);

        // Assert
        assertNotNull(player);
        assertEquals(playerId, player.getId());
    }

    @Test
    public void testFindPlayerByName() {
        // Arrange
        String playerName = "DD_JOHN";

        // Act
        Player player = playerRepository.findPlayerByName(playerName);

        // Assert
        assertNotNull(player);
        assertEquals(playerName, player.getName());
    }

    @Test
    public void testFindPlayerByAccountEmail() {
        // Arrange
        String accountEmail = "DD.John@gmail.com";

        // Act
        Player player = playerRepository.findPlayerByAccountEmail(accountEmail);

        // Assert
        assertNotNull(player);
        assertEquals(accountEmail, player.getAccount().getEmail());
    }

    @Test
    public void testGetAllPlayers() {
        // Act
        List<Player> players = playerRepository.getAllPlayers();

        // Assert
        assertNotNull(players);
        assertEquals(3, players.size());
    }
}
