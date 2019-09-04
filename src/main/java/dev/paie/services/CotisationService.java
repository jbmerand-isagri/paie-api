package dev.paie.services;

import dev.paie.entites.Cotisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CotisationService {

    @Autowired
    private RemunerationEmployeService remunerationEmployeService;

    public BigDecimal calculerTotalRetenueMontantSalarial(List<Cotisation> cotisations, BigDecimal salaireBrut) {
        BigDecimal total = new BigDecimal("0");
        for (Cotisation c : cotisations) {
            if (c.getImposable() && c.getTauxSalarial() != null) {
                total = total.add(c.getTauxSalarial().multiply(salaireBrut));
            }
        }

        return total;
    }

    public BigDecimal calculerTotalRetenueCotisationsPatronales(List<Cotisation> cotisations, BigDecimal salaireBrut) {
        BigDecimal total = new BigDecimal("0");
        for (Cotisation c : cotisations) {
            if (c.getImposable() && c.getTauxPatronal() != null) {
                total = total.add(c.getTauxSalarial().multiply(salaireBrut));
            }
        }

        return total;
    }

    public List<Cotisation> recupererCotisationsParMatriculeEmploye(String matricule) {
        return remunerationEmployeService.recupererRemunerationEmployeParMatricule(matricule).getProfilRemuneration().getCotisations();
    }


}
