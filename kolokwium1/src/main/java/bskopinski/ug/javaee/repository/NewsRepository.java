package bskopinski.ug.javaee.repository;

import bskopinski.ug.javaee.bean.NewsLetter;

import java.util.ArrayList;
import java.util.List;

public class NewsRepository {
    private List<NewsLetter> newsletterList = new ArrayList<>();


    public List<NewsLetter> getNewsletter() {
        return newsletterList;
    }

    public void addNewsletter(NewsLetter newsletter) {
        newsletterList.add(newsletter);
    }



}
