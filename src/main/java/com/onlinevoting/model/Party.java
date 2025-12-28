
package com.onlinevoting.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "party")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Party extends AuditDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_id")
    private Long partyId;

    @NotBlank(message = "Party name is mandatory")
    @Column(name = "party_name", nullable = false, length = 255)
    private String partyName;

    @NotBlank(message = "Logo text is mandatory")
    @Column(name = "logo_text", nullable = false, columnDefinition = "TEXT")
    private String logoText;

    @NotBlank(message = "Party president is mandatory")
    @Column(name = "president_name", nullable = false, length = 255)
    private String presidentName;
}