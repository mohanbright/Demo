package com.app.demoproject.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.app.demoproject.R
import com.app.demoproject.dataModal.HomeDataModal
import com.app.demoproject.databinding.FragmentMainBinding
import com.app.demoproject.ui.adapter.MainAdapter
import com.app.demoproject.utils.Constants

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    lateinit var mAdapter: MainAdapter
    lateinit var productList: List<HomeDataModal>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productList = ArrayList()
        productList = Constants.Products()
        setUpAdapter()


    }

    private fun setUpAdapter() {
        mAdapter = MainAdapter(productList)
        binding.adapter = mAdapter
    }

}