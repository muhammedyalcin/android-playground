package smartface.com.nativetest.RecyclerViewSwipe;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import androidx.recyclerview.widget.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

import smartface.com.nativetest.R;

public class SwipeHelper extends ItemTouchHelper.Callback {

    public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
    final static int drawItemWidth = 400;
    Context context;
    SimpleAdapter rAdapter;
    RecyclerView mRecyclerView;
    View myTestView;
    RecyclerView.ViewHolder mPrevDrawnViewHolder = null;
    volatile boolean animationDurationOver = false;
    private boolean isSwipeClick = false;

    public SwipeHelper(Context parentContext, RecyclerView recyclerView) {
        super();
        this.context = parentContext;

        myTestView = LayoutInflater.from(parentContext).inflate(R.layout.bitmaptest, null);
    }

    public void setAdapater(RecyclerView.Adapter adapter) {
        this.rAdapter = (SimpleAdapter) adapter;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
    }


    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//        String[] dataset = rAdapter.dataset;
//        rAdapter.setDataSet(new String[dataset.length -1]);
//        rAdapter.notifyItemRangeRemoved(0, 2);
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
    }

    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    @Override
    public boolean canDropOver(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder current, @NonNull RecyclerView.ViewHolder target) {
        return true;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
//        rAdapter.notifyItemMoved(viewHolder.getAdapterPosition(), viewHolder1.getAdapterPosition());
        return false;
    }

    @Override
    public void onMoved(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int fromPos, @NonNull RecyclerView.ViewHolder target, int toPos, int x, int y) {
        super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y);
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        isSwipeClick = false;
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

        if (actionState == ItemTouchHelper.ACTION_STATE_DRAG)
            return;

        Log.d("ITEMDRAWCALLBACK","onChildDraw" + " dX " + dX + " dY  " + dY);
//        if(animationDurationOver){
////            c.save();
////            c.rotate(180);
////            c.drawColor(Color.RED);
////            c.translate(0f,0f);
////            c.save();
//            drawARectColor(c, viewHolder, 50,50);
//            animationDurationOver = false;
//        }else  {

        // Optimize by just drawing in bounds

        if (dX < 0) {
            drawARectColor(c, viewHolder, 0);
            isSwipeClick = true;
        } else if (dX > 0) {
            drawARectColor(c, viewHolder, 1);
            isSwipeClick = true;
        } else if(isSwipeClick) {
            //Clear the canvas here.  THIS WILL CLEAR ITSELF.!!
            isSwipeClick = false;
        }
