package com.vjc.imagecompare.view

import android.app.Fragment
import android.content.Intent
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

            _imageInspectorView = it.findViewById<ImageInspectorView>(R.id.imageInspectorView)

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
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"

        this.startActivityForResult(intent, _REQUEST_CODE_IMAGE_GALLERY)
    }

    fun cameraButtonAction() {
        print("cameraButtonAction")
    }

    fun detailsButtonAction() {
        println("detailsButtonAction")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            _REQUEST_CODE_IMAGE_GALLERY -> {
                _imageInspectorView?.bitmapUri = data?.data
            }
        }
    }

    private var _imageInspectorView: ImageInspectorView? = null




}

private const val _REQUEST_CODE_IMAGE_GALLERY = 1