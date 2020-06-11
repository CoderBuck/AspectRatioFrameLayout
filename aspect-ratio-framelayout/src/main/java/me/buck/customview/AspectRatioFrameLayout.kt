package me.buck.customview

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * 一个可以指定宽高比的 FrameLayout
 */
class AspectRatioFrameLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var ratio = 1.0F

    init {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.AspectRatioFrameLayout)
        val ratioString = ta.getString(R.styleable.AspectRatioFrameLayout_aspect_ratio) ?: "1:1"
        ta.recycle()
        val split = ratioString.split(":")
        val w = split[0].trim().toFloat()
        val h = split[1].trim().toFloat()
        ratio = w / h
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)

        var wms = widthMeasureSpec
        var hms = heightMeasureSpec
        if (widthMode == MeasureSpec.EXACTLY && heightMode != MeasureSpec.EXACTLY) {
            hms = MeasureSpec.makeMeasureSpec((widthSize / ratio).toInt(), MeasureSpec.EXACTLY)
        } else if (heightMode == MeasureSpec.EXACTLY && widthMode != MeasureSpec.EXACTLY) {
            wms = MeasureSpec.makeMeasureSpec((heightSize * ratio).toInt(), MeasureSpec.EXACTLY)
        }
        super.onMeasure(wms, hms)
    }
}