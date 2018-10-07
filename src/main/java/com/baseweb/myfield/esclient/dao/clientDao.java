package com.baseweb.myfield.esclient.dao;

import com.baseweb.myfield.esclient.config.ElasticsearchConfig;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.util.ArrayList;

public class clientDao {

    public void insert() {
        QueryBuilder queryBuilder = QueryBuilders.termsQuery("user", new ArrayList<String>().add("kimchy"));
        try {
            Client client = ElasticsearchConfig.client;
            SearchResponse response = client.prepareSearch("twitter")
                    .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                    .setScroll(new TimeValue(60000))
                    .setQuery(queryBuilder)
                    .setSize(100).execute().actionGet();
        } catch (Exception e) {
            System.out.println("" + e);
        }

    }
}