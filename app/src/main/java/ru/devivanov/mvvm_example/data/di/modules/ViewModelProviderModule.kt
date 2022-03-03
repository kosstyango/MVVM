package ru.devivanov.mvvm_example.data.di.modules
import dagger.Module
import dagger.Provides
import ru.devivanov.mvpexample.data.AppDataBase
import ru.devivanov.mvpexample.data.BaseDataBase
import ru.devivanov.mvvm_example.viewmodel.MainViewModel
import javax.inject.Singleton

@Module
class ViewModelProviderModule {
    //Помечаем скоуп
    @Singleton
    //Помечаем, что этот метод у нас предоставляет зависимость
    @Provides
    fun provideRepo(): BaseDataBase = AppDataBase()

    //Помечаем скоуп
    @Singleton
    //Помечаем, что этот метод у нас предоставляет зависимость
    @Provides
    fun provideViewModel(repo: BaseDataBase): MainViewModel = MainViewModel(repo)
}