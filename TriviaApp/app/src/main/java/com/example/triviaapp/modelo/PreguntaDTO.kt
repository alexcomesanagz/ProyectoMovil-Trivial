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
){
    fun cambioValores(pregunta: PreguntaDTO){
        this.respuestaCorrecta=pregunta.respuestaCorrecta
        this.opcion1=pregunta.opcion1
        this.opcion2=pregunta.opcion2
        this.opcion3=pregunta.opcion3
        this.opcion4=pregunta.opcion4
        this.pregunta=pregunta.pregunta
    }
}