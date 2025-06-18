package com.jhenriquedsm.parcerias_serpro.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "parceria")
public class Parceria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 500)
    private String title;

    @Column(nullable = false, length = 1000)
    private String url;

    @Column(name = "news_date", nullable = false)
    private LocalDate newsDate;

    public Parceria() {}

    public Parceria(Long id, String title, String url, LocalDate newsDate) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.newsDate = newsDate;
    }

    public Parceria(String title, String url, LocalDate newsDate) {
        this.title = title;
        this.url = url;
        this.newsDate = newsDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(LocalDate newsDate) {
        this.newsDate = newsDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parceria parceria = (Parceria) o;
        return Objects.equals(id, parceria.id) && Objects.equals(title, parceria.title) && Objects.equals(url, parceria.url) && Objects.equals(newsDate, parceria.newsDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, url, newsDate);
    }
}