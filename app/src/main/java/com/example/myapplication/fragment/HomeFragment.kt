package com.example.myapplication.fragment

import MostPopularAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplication.activity.DetailActivity
import com.example.myapplication.activity.MainActivity
import com.example.myapplication.api.Meal
import com.example.myapplication.databinding.FragmentHome2Binding
import com.example.myapplication.pojo.CategoryMeals
import com.example.myapplication.videoModel.HomeViewModel
//import com.example.myapplication.retrofit.RetrofitInstance


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHome2Binding
    private lateinit var homeMvvm: HomeViewModel
    private lateinit var ramdomSticker: Meal
    private lateinit var popularItemsAdapter: MostPopularAdapter


    companion object{
        const val MEAL_ID = "com.example.myapplication.fragment.idMeal"
        const val MEAL_NAME = "com.example.myapplication.fragment.nameMeal"
        const val MEAL_THUMB = "com.example.myapplication.fragment.thumbMeal"

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeMvvm = ViewModelProvider(this)[HomeViewModel::class.java]

        popularItemsAdapter = MostPopularAdapter()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHome2Binding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preparePopularItemsRecyclerView()

        homeMvvm.getRandomSticker()
        observerRandomSticker()

        onRamdomStickerClick()

        homeMvvm.getPopularItems()
        observePopulartionItemsLiveData()

        onPopularItemsClick()
    }

    private fun preparePopularItemsRecyclerView(){
        binding.

    }

    private fun observePopularItemsLiveData(){
        homeMvvm.observeRandomMealLiverdata().observe(viewLifecycleOwner
        ) { mealList-> }
    }

    private fun onPopularItemsClick() {
        popularItemsAdapter.onItemClick = { meal ->
            val intent = Intent(activity, MainActivity::class.java) //DetailActivity test
            intent.putExtra(MEAL_ID, meal.idMeal)
            intent.putExtra(MEAL_NAME, meal.strMeal)
            intent.putExtra(MEAL_THUMB, meal.strMealThumb)
            startActivity(intent)
        }
    }

    private fun preparePopularItemsRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = popularItemsAdapter
        }
    }

    private fun observePopulartionItemsLiveData() {
        homeMvvm.observeRandomMealLiverdata().observe(viewLifecycleOwner,
        ) { FoodStickerList ->
            popularItemsAdapter.setMeals(mealsList = FoodStickerList as ArrayList<CategoryMeals>)

        }
    }

    private fun onRamdomStickerClick(){
//        binding.randomStickerCard.setOnClickerListener {
//            val intent = Intent(activity.MainActivity::class.java)
//            startActivity(intent)
//        }

        binding.cardPower.setOnClickListener(){
            val intent = Intent(activity,DetailActivity::class.java)

            intent.putExtra(MEAL_NAME,ramdomSticker.idMeal)
            intent.putExtra(MEAL_NAME,ramdomSticker.strMeal)
            intent.putExtra(MEAL_NAME,ramdomSticker.strMealThumb)
            startActivity(intent)
        }


    }

private fun observerRandomSticker(){
    homeMvvm.observeRandomStickerLivedata().observe(viewLifecycleOwner,
        {meal ->
            Glide.with(this@HomeFragment)
                .load(meal!!.strMealThumb)
                .into(binding.powerpuffGirlImg)


//                this@HomeFragment2.ramdomSticker = meal
            this.ramdomSticker = meal



    })


}


}

