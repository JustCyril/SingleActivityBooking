package com.example.singleactivitybooking.view.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.singleactivitybooking.R

class SecondFragment: Fragment() {

    companion object {
            fun newInstance(): SecondFragment {

                val f = SecondFragment()

                val bdl = Bundle(1)

                f.setArguments(bdl)

                return f
            }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View? = inflater.inflate(R.layout.fragment_frg2, container, false);

        return view
    }

}
