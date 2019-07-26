package com.example.indicator.indicator.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rulerbug.qmuidemo.qmuidemo.R

 class ItemFragment : Fragment() {
    var RootView: View? = null
    var tv_center: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        RootView = View.inflate(context, R.layout.fragment_item, null);

        return RootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_center = RootView!!.findViewById<TextView>(R.id.tv_center)
        val string = arguments!!.getString(TEXT_KEY)
        tv_center!!.setText(string)
    }

    companion object {
        val TEXT_KEY = "TEXT_KEY"
         fun getInstence(text: String): ItemFragment {
            val itemFragment = ItemFragment()
            val bundle = Bundle()
            bundle.putString(TEXT_KEY, text)
            itemFragment.arguments = bundle
            return itemFragment

        }
    }

}