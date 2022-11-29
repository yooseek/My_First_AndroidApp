package io.kseek.myandroidapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    private var currentUser = 1
    private var currentPosition = 0
    private var userList : ArrayList<User>? = null

    private var nextBtn : Button? = null
    private var secondMainText : TextView? = null
    private var userOption1: TextView? = null
    private var userOption2: TextView? = null
    private var userOption3: TextView? = null
    private var userOption4: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        userList = Constants.getUsers()
        Log.i("User size is", "${userList?.size}")

        nextBtn = findViewById(R.id.nextUser)
        secondMainText = findViewById(R.id.secondScreen)
        userOption1 = findViewById(R.id.userOption1)
        userOption2 = findViewById(R.id.userOption2)
        userOption3 = findViewById(R.id.userOption3)
        userOption4 = findViewById(R.id.userOption4)

        viewUser()

        userOption1?.setOnClickListener(this)
        userOption2?.setOnClickListener(this)
        userOption3?.setOnClickListener(this)
        userOption4?.setOnClickListener(this)
        nextBtn?.setOnClickListener(this)
    }

    private fun selectedOptionView(user:TextView, selectedOption : Int) {
        defaultOptionView()

        currentPosition = selectedOption

        user.setTextColor(Color.parseColor("#363A43"))
        user.setTypeface(user.typeface,Typeface.BOLD)
        user.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    private fun defaultOptionView() {
        val optionList = ArrayList<TextView>()
        optionList.add(0, userOption1!!)
        optionList.add(1, userOption2!!)
        optionList.add(2, userOption3!!)
        optionList.add(3, userOption4!!)

        for (option in optionList) {
            option.setTextColor(Color.BLUE)
            option.typeface = Typeface.DEFAULT
            option.background = null
        }
    }

    private fun viewUser () {
        defaultOptionView()

        var user : User = userList!![currentUser - 1]

        secondMainText?.text = user.name
        userOption1?.text = user.optionOne
        userOption2?.text = user.optionTwo
        userOption3?.text = user.optionThree
        userOption4?.text = user.optionFour

        if(currentUser ==  userList!!.size){
            nextBtn?.text = "Finish"
        }else {
            nextBtn?.text = "next user"
        }
    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.userOption1 -> {
                userOption1?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.userOption2 -> {
                userOption2?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.userOption3 -> {
                userOption3?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.userOption4 -> {
                userOption4?.let{
                    selectedOptionView(it,4)
                }
            }
            R.id.nextUser -> {
                currentUser++
                when {
                    currentUser <= userList!!.size -> {
                        viewUser()

                        currentPosition = 0
                    }else -> {
                        Toast.makeText(this,"Finish the User!!",Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}