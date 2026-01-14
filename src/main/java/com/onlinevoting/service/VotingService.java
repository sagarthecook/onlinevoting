package com.onlinevoting.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinevoting.model.Candidate;
import com.onlinevoting.model.Election;
import com.onlinevoting.model.UserDetail;
import com.onlinevoting.model.Voting;
import com.onlinevoting.repository.VotingRepository;

@Service
public class VotingService {

    private final VotingRepository votingRepository;
    
    public VotingService(VotingRepository votingRepository) {
        this.votingRepository = votingRepository;
    }

    public void saveVoting(Voting voting) {
        votingRepository.save(voting);
    }

    public void createVotingEntries(Long electionId, List<UserDetail> voters) {
        for (UserDetail voter : voters) {
            Voting voting = new Voting();
            Election election = new Election();
            election.setId(electionId);
            voting.setElection(election);
            voting.setVoter(voter);
            voting.setCandidateId(null);
            voting.setActive(true);
            votingRepository.save(voting);
        }
    }   

    public List<Voting> getAllVotingsByElectionId(Long electionId) {
        return votingRepository.findAllByElection(electionId);
    }
}
