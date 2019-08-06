package sg.edu.rp.webservices.demogetmyage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGetAge.setOnClickListener {
            val userDOB = editTextDOB.text.toString()
            if (userDOB.isNotEmpty()){
                val year = Calendar.getInstance().get(Calendar.YEAR)
                val age = year - userDOB.toInt()
                var output = ""
                when (age){
                    in 0..17 -> output = "Underage"
                    in 18..65 -> output = "Young people"
                    in 66..79 -> output = "Middle-aged"
                    in 80..99 -> output = "Elderly"
                    else -> {
                        output = "Long-lived elderly"
                    }
                }
                textViewShowAge.text = "Your age is $age\n $output"
            } else {
                Toast.makeText(this, "Please enter your birth year", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
