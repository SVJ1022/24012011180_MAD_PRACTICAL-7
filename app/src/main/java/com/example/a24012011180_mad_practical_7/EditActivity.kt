package com.example.a24012011180_mad_practical_7

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditActivity : AppCompatActivity() {

    lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        db = DatabaseHelper(this)

        val editName = findViewById<EditText>(R.id.editName)
        val editPhone = findViewById<EditText>(R.id.editPhone)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editAddress = findViewById<EditText>(R.id.editAddress)
        val updateButton = findViewById<Button>(R.id.updateButton)

        val personId = intent.getStringExtra("person_id")

        val person = db.getPerson(personId!!)

        if (person != null) {

            editName.setText(person.name)
            editPhone.setText(person.phoneNo)
            editEmail.setText(person.emailId)
            editAddress.setText(person.address)

            updateButton.setOnClickListener {

                val updatedPerson = Person(
                    person.id,
                    editName.text.toString(),
                    editPhone.text.toString(),
                    editEmail.text.toString(),
                    editAddress.text.toString(),
                    person.latitude,
                    person.longitude
                )

                db.updatePerson(updatedPerson)

                finish()
            }
        }
    }
}