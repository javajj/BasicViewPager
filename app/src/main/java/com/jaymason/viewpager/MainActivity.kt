package com.jaymason.viewpager

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	private lateinit var doppelgangerNamesArray: Array<String>

	private val dopplegangerPageChangeCallBack = object : OnPageChangeCallback(){
		override fun onPageSelected(position: Int) {
			super.onPageSelected(position)
			Toast.makeText(this@MainActivity, "Page has been swiped $position", Toast.LENGTH_SHORT).show()
		}
	}


	override fun onCreate(savedInstanceState: Bundle?) {
		// Switch to AppTheme for displaying the activity
		setTheme(R.style.AppTheme)

		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		doppelgangerNamesArray = resources.getStringArray(R.array.doppelganger_names)
		val fragmentAdapter = FragmentAdapter(this, doppelgangerNamesArray.size)
		viewPager.adapter = fragmentAdapter
		viewPager.registerOnPageChangeCallback(dopplegangerPageChangeCallBack)
		TabLayoutMediator(tabLayout, viewPager){ tab, position ->
			tab.text = doppelgangerNamesArray[position].split(" ")[0]
		}.attach()
		viewPager.layoutDirection = ViewPager2.LAYOUT_DIRECTION_LTR
		tabLayout.layoutDirection = View.LAYOUT_DIRECTION_LTR
	}

	override fun onDestroy() {
		super.onDestroy()
		viewPager.registerOnPageChangeCallback(dopplegangerPageChangeCallBack)
	}
}