package com.hossam.android.arabicchallenge5app.test.start;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;

import com.hossam.android.arabicchallenge5app.R;
import com.hossam.android.arabicchallenge5app.base.BaseFragment;
import com.jkb.fragment.rigger.rigger.Rigger;
/**
 * @author JingYeoh
 *         <a href="mailto:yangjing9611@foxmail.com">Email me</a>
 *         <a href="https://github.com/justkiddingbaby">Github</a>
 *         <a href="http://blog.justkiddingbaby.com">Blog</a>
 * @since Dec 01,2017
 */

public class ResultFragment extends BaseFragment implements OnClickListener {

  public static Fragment newInstance() {
    Bundle args = new Bundle();
    ResultFragment fragment = new ResultFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  protected int getContentView() {
    return R.layout.frg_start_result;
  }

  @Override
  protected void init(Bundle savedInstanceState) {
    findViewById(R.id.fsr_setValue).setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    Bundle args = new Bundle();
    args.putString(BUNDLE_KEY, "This is the result from ResultFragment");
    Rigger.getRigger(this).setResult(Rigger.RESULT_OK, args);
    Rigger.getRigger(this).close();
  }
}
