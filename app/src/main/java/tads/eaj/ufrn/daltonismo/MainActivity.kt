package tads.eaj.ufrn.daltonismo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.daltonismo.databinding.ActivityMainBinding
import tads.eaj.ufrn.daltonismo.models.Daltonismo

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var testeDaltonismo = Daltonismo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.daltonismo = testeDaltonismo

        binding.apply {

            val intent = Intent(this@MainActivity, TesteActivity::class.java)
            val param = Bundle()
            teste1.setOnClickListener {
                param.putInt("teste", 1)
                intent.putExtras(param)
                startActivityForResult(intent, 1)
            }
            teste2.setOnClickListener {
                param.putInt("teste", 2)
                intent.putExtras(param)
                startActivityForResult(intent, 2)
            }
            teste3.setOnClickListener {
                param.putInt("teste", 3)
                intent.putExtras(param)
                startActivityForResult(intent, 3)
            }

            verificar.setOnClickListener {
                if( testeDaltonismo.resposta1 == "" ||
                    testeDaltonismo.resposta2 == "" ||
                    testeDaltonismo.resposta3 == "" )
                {
                    Toast.makeText(this@MainActivity, "Preencha todas as respostas", Toast.LENGTH_SHORT).show()
                } else {
                    if(testeDaltonismo.resposta1 == "29" &&
                       testeDaltonismo.resposta2 == "74" &&
                       testeDaltonismo.resposta3 == "2" )
                    {
                        resultado.text = "Sem sintomas"
                        invalidateAll()
                    }
                    else {
                        resultado.text = "Daltonismo"
                        invalidateAll()
                    }
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        binding.apply {
            when(requestCode) {
                1 -> {
                    testeDaltonismo.resposta1 = data?.getStringExtra("resposta").toString()
                    resposta1.text = data?.getStringExtra("resposta").toString()
                    invalidateAll()
                }
                2 -> {
                    testeDaltonismo.resposta2 = data?.getStringExtra("resposta").toString()
                    resposta2.text = data?.getStringExtra("resposta").toString()
                    invalidateAll()
                }
                3 -> {
                    testeDaltonismo.resposta3 = data?.getStringExtra("resposta").toString()
                    resposta3.text = data?.getStringExtra("resposta").toString()
                    invalidateAll()
                }
            }
        }
    }
}