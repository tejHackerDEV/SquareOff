package com.samba.squareoff.repo

import com.samba.squareoff.services.RetrofitInstance

class MainActivityRepo {

    suspend fun fetch() = RetrofitInstance.api.fetch()
}