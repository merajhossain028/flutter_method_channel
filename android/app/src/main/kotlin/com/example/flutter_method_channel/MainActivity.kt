package com.example.flutter_method_channel

import io.flutter.embedding.android.FlutterActivity

import android.widget.Toast
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity(){

    private val channelName = "toast_android";
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        val channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, channelName);

        channel.setMethodCallHandler{ call, _ ->

            val args = call.arguments as Map<String,String>
            val message = args["message"];

            if (call.method == "showToast"){
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}