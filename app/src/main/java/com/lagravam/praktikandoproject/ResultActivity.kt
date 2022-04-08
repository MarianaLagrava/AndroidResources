package com.lagravam.praktikandoproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lagravam.praktikandoproject.databinding.ActivityMainBinding
import com.lagravam.praktikandoproject.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val bundle=intent.extras!!

        var name = bundle.getString("KEY_NAME")
        var lastname = bundle.getString("KEY_LASTNAME")
        var counter = bundle.getInt("KEY_COUNTER")

        binding.textViewName.text = name
        binding.textViewLastname.text = lastname
        binding.textViewCounter.text = counter.toString()


    }
}