package com.filomenadeveloper.teste_alpha.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.filomenadeveloper.teste_alpha.R
import com.filomenadeveloper.teste_alpha.models.Activities

class ActivitiesAdapter(val type:ArrayList<Activities>): RecyclerView.Adapter<ActivitiesAdapter.ViewHolder>() {

    var context: Context? = null;

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var mType: TextView = itemView.findViewById(R.id.text_type)
            var mMount: TextView = itemView.findViewById(R.id.text_amout)
            var mData: TextView = itemView.findViewById(R.id.text_date)
            var cardView: CardView = itemView.findViewById(R.id.card)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_type, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return type.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var atividades = type[position]
        try {
        if (type[position].transaction_type.equals("DEPOSIT")){
            holder.mType.text = "DEPOSITO"
        }else if (type[position].transaction_type.equals("PAYMENT")){
            holder.mType.text = "PAGAMENTO"
        }else if (type[position].transaction_type.equals("WITHDRAWAL")){
            holder.mType.text = "LEVANTAMENTO"
        }else if (type[position].transaction_type.equals("RECHARGE") || type[position].transaction_type.equals("MOBILE_VOICE_RECHARGE")){
            holder.mType.text = "CARREGAMENTO"
        }
        holder.mData.text = getData(type[position].created_at)
        holder.mMount.text = "KZ ${type[position].amount.toString()}"

        holder.cardView.setOnClickListener {
           DialogDeposit(atividades)
        }
        }catch(e: Exception){

        }

    }

    fun getData(date : String): String{

        val  dateYear =date.substring(0, 4)
        val dateMonth =date.substring(5, 7)
        val dateDay =date.substring(8,10)
        val hour =date.substring(11,13)
        val min =date.substring(14,16)

        val date ="$dateDay/$dateMonth/$dateYear $hour:$min"
        return  date
    }

    fun DialogDeposit(atividade : Activities){
        var mDialogView: View = LayoutInflater.from(context!!).inflate(R.layout.dialogo_transaction, null)
        var builder =
            AlertDialog.Builder(context!!).setView(mDialogView)
        val mAlertDialog = builder.show()
        val texto = mDialogView.findViewById<TextView>(R.id.texto1)
        val texto1 = mDialogView.findViewById<TextView>(R.id.texto2)
        val texto2 = mDialogView.findViewById<TextView>(R.id.texto3)
        val texto3 = mDialogView.findViewById<TextView>(R.id.texto4)
        val texto4 = mDialogView.findViewById<TextView>(R.id.texto5)
        val canelar = mDialogView.findViewById<Button>(R.id.BtnOk)

        if (atividade.transaction_type.equals("DEPOSIT")) {
            texto.text = atividade.payment_method.name
            texto1.text = "IBAN: ${atividade.company_bank_account.iban}"
            texto2.text = atividade.company_bank_account.holder
            texto4.text = atividade.company_bank_account.bank.description
            texto3.text = "KZ ${atividade.amount}"

        }else if (atividade.transaction_type.equals("PAYMENT")) {
            texto.text = "PAGAMENTO"
            texto1.text = "De: ${atividade.to.firstname} ${atividade.to.lastname}"
            texto2.text = "Para: ${atividade.from.firstname} ${atividade.from.lastname}"
            texto3.text = "KZ ${atividade.amount}"
            texto4.text = atividade.description

        }else if (atividade.transaction_type.equals("WITHDRAWAL")) {
            if(atividade.bank_account == null){
                texto.text = "LEVANTAMENTO"
                texto4.text = "KZ ${atividade.amount}"
                texto1.visibility = View.GONE
                texto2.visibility = View.GONE
                texto3.visibility = View.GONE
            }else{
                texto.text = "LEVANTAMENTO"
                texto1.text = atividade.bank_account.bank.name
                texto2.text = atividade.bank_account.type_of
                texto3.text = atividade.bank_account.holder
                texto4.text = "KZ ${atividade.amount}"
            }


        }else if (atividade.transaction_type.equals("RECHARGE") || atividade.transaction_type.equals("MOBILE_VOICE_RECHARGE")) {
            texto.text = "CARREGAMENTO"
            texto1.text ="Numero: ${atividade.phone_number}"
            texto2.text ="Recarga: ${atividade.recharge_code}"
            texto3.text = "Valor da recarga: KZ ${atividade.recharge_price}"
            texto4.text = "Operadora: ${atividade.mobile_operator_name}"

        }
        canelar.setOnClickListener {
                mAlertDialog.dismiss()
        }
    }
}