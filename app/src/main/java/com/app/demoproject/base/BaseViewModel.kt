package com.app.demoproject.base

import androidx.databinding.BaseObservable
import androidx.lifecycle.ViewModel

open class BaseViewModel(baseView: BaseView) : ViewModel() {
    var booleanObserver: BooleanObserver? = null
        get() {
            if (field == null) {
                field = BooleanObserver()
            }
            return field
        }

    inner class BooleanObserver : BaseObservable() {
        var isVisible = false
            set(visible) {
                field = visible
                notifyChange()
            }

    }

}