//        }
//        recyclerView.requestLayout();
//        recyclerView.invalidate();
//        viewHolder.itemView.setTranslationX(dX);
        mPrevDrawnViewHolder = viewHolder;
    }

    @Override
    public long getAnimationDuration(@NonNull RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
        long animDuration = super.getAnimationDuration(recyclerView, animationType, animateDx, animateDy);

        if (ItemTouchHelper.ANIMATION_TYPE_SWIPE_SUCCESS == animationType) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    animationDurationOver = true;
                }
            }, animDuration);
        }

        return animDuration;
    }

    @Override
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return .5f;
    }

    public void drawARectColor(Canvas c, RecyclerView.ViewHolder viewHolder, int direction) {
        View myView = viewHolder.itemView;

        // To draw the rount rect, use this.
//        Path path = new Path();
//        path.addRoundRect(rectF, new float[]{15,15,15,15,15,15,15,15}, Path.Direction.CCW);
//        c.drawPath(path, p);

        AssetManager assetManager = context.getAssets();
        InputStream inputStream;
        Bitmap bitmap = null;
        try {
            inputStream = assetManager.open("accountimg36.png");
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(direction == 0)
            drawIconWithText(c, myView, bitmap, 20, Typeface.DEFAULT_BOLD, Color.YELLOW, Color.RED, "RIGHTTEST", direction);
        else
            drawIconWithText(c, myView, bitmap, 20, Typeface.DEFAULT_BOLD, Color.YELLOW, Color.RED, "LEFTTEST", direction);
//        drawWithText(c, myView, 60, Typeface.DEFAULT_BOLD, Color.BLUE, Color.RED, "HELLO", direction);
    }

    /* What if just image given ? Convert  the color to Color object */
    public void drawIconWithText(Canvas c, View view, Bitmap bitmap, int textSize, Typeface typeface, int bgColor, int textColor, String text, int direction) {
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(bgColor);

        //Draw rect with round area
        RectF rectF = new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        c.drawRect(rectF, p);

        Paint textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(textColor);
        textPaint.setTextSize(!text.isEmpty() ? textSize : 0); //Convert to dp AND be sure text is given
        textPaint.setTypeface(typeface);

        float rightSpace = (context.getResources().getDisplayMetrics().density * 16);
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int vRight = view.getRight();
        int vTop = view.getTop();
        int vLeft = view.getLeft();
        float totalHeight = height + textPaint.getTextSize();
        float halfTotalHeight = totalHeight / 2;
        int halfViewHeight = view.getHeight() / 2;
        float wText = textPaint.measureText(text);  //Width of the given text
        float halfWidthText = wText / 2;
        int centerToText = wText > 0 ? width / 2 : 0; //if there no text given then ignore the half of width. The purpose is to give exact center position

        float bitmapStart = direction == 0 ?
                vRight - width - rightSpace - halfWidthText + centerToText :
                vLeft + width + rightSpace + halfWidthText - centerToText;
        float bitmapEnd = direction == 0 ?
                vRight - rightSpace - halfWidthText + centerToText :
                vLeft + rightSpace + halfWidthText - centerToText;
        float textStart = direction == 0 ? vRight - wText - rightSpace : vLeft + rightSpace;

        RectF totalF = new RectF(
                vRight - totalHeight,
                vTop + halfViewHeight - halfTotalHeight,
                vRight,
                vTop + halfViewHeight - halfTotalHeight + totalHeight);

        RectF bitmapRectF = new RectF(
                bitmapStart,
                totalF.top,
                bitmapEnd,
                totalF.top + height);

        c.drawText(text,
                textStart,
                totalF.bottom, textPaint);

        c.drawBitmap(bitmap, null, bitmapRectF, textPaint);
//        c.drawRect(bitmapRectF, textPaint);

    }
//    public void drawLeftWithIcon(Canvas c, View view, Bitmap bitmap, int textSize, Typeface typeface, int bgColor, int textColor, String text){
//
//        Paint p = new Paint();
//        p.setAntiAlias(true);
//        p.setColor(bgColor);
//
//        //Draw rect with round area
//        RectF rectF = new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
//        c.drawRect(rectF, p);
//
//        Paint textPaint = new Paint();
//        textPaint.setAntiAlias(true);
//        textPaint.setColor(textColor);
//        textPaint.setTextSize(!text.isEmpty() ? textSize : 0); //Convert to dp AND be sure text is given
//        textPaint.setTypeface(typeface);
//
//        float rightSpace = (context.getResources().getDisplayMetrics().density * 16);
//        int height = bitmap.getHeight();
//        int width = bitmap.getWidth();
//        int vRight = view.getRight();
//        int vLeft = view.getLeft();
//        int vTop = view.getTop();
//        float totalHeight = height + textPaint.getTextSize();
//        float halfTotalHeight = totalHeight / 2;
//        int halfViewHeight = view.getHeight() / 2;
//        float wText = textPaint.measureText(text);  //Width of the given text
//        float halfWidthText = wText / 2;
//        int centerToText =  wText > 0 ? width / 2 : 0; //if there no text given then ignore the half of width. The purpose is to give exact center position
//
//
//        RectF totalF = new RectF(
//                vRight - totalHeight,
//                vTop + halfViewHeight - halfTotalHeight,
//                vRight,
//                vTop + halfViewHeight - halfTotalHeight + totalHeight);
//
//        RectF bitmapRectF = new RectF(
//                vLeft + width + rightSpace  + halfWidthText - centerToText,
//                totalF.top,
//                vLeft + rightSpace  + halfWidthText - centerToText,
//                totalF.top + height);
//
//        c.drawText(text,
//                vLeft + rightSpace,
//                totalF.bottom, textPaint);
//
//        c.drawBitmap(bitmap, null, bitmapRectF, textPaint);
//
//    }


    //Convert  the color to Color object
    public void drawWithText(Canvas c, View view, int textSize, Typeface typeface, int bgColor, int textColor, String text, int direction) {
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(bgColor);

        //Draw rect with round area
        RectF rectF = new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        c.drawRect(rectF, p);

        Paint textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize); //Convert to dp
        textPaint.setTypeface(typeface);

        float rightSpace = (context.getResources().getDisplayMetrics().density * 16);

        int vRight = view.getRight();
        int vLeft = view.getLeft();
        int halfViewHeight = view.getHeight() / 2;
        float wText = textPaint.measureText(text);  //Width of the given text
        float halfHeightText = textPaint.getTextSize() / 2;
        float textStart = direction == 0 ? vRight - wText - rightSpace : vLeft + rightSpace;

        c.drawText(text,
                textStart,
                view.getTop() + halfViewHeight + halfHeightText,
                textPaint);
    }

    //Convert  the color to Color object
//    public void drawWithTextLEFT(Canvas c, View view, int textSize, Typeface typeface, int bgColor, int textColor, String text) {
//        Paint p = new Paint();
//        p.setAntiAlias(true);
//        p.setColor(bgColor);
//
//        //Draw rect with round area
//        RectF rectF = new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
//        c.drawRect(rectF, p);
//
//        Paint textPaint = new Paint();
//        textPaint.setAntiAlias(true);
//        textPaint.setColor(textColor);
//        textPaint.setTextSize(textSize); //Convert to dp
//        textPaint.setTypeface(typeface);
//
//        float rightSpace = (context.getResources().getDisplayMetrics().density * 16);
//
//        int vRight = view.getRight();
//        int vLeft = view.getLeft();
//        int halfViewHeight = view.getHeight() / 2;
//        float wText = textPaint.measureText(text);  //Width of the given text
//
//        float halfHeightText = textPaint.getTextSize() / 2;
//
//        c.drawText(text,
//                vLeft + rightSpace,
//                view.getTop() + halfViewHeight + halfHeightText,
//                textPaint);
//    }
}


/*
Code for copying the view as bitmap and drawing it.
myTestView.layout(0, 0, (int)rectF.width(), (int) rectF.height());
int widthSpec = View.MeasureSpec.makeMeasureSpec((int) rectF.width(), View.MeasureSpec.EXACTLY);
int heightSpec = View.MeasureSpec.makeMeasureSpec(((int) rectF.height()), View.MeasureSpec.EXACTLY);
myTestView.measure((int)rectF.width(), (int) rectF.height());
c.translate(rectF.left, rectF.top);
myTestView.draw(c);
*/
