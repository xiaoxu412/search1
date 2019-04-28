package com.zhang.search.service;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import java.io.IOException;

public interface SolrService {
    /**
     * solr 查询
     */
    SolrDocumentList querySolr(String collection, String q, String field) throws IOException, SolrServerException;
    /**
     * 根据ID查询
     */
    SolrDocument getById(String collection, String id) throws IOException, SolrServerException;
    /**
     * 删除全部索引
     * @param collection
     */
    void deleteAll(String collection) throws IOException, SolrServerException;
}
