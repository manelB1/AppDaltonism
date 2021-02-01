package tads.eaj.ufrn.daltonismo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityRecebe : AppCompatActivity(){

    lateinit var nome: TextView
    lateinit var altura: TextView
    lateinit var botaoVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intentteste)

        nome = findViewById(R.id.nome)
        altura = findViewById(R.id.altura)
        botaoVoltar = findViewById(R.id.botaoVoltar)

        val params:Bundle? = intent.extras
        nome.text = params?.getString("Nome")
        altura.text = params?.getString("Altura")

        botaoVoltar.setOnClickListener {
            val i = Intent()
            i.putExtra("DADO_RESPOSTA", "Deu certo")
            setResult(Activity.RESULT_OK, i)
            finish()
        }

    }
}