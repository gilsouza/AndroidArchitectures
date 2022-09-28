package br.com.gilsouza.androidarchitetctures.mvp;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import br.com.gilsouza.androidarchitetctures.R;

public class MVPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        setTitle("MVP Activity");
    }

    @Override
    public Intent getIntent() {
        return super.getIntent();
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MVPActivity.class);
    }
}