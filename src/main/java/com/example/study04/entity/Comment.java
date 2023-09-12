package com.example.study04.entity;

import com.example.study04.dto.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;

    public static Comment toEntity(CommentDTO dto) {
        return Comment.builder()
                .id(dto.getId())
                .comment(dto.getComment())
                .build();
    }
}
