package com.app.demoproject.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.app.demoproject.R
import com.app.demoproject.base.BaseActivity
import com.app.demoproject.base.BaseView
import com.app.demoproject.base.BaseViewModel
import com.app.demoproject.databinding.ActivityMainBinding
import com.app.demoproject.session.Session
import com.app.demoproject.ui.fragment.MainFragment
import com.app.demoproject.ui.login.LoginActivity
import com.google.android.material.navigation.NavigationView

class MainActivity : BaseActivity<ActivityMainBinding>(),
    NavigationView.OnNavigationItemSelectedListener, BaseView {

    lateinit var mainViewModel: BaseViewModel
    lateinit var toggle: ActionBarDrawerToggle
    var mainFragment: MainFragment = MainFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        activity = this@MainActivity
        super.onCreate(savedInstanceState)
        mainViewModel = BaseViewModel(this)
        binding.navView.getHeaderView(0).findViewById<TextView>(R.id.iv_logout)
            .setOnClickListener {
                Session.getInstance()!!.logout()
                startActivityWithIntent(LoginActivity::class.java)
                finishAffinity()
            }
        _initialHome()
    }


    fun _initialHome() {

        toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
        toggle.syncState()
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.title = resources.getString(R.string.dash)
        binding.apply {
            navView.setNavigationItemSelectedListener(this@MainActivity)
        }
        loadFragment(R.id.content_container, mainFragment)
    }


    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_dashboard -> {
                supportActionBar!!.title = resources.getString(R.string.dash)
                showErrorMessage("Clicked on ${resources.getString(R.string.dash)}")
                _fetchDrawerGravity()
                return true
            }
            R.id.nav_products -> {
                supportActionBar!!.title = resources.getString(R.string.product)
                _fetchDrawerGravity()
                return true
            }
            R.id.nav_category -> {

                supportActionBar!!.title = resources.getString(R.string.category)
                showErrorMessage("Clicked on ${resources.getString(R.string.category)}")
                _fetchDrawerGravity()
                return true
            }
            R.id.orders -> {
                supportActionBar!!.title = resources.getString(R.string.orders)
                showErrorMessage("Clicked on ${resources.getString(R.string.orders)}")
                _fetchDrawerGravity()
                return true
            }
        }
        return false
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        when (item.itemId) {
            R.id.filter_by_name -> {
                mainFragment.mAdapter.filterByName(mainFragment.productList)
                mainFragment.mAdapter.notifyDataSetChanged()
                return true
            }
            R.id.filter_by_price -> {
                mainFragment.mAdapter.filterByPrice(mainFragment.productList)
                mainFragment.mAdapter.notifyDataSetChanged()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    fun _fetchDrawerGravity() {
        if (!binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        } else {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true

    }


}
