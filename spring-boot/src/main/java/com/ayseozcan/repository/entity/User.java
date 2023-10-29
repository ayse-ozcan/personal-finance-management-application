package com.ayseozcan.repository.entity;

import com.ayseozcan.repository.enums.ERole;
import com.ayseozcan.repository.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document
public class User extends BaseEntity {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String profilePicture;
    @Builder.Default
    private EStatus eStatus = EStatus.PENDING;
    @Builder.Default
    private ERole eRole = ERole.USER;
}
