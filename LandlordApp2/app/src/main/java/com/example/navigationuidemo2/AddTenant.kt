package com.example.navigationuidemo2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.navigationuidemo2.databinding.AddtenantActivityBinding

class AddTenant : AppCompatActivity() {
    private lateinit var binding: AddtenantActivityBinding
    private val viewModel: TenantViewModel by viewModels(
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding = DataBindingUtil.setContentView(this, R.layout.addtenant_activity)
            binding.lifecycleOwner = this
            binding.viewModel = viewModel
            val fullName = binding.fullName
            val unitNumber = binding.unitNumber
            val fullRent = binding.fullRent

            binding.button.setOnClickListener{
                val name = fullName.text.toString()
                val unit = unitNumber.text.toString()
                val rent = fullRent.text.toString()
                viewModel.addTenant(name, unit, rent)
                fullName.text.clear()
                unitNumber.txt.clear()
                fullRent.text.clear()
            }

            binding.btnBack.setOnClickListener{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        enableEdgeToEdge()
        setContentView(R.layout.addtenant_activity)
        Log.d("LIFECYCLE", "AddTenantActivity - onCreate")


        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            val totalTenants = 1
            val totalRent = 5000

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("TotalTenants",totalTenants)
            intent.putExtra("TotalRent", totalRent)
            startActivity(intent)
        }


        val tvDisplayTenantInfo = findViewById<TextView>(R.id.tvAddTenantInfo)
        val btnAddTenant = findViewById<Button>(R.id.button)
        val fullName = findViewById<EditText>(R.id.fullName)
        val unitNumber = findViewById<EditText>(R.id.unitNumber)
        val fullRent = findViewById<EditText>(R.id.fullRent)

        btnAddTenant.setOnClickListener {

            val etFullName = fullName.text.toString()
            val etUnitNumber = unitNumber.text.toString()
            val etFullRent = fullRent.text.toString()

            val tenantInfo = "Name: $etFullName\nUnit: $etUnitNumber\nRent: $etFullRent\n\n"
            tvDisplayTenantInfo.append(tenantInfo)
        }




    }
    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE", "SecondActivity - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE", "SecondActivity - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE", "SecondActivity - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE", "SecondActivity - onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LIFECYCLE", "SecondActivity - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE", "SecondActivity - onDestroy")
    }
}