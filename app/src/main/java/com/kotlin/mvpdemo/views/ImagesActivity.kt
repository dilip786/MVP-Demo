package com.kotlin.mvpdemo.views

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.mvc_demo.model.ImageDO
import com.kotlin.mvpdemo.R
import com.kotlin.mvpdemo.adapters.ImagesAdapter
import com.kotlin.mvpdemo.listeners.ImagesPresenterListener
import com.kotlin.mvpdemo.presenters.ImageListPresenter

class ImagesActivity : AppCompatActivity(), ImagesPresenterListener {

    private var rvList: RecyclerView? = null;
    private var listAdapter: ImagesAdapter? = null;
    private var images: ArrayList<ImageDO> = ArrayList()
    private var presenter: ImageListPresenter? = null
    private var tvError: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControls()
    }

    private fun initControls() {

        tvError = findViewById(R.id.tvError)

        // Page Title
        title = "MVP Demo"

        // Initialize Recycler views
        rvList = findViewById(R.id.rvList)
        rvList!!.layoutManager = GridLayoutManager(this, 2)
        rvList!!.addItemDecoration(GridItemDecoration(10, 2))

        // Setup Adapter
        listAdapter = ImagesAdapter(this, images = images);
        rvList!!.adapter = listAdapter;

        // Setup Presenter
        presenter = ImageListPresenter(this, this)
        presenter!!.getImages(
            "13745654-0d7421681193bbdba054b8959",
            "Kids", 100, 1
        )

    }

    override fun onSuccess(images: ArrayList<ImageDO>?) {

        // Update Recycler Images
        rvList!!.visibility = View.VISIBLE
        tvError!!.visibility = View.GONE

        this.images.clear()
        this.images.addAll(images!!)
        listAdapter!!.notifyDataSetChanged()
    }

    override fun onFailure(errorMessage: String?) {

        rvList!!.visibility = View.GONE
        tvError!!.visibility = View.VISIBLE

        tvError!!.text = errorMessage
    }

}
