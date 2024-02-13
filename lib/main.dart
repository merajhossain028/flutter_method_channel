import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  // MethodChannel for Android
  // Create a variable for MethodChannel
  var channel = const MethodChannel('toast_android');

  // Create a function to show toast
  // In this function we will call the method channel using invokeMethod
  showToast() {
    channel.invokeMethod(
        'showToast', {'message': 'This is Flutter MethodChannel '});
  }
  /*
  * The above code will call the method channel and pass the message to the native code.
  * Now the 'android' folder will contain the MainActivity.kt file where we will write the native code to show the toast.
  * Open the 'android' folder into Android Studio and open MainActivity file. The file location is in app -> java -> com.example.your_app_name -> MainActivity.kt
  * Now edit the MainActivity.kt file and add the following code.
  * In this project's MainActivity.kt file, we have added the following code.
  */

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(
                onPressed: showToast, child: const Text("Show Toast"))
          ],
        ),
      ),
    );
  }
}
