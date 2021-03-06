package me.ibore.recycler.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.ibore.widget.RecyclerTabLayout;
import me.ibore.widget.recycler.RecyclerAdapter;
import me.ibore.widget.recycler.RecyclerHolder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerTabLayout recyclerTabLayout = new RecyclerTabLayout(this);
        RecyclerAdapter<String, RecyclerHolder> adapter = new RecyclerAdapter<String, RecyclerHolder>() {
            @Override
            protected RecyclerHolder onCreateRecyclerViewHolder(ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            protected void onBindRecyclerViewHolder(RecyclerHolder holder, List mDatas, int position) {
                TextView textView = holder.getTextView(R.id.all);
            }
        };

    }
}
