package com.samba.squareoff.services

import com.samba.squareoff.recycler_view.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface FollowChessApi {
    @GET("/config.json")
    suspend fun fetch() : Response<ApiResponse>
}