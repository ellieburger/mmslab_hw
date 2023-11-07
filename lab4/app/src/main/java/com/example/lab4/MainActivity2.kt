package com.example.lab4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //將變數與 XML 元件綁定
        val send = findViewById<Button>(R.id.send)
        val input_drink = findViewById<EditText>(R.id.input_drink)
        val btn_sugar = findViewById<RadioGroup>(R.id.btn_sugar)
        val btn_ice = findViewById<RadioGroup>(R.id.btn_ice)
        send.setOnClickListener {
            if (input_drink.length() < 1)
                Toast.makeText(this, "請輸入飲料名稱",
                    Toast.LENGTH_SHORT).show()
            else {
                //宣告 Bundle
                val b = Bundle()
                //取得 EditText 字串內容，把飲料名稱、甜度與冰塊資訊放入 Bundle
                b.putString("drink", input_drink.text.toString())
                b.putString("sugar", btn_sugar.findViewById<RadioButton>
                    (btn_sugar.checkedRadioButtonId).text.toString())
                b.putString("ice", btn_ice.findViewById<RadioButton>
                    (btn_ice.checkedRadioButtonId).text.toString())
                //用 Activity.RESULT_OK 標記執行狀態並記錄 Intent
                setResult(Activity.RESULT_OK, Intent().putExtras(b))
                finish()
            }
        }
    }
}