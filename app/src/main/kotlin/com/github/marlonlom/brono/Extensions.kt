package com.github.marlonlom.brono

import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(layoutRes: Int): View {
  return LayoutInflater.from(this.context).inflate(layoutRes, this, false)
}

fun View.makeSnackbar(text: String, duration: Int = Snackbar.LENGTH_SHORT) {
  Snackbar.make(this, text, duration).show()
}

fun MainActivity.navigateToDetails(itemId: Long) {
  val intent = Intent(this, DetailActivity.javaClass)
  intent.putExtra(DetailActivity.EXTRA_ID, itemId)
  startActivity(intent)
}