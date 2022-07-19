/*
*  Copyright 2022 Matthew Nelson
*
*  Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
*  You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
* */
package io.matthewnelson.component.parcelize.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.matthewnelson.component.parcelize.sample.data.MyData
import io.matthewnelson.component.parcelize.sample.data.SealedValueClass

class MainActivity: AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent()

        Log.d("MainActivity", "Putting MyData into an Intent as a Parcelable")
        intent.putExtra("MY_DATA", MyData("My Data"))

        Log.d("MainActivity", "Retrieving MyData from Intent as a Parcelable")
        val myData = intent.getParcelableExtra<MyData>("MY_DATA")

        Log.d("MainActivity", myData.toString())

        Log.d("MainActivity", "--------------------------------")

        Log.d("MainActivity", "Putting SealedValueClass into an Intent as a Parcelable")
        intent.putExtra(
            "SEALED_VALUE_CLASS",
            SealedValueClass("It's a value class, but wrapped by a sealed interface for type safety on other platforms!")
        )

        Log.d("MainActivity", "Retrieving SealedValueClass from Intent as a Parcelable")
        val sealedValue = intent.getParcelableExtra<SealedValueClass>("SEALED_VALUE_CLASS")

        Log.d("MainActivity", sealedValue.toString())
    }
}
