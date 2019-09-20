package com.example.doel.firstkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewTranlationY = textView_progress.translationY

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                textView_progress.text = progress.toString()

                val translationDistance = (initialTextViewTranlationY +
                        progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                textView_progress.animate().translationY(translationDistance)
                if (!fromUser)
                    textView_progress.animate().setDuration(500).rotation(360f)
                        .translationY(initialTextViewTranlationY)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        button_reset.setOnClickListener { v ->
            seekBar.progress = 0


        }
    }
}
