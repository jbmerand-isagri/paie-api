package dev.paie.services;

import dev.paie.entites.Periode;
import dev.paie.repository.PeriodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeriodeService {

    @Autowired
    private PeriodeRepository periodeRepository;

    public Periode recupererPeriodeParSonId(Integer id) {
        return periodeRepository.findById(id);
    }

}
