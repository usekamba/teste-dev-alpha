package com.filomenadeveloper.teste_alpha.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.filomenadeveloper.teste_alpha.Cruds
import com.filomenadeveloper.teste_alpha.R
import com.filomenadeveloper.teste_alpha.RetrofitInstance
import com.filomenadeveloper.teste_alpha.models.Activities
import retrofit2.*

class MainActivity : AppCompatActivity() {

    val token = "xHS1xKwsC4LZvJzXtep0hwtt"
    var mList:  ArrayList<Activities> = ArrayList()
    private lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = findViewById<RecyclerView>(R.id.recycler_activities)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        // Pegar os dados da resposta dada pela api e mostrar em uma lista UI
        val service = RetrofitInstance.buildApi(Cruds::class.java, token)
        val call = service.getUserActivity()
        call.enqueue(object : Callback<List<Activities>>{
            override fun onResponse(call: Call<List<Activities>>, response: Response<List<Activities>>) {
                if (response.code() == 200){
                    try {
                        mList = response.body() as ArrayList<Activities>
                        var adapter = ActivitiesAdapter(mList)
                        mRecyclerView.adapter = adapter
                    }catch(e: Exception){

                    }

                }else{
                    Toast.makeText(applicationContext,response.message(),Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<Activities>>, t: Throwable) {
                Toast.makeText(applicationContext,"Verifica a conexão a internet",Toast.LENGTH_LONG).show()
            }



        })



    }
}