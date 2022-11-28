package com.optv.inventryverse.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.optv.inventryverse.R;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            new AlertDialog.Builder(this)
                    .setMessage("Are you sure you want to exit? You'll automatically log out once you exit.")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Dashboard.this.finishAffinity();
                        }
                    })
                    .setNegativeButton("No", null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        return false;
    }
}