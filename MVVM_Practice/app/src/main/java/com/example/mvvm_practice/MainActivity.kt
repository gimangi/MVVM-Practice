package com.example.mvvm_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_practice.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>({ActivityMainBinding.inflate(it)}) {

    companion object {
        const val TAG: String = "로그"
    }

    lateinit var myNumberViewModel: MyNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)

        myNumberViewModel.currentValue.observe(this, Observer {
            Log.d(TAG, "MainActivity - myNumberViewModel - currentValue 라이브 데이터 값 변경 : $it")
            binding.tvNumber.text = it.toString()
        })


    }
}