package pe.edu.upc.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btYes: Button
    private lateinit var btNo: Button
    private lateinit var btNext: Button

    lateinit var tvQuestion: TextView
    var index = 0

    private lateinit var questions: ArrayList<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initListeners()
        loadQuestions()
        showQuestion()
    }




    private fun loadQuestions() {
        questions = ArrayList()
        questions.add(Question("¿Es Lima la capital de Perú?", true))
        questions.add(Question("¿Es Buenos Aires una ciudad de Ecuador?", false))
        questions.add(Question("¿Es Caracas la capital de Venezuela?", true))
    }

    private fun initListeners() {
        btYes.setOnClickListener {
            checkAnswer(true)
        }

        btNo.setOnClickListener {
            checkAnswer(false)
        }

        btNext.setOnClickListener {
            index += 1
            showQuestion()
        }
    }

    private fun checkAnswer(answer: Boolean) {
         if (answer == questions[index].answer){
             Toast.makeText(this, "Es correcto", Toast.LENGTH_SHORT).show()
         } else {
             Toast.makeText(this, "Es incorrecto", Toast.LENGTH_SHORT).show()
         }
    }

    private fun showQuestion() {
        tvQuestion.text = questions[index].sentence
    }

    private fun initViews() {
        btYes = findViewById(R.id.btYes)
        btNo = findViewById(R.id.btNo)
        btNext = findViewById(R.id.btNext)
        tvQuestion = findViewById(R.id.tvQuestion)
    }
}