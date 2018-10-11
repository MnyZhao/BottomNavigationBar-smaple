package com.mny.navbar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;


public class BlankFragment extends Fragment {
    View rootView;

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(String msg) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString("msg", msg);
        fragment.setArguments(args);
        return fragment;
    }

    String msg = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            msg = getArguments().getString("msg");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        } else {
            ViewParent parent = rootView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(rootView);//去掉一个parent
            }
        }
        TextView tv = rootView.findViewById(R.id.msg);
        tv.setText(msg);
        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
