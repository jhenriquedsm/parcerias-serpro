package com.jhenriquedsm.parcerias_serpro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "parceria")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Parceria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

    @Column(name = "news_date", nullable = false)
    private LocalDate newsDate;

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