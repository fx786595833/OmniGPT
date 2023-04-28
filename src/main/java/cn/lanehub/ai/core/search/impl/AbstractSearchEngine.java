package cn.lanehub.ai.core.search.impl;

import cn.lanehub.ai.core.search.ISearchEngine;
import cn.lanehub.ai.core.search.model.SortType;

public abstract  class AbstractSearchEngine implements ISearchEngine {


    @Override
    public String search(String keywords, String sortType) {
        return doSearch(keywords, SortType.fromName(sortType));
    }

    protected abstract String doSearch(String keywords, SortType sortType);
}
