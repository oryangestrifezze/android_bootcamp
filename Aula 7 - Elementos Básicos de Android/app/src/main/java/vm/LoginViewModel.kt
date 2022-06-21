package vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    /*
    LiveData é uma classe armazenadora de dados observável. Diferente de um observável comum,
     o LiveData conta com reconhecimento de ciclo de vida, ou seja, ele respeita o ciclo de vida
     de outros componentes do app, como atividades, fragmentos ou serviços.
     */
    private var _isValid: MutableLiveData<Boolean> = MutableLiveData()

    val isValid: LiveData<Boolean>
        get() = _isValid

    fun login(email: String?,password:String? )  {
        val _email = email?.contains("@")?: true
         val _password = password?.contains("123456") ?: true
        var result = _email && _password
        _isValid.value = result
    }

}