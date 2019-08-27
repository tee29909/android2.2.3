package buu.informatics.s59160571.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160571.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        binding.apply {
            doneButton.setOnClickListener {
                addNickname(it)
            }
            nicknameText.setOnClickListener {
                updateNickname(it)
            }
        }
    }
    private fun addNickname(view: View) {
        binding.apply {
           nicknameText.text = nicknameEdit.text
           nicknameEdit.visibility = View.GONE
           nicknameText.visibility = View.VISIBLE
           doneButton.visibility = View.GONE
            view.visibility = View.GONE

            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }



    }
    private fun updateNickname (view: View) {


        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
            view.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            nameText.visibility = View.GONE
            nicknameEdit.requestFocus()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(nicknameEdit, 0)
        }





    }
}
