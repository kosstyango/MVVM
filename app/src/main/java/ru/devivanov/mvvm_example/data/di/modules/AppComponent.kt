package ru.devivanov.mvvm_example.data.di.modules

import dagger.Component
import ru.devivanov.mvvm_example.view.MainActivity
import javax.inject.Singleton

//Указываем, к какому скоупу он относится
    @Singleton
//Указываем, что это компонент
    @Component(
        //Передаем, какие модули будут жить в этом компоненте
        modules = [
            ViewModelProviderModule::class
        ]
    )
    interface AppComponent {
        //Указываем метод, который будет инжектить зависимости в определенное место
        fun inject(mainActivity: MainActivity)
    }