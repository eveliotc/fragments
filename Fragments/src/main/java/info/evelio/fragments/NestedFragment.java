package info.evelio.fragments;

public class NestedFragment extends LoggerFragment {

  public NestedFragment addNestedFragment(String tag) {
    final NestedFragment fr = new NestedFragment();
    getChildFragmentManager().beginTransaction().add(R.id.child_container, fr, tag).commit();
    return fr;
  }

}
