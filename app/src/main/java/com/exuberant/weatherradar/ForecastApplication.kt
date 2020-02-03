package com.exuberant.weatherradar

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class ForecastApplication: Application(), KodeinAware {

    override val kodein = Kodein.lazy {

    }

}