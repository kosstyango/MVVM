package ru.devivanov.mvvm_example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.devivanov.mvvm_example.R
import ru.devivanov.mvvm_example.data.di.modules.DaggerAppComponent
import ru.devivanov.mvvm_example.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    //Инжектим ViewModel
    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        //Создаем граф зависимостей
        DaggerAppComponent.create().inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Подписываемся на изменения
        mainViewModel.lifeData.observe(this) {list ->
            var string = ""
            list.forEach {
                string += it
            }
            text_view.text = string
        }
        //Этой кнойпкой будем забирать из поля списком
        button_get.setOnClickListener {
            mainViewModel.getDB()
        }
        //Этой кнопкой будем класть в базу строку
        button_put.setOnClickListener {
            val text = edit_text.text.toString()
            mainViewModel.putToDB(text)
        }
    }
}