package views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.exercise.databinding.HomeActivityBinding
import vm.LoginViewModel


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: HomeActivityBinding
    private val viewModel: LoginViewModel = LoginViewModel()
    //Criando
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonForm.setOnClickListener {
            val email = binding.inputEmailt.text?.toString()
            val password = binding.inputPassword.text?.toString()
            viewModel.login(email, password)
        }

        viewModel.isValid.observe(this) { isValid ->
            if(isValid) navegarActivityBinding() else showMessageError()
        }

    }

    private fun navegarActivityBinding() {
        val intent = Intent(this, AfterLoginActivity::class.java)
        startActivity(intent)
    }

    private fun showMessageError() {
        Toast.makeText(this, "Email ou senha inválidos", Toast.LENGTH_LONG).show()
    }
}