package com.example.activities.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.activities.R
import com.example.activities.teamcontroller.mvcController
import com.example.activities.model.activities
import com.example.activities.teamcontroller.mvcKambaClient
import com.example.activities.teamcontroller.mvcServiceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class mvcView : AppCompatActivity() {


    val activityList : ArrayList<activities> = ArrayList();
    var progressBar :ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv_activity = findViewById<RecyclerView>(R.id.rv_activities)
        rv_activity.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = mvcController(activityList)
        rv_activity.adapter =adapter

        progressBar =findViewById(R.id.progressbar_id)


        sr_layout.setColorSchemeColors(resources.getColor(R.color.colorPrimary))

        sr_layout.setOnRefreshListener {
            loadItems()
        }


        loadItems()

    }

    fun loadItems(){
        sr_layout.isRefreshing=true

        loadActivities()


    }

    fun onItemsLoadComplete()
    {
        rv_activities.adapter!!.notifyDataSetChanged()
        sr_layout.isRefreshing=false
    }

    override fun onResume() {
        super.onResume()

        sr_layout.setOnRefreshListener {
            loadItems()
        }

    }

    private  fun loadActivities()
    {
        progressBar!!.visibility =View.VISIBLE
      val activitiesService =  mvcServiceBuilder.buildService(mvcKambaClient::class.java)

      val requestCall = activitiesService.getActivities();

       requestCall.enqueue(object : Callback<List<activities>> {

           override fun onResponse( call: Call<List<activities>>,  response: Response<List<activities>>)
           {
              if(response.isSuccessful)
              {
                  val activities = response.body()!!
                  var activities_op :ArrayList<activities> = ArrayList()

                  for ( activity in activities)
                  {
                       if((  activity.transaction_type.equals("PAYMENT") || activity.transaction_type.equals("RECHARGE")
                           || activity.transaction_type.equals("DEPOSIT"))) {
                           activities_op.add(activity)
                       }
                  }

                  rv_activities.adapter =
                      mvcController(activities_op)
                  rv_activities.visibility=View.VISIBLE
                  progressbar_id.visibility = View.INVISIBLE
                  sr_layout.isRefreshing =false


                  onItemsLoadComplete();

              }else if(response.code() == 401) {
                  Toast.makeText(this@mvcView,
                      "Your session has expired. Please Login again.", Toast.LENGTH_LONG).show()
                //  progressbar_id.visibility = View.INVISIBLE
                  progressBar!!.visibility =View.INVISIBLE

              } else { // Application-level failure
                  // Your status code is in the range of 300's, 400's and 500's
                   Toast.makeText(this@mvcView, "Failed to retrieve items", Toast.LENGTH_LONG).show()
                  progressBar!!.visibility =View.INVISIBLE
              }
               onItemsLoadComplete();

           }
           override fun onFailure(call: Call<List<activities>>, t: Throwable) {
               Log.e("Note ", t.toString())
               Toast.makeText(this@mvcView, "Error Occurred" + t.toString(), Toast.LENGTH_LONG).show()
               onItemsLoadComplete();
               progressBar!!.visibility =View.INVISIBLE
           }

       })


    }
}
