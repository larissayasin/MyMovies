package com.lyasin.mymovies.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.lyasin.mymovies.R
import kotlinx.android.synthetic.main.activity_main.*


class HomeActivity : AppCompatActivity() {

    private val fragPopular: Fragment = PopularFragment()
    private val fragTopRated: Fragment = TopRatedFragment()
    private val fragFavorite: Fragment = FavoriteFragment()
    private val fm = supportFragmentManager
    private var active = fragPopular

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_bottom_menu.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_popular -> {
                    fm.beginTransaction().hide(active).show(fragPopular).commit()
                    active = fragPopular
                }
                R.id.item_top_rated -> {
                    fm.beginTransaction().hide(active).show(fragTopRated).commit()
                    active = fragTopRated
                }
                R.id.item_favorites -> {
                    fm.beginTransaction().hide(active).show(fragFavorite).commit()
                    active = fragFavorite
                }
            }
            true
        }
        fm.beginTransaction().add(R.id.main_frame, fragFavorite, "3").hide(fragFavorite).commit()
        fm.beginTransaction().add(R.id.main_frame, fragTopRated, "2").hide(fragTopRated).commit()
        fm.beginTransaction().add(R.id.main_frame, fragPopular, "1").commit()
    }

}
