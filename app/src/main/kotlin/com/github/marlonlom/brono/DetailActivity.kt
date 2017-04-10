package com.github.marlonlom.brono

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.detailImage
import kotlinx.android.synthetic.main.activity_detail.detailTitle
import kotlinx.android.synthetic.main.activity_detail.detail_toolbar

class DetailActivity : AppCompatActivity() {

  companion object {
    val EXTRA_ID = "DetailActivity.Id"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    setSupportActionBar(detail_toolbar)
    if (supportActionBar != null) {
      supportActionBar!!.setDisplayHomeAsUpEnabled(true)
      supportActionBar!!.setHomeButtonEnabled(true)
    }

    val id = intent.getLongExtra(EXTRA_ID, -1)
    val item = getItems().firstOrNull { it.id == id }

    with(item) {
      if (item != null) {
        Picasso.with(this@DetailActivity).load(item.url).into(detailImage)
        detailTitle.text = item.title
      }
    }
  }
}
