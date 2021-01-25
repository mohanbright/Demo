package com.app.demoproject.utils

import com.app.demoproject.R
import com.app.demoproject.dataModal.HomeDataModal

object Constants {
    var DATABASE_NAME = "DemoDatabase"
    var DATABASE_VERSION = 3


    fun Products(): List<HomeDataModal> {

        var productList = ArrayList<HomeDataModal>()
        productList.add(HomeDataModal(R.drawable.orange, 100, "Oranges"))
        productList.add(HomeDataModal(R.drawable.mango, 80, "Mango"))
        productList.add(HomeDataModal(R.drawable.juice, 50, "Orange juice"))
        productList.add(HomeDataModal(R.drawable.apple, 50, "Apple"))
        productList.add(HomeDataModal(R.drawable.strawberry, 120, "Strawberry"))

        return productList

    }


}