package com.curdu.cafeflow.c_models.entitats

import java.io.Serializable

data class Usuari (
    var nom : String,
    var contrasenya: String,
    var email: String
) : Serializable