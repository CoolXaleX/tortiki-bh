package ru.tortiki.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@MongoEntity(collection = "testCollection", database = "testDb")
public class Post extends PanacheMongoEntity implements Serializable {
    private String title;
    private String desc;
    private String date;
    private List<Integer> likers;

    public Post() {
    }

    public Post(String title, String desc, String date) {
        this.title = title;
        this.desc = desc;
        this.date = date;
    }

    public Post(String title, String desc, String date, List<Integer> likers) {
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.likers = likers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Integer> getLikers() {
        return likers;
    }

    public void setLikers(List<Integer> likers) {
        this.likers = likers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(getTitle(), post.getTitle()) &&
                Objects.equals(getDesc(), post.getDesc()) &&
                Objects.equals(getDate(), post.getDate()) &&
                Objects.equals(getLikers(), post.getLikers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDesc(), getDate(), getLikers());
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", date='" + date + '\'' +
                ", likers=" + likers +
                ", id=" + id +
                '}';
    }
}
