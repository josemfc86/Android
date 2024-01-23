package com.example.amphibians.data

import com.example.amphibians.network.AmphibiansApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

//Contenedor de inyección de dependencias a nivel de aplicación.
interface AppContainer {
    val amphibiansRepository: AmphibiansRepository
}
/*
Implementación para el contenedor de inyección de dependencias a nivel de aplicación.
Las variables se inicializan de forma perezosa y se comparte la misma instancia en toda la aplicación.
*/
class DefaultAppContainer : AppContainer {

    private val baseURL =
        "https://android-kotlin-fun-mars-server.appspot.com"

    /*
    Utilice el constructor Retrofit para construir un objeto retrofit utilizando un convertidor
    kotlinx.serialization
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseURL)
        .build()

    //Objeto de servicio retrofit para crear llamadas api
    private val retrofitService: AmphibiansApiService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }

    //Implementación de DI para el repositorio de anfibios
    override val amphibiansRepository: AmphibiansRepository by lazy {
        NetworkAmphibiansRepository(retrofitService)
    }

}