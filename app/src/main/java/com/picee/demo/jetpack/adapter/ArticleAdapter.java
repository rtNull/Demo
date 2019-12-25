package com.picee.demo.jetpack.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.picee.demo.R;
import com.picee.demo.jetpack.bean.Article;

import java.util.List;

public class ArticleAdapter extends BaseQuickAdapter<Article, BaseViewHolder> {
    public ArticleAdapter(List<Article> data) {
        super(R.layout.item_article, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Article item) {
        helper.setText(R.id.tv, item.getTitle());
        helper.setText(R.id.tvAuthor, item.getAuthor());
        helper.setText(R.id.tvDate, item.getNiceDate());
    }
}
