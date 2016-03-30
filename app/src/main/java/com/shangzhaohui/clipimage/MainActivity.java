package com.shangzhaohui.clipimage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.shangzhaohui.clipimage.view.ClipImageView;

public class MainActivity extends AppCompatActivity {
        private ClipImageView mImageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        initUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void initUI() {
        Button btn = (Button)findViewById(R.id.btn_to_process);
         mImageview = (ClipImageView)findViewById(R.id.image_src);
        mImageview.setBackgroundResource(R.drawable.a);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageview.setBitmap();
            }
        });


        Button btnReset = (Button) findViewById(R.id.reset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageview.setBackgroundResource(R.drawable.a);
            }
        });

        final Button btnChangeStyle = (Button) findViewById(R.id.change_style);
        btnChangeStyle.setText(mImageview.getStyleStr());
        btnChangeStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mImageview.changeStyle();
                btnChangeStyle.setText(mImageview.getStyleStr());
            }
        });

        Button saveBtn = (Button)findViewById(R.id.save);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitmapUtil.saveBitmap(mImageview.getBitmap(),MainActivity.this);
            }
        });
    }
}
