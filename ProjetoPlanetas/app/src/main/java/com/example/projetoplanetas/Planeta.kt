package com.example.projetoplanetas

import android.content.Context
import android.content.res.Resources
import android.content.res.TypedArray

class Planeta(var name: String, var imagemId: Int) {

    companion object{
        fun buildPlanets(context: Context): List<Planeta>{
            var planets: ArrayList<Planeta> = ArrayList()
            var res: Resources = context.resources
            var names = res.getStringArray(R.array.planets_names)
            var images: TypedArray =  res.obtainTypedArray(R.array.planets_imgs)

            for(i in names.indices){
                var planet = Planeta(names[i], images.getResourceId(i, -1))

                planets.add(planet)
            }

            return planets
        }
    }
}