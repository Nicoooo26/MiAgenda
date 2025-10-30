package com.example.miagenda

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val contactos = mutableListOf<Contacto>(
        Contacto("lucas",689883123),
        Contacto("juan",634823912),
        Contacto("ana",604391822),
        )

    lateinit var rvListadoContactos: RecyclerView
    lateinit var fabAddContact: FloatingActionButton

    lateinit var adapter: ContactosAdapter
    lateinit var btnCheck: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initComponents()
        initUi()
        initListeners()

    }

    private fun initComponents() {
        rvListadoContactos = findViewById(R.id.rvListadoContactos)
        //fabAddContact = findViewById(R.id.fabAddContact)
        btnCheck = findViewById(R.id.btnCheck)
    }

    private fun initUi() {
        this.adapter = ContactosAdapter(contactos)
        rvListadoContactos.layoutManager = LinearLayoutManager(this)
        rvListadoContactos.adapter = this.adapter
    }

    private fun initListeners() {
        /*fabAddContact.setOnClickListener {

        }*/
        btnCheck.setOnClickListener {
            contactos.forEach { cts ->
                if(cts.telefono.toString().length != 9){
                    cts.esCorrecto=true
                }else{
                    cts.esCorrecto=false
                }
            }
            adapter.notifyDataSetChanged()
        }
    }
}