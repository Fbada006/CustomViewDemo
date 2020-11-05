package com.example.customviewdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class MyCustomView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    //circle and text colors
    private var circleCol = 0
    private var labelCol = 0
    private var radius = 0

    //label text
    private var circleText: String? = null

    //paint for drawing custom view
    private val circlePaint = Paint()

    //get the attributes specified in attrs.xml using the name we included
    private val a = context.theme.obtainStyledAttributes(attrs,
        R.styleable.MyView, 0, 0)

    init {
        try {
            //get the text and colors specified using the names in attrs.xml
            circleText = a.getString(R.styleable.MyView_circleLabel)
            circleCol = a.getInteger(R.styleable.MyView_circleColor, 0)
            labelCol = a.getInteger(R.styleable.MyView_labelColor, 0)
        } finally {
            a.recycle();
        }
    }

    fun setCircleColor(newColor: Int) {
        //update the instance variable
        circleCol = newColor
        //redraw the view
        invalidate()
        requestLayout()
    }

    fun setLabelColor(newColor: Int) {
        //update the instance variable
        labelCol = newColor
        //redraw the view
        invalidate()
        requestLayout()
    }

    fun setLabelText(newLabel: String) {
        //update the instance variable
        circleText = newLabel
        //redraw the view
        invalidate()
        requestLayout()
    }

    override fun onDraw(canvas: Canvas?) {
        //get half of the width and height as we are working with a circle
        val viewWidthHalf = this.measuredWidth / 2
        val viewHeightHalf = this.measuredHeight / 2

        //get the radius as half of the width or height, whichever is smaller
        //subtract ten so that it has some space around it
        radius = if (viewWidthHalf > viewHeightHalf) viewHeightHalf - 10 else viewWidthHalf - 10

        circlePaint.style = Paint.Style.FILL
        circlePaint.isAntiAlias = true

        circlePaint.color = circleCol

        canvas?.drawCircle(viewWidthHalf.toFloat(), viewHeightHalf.toFloat(), radius.toFloat(), circlePaint)

        //set the text color using the color specified
        circlePaint.color = labelCol

        circlePaint.textAlign = Paint.Align.CENTER;
        circlePaint.textSize = 50F

        //draw the text using the string attribute and chosen properties
        canvas?.drawText(circleText.toString(), viewWidthHalf.toFloat(), viewHeightHalf.toFloat(), circlePaint);
    }
}