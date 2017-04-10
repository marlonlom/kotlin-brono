package com.github.marlonlom.brono

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView.LayoutManager
import kotlinx.android.synthetic.main.activity_main.home_toolbar
import kotlinx.android.synthetic.main.activity_main.recyclerView_items

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    setSupportActionBar(home_toolbar)

    val activity = this

    recyclerView_items.layoutManager = LinearLayoutManager(this) as LayoutManager
    recyclerView_items.adapter = ItemAdapter(getItems(), { item ->
      recyclerView_items.makeSnackbar("Clicked image: " + item.title)
      val intent = Intent(this, DetailActivity::class.java)
      intent.putExtra(DetailActivity.EXTRA_ID, item.id)
      startActivity(intent)
    })
    recyclerView_items.setHasFixedSize(true)
    recyclerView_items.addItemDecoration(
        DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
  }
}
