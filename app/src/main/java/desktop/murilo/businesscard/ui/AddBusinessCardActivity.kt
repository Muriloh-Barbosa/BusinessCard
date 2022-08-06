package desktop.murilo.businesscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import desktop.murilo.businesscard.App
import desktop.murilo.businesscard.R
import desktop.murilo.businesscard.data.BusinessCard
import desktop.murilo.businesscard.databinding.ActivityAddBusinessCardBinding


class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy  { ActivityAddBusinessCardBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnConfirme.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.titleNome.editText?.text.toString(),
                telefone = binding.titleTelefone.editText?.text.toString(),
                email = binding.titleEmail.editText?.text.toString(),
                empresa = binding.titleEmpresa.editText?.text.toString(),
                fundoPersonalizado = binding.titleCor.editText?.text.toString()

            )
            mainViewModel.insert(businessCard)
            Toast.makeText( this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}