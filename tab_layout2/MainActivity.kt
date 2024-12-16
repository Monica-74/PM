package com.example.tab_layout2


import android.annotation.SuppressLint
import android.app.Activity
import android.content.ClipData.Item
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import androidx.activity.result.ActivityResult
// en java sería class mainActivity extends AppCompatActivity{}
class MainActivity : AppCompatActivity() {

    private lateinit var ventanaDeslizante: ViewPager
    private lateinit var tablayout: TabLayout
    private lateinit var  txtTexto:TextView //


    // private lateinit var  barra:Toolbar


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView((R.layout.activity_main))

//        Obtiene la referencias de los objetos del layout con findViewById
        //con esto solo lo llamamos
        ventanaDeslizante = findViewById(R.id.viewpager)
        tablayout = findViewById(R.id.tablayout)
        txtTexto = findViewById(R.id.txtTextoInformacion)
        //Inicia el controlador de deslizamiento de ventanas
//        que recibe como parametro un objeto llamado supportFragmentManager
//        que es el que gestiona los fragmentos en las actividades
//        se llama asi el objeto supportFragmentManager
//        sería el equivalente en JAva a this.getSupportFragmentManager()

        val controlador = ControladorVentanasDeslizantes(this.supportFragmentManager)

//    agregamos los fragmentos de codigo al controlador
        controlador.addFragment(CorreosFragment(),"Correos")
        controlador.addFragment(ContactosFragment(),"Contactos")

        ventanaDeslizante.adapter = controlador

        tablayout.setupWithViewPager(ventanaDeslizante)
        tablayout.getTabAt(0)?.setIcon(R.drawable.baseline_email_24)
        tablayout.getTabAt(1)?.setIcon(R.drawable.baseline_contacts_24)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { //objeto item que llama desde la que llama a la que llama
        return when (item.itemId){
            R.id.action_settings -> true

            R.id.btnInformacionApp -> {
                lanzarInformacionDe()
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }
    fun lanzarInformacionDe(view: View? = null){ //inicia y lanza la actividad
        val i = Intent(this, InformacionLegalActivity::class.java)
        //startActivity(i)
        resultLauncher.launch(i)
    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result: ActivityResult ->
        val intent = result
        var nombre =result.data?.getStringExtra("Usuario")
        if (result.resultCode == Activity.RESULT_OK) {
            //val intent = result.data para no poner nombre sino solo datos

            txtTexto.setText("El usuario" + nombre+ "ha aceptado los terminos legales")

        }
        else if (result.resultCode == Activity.RESULT_CANCELED){
            txtTexto.setText("El usuario" + nombre+ "ha cancelado los terminos legales")

        }
        else{
            txtTexto.setText("El usuario" + nombre +"ha modifica los terminos legales")
        }



    }


}

class R {
    companion object {
        val id: Any
            get() {
                TODO()
            }
        val layout: Any
    }

}
