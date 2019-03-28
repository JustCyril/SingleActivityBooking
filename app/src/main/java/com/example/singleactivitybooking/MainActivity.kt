package com.example.singleactivitybooking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.example.singleactivitybooking.view.fragments.BaseFragment
import com.example.singleactivitybooking.view.ViewPagerAdapter
import com.example.singleactivitybooking.view.fragments.FourthFragment
import com.example.singleactivitybooking.view.fragments.SecondFragment
import com.example.singleactivitybooking.view.fragments.ThirdFragment

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_container)

        initViews()
        setupViewPager()
    }

    private fun initViews() {
        viewPager = findViewById(R.id.viewPager)
        tabs = findViewById(R.id.tabs)
    }

    private fun setupViewPager() {

        val adapter = ViewPagerAdapter(getSupportFragmentManager())

        var firstFragment: BaseFragment = BaseFragment.newInstance()
        var secondFragment: SecondFragment = SecondFragment.newInstance()
        var thirdFragment: ThirdFragment = ThirdFragment.newInstance()
        var fourthFragment: FourthFragment = FourthFragment.newInstance()

        adapter.addFragment(firstFragment, "frag1")
        adapter.addFragment(secondFragment, "frag2")
        adapter.addFragment(thirdFragment, "frag3")
        adapter.addFragment(fourthFragment, "frag4")

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}
