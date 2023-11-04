package com.example.myapplication.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.api.FoodSticker
import com.example.myapplication.api.Meal
import com.example.myapplication.retrofit.RetrofitInstance
//import com.example.myapplication.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment2 : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RetrofitInstance.api.getRandomFood().enqueue(object : Callback<FoodSticker>{
            override fun onResponse(call: Call<FoodSticker>, response: Response<FoodSticker>) {
                TODO("Not yet implemented")
                if (response.body() != null){
                    val randomFood : Meal = response.body()!!.meals[0]
                    Log.d("Test","meal id ${randomFood.idMeal} name${randomFood.strMeal}")
                }else{
                    return

                }
            }

            override fun onFailure(call: Call<FoodSticker>, t: Throwable) {
                Log.d("HomeFragment",t.message.toString())
            }

        })

        }


}