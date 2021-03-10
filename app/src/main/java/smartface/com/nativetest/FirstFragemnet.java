package smartface.com.nativetest;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;
import androidx.transition.TransitionInflater;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.FileProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import smartface.com.nativetest.SnapAlignment.GridviewHolderAdapter;

/**
 * Created by smartface on 15.08.2018.
 */

public class FirstFragemnet  extends Fragment{

        private RecyclerView mRecyclerView;
        private RecyclerView.Adapter mAdapter;
        public static StaggeredGridLayoutManager mLayoutManager;
        static boolean  scrollEnable = false;
        String[] myDataset = new String[50];
        FirstFragemnet self;
    // The onCreateView method is called when Fragment should create its View object hierarchy,
        // either dynamically or via XML layout inflation.
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
                setHasOptionsMenu(true);


// `

                 self = this;

                 if(FragmentOnDestroyTest.rootViewFragments == null) {

                 FragmentOnDestroyTest.rootViewFragments = (ViewGroup) inflater.inflate(R.layout.textviewsize_animate, null);

                 Context context = this.getContext();

                 ViewGroup view = FragmentOnDestroyTest.rootViewFragments.findViewById(R.id.page_layout);

                 RelativeLayout myRelativLayout = new RelativeLayout(context);
                 myRelativLayout.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                 SwipeRefreshLayout swipeRefreshLayout = new SwipeRefreshLayout(context);

                 ContextThemeWrapper themeWrapper = new ContextThemeWrapper(context, R.style.ScrollBarRecyclerView);

                 final RecyclerView constRecyclerview = mRecyclerView;
                 RecyclerView mRecyclerView = new RecyclerView(themeWrapper){
                     @Override
                     protected void onAttachedToWindow() {
                         super.onAttachedToWindow();
                         mLayoutManager.onRestoreInstanceState(FragmentOnDestroyTest.restoreInstance);
                     }
                 };

                 mRecyclerView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                 mRecyclerView.setHasFixedSize(true);
                 mRecyclerView.setDrawingCacheEnabled(true);
                 mRecyclerView.setClipToPadding(false);


                 mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

                 Parcelable parcelable = mLayoutManager.onSaveInstanceState();
                 mLayoutManager.onRestoreInstanceState(parcelable);

                 mRecyclerView.setLayoutManager(mLayoutManager);

                 for (int i = 0; i < myDataset.length; i++) {
                         myDataset[i] = "https://picsum.photos/400/100?image=" + i;
                 }

                 mAdapter = new GridviewHolderAdapter(myDataset);
                     mAdapter.notifyDataSetChanged();
                 mRecyclerView.setAdapter(mAdapter);

                 swipeRefreshLayout.addView(mRecyclerView);

//                 myRelativLayout.addView(swipeRefreshLayout);

                 FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                 params.leftMargin=250;

                 final ImageView imgV =  (ImageView) view.findViewById(R.id.imageView2);
                 imgV.setLayoutParams(params);
                 imgV.setTransitionName("myshared");

                 imgV.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         FragmentManager  fg = self.getActivity().getSupportFragmentManager();
                         FragmentTransaction ft = fg.beginTransaction();

                         SecondFragement secondFragement1 = new SecondFragement();

                         ft.replace(R.id.page_layout , secondFragement1, "TEST77");
                         // Complete the changes added above
                         ft.commitAllowingStateLoss();
                         fg.executePendingTransactions();
                     }
                 });
                 view.addView(myRelativLayout);
                }
                return FragmentOnDestroyTest.rootViewFragments;
        }

        @Override
        public void onAttach(Context context) {
                super.onAttach(context);
        }

        // This event is triggered soon after onCreateView().
        // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {

        }

        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
                super.onCreateOptionsMenu(menu,inflater);
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
                super.onSaveInstanceState(outState);
        }

        @Override
        public void onDestroy() {
                super.onDestroy();
        }

        public static void setTimeout(Runnable runnable, int delay){
//                new Thread(() -> {
//                        try {
//                                Thread.sleep(delay);
//                                runnable.run();
//                        }
//                        catch (Exception e){
//                                System.err.println(e);
//                        }
//                }).start();
        }


        public class WebClient extends WebViewClient {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                        return super.shouldOverrideUrlLoading(view, request);
                }
        }
}
