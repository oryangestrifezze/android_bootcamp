package vm

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import model.ActivityModel

class ActivityDetailViewModel(private val datasource: StartViewModel)  : ViewModel(){

    fun getActivityForId(id: Int) : ActivityModel? {
        return datasource.getActivityForId(id)
    }
}