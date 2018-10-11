package com.mny.navbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 三个menu
     */
    private Button mBtnThree;
    /**
     * 五个个menu
     */
    private Button mBtnFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        mBtnThree = (Button) findViewById(R.id.btn_three);
        mBtnThree.setOnClickListener(this);
        mBtnFive = (Button) findViewById(R.id.btn_five);
        mBtnFive.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_three:
                skip(MainActivity.class);
                break;
            case R.id.btn_five:
                skip(Main5Activity.class);
                break;
        }
    }

    private void skip(Class t) {
        Intent intent = new Intent(this, t);
        startActivity(intent);
    }
}
