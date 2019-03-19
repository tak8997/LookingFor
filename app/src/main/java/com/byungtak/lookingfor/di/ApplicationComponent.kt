package com.byungtak.lookingfor.di

import com.byungtak.lookingfor.LookingForApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    ApplicationModule::class,
    ApplicationRepositoryModule::class
])
internal interface ApplicationComponent: AndroidInjector<LookingForApp> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<LookingForApp>()
}