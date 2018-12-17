package com.github.droibit.appbar_header.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.list

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    list.also {
      it.setHasFixedSize(true)
      it.adapter = TextListAdapter(this)
    }
  }
}
