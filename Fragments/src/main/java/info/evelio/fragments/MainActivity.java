package info.evelio.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

  private static final String ROOT = "ROOT";
  private static final String NESTED = "NESTED";
  private static final String SUPERNESTED = "SUPERNESTED";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (savedInstanceState == null) {
      addRootFragment(ROOT);
    }
  }

  private Fragment addRootFragment(String tag) {
    final Fragment fr = new RootFragment();
    getSupportFragmentManager().beginTransaction().add(R.id.fragment_root, fr, tag).commit();
    return fr;
  }

  public static class RootFragment extends NestedFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);

      addNestedFragment(NESTED);
    }
  }


}
