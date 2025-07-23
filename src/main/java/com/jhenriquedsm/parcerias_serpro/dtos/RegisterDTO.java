package com.jhenriquedsm.parcerias_serpro.dtos;

import com.jhenriquedsm.parcerias_serpro.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
