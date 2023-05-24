package com.example.myapplication.data.repo

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

class LocalDataProviderImpl(
    private val gson: Gson
) : LocalDataProvider {
    override suspend fun saveData(data: Any) = withContext(Dispatchers.IO) {
        val jsonString = gson.toJson(data)
        try {
            val file = File("context.filesDir", FILE_NAME)
            val writer = FileWriter(file)
            writer.write(jsonString)
            writer.flush()
            writer.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override suspend fun getFavData(): List<Any> = emptyList()


    override suspend fun getData(): Any? {
        var data: Any? = null
        withContext(Dispatchers.IO) {
            try {
                val file = File("context.filesDir", FILE_NAME)
                val reader = FileReader(file)
                data = gson.fromJson(reader, Any::class.java)
                reader.close()
                return@withContext
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return data
    }


    companion object {
        const val FILE_NAME = "myFile.txt"

        const val YEREVAN =
            "https://media.istockphoto.com/id/1144776438/photo/yerevan-capital-of-armenia-in-front-of-mt-ararat.jpg?s=2048x2048&w=is&k=20&c=NOlcuBAJaOnZZkBP98gxJ7UZrsFo8iLEXkTu8VahAW8="
        const val LONDON =
            "https://media.istockphoto.com/id/486335054/photo/westminster-palace-in-london-at-dusk.jpg?s=2048x2048&w=is&k=20&c=doEmCqG5FCaMmWrjC10aShWq-wyNL5QzQOl4DipmRvQ="
        const val MOSCOW =
            "https://media.istockphoto.com/id/502362300/photo/st-basils-cathedral.jpg?s=2048x2048&w=is&k=20&c=BQ4CAcDWyNMdLZEE7uEeqS8XIxZpIXb9WIcJLsfbK0M="
        const val PARIS =
            "https://media.istockphoto.com/id/1318491139/photo/eiffel-tower-and-spring-tulips-on-field-of-mars-paris-france.jpg?s=2048x2048&w=is&k=20&c=hNsm_sJaZw074hpiL-PSOR5KLwn3akJlyQ8otu7gbUc="
        const val MADRID =
            "https://media.istockphoto.com/id/1317090704/photo/architecture-in-madrid.jpg?s=2048x2048&w=is&k=20&c=tfXkocPFh39mxZBgK42Ctkim8fTZ-HYIq7wa9Tmn0VM="
        const val BARCELONA =
            "https://media.istockphoto.com/id/1418575808/photo/barcelona-eixample-residential-district-and-famous-basilica-sagrada-familia-at-sunset.jpg?s=2048x2048&w=is&k=20&c=NLXd1e48Yruyf_Oi4Gcis2Oipt6YvQO1nF33zD388g4="
        const val ROMA =
            "https://media.istockphoto.com/id/1367812451/photo/piazza-de-spagna-in-rome-italy-spanish-steps-in-the-morning-rome-architecture-and-landmark.jpg?s=2048x2048&w=is&k=20&c=r-QhtmL-w-4QzueuFpSPxe_mADn0fyaHvsQJKP49JaU="
        const val MILAN =
            "https://media.istockphoto.com/id/637278516/photo/piazza-duomo-in-milan.jpg?s=2048x2048&w=is&k=20&c=tsVCt8olNnN9KPZRlkBsaBX5nA0L21jCEcgP3ObCdFs="
        const val PRAGUE =
            "https://media.istockphoto.com/id/1418683496/photo/vltava-river-and-charles-bridge-in-prague-czech-republic.jpg?s=2048x2048&w=is&k=20&c=nPSxKijd7_4r81oUI7ND_flJWAyPQPqG_v4P3p46USM="
    }
}

