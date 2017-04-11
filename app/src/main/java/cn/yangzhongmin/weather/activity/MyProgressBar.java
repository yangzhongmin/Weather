package cn.yangzhongmin.weather.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/**
 * Created by yzm on 2017/4/10.
 */

public class MyProgressBar extends ProgressBar {

    private int bgStrokeWidth = 44;
    private int barStrokeWidth = 15;
    private int bgColor = Color.GRAY;
    private int barColor = Color.RED;
    private int smallBgColor = Color.WHITE;
    private int progress = 0;
    private int angleOfMoveCircle = 130;    //移动小圆的起始角度。
    private int startAngle = 120;    //弧形进度条的开始角度
    private int endAngle = 60;     //弧形进度条的结束角度
    private Paint mPaintBar = null;     //画Progress Bar的笔
    private Paint mPaintSmallBg = null;     //画弧形小背景的笔
    private Paint mPaintBg = null;      //画弧形背景的笔
    private Paint mPaintCircle = null;  //画弧度开始和结尾圆形弧度的画笔
    private RectF rectBg = null; //画弧形的正方形背景区域的正方形
    private int diameter = 450;  //圆弧直径
    private boolean showSmallBg = true;// 是否显示小背景。
    private boolean showMoveCircle = true;// 是否显示移动的小园。

    public MyProgressBar(Context context) {
        super(context);
    }

    public MyProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        init(canvas);
    }

    private void init(Canvas canvas) {
        //画弧形的正方形区域
        rectBg = new RectF(15, 15, diameter, diameter);

        // 计算弧形的圆心和半径。
        int cx1 = (diameter + 15) / 2;
        int cy1 = (diameter + 15) / 2;
        int arcRadius = (diameter - 15) / 2;

        //ProgressBar结尾和开始画两个圆，实现ProgressBar的圆角。
        //新建画圆角的画笔
        mPaintCircle = new Paint();
        mPaintCircle.setAntiAlias(true);
        mPaintCircle.setColor(bgColor);

        //画开始时的小圆
        canvas.drawCircle(
                (float) (cx1 + arcRadius * Math.cos(startAngle * 3.14 / 180)),
                (float) (cy1 + arcRadius * Math.sin(startAngle * 3.14 / 180)),
                bgStrokeWidth / 2, mPaintCircle);

        //画结束时的小圆
        canvas.drawCircle(
                (float) (cx1 + arcRadius * Math.cos((180 - startAngle) * 3.14 / 180)),
                (float) (cy1 + arcRadius * Math.sin((180 - startAngle) * 3.14 / 180)),
                bgStrokeWidth / 2, mPaintCircle);

        //画弧形背景
        mPaintBg = new Paint();
        mPaintBg.setAntiAlias(true);
        mPaintBg.setStyle(Paint.Style.STROKE);
        mPaintBg.setColor(bgColor);
        mPaintBg.setStrokeMiter(bgStrokeWidth);
        canvas.drawArc(rectBg, startAngle, endAngle, false, mPaintBg);

        // 画弧形小背景。
        if (showSmallBg) {
            mPaintSmallBg = new Paint();
            mPaintSmallBg.setAntiAlias(true);
            mPaintSmallBg.setStyle(Paint.Style.STROKE);
            mPaintSmallBg.setStrokeWidth(barStrokeWidth);
            mPaintSmallBg.setColor(smallBgColor);
            canvas.drawArc(rectBg, startAngle, endAngle, false, mPaintSmallBg);
        }

        //弧形ProgressBar
        mPaintBar = new Paint();
        mPaintBar.setAntiAlias(true);
        mPaintBar.setStyle(Paint.Style.STROKE);
        mPaintBar.setStrokeWidth(barStrokeWidth);
        mPaintBar.setColor(barColor);
        canvas.drawArc(rectBg, startAngle, progress, false, mPaintBar);

        // 随ProgressBar进度移动的圆。
        if (showMoveCircle) {
            mPaintCircle.setColor((barColor));
            canvas.drawCircle(
                    (float) (cx1 + arcRadius * Math.cos(angleOfMoveCircle * 3.14 / 180)),
                    (float) (cy1 + arcRadius * Math.sin(angleOfMoveCircle * 3.14 / 180)),
                    bgStrokeWidth / 2, mPaintCircle);


        }

        invalidate();
    }

    //更新Progress bar的进度
    public void addProgress(int _progress){
        progress += _progress;
        angleOfMoveCircle += _progress;
        if(progress > endAngle){
            progress = 0 ;
            angleOfMoveCircle = startAngle;
        }
        invalidate();
    }


    public int getBgStrokeWidth() {
        return bgStrokeWidth;
    }

    /**
     * 设置弧形背景的画笔宽度。
     */
    public void setBgStrokeWidth(int bgStrokeWidth) {
        this.bgStrokeWidth = bgStrokeWidth;
    }


    public int getBarStrokeWidth() {
        return barStrokeWidth;
    }

    /**
     * 设置弧形ProgressBar的画笔宽度。
     */
    public void setBarStrokeWidth(int barStrokeWidth) {
        this.barStrokeWidth = barStrokeWidth;
    }


    public int getBgColor() {
        return bgColor;
    }

    /**
     * 设置设置弧形背景的颜色
     * @param bgColor
     */
    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }


    public int getBarColor() {
        return barColor;
    }

    /**
     * 设置弧形ProgressBar的颜色
     * @param barColor
     */
    public void setBarColor(int barColor) {
        this.barColor = barColor;
    }


    public int getSmallBgColor() {
        return smallBgColor;
    }

    /**
     * 设置弧形小背景的颜色
     * @param smallBgColor
     */
    public void setSmallBgColor(int smallBgColor) {
        this.smallBgColor = smallBgColor;
    }


    @Override
    public int getProgress() {
        return progress;
    }

    /**
     * 设置进度条的进度
     * @param progress
     */
    @Override
    public void setProgress(int progress) {
        this.progress = progress;
    }


    public int getAngleOfMoveCircle() {
        return angleOfMoveCircle;
    }

    /**
     * 设置移动小圆的位置角度
     * @param angleOfMoveCircle
     */
    public void setAngleOfMoveCircle(int angleOfMoveCircle) {
        this.angleOfMoveCircle = angleOfMoveCircle;
    }


    public int getStartAngle() {
        return startAngle;
    }

    /**
     * 设置弧形进度条的开始角度
     * @param startAngle
     */
    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }


    public int getEndAngle() {
        return endAngle;
    }

    /**
     * 设置弧形进度条的结束角度
     * @param endAngle
     */
    public void setEndAngle(int endAngle) {
        this.endAngle = endAngle;
    }


    public int getDiameter() {
        return diameter;
    }

    /**
     * 设置弧形的直径
     * @param diameter
     */
    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }


    public boolean isShowSmallBg() {
        return showSmallBg;
    }

    /**
     * 设置是否显示小背景
     * @param showSmallBg
     */
    public void setShowSmallBg(boolean showSmallBg) {
        this.showSmallBg = showSmallBg;
    }


    public boolean isShowMoveCircle() {
        return showMoveCircle;
    }

    /**
     * 设置是否显示随进度显示的小圆球
     * @param showMoveCircle
     */
    public void setShowMoveCircle(boolean showMoveCircle) {
        this.showMoveCircle = showMoveCircle;
    }
}
