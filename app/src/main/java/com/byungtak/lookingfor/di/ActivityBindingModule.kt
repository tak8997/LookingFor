package com.byungtak.lookingfor.di

import com.byungtak.lookingfor.ui.main.MainActivity
import com.byungtak.lookingfor.ui.main.MainModule
import com.empathy.empathy_android.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun feedActivity(): MainActivity

}
