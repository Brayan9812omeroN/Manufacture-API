package com.pruebatecnica.manufactura_api.dto;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Size;

@Validated
public record AuthCreateRoleRequest(@Size(max = 2, message = "The user cannot have more than 2 roles") List<String> roleListName) {}