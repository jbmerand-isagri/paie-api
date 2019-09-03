package dev.paie.services;

import dev.paie.controleurs.GradeDto;
import dev.paie.entites.Grade;
import dev.paie.repository.GradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GradeService.class);

    private GradeRepository gradeRepository;

    public GradeService() {
        super();
    }

    @Autowired
    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<GradeDto> recupererListeGradesDto() {
        List<Grade> grades = gradeRepository.findAll();
        List<GradeDto> gradesDto = new ArrayList<>();

        for (Grade g : grades) {
            gradesDto.add(new GradeDto(g));
        }

        return gradesDto;
    }

    public Grade recupererUnGradeParSonCode(String code) {
        return gradeRepository.findByCodeIgnoreCase(code);
    }
}
