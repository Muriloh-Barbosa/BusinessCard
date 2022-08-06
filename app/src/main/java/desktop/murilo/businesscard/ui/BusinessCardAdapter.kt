package desktop.murilo.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import desktop.murilo.businesscard.data.BusinessCard
import desktop.murilo.businesscard.databinding.ItemBusinessCardBinding
import java.lang.Boolean

class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()){

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind (item: BusinessCard){
            binding.tvNome.text = item.nome
            binding.tvTelefone.text = item.telefone
            binding.tvEmail.text = item.email
            binding.nomeEmpresa.text = item.empresa
            binding.cdContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.cdContent.setOnClickListener{
                listenerShare(it)
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard): kotlin.Boolean {
        return oldItem.id == newItem.id &&
                oldItem.nome == newItem.nome &&
                oldItem.email == newItem.email &&
                oldItem.empresa == newItem.empresa &&
                oldItem.fundoPersonalizado == newItem.fundoPersonalizado
    }

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard): kotlin.Boolean {
        return oldItem.id == newItem.id &&
                oldItem.nome == newItem.nome &&
                oldItem.email == newItem.email &&
                oldItem.empresa == newItem.empresa &&
                oldItem.fundoPersonalizado == newItem.fundoPersonalizado
    }

}