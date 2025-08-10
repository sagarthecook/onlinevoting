package com.onlinevoting.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class AuditDetail {
    private String createdBy;
    private LocalDateTime createdDate;
    private String updateBy;
    private LocalDateTime updatedBy;
    private Boolean isActive;
}
