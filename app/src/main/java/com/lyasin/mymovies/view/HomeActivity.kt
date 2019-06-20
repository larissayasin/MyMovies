package com.lyasin.mymovies.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.lyasin.mymovies.R
import kotlinx.android.synthetic.main.activity_main.*


class HomeActivity : AppCompatActivity(){

    val fragment1: Fragment = PopularFragment()
    val fragment2: Fragment = TopRatedFragment()
    val fm = supportFragmentManager
    var active = fragment1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_bottom_menu.setOnNavigationItemSelectedListener {
            item ->
            when (item.itemId) {
                R.id.item_popular -> {
                    supportActionBar?.title = ""
                    fm.beginTransaction().hide(active).show(fragment1).commit()
                    active = fragment1
                }
                R.id.item_top_rated -> {
                    supportActionBar?.title = ""
                    fm.beginTransaction().hide(active).show(fragment2).commit()
                    active = fragment2
                }
                R.id.item_favorites -> {
                }
            }
            true
        }

        //fm.beginTransaction().add(R.id.main_frame, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.main_frame, fragment2, "2").hide(fragment2).commit()
        fm.beginTransaction().add(R.id.main_frame,fragment1, "1").commit()

      //  main_bottom_menu.itemIconTintList = null
    }

}
