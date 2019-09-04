package dev.paie.utils;

import dev.paie.entites.Cotisation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class BulletinSalaireUtils {

    public BigDecimal calculerSalaireBrut(BigDecimal tauxBase, BigDecimal nbHeuresBase,
                                          BigDecimal primeExceptionnelle) {
        // salaire de base + prime exceptionnelle
        // (base * taux salarial) + prime exceptionnelle
        // [grade](nb_heures_base * taux_base) + [bulletin_salaire](prime_exceptionnelle)

        return (tauxBase.multiply(nbHeuresBase)).add(primeExceptionnelle);
    }

    public BigDecimal calculerNetImposable(BigDecimal salaireBrut, List<Cotisation> cotisations) {
        // salaire brut - somme des cotisations salariales non imposables
        // salaire brut - somme [cotisation](salaire brut * taux_salarial) [[si non null & imposable=false]]

        BigDecimal sommeDesCotisations = new BigDecimal("0");

        for (Cotisation c : cotisations) {
            if (!c.getImposable() && c.getTauxSalarial() != null) {
                sommeDesCotisations = sommeDesCotisations.add(salaireBrut.multiply(c.getTauxSalarial()));
            }
        }

        return salaireBrut.subtract(sommeDesCotisations);
    }

     public BigDecimal calculerNetAPayer(BigDecimal salaireNetImposable, List<Cotisation> cotisations) {
        // salaire net imposable - somme des cotisations salariales imposables
        // salaire net imposable - somme [cotisation](salaire brut * taux_salarial) [[si non null & imposable=true]]

         BigDecimal sommeDesCotisations = new BigDecimal("0");

         for (Cotisation c : cotisations) {
             if (c.getImposable() && c.getTauxSalarial() != null) {
                 sommeDesCotisations = sommeDesCotisations.add(salaireNetImposable.multiply(c.getTauxSalarial()));
             }
         }

         return salaireNetImposable.subtract(sommeDesCotisations);

    }

    public BigDecimal calculerTotalRetenueMontantSalarialNonImposables(List<Cotisation> cotisations, BigDecimal salaireBrut) {
        BigDecimal total = new BigDecimal("0");
        for (Cotisation c : cotisations) {
            if(!c.getImposable()&& c.getTauxSalarial() != null) {
                total = total.add(c.getTauxSalarial().multiply(salaireBrut));
            }
        }
        return total;
    }

    public BigDecimal calculerTotalRetenueCotisationsPatronalesNonImposables(List<Cotisation> cotisations, BigDecimal salaireBrut) {
        BigDecimal total = new BigDecimal(("0"));
        for(Cotisation c : cotisations) {
            if(!c.getImposable() && c.getTauxPatronal() != null) {
                total = total.add(c.getTauxPatronal().multiply(salaireBrut));
            }
        }
        return total;
    }
}
