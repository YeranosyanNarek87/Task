package com.example.myapplication.repo

import android.net.vcn.VcnWifiUnderlyingNetworkTemplate
import android.util.Log
import com.example.myapplication.data.CityWeatherInfo
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

class LocalDataProviderImpl(
    private val gson: Gson = Gson()
) : LocalDataProvider {
    override suspend fun saveData(data: CityWeatherInfo) = withContext(Dispatchers.IO){
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


    override suspend fun getData(): CityWeatherInfo? {
        var data: CityWeatherInfo? = null
        withContext(Dispatchers.IO) {
            try {
                val file = File("context.filesDir", FILE_NAME)
                val reader = FileReader(file)
                data = gson.fromJson(reader, CityWeatherInfo::class.java)
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

    }

}

