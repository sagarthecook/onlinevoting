package com.onlinevoting.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AuditDetail {
    private String createdBy;
    private LocalDateTime createdDate;
    private String updateBy;
    private LocalDateTime updatedBy;
    private Boolean isActive;

    public AuditDetail(String createdBy, LocalDateTime createdDate, String updateBy, LocalDateTime updatedBy, Boolean isActive) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updateBy = updateBy;
        this.updatedBy = updatedBy;
        this.isActive = isActive;
    }
}
