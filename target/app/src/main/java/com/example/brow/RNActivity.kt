package com.example.brow

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import com.meedwire.expo_app.brownfield.BrownfieldActivity
import com.meedwire.expo_app.brownfield.showReactNativeFragment

class RNActivity : BrownfieldActivity(), DefaultHardwareBackBtnHandler {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        showReactNativeFragment()
    }

    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }
}