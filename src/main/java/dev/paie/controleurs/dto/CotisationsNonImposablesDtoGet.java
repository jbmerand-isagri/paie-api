package dev.paie.controleurs.dto;

import java.math.BigDecimal;
import java.util.List;

public class CotisationsNonImposablesDtoGet {

    private List<CotisationNonImposableDtoGet> cotisations;
    private BigDecimal totalRetenueMontantSalarial;
    private BigDecimal totalRetenueCotisationsPatronales;

    public CotisationsNonImposablesDtoGet(List<CotisationNonImposableDtoGet> cotisations,
                                          BigDecimal totalRetenueMontantSalarial,
                                          BigDecimal totalRetenueCotisationsPatronales) {
        this.cotisations = cotisations;
        this.totalRetenueMontantSalarial = totalRetenueMontantSalarial;
        this.totalRetenueCotisationsPatronales = totalRetenueCotisationsPatronales;
    }

    public List<CotisationNonImposableDtoGet> getCotisations() {
        return cotisations;
    }

    public void setCotisations(List<CotisationNonImposableDtoGet> cotisations) {
        this.cotisations = cotisations;
    }

    public BigDecimal getTotalRetenueMontantSalarial() {
        return totalRetenueMontantSalarial;
    }

    public void setTotalRetenueMontantSalarial(BigDecimal totalRetenueMontantSalarial) {
        this.totalRetenueMontantSalarial = totalRetenueMontantSalarial;
    }

    public BigDecimal getTotalRetenueCotisationsPatronales() {
        return totalRetenueCotisationsPatronales;
    }

    public void setTotalRetenueCotisationsPatronales(BigDecimal totalRetenueCotisationsPatronales) {
        this.totalRetenueCotisationsPatronales = totalRetenueCotisationsPatronales;
    }
}
