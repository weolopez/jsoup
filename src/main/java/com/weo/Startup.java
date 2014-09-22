/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weo;

import org.apache.camel.Exchange;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author mlopez
 */
public class Startup {
    public String process(Exchange e) {
        String s;
        Document d = Jsoup.parse(e.getIn().getBody(String.class));
        //  Element element = d.getElementById("IS5");
        String query = e.getIn().getHeader("query", String.class);
               
        if (null == d.body().getElementById(query)) s=d.body().html();
        else s = d.body().getElementById(query).html();    
        
        e.getIn().setBody(s);
        e.getIn().setHeader("Exchange.CONTENT_TYPE", "text/html");
        e.getIn().setHeader("Exchange.CONTENT_ENCODING", "*");
        return s;
    }
}
