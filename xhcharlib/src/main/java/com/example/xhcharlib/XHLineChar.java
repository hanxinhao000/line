package com.example.xhcharlib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import java.util.ArrayList;
import java.util.List;

/**
 * 图标控件  XINHAO_HAN
 */

public class XHLineChar extends View {

    private Context context;

    //最大值
    private float max = 0;

    //最小值
    private float min = 0;
    //控件高度
    private int viewH = 0;

    //控件宽度

    private int viewW = 0;

    private List<XHData> list;

    private Paint paint;

    //宽的每等份
    private float midW = 0;

    //高的每等分
    private float midH = 0;

    //横向为60各等分
    private float lineW = (50 + 100);

    //滚动器
    private Scroller scroller;

    //保存点的分布
    private ArrayList<DrawData> arrayLis;
    private float move = 30000;
    private float moveL;
    private float moveR;

    public XHLineChar(Context context) {
        super(context);
        initView(context);
    }

    public XHLineChar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public XHLineChar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 开始初始化
     */

    private void initView(Context context) {
        this.context = context;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(30);
        arrayLis = new ArrayList<>();
        scroller = new Scroller(context);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewH = h;
        viewW = w;
        Log.e("每等份的值", "h" + h);
        maxNum();
    }


    //获取最高抵值

    public void setMaxTable(float max) {
        this.max = max;
        startDraw();
    }

    //获取最低值

    public void setMinTable(float min) {
        this.min = min;
        startDraw();

    }


    private void startDraw() {


        if (max != 0 && min != 0)
            invalidate();

    }

    //计算等分值

    private void maxNum() {

        midH = (viewH - 200) / (max - min);

        if (midH < 0) {
            midH *= -1;
        }

       // Log.e("每等份的值", "maxNum: " + midH + "  viewH:" + viewH);

        maxDian();
    }

    //闯入数据集合
    public void setDataArray(List<XHData> list) {

        this.list = list;


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        paint.setColor(Color.parseColor("#adadad"));


        //画竖线
        canvas.drawLine((120), 100, (120), viewH - 100, paint);
        //画横线
        canvas.drawLine((120), viewH - 100, viewW, viewH - 100, paint);

        drawD(canvas);

        drawLine(canvas);

        drawCR(canvas);

        drawHLLine(canvas);
        paint.setColor(Color.parseColor("#adadad"));
        canvas.drawText("" + max, 50, 100, paint);
        canvas.drawText("" + min, 50, viewH - 100, paint);


    }

    private void drawHLLine(Canvas canvas) {

        if (hLine != 0 && lLine != 0) {
            paint.setColor(Color.parseColor("#ad0015"));
            canvas.drawLine(120, (max - hLine) * midH + 100, viewW, (max - hLine) * midH + 100, paint);
            //(((max - list.get(i).getData())) * midH) + 100

            canvas.drawLine(120, ((max - lLine) * midH) + 100, viewW, ((max - lLine) * midH) + 100, paint);

            //画字

            canvas.drawText(hLine + "", 50, (max - hLine) * midH + 100, paint);
            canvas.drawText(lLine + "", 50, (max - lLine) * midH + 100, paint);
        }

    }


    //计算点的位置

    private void maxDian() {

        for (int i = 0; i < list.size(); i++) {

            DrawData drawData = new DrawData();

            drawData.setDianX(lineW);

            drawData.setDianY((((max - list.get(i).getData())) * midH) + 100);

            drawData.setDate(list.get(i).getDate());

            drawData.setColor(list.get(i).getColor());
            arrayLis.add(drawData);
            lineW += 150;
        }


        invalidate();

    }

    //画点
    private void drawD(Canvas canvas) {

        boolean dataUser = list.get(0).isDataUser();
        if (dataUser) {


            for (int i = 0; i < arrayLis.size(); i++) {
                paint.setColor(arrayLis.get(i).getColor());

                canvas.drawCircle(arrayLis.get(i).getDianX(), arrayLis.get(i).getDianY(), 5, paint);

                //画底部Text

                paint.setColor(Color.parseColor("#adadad"));
                paint.setTextSize(25);
                canvas.drawText(arrayLis.get(i).getDate(), arrayLis.get(i).getDianX(), viewH, paint);

            }

        } else {
            for (int i = 0; i < list.size(); i++) {
                canvas.drawCircle(list.get(i).getX(), list.get(i).getY(), 5, paint);

            }
        }


    }

    //开始－ ＋数值
    private float updateData(float num) {

        for (int i = 0; i < arrayLis.size(); i++) {

            //arrayLis.get(i).setDianY(arrayLis.get(i).getDianY() + num);
            move = arrayLis.get(i).getDianX() + num;

            arrayLis.get(i).setDianX(move);
        }

        return move;
    }

    private float hLine = 0;

    private float lLine = 0;

    //高底线
    public void setLineHOrLineW(float hLine, float lLine) {

        this.hLine = hLine;
        this.lLine = lLine;

        invalidate();

    }

    //画方块
    private void drawCR(Canvas canvas) {


        paint.setColor(Color.parseColor("#fAfAfA"));
        canvas.drawRect(0, 0, 118, viewH, paint);

    }


    private int startX = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                startX = (int) event.getX();

                break;

            case MotionEvent.ACTION_UP:

                if (move > moveL) {
                    moveLine((int) move, (int) moveL);
                }

                break;
            case MotionEvent.ACTION_MOVE:
                int endY = (int) event.getX();
                int mid = endY - startX;

                float scaleX = getScrollX();


                //右边界
                moveR = lineW - (lineW - viewW) - 90;
                //左边界
                moveL = lineW;

                if (move + mid < moveR) {
                    return true;

                }
                //防止右边越界
              /*  if (move > moveR || mid > 0) {
                    updateData(mid);
                }
*/

                //防止左边越界

                if ((move + 150) < moveL || mid < 0) {
                    if ((move + 140) + mid > moveL && move != 30000)
                        return true;
                    updateData(mid);


                }




               /* if(move <(lineW - (lineW - viewW)) && mid < 0){
                    updateData(mid);
                }*/

               // Log.e("触摸数据:", "move: " + move + " : lineW : " + lineW + ": (lineW - (lineW - viewW)) :" + (lineW - (lineW - viewW)) + " : mid :" + mid + ":(move > moveL):" + (moveL - move));


                startX = endY;
                invalidate();
                break;

        }
        return true;
    }


    //还原线

    private void moveLine(int startLine, int endLine) {

        scroller.startScroll(startLine, 0, endLine - startLine, 0, 300);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();

        if (scroller.computeScrollOffset()) {


           // Log.e("数据看法", "computeScroll: " + scroller.getCurrX());
        }

        invalidate();
    }


    //画线
    private void drawLine(Canvas canvas) {

        //画线
        boolean dataUser = list.get(0).isDataUser();
        if (dataUser) {


            for (int i = 0; i < arrayLis.size(); i++) {

                canvas.drawLine(arrayLis.get(i).getDianX(), arrayLis.get(i).getDianY(), arrayLis.size() - 1 == i ? arrayLis.get(i).getDianX() : arrayLis.get(i + 1).getDianX(), arrayLis.size() - 1 == i ? arrayLis.get(i).getDianY() : arrayLis.get(i + 1).getDianY(), paint);


                //画线


            }

        } else {
            for (int i = 0; i < list.size(); i++) {
                canvas.drawCircle(list.get(i).getX(), list.get(i).getY(), 5, paint);

            }
        }


    }
}
