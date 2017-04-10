package com.github.marlonlom.brono

fun getItems() = (1..10).map {
  Item(it.toLong(), "Nature image $it", "http://lorempixel.com/400/400/nature/$it/")
}

data class Item(val id: Long, val title: String, var url: String)