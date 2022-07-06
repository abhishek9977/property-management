package com.mycompany.propertymanagement1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO
{
    private Long id;
    private String ownerName;
    @NotNull(message = "email is manditory")
    @NotEmpty(message = "email should not be empty")
    @Size(min=1,max=50,message = "owner email should be between 1 o 50 ")
    private String ownerEmail;
    @NotNull(message = "email cannot be null")
    @NotEmpty(message = "password cannot be empty")
    private String password;
    private String phone;
}
