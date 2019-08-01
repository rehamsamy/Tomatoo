package com.example.khaled_sa2r.tomatoo.MenuActivities.Profile;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.khaled_sa2r.tomatoo.MyBase.MyBaseActivity;
import com.example.khaled_sa2r.tomatoo.R;

public class EditPaymentMethodActivity extends MyBaseActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_payment_method);

        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("       Payment Method");
        mToolbar.setNavigationIcon(R.drawable.back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
