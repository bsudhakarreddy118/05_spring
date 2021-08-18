package com.learn.contactservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Contact {
    @Id
    private String contactId;
    private String name;
    private String email;
    private String mobile;
    private String category;
    private String userEmail;
}
