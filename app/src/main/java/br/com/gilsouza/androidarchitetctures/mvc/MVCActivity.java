package br.com.gilsouza.androidarchitetctures.mvc;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.gilsouza.androidarchitetctures.R;

public class MVCActivity extends AppCompatActivity {

    private List<String> listValues = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView list;
    private CountriesController controller;
    private Button retryButton;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        setTitle("MVC Activity");

        controller = new CountriesController(this);

        list = findViewById(R.id.list);
        retryButton = findViewById(R.id.retryButton);
        progress = findViewById(R.id.progress);
        adapter = new ArrayAdapter<>(this, R.layout.row_layout, R.id.listText, listValues);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MVCActivity.this, "You clicked " + listValues.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setValues(List<String> values) {
        listValues.clear();
        listValues.addAll(values);
        retryButton.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
        list.setVisibility(View.VISIBLE);
        adapter.notifyDataSetChanged();
    }

    public void onRetry(View view) {
        controller.onRefresh();
        retryButton.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        list.setVisibility(View.GONE);
    }

    public void onError() {
        Toast.makeText(this, R.string.error_message, Toast.LENGTH_SHORT).show();
        retryButton.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
        list.setVisibility(View.GONE);
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MVCActivity.class);
    }
}