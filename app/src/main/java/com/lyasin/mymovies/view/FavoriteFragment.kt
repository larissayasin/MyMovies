package com.lyasin.mymovies.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.lyasin.mymovies.R
import com.lyasin.mymovies.viewmodel.FavoriteMovieViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {


    private lateinit var v: View
    private val vm: FavoriteMovieViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_list, container, false)
        return v
    }

    override fun onResume() {
        super.onResume()
        v.rv_list.layoutManager = LinearLayoutManager(context)
        v.rv_list.adapter = FavoriteAdapter(vm.all()?.list ?: listOf())
    }
}
