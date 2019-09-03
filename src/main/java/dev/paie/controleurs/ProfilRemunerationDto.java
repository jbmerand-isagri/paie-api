package dev.paie.controleurs;

import dev.paie.entites.ProfilRemuneration;

public class ProfilRemunerationDto {

    private String code;

    public ProfilRemunerationDto(ProfilRemuneration profilRemuneration) {
        this.code = profilRemuneration.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
