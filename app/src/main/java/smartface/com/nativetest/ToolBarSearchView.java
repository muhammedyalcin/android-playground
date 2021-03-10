package smartface.com.nativetest;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ToolBarSearchView extends AppCompatActivity {

    Menu optionsMenu;
    Button iconifiedByDefaultBtn;
    Button iconified;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.toolbar_searchview);

        Toolbar toolbar =  findViewById(R.id.toolbar_top);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("");


        RelativeLayout rootLayout = (RelativeLayout) findViewById(R.id.rootLayout);

        LinearLayout.LayoutParams params =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
        params.setMargins(0,300,0,0);

        rootLayout.addView(initSearchView() , params);

    }

    public SearchView initSearchView() {

        SearchView mySearchView = new SearchView(this);
        mySearchView.setIconifiedByDefault(false);
        mySearchView.clearFocus();

//        mySearchView.onActionViewExpanded();

        LinearLayout mSearchEditFrame = mySearchView.findViewById(androidx.appcompat.R.id.search_edit_frame);

        AppCompatImageView searchImage =(AppCompatImageView) mSearchEditFrame.getChildAt(0);
        ViewGroup.LayoutParams layoutParams  = searchImage.getLayoutParams();
        mSearchEditFrame.removeViewAt(0);

//        ImageView img = new ImageView(this);
//        img.setLayoutParams(layoutParams);
//        img.setBackgroundColor(Color.YELLOW);

//        FrameLayout frameLayout = new FrameLayout(this);
//        frameLayout.setBackgroundColor(Color.BLACK);
//        FrameLayout.LayoutParams frameLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        frameLayout.setLayoutParams(frameLayoutParams);

//        frameLayout.addView(null);

//        img.setImageDrawable( getResources().getDrawable(R.drawable.com_mixpanel_android_ic_phone));
//        mSearchEditFrame.addView(null,0);

//        searchImage.setImageDrawable(getResources().getDrawable(R.drawable.com_mixpanel_android_ic_phone));

//        Log.i("searchViewTag", "child cound " +  mSearchEditFrame.getChildAt(0) );

        AppCompatImageView closeBtn = (AppCompatImageView) mySearchView.findViewById(R.id.search_close_btn);
        closeBtn.setImageDrawable(getResources().getDrawable(R.drawable.com_mixpanel_android_ic_phone));
//        closeBtn.getDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

        View mUnderLine = (View) mySearchView.findViewById(R.id.search_plate);
        mUnderLine.setBackgroundColor(Color.TRANSPARENT);
        mUnderLine.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);

        AppCompatAutoCompleteTextView mSearchSrcTextview = (AppCompatAutoCompleteTextView) mySearchView.findViewById(R.id.search_src_text);
//        mSearchSrcTextview.setBackgroundColor(Color.LTGRAY);

//        Drawable[] allDrawables = mSearchSrcTextview.getCompoundDrawablesRelative();
//        Rect leftDrawableBounds = getResources().getDrawable(android.R.drawable.btn_star).getBounds();
//
//        Drawable mPasswordToggleDummyDrawable = getResources().getDrawable(R.drawable.com_mixpanel_android_close);
//        mPasswordToggleDummyDrawable.setBounds(0,0,300,0); //Width known!!
//
//        mSearchSrcTextview.setCompoundDrawablesRelative(null,null,mPasswordToggleDummyDrawable,null);
        mSearchSrcTextview.setHint("hheloe");

        TypedArray a = this.obtainStyledAttributes(null, androidx.appcompat.R.styleable.SearchView, androidx.appcompat.R.attr.searchViewStyle,0);
        Drawable mSearchHintIcon = a.getDrawable(androidx.appcompat.R.styleable.SearchView_searchHintIcon);
        a.recycle();

        TypedArray b = this.obtainStyledAttributes(null,R.styleable.MaterialTextBoxEditted, R.attr.gave_text,0 );
        Toast.makeText(this,  " " +"&quot;" + " obtained " + b.getString(R.styleable.MaterialTextBoxEditted_gave_text), Toast.LENGTH_LONG).show();

        final int textSize = (int) (mSearchSrcTextview.getTextSize() * 1.25);
        mSearchHintIcon.setBounds(0, 0, textSize, textSize);

        final SpannableStringBuilder ssb = new SpannableStringBuilder("   ");
        ssb.setSpan(new ImageSpan(mSearchHintIcon), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.append(mSearchSrcTextview.getHint());

        mSearchSrcTextview.setHint(ssb);
//        mSearchSrcTextview.getHint();

//


//        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                Log.i("searchViewTag"," onQueryTextSubmit " + query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });

//        mSearchSrcTextview.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean b) {
//                Log.i("searchViewTag"," onFocusChange ");
////                mySearchView.clearFocus();
//                mUnderLine.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
//            }
//        });

//        AppCompatImageView mSearchButton = mySearchView.findViewById(R.id.search_button);
//        Drawable d = getResources().getDrawable(android.R.drawable.btn_star);
//        mSearchButton.setImageDrawable(d);

//        mSearchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i("searchViewTag"," setOnClickListener ");
//            }
//        });

        return  mySearchView;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        optionsMenu = menu;

        optionsMenu.clear();
        MenuItem item =  optionsMenu.add(0, 7,0,"");
        item.setEnabled(true);

        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
//        SearchView mySearchView = initSearchView();
//        mySearchView.onActionViewExpanded();
//        item.setActionView(mySearchView);
        return true;
    }

}

