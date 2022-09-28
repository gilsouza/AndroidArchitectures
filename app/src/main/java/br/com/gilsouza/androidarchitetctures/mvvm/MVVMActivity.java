package br.com.gilsouza.androidarchitetctures.mvvm;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import br.com.gilsouza.androidarchitetctures.R;

public class MVVMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        setTitle("MVVM Activity");
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MVVMActivity.class);
    }
}