package com.samba.squareoff.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samba.squareoff.recycler_view.model.ApiResponse
import com.samba.squareoff.recycler_view.model.RvModel
import com.samba.squareoff.repo.MainActivityRepo
import com.samba.squareoff.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivityViewModel: ViewModel() {
    private val repo: MainActivityRepo = MainActivityRepo()

    val fetchedData: MutableLiveData<Resource<List<RvModel>>> = MutableLiveData()

    init {
        fetch()
    }

    private fun fetch() = viewModelScope.launch {
        fetchedData.postValue(Resource.Loading())
        val response = repo.fetch()
        fetchedData.postValue(handleFetchedData(response))
    }

    private fun handleFetchedData(rvModel: Response<ApiResponse>) : Resource<List<RvModel>> {
        if (rvModel.isSuccessful) {
            rvModel.body()?.let { result -> return Resource.Success(result.trns) }
        }
        return Resource.Error(rvModel.message())
    }
}