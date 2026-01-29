package com.example.triviaapp.modelo

data class PreguntaDTO(
    var id: String,
    var idTrivial: String,
    var opcion1: String,
    var pregunta: String,
    var respuestaCorrecta: Int
)