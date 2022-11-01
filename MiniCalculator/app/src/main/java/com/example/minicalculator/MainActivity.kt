package com.example.minicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.minicalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding

    var isNewOp = true
    var oldNumber = ""
    var op ="+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun numberEvent(view: View) {
        if (isNewOp)
            binding.editText.setText("")
        isNewOp = false
      var buclick = binding.editText.text.toString()
      var buselect = view as Button
      when(buselect.id) {
          binding.bu1.id -> {buclick += "1"}
          binding.bu2.id -> {buclick += "2"}
          binding.bu3.id -> {buclick += "3"}
          binding.bu4.id -> {buclick += "4"}
          binding.bu5.id -> {buclick += "5"}
          binding.bu6.id -> {buclick += "6"}
          binding.bu7.id -> {buclick += "7"}
          binding.bu8.id -> {buclick += "8"}
          binding.bu9.id -> {buclick += "9"}
          binding.bu0.id -> {buclick += "0"}
          binding.buDot.id ->{buclick +=  "."}
          binding.buPlusMinus.id -> {buclick =  "-$buclick"}

}




       binding.editText.setText(buclick)
}

    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = binding.editText.text.toString()
        var buselect = view as Button
        when(buselect.id){
            binding.buMultiply.id -> {op = "*"}
            binding.buPlus.id -> {op = "+"}
            binding.buMinus.id -> {op = "-"}
            binding.buDivide.id -> {op = "/"}

        }
    }

    fun equalEvent(view: View) {
        var newnumber = binding.editText.text.toString()
        var result = 0.0
        when(op){
            "+" -> {result = oldNumber.toDouble() + newnumber.toDouble()}
            "*" -> {result = oldNumber.toDouble() * newnumber.toDouble()}
            "/" -> {result = oldNumber.toDouble() / newnumber.toDouble()}
            "-" -> {result = oldNumber.toDouble() - newnumber.toDouble()}

        }
        binding.editText.setText(result.toString())
    }

    fun acEvent(view: View) {
        binding.editText.setText("0")
        isNewOp = true
    }

    fun percentEvent(view: View) {
        var no = binding.editText.text.toString().toDouble()/100
        binding.editText.setText(no.toString())
        isNewOp = true

    }


}
