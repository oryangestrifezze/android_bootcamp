package views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.exercise.databinding.AfterLoginActivityBinding


class AfterLoginActivity : AppCompatActivity() {

    private lateinit var binding: AfterLoginActivityBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = AfterLoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityViewBinding.text = "Login Efetuado com sucesso :)"

        binding.buttonViewBiding.setOnClickListener {
            navegarActivityMain()
        }
    }

    private fun navegarActivityMain() = finish()

}
