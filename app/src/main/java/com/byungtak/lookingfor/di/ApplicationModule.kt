package com.byungtak.lookingfor.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.byungtak.lookingfor.BaseViewModelFactory
import com.byungtak.lookingfor.LookingForApp
import com.byungtak.lookingfor.di.qualifier.App
import com.byungtak.lookingfor.repository.LookingForRepository
import com.byungtak.lookingfor.repository.LookingForRepositoryApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module(includes = [ApplicationModule.ProvideModule::class])
internal interface ApplicationModule {

    @Module
    class ProvideModule {

        @Singleton
        @Provides
        @App
        fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

        @Singleton
        @Provides
        @App
        fun provideContext(): Context = LookingForApp.instance
    }

    @Binds
    @Singleton
    fun bindsEmpathyRepository(repository: LookingForRepository): LookingForRepositoryApi

    @Binds
    fun bindsViewModelFactory(viewModelFactory: BaseViewModelFactory): ViewModelProvider.Factory

}
