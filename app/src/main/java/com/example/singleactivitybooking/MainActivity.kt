package com.example.singleactivitybooking

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import com.example.singleactivitybooking.view.fragments.BaseFragment
import com.example.singleactivitybooking.view.viewpager.ViewPagerAdapter
import com.example.singleactivitybooking.view.fragments.FourthFragment
import com.example.singleactivitybooking.view.fragments.SecondFragment
import com.example.singleactivitybooking.view.fragments.ThirdFragment
import com.example.singleactivitybooking.view.viewpager.NonswipableViewPager

class MainActivity : AppCompatActivity() {

    private var viewPager: NonswipableViewPager? = null
    private var bottomNavi: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_container)
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);     //  Fixed Portrait orientation

        initViews()
        setupViewPager()
        setupBottomNaviListener()
    }

    private fun initViews() {
        viewPager = findViewById(R.id.viewPager)
        viewPager?.setSwipePagingEnabled(false)
        bottomNavi = findViewById(R.id.main_bottom_navigation)
    }

    private fun setupViewPager() {

        val adapter = ViewPagerAdapter(getSupportFragmentManager())

        var bookingFragment: BaseFragment = BaseFragment.newInstance()
        var mapFragment: SecondFragment = SecondFragment.newInstance()
        var accountFragment: ThirdFragment = ThirdFragment.newInstance()
        var infoFragment: FourthFragment = FourthFragment.newInstance()

        adapter.addFragment(bookingFragment)
        adapter.addFragment(mapFragment)
        adapter.addFragment(accountFragment)
        adapter.addFragment(infoFragment)

        viewPager?.adapter = adapter
    }

    private fun setupBottomNaviListener() {
        bottomNavi?.setOnNavigationItemSelectedListener { onNavigationItemSelected(it) }
    }

    private fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.title == getString(R.string.BOOKING)) {
            viewPager?.setCurrentItem(0)
        }
        if (menuItem.title == getString(R.string.MAP)) {
            viewPager?.setCurrentItem(1)
        }
        if (menuItem.title == getString(R.string.ACCOUNT)) {
            viewPager?.setCurrentItem(2)
        }
        if (menuItem.title == getString(R.string.INFO)) {
            viewPager?.setCurrentItem(3)
        }
        return true
    }
}
