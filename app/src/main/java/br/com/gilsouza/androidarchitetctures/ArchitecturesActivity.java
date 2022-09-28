package br.com.gilsouza.androidarchitetctures;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.gilsouza.androidarchitetctures.mvc.MVCActivity;
import br.com.gilsouza.androidarchitetctures.mvp.MVPActivity;
import br.com.gilsouza.androidarchitetctures.mvvm.MVVMActivity;

public class ArchitecturesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architectures);
    }

    public void onMVC(View view) { startActivity(MVCActivity.getIntent(this)); }

    public void onMVP(View view) {
        startActivity(MVPActivity.getIntent(this));
    }

    public void onMVVM(View view) {
        startActivity(MVVMActivity.getIntent(this));
    }
}