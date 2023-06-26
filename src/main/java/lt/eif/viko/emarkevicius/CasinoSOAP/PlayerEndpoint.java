package lt.eif.viko.emarkevicius.CasinoSOAP;

import lt.eif.viko.emarkevicius.CasinoSOAP.requests.GetAllPlayersRequest;
import lt.eif.viko.emarkevicius.CasinoSOAP.requests.GetPlayerByAccountEmailRequest;
import lt.eif.viko.emarkevicius.CasinoSOAP.requests.GetPlayerByIdRequest;
import lt.eif.viko.emarkevicius.CasinoSOAP.requests.GetPlayerByNameRequest;
import lt.eif.viko.emarkevicius.CasinoSOAP.responses.GetAllPlayersResponse;
import lt.eif.viko.emarkevicius.CasinoSOAP.responses.GetPlayerByNameResponse;
import lt.eif.viko.emarkevicius.CasinoSOAP.responses.GetPlayerByAccountEmailResponse;
import lt.eif.viko.emarkevicius.CasinoSOAP.responses.GetPlayerByIdResponse;

import lt.viko.eif.emarkevicius.casino.model.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import java.util.List;

/**
 * The PlayerEndpoint class is an endpoint for handling SOAP requests related to players in a casino.
 *
 * It provides methods for retrieving player information based on different criteria.
 *
 * This class is a component and an endpoint in the Spring framework.
 */
@Component
@Endpoint
public class PlayerEndpoint {

        /**
         * The namespace URI for the SOAP requests and responses.
         */
        public static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

        private final PlayerRepository playerRepository;

        /**
         * Constructs a PlayerEndpoint object with the specified PlayerRepository.
         * @param playerRepository the repository used for accessing player data
         */
        @Autowired
        public PlayerEndpoint(PlayerRepository playerRepository) {
            this.playerRepository = playerRepository;
        }

        /**
         * Retrieves a player by ID from the repository.
         *
         * @param request the request containing the player ID
         * @return the response containing the player with the specified ID
         */
        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPlayerByIdRequest")
        @ResponsePayload
        public GetPlayerByIdResponse getPlayerById(@RequestPayload GetPlayerByIdRequest request) {
            Assert.isTrue(request.getId() > 0, "Player ID must be greater than zero");
            Player player = playerRepository.findPlayerById(request.getId());

            GetPlayerByIdResponse response = new GetPlayerByIdResponse();
            response.setPlayer(player);

            return response;
        }

        /**
         * Retrieves a player by name from the repository.
         *
         * @param request the request containing the player's name
         * @return the response containing the player with the specified name
         */
        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPlayerByNameRequest")
        @ResponsePayload
        public GetPlayerByNameResponse getPlayerByName(@RequestPayload GetPlayerByNameRequest request) {
            Assert.notNull(request.getName(), "Player's name must not be null");
            Player player = playerRepository.findPlayerByName(request.getName());

            GetPlayerByNameResponse response = new GetPlayerByNameResponse();
            response.setPlayer(player);

            return response;
        }

        /**
         * Retrieves a player by account email from the repository.
         *
         * @param request the request containing the player's account email
         * @return the response containing the player with the specified account email
         */
        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPlayerByAccountEmailRequest")
        @ResponsePayload
        public GetPlayerByAccountEmailResponse getPlayerByAccountEmail(@RequestPayload GetPlayerByAccountEmailRequest request) {
            Assert.notNull(request.getAccountEmail(), "Account email must not be null");
            Player player = playerRepository.findPlayerByAccountEmail(request.getAccountEmail());

            GetPlayerByAccountEmailResponse response = new GetPlayerByAccountEmailResponse();
            response.setPlayer(player);

            return response;
        }

        /**
         * Retrieves a player by account email from the repository.
         *
         * @param request the request containing the player's account email
         * @return the response containing the player with the specified account email
         */
        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllPlayersRequest")
        @ResponsePayload
        public GetAllPlayersResponse getAllPlayers(@RequestPayload GetAllPlayersRequest request) {
            List<Player> players = playerRepository.getAllPlayers();

            GetAllPlayersResponse response = new GetAllPlayersResponse();
            response.setPlayers(players);

            return response;
        }

    }

