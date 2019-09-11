package com.example.projetoplanetas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class PlanetFragment : Fragment() {

    private var planeta : Planeta?=null

    companion object{
        fun newInstance(planeta: Planeta):PlanetFragment{
            var fragment = PlanetFragment()
            fragment.planeta = planeta
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.fragment_planet,container,false)
        var imageView: ImageView = view.findViewById(R.id.image)
        imageView.setImageResource(planeta?.imagemId!!)

        activity?.title = planeta?.name
        return view
    }
}