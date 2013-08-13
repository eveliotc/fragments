package info.evelio.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LoggerFragment extends Fragment {

  private TextView mLogView;
  private StringBuilder mLogBuilder;

  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);

    log("onAttach");
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    log("onCreate");
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    log("onCreateView");
    return inflater.inflate(R.layout.fragment_logger, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    mLogView = (TextView) view.findViewById(R.id.log_view);
    final TextView nameView = (TextView) view.findViewById(R.id.name_view);
    nameView.setText(getTag());

    log("onViewCreated");
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    log("onActivityCreated");
  }

  @Override
  public void onViewStateRestored(Bundle savedInstanceState) {
    super.onViewStateRestored(savedInstanceState);

    log("onViewStateRestored");
  }

  @Override
  public void onStart() {
    super.onStart();

    log("onStart");
  }

  @Override
  public void onResume() {
    super.onResume();

    log("onResume");
  }

  @Override
  public void onPause() {
    super.onPause();

    log("onPause");
  }

  @Override
  public void onStop() {
    super.onStop();

    log("onStop");
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    log("onSaveInstanceState");
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    log("onDestroyView");
    mLogView = null;
  }

  @Override
  public void onDetach() {
    super.onDetach();

    log("onDetach");
  }

  @Override
  public void onDestroy() {
    super.onDestroy();

    log("onDestroy");
  }


  private void log(String msg) {
    msg = getTag() + "[" + hashCode() + "] " + msg;
    StringBuilder builder = mLogBuilder;
    if (builder == null) {
      builder = new StringBuilder(msg);
      mLogBuilder = builder;
    } else {
      builder.append(msg);
    }

    builder.append("\n");

    Log.d("fr:log", msg);
    final TextView view = mLogView;
    if (view != null) {
      view.setText(builder.toString());
    }
  }
}
