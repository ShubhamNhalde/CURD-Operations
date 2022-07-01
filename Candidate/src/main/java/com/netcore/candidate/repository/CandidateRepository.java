package com.netcore.candidate.repository;

import com.netcore.candidate.model.HiredCandidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends MongoRepository<HiredCandidate, Long> {
}