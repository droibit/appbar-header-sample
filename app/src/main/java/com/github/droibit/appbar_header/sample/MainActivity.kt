package com.github.droibit.appbar_header.sample

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.doOnLayout
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_main.appBarLayout
import kotlinx.android.synthetic.main.activity_main.list

private const val EXTRA_KEY_APPBAR_Y_OFFSET = "EXTRA_KEY_APPBAR_Y_OFFSET"

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    list.also {
      it.setHasFixedSize(true)
      it.adapter = TextListAdapter(this)
    }

    if (savedInstanceState != null) {
      appBarLayout.doOnLayout {
        val offset = savedInstanceState.getInt(EXTRA_KEY_APPBAR_Y_OFFSET)
        AppBarLayoutBehavior.from(it)
            .topAndBottomOffset = offset
      }
    }

    Handler().postDelayed({
      (list.adapter as TextListAdapter).replace(
          (0 until 100).map { "Text $it" }
      )
    }, 250L)
  }

  override fun onSaveInstanceState(outState: Bundle) {
    val behavior = AppBarLayoutBehavior.from(appBarLayout)
    outState.putInt(EXTRA_KEY_APPBAR_Y_OFFSET, behavior.topAndBottomOffset)

    super.onSaveInstanceState(outState)
  }
}

private object AppBarLayoutBehavior {

  fun from(view: View): AppBarLayout.Behavior {
    return (view.layoutParams as CoordinatorLayout.LayoutParams).behavior as AppBarLayout.Behavior
  }
}