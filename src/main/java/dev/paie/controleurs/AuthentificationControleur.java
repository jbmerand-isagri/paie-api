package dev.paie.controleurs;

import dev.paie.entites.Credentials;
import dev.paie.exceptions.AuthentificationException;
import dev.paie.services.AuthentificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthentificationControleur {

    private final Logger LOGGER = LoggerFactory.getLogger(AuthentificationControleur.class);

    @Value("${collegues_api.url}")
    private String urlColleguesApi;

    @Autowired
    private AuthentificationService authentificationService;

    @PostMapping(value="/auth")
    public String authenticate(@RequestBody Credentials credentials, HttpServletResponse httpServletResponse) {
        LOGGER.info("authenticate() lancé");
        authentificationService.authentifierEtImporterToken(credentials.getIdentifiant(), credentials.getMotDePasse()
                , urlColleguesApi + "/auth", httpServletResponse);
        return "SUCCES : authentification réussie.";
    }

    @ExceptionHandler(AuthentificationException.class)
    public ResponseEntity<String> handleException(AuthentificationException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

}
