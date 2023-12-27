package com.example.myapplication.youtubeVD.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentHome2Binding
import com.example.myapplication.youtubeVD.activity.StickerActivity
import com.example.myapplication.youtubeVD.pojo.Meal
import com.example.myapplication.youtubeVD.videoModel.HomeViewModel


class HomeFragment2 : Fragment() {

    private lateinit var binding: FragmentHome2Binding
    private lateinit var homeMvvm: HomeViewModel
    private lateinit var randomSticker: Meal

    ///

    companion object{
        const val MEAL_ID = "com.example.myapplication.youtubeVD.fragment.idMeal"
        const val MEAL_NAME = "com.example.myapplication.youtubeVD.fragment.nameMeal"
        const val MEAL_THUMB = "com.example.myapplication.youtubeVD.fragment.thumbMeal"
    }

    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeMvvm = ViewModelProvider(this)[HomeViewModel::class.java]


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHome2Binding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        homeMvvm.getRamdomMeal()
        observerRamdomMeal()


    }

    /////

    private fun onRamdomMealClick(){
        binding.powerpuffGirlImg.setOnClickListener {
            val intent = Intent(activity, StickerActivity::class.java)

            intent.putExtra(MEAL_ID,randomSticker.idMeal)
            intent.putExtra(MEAL_NAME,randomSticker.strMeal)
            intent.putExtra(MEAL_THUMB,randomSticker.strMealThumb)

            startActivity(intent)
        }


    }

    /////


    private fun observerRamdomMeal(){
        homeMvvm.observeRandomMealLivedata().observe(viewLifecycleOwner,object : Observer<Meal>{
            override fun onChanged(t: Meal) {
                Glide.with(this@HomeFragment2)
                    .load(t!!.strMealThumb)
                    .into(binding.powerpuffGirlImg)
            }

        })
    }

}