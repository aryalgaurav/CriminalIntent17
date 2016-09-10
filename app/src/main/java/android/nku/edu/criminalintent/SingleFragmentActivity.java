package android.nku.edu.criminalintent;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Gaurav on 8/16/2016.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

    /**
     * Returns the ID of the layout that the activity will inflate.*/
    @LayoutRes
    protected int getLayoutResId() {
        return R.layout.activity_fragment;
    }

}
