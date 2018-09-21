package com.hossam.android.arabicchallenge5app.test;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.hossam.android.arabicchallenge5app.R;
import com.hossam.android.arabicchallenge5app.base.BaseFragment;
import com.hossam.android.arabicchallenge5app.utils.AnimationHelper;
import com.jkb.fragment.rigger.annotation.LazyLoad;
import com.jkb.fragment.rigger.utils.Logger;

/**
 * @author JingYeoh
 * <a href="mailto:yangjing9611@foxmail.com">Email me</a>
 * <a href="https://github.com/justkiddingbaby">Github</a>
 * <a href="http://blog.justkiddingbaby.com">Blog</a>
 * @since Nov 30,2017
 */
@LazyLoad
public class ContainerFragment extends BaseFragment {

    MediaPlayer mp;
    private int position;
    private boolean customAnim;
    private int[] icons = new int[]{
            R.drawable.heart, R.drawable.block, R.drawable.motorcycle, R.drawable.bear
    };
    private int[] colors = new int[]{
            R.color.colorWhite, R.color.colorWhity, R.color.colorWhitygrey, R.color.colorgreyy
    };

    public static ContainerFragment newInstance(int value, boolean customAnim, int voice, int alef) {
        Bundle args = new Bundle();
        args.putInt(BUNDLE_KEY, value);
        args.putBoolean(BUNDLE_KEY + 1, customAnim);
        args.putInt(BUNDLE_KEY + 2, voice);
        args.putInt(BUNDLE_KEY + 3, alef);
        ContainerFragment fragment = new ContainerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.frg_content;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        Logger.d(this, "init isUserHintVisible=" + getUserVisibleHint());
        Bundle args = savedInstanceState == null ? getArguments() : savedInstanceState;
        position = args.getInt(BUNDLE_KEY);
        customAnim = args.getBoolean(BUNDLE_KEY + 1);

        mp = MediaPlayer.create(getActivity(), args.getInt(BUNDLE_KEY+2));

        ImageView imageView = (ImageView) findViewById(R.id.fc_iv);

        imageView.setImageResource(args.getInt(BUNDLE_KEY+3));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying()) {
                    mp.pause();
                }
                else {
                    mp.start();
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_KEY, position);
        outState.putBoolean(BUNDLE_KEY + 1, customAnim);
    }

    public void onLazyLoadViewCreated(Bundle savedInstanceState) {
        Logger.d(this, "onLazyLoadViewCreated()");

        findViewById(R.id.fc_content)
                .setBackgroundColor(ContextCompat.getColor(mContext, colors[position % icons.length]));
    }

    public int[] getPuppetAnimations() {
        return new int[]{
                R.anim.push_left_in_no_alpha,
                R.anim.push_right_out_no_alpha,
                R.anim.push_right_in_no_alpha,
                R.anim.push_left_out_no_alpha
        };
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (customAnim) return super.onCreateAnimation(transit, enter, nextAnim);
        if (enter) {
            return AnimationHelper.createRotate3dEnterAnimation();
        } else {
            return AnimationHelper.createRotate3dExitAnimation();
        }
    }

    public boolean onRiggerBackPressed() {
        Logger.i(this, position + "::onRiggerBackPressed");
        return false;
    }
}
