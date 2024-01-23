package com.example.amphibians.data

import com.example.amphibians.network.Amphibian
import com.example.amphibians.network.AmphibiansApiService

//El repositorio recupera datos de anfibios de la fuente de datos subyacente.
interface AmphibiansRepository {
    //Recupera la lista de anfibios de la fuente de datos subyacente
    suspend fun getAmphibians(): List<Amphibian>
}

//Red de Implementación de un repositorio que recupera datos de anfibios de la fuente de datos subyacente.
class NetworkAmphibiansRepository(private val amphibiansApiService: AmphibiansApiService): AmphibiansRepository{
    //Recupera la lista de anfibios de la fuente de datos subyacente
    override suspend fun getAmphibians(): List<Amphibian> {
        return amphibiansApiService.getAmphibians()
    }
}