package com.picee.demo.jetpack;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.picee.demo.R;
import com.picee.demo.jetpack.adapter.ArticleAdapter;
import com.picee.demo.jetpack.bean.Article;
import com.picee.demo.jetpack.viewmodel.ArticleViewModel;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class JetpackActivity extends AppCompatActivity {
    private final String TAG = "JetpackActivity";
    private RecyclerView rvArticles;
    private ArticleViewModel articleViewModel;
    private List<Article> articleList;
    private ArticleAdapter articleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jetpack);
        rvArticles = findViewById(R.id.rvArticles);
        rvArticles.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        articleList = new ArrayList<>();
        articleAdapter = new ArticleAdapter(articleList);
        rvArticles.setAdapter(articleAdapter);
        articleAdapter.setOnItemClickListener((adapter, view, position) -> {
            Article article = (Article) adapter.getItem(position);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(article.getLink()));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
        rvArticles.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).build());
        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);
        articleViewModel.articlesLiveData.observe(this, articles -> {
            articleList.clear();
            articleList.addAll(articles);
            articleAdapter.notifyDataSetChanged();
        });
        articleViewModel.getArticles();
    }
}
