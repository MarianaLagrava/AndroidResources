package com.lagravam.praktikandoproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.lagravam.praktikandoproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Darle vuelta a tu nombre de Activity (ActivityMain) y despues le agregas Binding
    //1 Declarar binding, tener el layout en xml

    //////////////////////////////////////////////////////////
    //ESTRUCTURA PARA DATA BINDING Y VIEWMODEL, IMPORTAR PRIMERO LAS DEPENDENCIAS EN EL GRADLE
    //
    private lateinit var binding: ActivityMainBinding

    //Importando los viewmodels
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //2 declararle el activitymainbinding al binding con layoutinflater

        binding = ActivityMainBinding.inflate(layoutInflater)

        //3 setear en setcontentView binding.root 

        setContentView(binding.root)

        //setearle al binding el viewModel
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        //DECLARAR LAS FUNCIONES SIEMPRE
        addEventListeners()

    }


    //
    fun addEventListeners(){
        binding.minusBtn.setOnClickListener {
            viewModel.minusAction()
        }

        binding.plusBtn.setOnClickListener {
            viewModel.addAction()
        }

        binding.saveBtn.setOnClickListener {
            openActivity()
        }
    }


    fun openActivity(){
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("KEY_NAME",viewModel.name.value)
        intent.putExtra("KEY_LASTNAME", viewModel.lastname.value)
        intent.putExtra("KEY_COUNTER", viewModel.counter.value)
        startActivity(intent)
    }
}
/////////////////////////////////////////////////////////////////////////////////////////