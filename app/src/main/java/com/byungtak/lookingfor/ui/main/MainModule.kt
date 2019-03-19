package com.byungtak.lookingfor.ui.main

import dagger.Module

@Module(includes = [MainModule.ProvideModule::class])
internal interface MainModule {

    @Module
    class ProvideModule {

    }
}