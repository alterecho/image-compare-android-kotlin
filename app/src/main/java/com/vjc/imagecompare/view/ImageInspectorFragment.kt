package com.vjc.imagecompare.view

import android.app.Fragment
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.vjc.imagecompare.R
import java.util.*

class ImageInspectorFragment constructor() : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater?.inflate(R.layout.fragment_image_inspector, container, false)


        view?.let {
            val random = Random();
            it.setBackgroundColor(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)))

            val addButton = it.findViewById<Button>(R.id.addButton)
            addButton.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    addButtonAction()
                }
            })

            val cameraButton = it.findViewById<Button>(R.id.cameraButton)
            cameraButton.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    cameraButtonAction()
                }
            })

            val detailsButton = it.findViewById<Button>(R.id.detailsButton)
            detailsButton.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    detailsButtonAction();
                }
            })


        }


        return view
    }

    fun addButtonAction() {
        println("addButtonAction");
    }

    fun cameraButtonAction() {
        print("cameraButtonAction")
    }

    fun detailsButtonAction() {
        println("detailsButtonAction")
    }

}