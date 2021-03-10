package smartface.com.nativetest;

import androidx.annotation.Nullable;
import androidx.transition.TransitionInflater;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.core.app.SharedElementCallback;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by smartface on 15.08.2018.
 */

public class SecondFragement extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // The onCreateView method is called when Fragment should create its View object hierarchy,
        // either dynamically or via XML layout inflation.
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
            Toast.makeText(getContext(), " SecondFragement View creation ", Toast.LENGTH_SHORT).show();

            setHasOptionsMenu(true);

            // Defines the xml file for the fragment
            return inflater.inflate(R.layout.textviewsize_animate, null);
        }

        // This event is triggered soon after onCreateView().
        // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {

//            setEnterSharedElementCallback(new SharedElementCallback() {
//                @Override
//                public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
//                    super.onMapSharedElements(names, sharedElements);
//                }
//            });
//
//            setExitSharedElementCallback(new SharedElementCallback() {
//                @Override
//                public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
//                    super.onMapSharedElements(names, sharedElements);
//                }
//            });
//
//            final ImageView imgV =  (ImageView) view.findViewById(R.id.imageView2);
//            imgV.setTransitionName("myshared");

            // Setup any handles to view objects here
            // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
            Button btn  = (Button) view.findViewById(R.id.btnAnimate);
            btn.setText("Go Back!");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();

                    supportFragmentManager.popBackStackImmediate();
                }
            });

        }

        @Override
        public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        System.out.println("onSaveInstanceState !! ! ! ! ! !");

        }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        System.out.println("on onActivityCreated SecondFragement !! ! ! ! ! !");

    }


        @Override
        public void onDestroy() {
            super.onDestroy();
            System.out.println("on Destroy SecondFragement !! ! ! ! ! !");
            Toast.makeText(getContext(), " on Destroy SecondFragement ", Toast.LENGTH_SHORT).show();

        }

    @Override
    public void onDetach() {
        super.onDetach();

        Toast.makeText(getContext(), " on onDetach SecondFragement ", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        Toast.makeText(getContext(), " onCreateOptionsMenu SecondFragement", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(getContext(), " onOptionsItemSelected ", Toast.LENGTH_SHORT).show();

        return true;
    }
}
