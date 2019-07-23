package com.mksoft.a0714userinsertanduserdeleteproject.DI;


import com.mksoft.a0714userinsertanduserdeleteproject.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


/**
 * Created by Philippe on 02/03/2018.
 */


@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();


}
