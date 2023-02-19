package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.awt.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="userName")
    private user writer;

    // image 추가
    private String title;

    @Lob
    private String summary;

    @ColumnDefault("0")
    private int hits;

    @ColumnDefault("0")
    private int likes;

    @ColumnDefault("'Open'")
    @Enumerated(EnumType.STRING)
    private BoardType type;

    @CreationTimestamp
    private Timestamp timestamp;
}