package com.onlinevoting.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "candidate")
@Data
public class Candidate extends AuditDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @NotBlank(message = "Candidate name is mandatory")
    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;

    @Column(name = "middle_name", nullable = false, length = 255)
    private String middleName;

    @NotBlank(message = "Candidate last name is mandatory")
    @Column(name = "last_name", nullable = false, length = 255)
    private String lastName;

    @NotBlank(message = "occupation is mandatory")
    @Column(name = "occupation", nullable = false, length = 255)
    private String occupation;

    @NotNull(message="Income is mandatory")
    @Column(name = "income", nullable = false)
    private Double income;

    @NotNull(message = "Party is mandatory")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "party_id", referencedColumnName = "id")
    private Party party;
  

    @NotNull(message = "Election is mandatory")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "election_id", referencedColumnName = "election_id")
    private Election election;

}

