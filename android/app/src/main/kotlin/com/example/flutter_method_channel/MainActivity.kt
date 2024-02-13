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

//For Java
/*
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "toast_android";

    @Override
    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);

        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            if (call.method.equals("showToast")) {
                                String message = call.argument("message");
                                showToast(message);
                                result.success(null);
                            } else {
                                result.notImplemented();
                            }
                        }
                );
    }

    private void showToast(String message) {
        // Code to show Toast on Android
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
 */