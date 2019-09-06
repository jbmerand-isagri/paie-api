package dev.paie.services;

import dev.paie.entites.Credentials;
import dev.paie.exceptions.AuthentificationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Service
public class AuthentificationService {

    private final Logger LOGGER = LoggerFactory.getLogger(AuthentificationService.class);

    public void authentifierEtImporterToken(String identifiant, String motDePasse, String url,
                                            HttpServletResponse res) throws AuthentificationException {
        LOGGER.info("authentifierEtImporterToken() lancé");

        RestTemplate template = new RestTemplate();
        Credentials cred = new Credentials(identifiant, motDePasse);

        try {
            HttpEntity<Credentials> request = new HttpEntity<>(cred);
            HttpEntity<String> response = template.exchange(url, HttpMethod.POST, request, String.class);
            HttpHeaders headers = response.getHeaders();
            String set_cookie = headers.getFirst(headers.SET_COOKIE);
            String cookieValue = set_cookie.substring((set_cookie.indexOf("=")+1), set_cookie.indexOf(";"));
            String[] cookieParts = set_cookie.split(";");
            LOGGER.info("Response: " + response.toString() + "\n");
            Cookie cookie = new Cookie("AUTH-TOKEN", cookieValue);
            cookie.setMaxAge(3600000);
            LOGGER.info("cookieValue " + cookieValue + "\n");
            res.addCookie(cookie);
        } catch(Exception e) {
            throw new AuthentificationException("ERREUR : problème d'authentification. \n" + e);
        }

    }

}
