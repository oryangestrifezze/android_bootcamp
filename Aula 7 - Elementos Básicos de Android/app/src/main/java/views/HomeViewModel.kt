package views
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*
 Viewmodel é apenas uma classe que processa dados e os guarda para serem consumidos pela activity.
 Dentro da activity tem um observer que fica de olho no modelview, e quando os dados sao processados ela
  os pega para ela.
 */
class HomeViewModel : ViewModel() {

    val _showDialog = MutableLiveData<Boolean>()
    fun onButtonClicked() {
        _showDialog.value = true
    }
//
//    val showDialog : LiveData<Boolean>
//        get() {
//            TODO()
//        }
}