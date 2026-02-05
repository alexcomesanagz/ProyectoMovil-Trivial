package com.example.triviaapp.modelo

data class PreguntaDTO(
    var id: String,
    var idTrivial: String,
    var opcion1: String,
    var opcion2: String,
    var opcion3: String,
    var opcion4: String,
    var pregunta: String,
    var respuestaCorrecta: Int
)