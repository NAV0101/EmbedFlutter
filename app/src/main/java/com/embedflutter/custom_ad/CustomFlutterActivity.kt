package com.embedflutter.custom_ad
import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugins.googlemobileads.GoogleMobileAdsPlugin

open class CustomFlutterActivity : FlutterActivity() {
//    private val channel = "io.flutter.channel/app_methods"


    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        val nativeAdFactory: GoogleMobileAdsPlugin.NativeAdFactory = CustomNativeAd(layoutInflater)
        GoogleMobileAdsPlugin.registerNativeAdFactory(flutterEngine, "nativeAdView", nativeAdFactory)

//        val smallNativeAdFactory: GoogleMobileAdsPlugin.NativeAdFactory = CustomNativeAdSmall(layoutInflater)
//        GoogleMobileAdsPlugin.registerNativeAdFactory(flutterEngine, "smallNativeAdView", smallNativeAdFactory)

//        MethodChannel(
//            flutterEngine.dartExecutor.binaryMessenger,
//            channel
//        ).setMethodCallHandler { call, result ->
//            print(call.method)
//            result.notImplemented()
//        }
    }

    override fun cleanUpFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        GoogleMobileAdsPlugin.unregisterNativeAdFactory(flutterEngine, "nativeAdView");
//        GoogleMobileAdsPlugin.unregisterNativeAdFactory(flutterEngine, "smallNativeAdView");
    }
}