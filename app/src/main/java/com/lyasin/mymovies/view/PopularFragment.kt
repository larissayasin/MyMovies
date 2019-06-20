package com.lyasin.mymovies.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.lyasin.mymovies.R
import com.lyasin.mymovies.model.Movie
import com.lyasin.mymovies.viewmodel.TopRatedMovieViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class PopularFragment : Fragment() {

    private val vm : TopRatedMovieViewModel by viewModel()
    private val adapter = MoviePagedAdapter()
    private lateinit var v: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.fragment_list, container, false)
        v.rv_list.layoutManager = LinearLayoutManager(context)
        v.rv_list.adapter = adapter
        observeMovieList()

        vm.networkStateLiveData?.observe(this, Observer { network ->
            when{
                network.error != null ->  {
                    Toast.makeText(context, getString(R.string.error_msg), Toast.LENGTH_SHORT).show()
                }
            }
        })
        return v
    }

    private fun observeMovieList(){
        vm.movieList.observe(this,
            Observer<PagedList<Movie>> { items ->
                adapter.submitList(items)
            })
    }
}
