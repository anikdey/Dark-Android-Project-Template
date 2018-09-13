package javarank.com.dreamjournalui.home.model;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private String tag;
    private String title;
    private String content;

    public Item() {
    }

    public Item(String tag, String title, String content) {
        this.tag = tag;
        this.title = title;
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Lucidity", "Demo title", "Demo content"));
        items.add(new Item("Lucidity", "Demo title", "Demo content"));
        items.add(new Item("Lucidity", "Demo title", "Demo content"));
        items.add(new Item("Lucidity", "Demo title", "Demo content"));
        items.add(new Item("Lucidity", "Demo title", "Demo content"));
        items.add(new Item("Lucidity", "Demo title", "Demo content"));
        items.add(new Item("Lucidity", "Demo title", "Demo content"));
        items.add(new Item("Lucidity", "Demo title", "Demo content"));
        return items;
    }

}