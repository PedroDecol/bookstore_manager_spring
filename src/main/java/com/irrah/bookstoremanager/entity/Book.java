package com.irrah.bookstoremanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true,unique = true)
    private String name;

    @Column(nullable = true)
    private Integer pages;

    @Column(nullable = true)
    private Integer chapters;

    @Column(nullable = true)
    private String isbn;

    @Column(name = "publisher_name",nullable = true,unique = true)
    private String publisherName;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @JoinColumn(name = "author_id")
    private Author author;
}
