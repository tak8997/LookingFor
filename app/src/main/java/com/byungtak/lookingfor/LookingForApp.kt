package com.byungtak.lookingfor

import android.app.Activity
import android.app.Application
import com.byungtak.lookingfor.di.DaggerApplicationComponent
import com.facebook.stetho.Stetho
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

internal class LookingForApp: Application(), HasActivityInjector {

    companion object {
        lateinit var instance: LookingForApp
            private set
    }

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        instance = this

        initializeDagger()
        initializeLeakcanary()
        initializeStetho()
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    private fun initializeDagger() {
        DaggerApplicationComponent
                .builder()
                .create(this)
                .inject(this)
    }

    private fun initializeLeakcanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }

        LeakCanary.install(this)
    }

    private fun initializeStetho() {
        Stetho.initializeWithDefaults(this)
    }
}