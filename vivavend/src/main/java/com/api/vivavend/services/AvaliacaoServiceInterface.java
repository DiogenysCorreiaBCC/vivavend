package com.api.vivavend.services;

import com.api.vivavend.model.Avaliacao;

public interface AvaliacaoServiceInterface {
    Avaliacao saveAvaliacao(Avaliacao avaliacao);
    void deleteAvaliacao(Avaliacao avaliacao);
}
