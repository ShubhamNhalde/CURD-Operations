package com.netcore.candidate.service;

import com.netcore.candidate.dto.HiredCandidateDto;
import com.netcore.candidate.model.HiredCandidate;
import com.netcore.candidate.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HiredCandidateService implements IHiredCandidateService{

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;


    @Override
    public HiredCandidate createCandidate(HiredCandidateDto hiredCandidateDto) {
        HiredCandidate hiredCandidate = new HiredCandidate(hiredCandidateDto);
        hiredCandidate.setId(sequenceGeneratorService.generateSequence(HiredCandidate.SEQUENCE_NAME));
        return candidateRepository.save(hiredCandidate);
    }

    @Override
    public List<HiredCandidate> getAllCandidates() {
        List<HiredCandidate> userData = candidateRepository.findAll();
        return userData;
    }

    @Override
    public HiredCandidate updateCandidate(long id, HiredCandidateDto hiredCandidateDto) {
        Optional<HiredCandidate> hiredCandidate = candidateRepository.findById(id);
        if (hiredCandidate.isPresent()){
            hiredCandidate.get().setFirstName(hiredCandidateDto.getFirstName());
            hiredCandidate.get().setLastName(hiredCandidateDto.getLastName());
            hiredCandidate.get().setEmail(hiredCandidateDto.getEmail());
            hiredCandidate.get().setLocation(hiredCandidateDto.getLocation());
        }
        return candidateRepository.save(hiredCandidate.get());
    }

    @Override
    public HiredCandidate deleteCandidate(Long id) {
        Optional<HiredCandidate> hiredCandidate = candidateRepository.findById(id);
        hiredCandidate.ifPresent(candidate -> candidateRepository.delete(candidate));
        return null;
    }
}
