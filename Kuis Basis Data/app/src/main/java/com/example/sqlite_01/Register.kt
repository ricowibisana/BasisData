package com.example.sqlite_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Toast
import com.example.sqlite_01.`object`.UserModelClass
import com.example.sqlite_01.model.DatabaseHandler
import kotlinx.android.synthetic.main.activity_register.*
import java.sql.Types.NULL

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        toLogin.setOnClickListener {
            val inte = Intent(this, Login::class.java)
            startActivity(inte)
        }
    }

    fun register(view: View) {
        val regEmail = regist_email!!.text.toString()
        val regPass = regist_pass!!.text.toString()
        val regValPass = regist_val_pass!!.text.toString()
        val databaseHandler: DatabaseHandler = DatabaseHandler(this)
        if(regEmail != "" && regPass != "" && regValPass != ""){
            if (!databaseHandler!!.checkEmail(regEmail.trim())){
                if (regPass == regValPass){
                    var regist = UserModelClass(userId = NULL,
                        userEmail = regEmail.trim(),
                        userPass = regPass.trim())

                    databaseHandler!!.addUser(regist)

                    val inte = Intent(this, Login::class.java)
                    startActivity(inte)
                } else{
                    Toast.makeText(applicationContext,"Validasi password tidak sesuai!", Toast.LENGTH_LONG).show()
                }
            } else{
                Toast.makeText(applicationContext,"Email '$regEmail' sudah terpakai", Toast.LENGTH_LONG).show()
            }
        } else{
            Toast.makeText(applicationContext,"Field tidak boleh ada yang kosong!", Toast.LENGTH_LONG).show()
        }
    }
}
