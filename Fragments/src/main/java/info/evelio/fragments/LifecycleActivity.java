package info.evelio.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class LifecycleActivity extends FragmentActivity {

  private static final String A = "A";
  private static final String B = "B";
  private static final String RETAIN = "RE";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    if (savedInstanceState == null) {
      addFragment(A);
      addFragment(B);
      addFragment(RETAIN).setRetainInstance(true);
    }
  }

  private Fragment addFragment(String tag) {
    final Fragment fr = new LoggerFragment();
    getSupportFragmentManager().beginTransaction().add(R.id.fragment_root, fr, tag).commit();
    return fr;
  }

}
