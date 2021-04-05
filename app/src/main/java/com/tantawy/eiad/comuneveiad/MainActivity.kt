package com.tantawy.eiad.comuneveiad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tantawy.eiad.comuneveiad.recyclerview.PersonAdapter
import com.tantawy.eiad.comuneveiad.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var personAdapter: PersonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRv()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getPersonList()

        viewModel.myResponse.observe(this, Observer { response ->
            val mdata = response.results
            if(mdata.size == 0){
                no_people.visibility = View.VISIBLE
                rv_people.visibility = View.GONE
            }
            else{
                no_people.visibility = View.GONE
                rv_people.visibility = View.VISIBLE
                personAdapter = PersonAdapter(mdata, this)
                rv_people.adapter = personAdapter
            }
        }
        )
    }

    private fun initRv(){
        rv_people.layoutManager = LinearLayoutManager(this)
        rv_people.setHasFixedSize(true)
    }
}