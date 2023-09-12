package com.example.study04.dto;

import com.example.study04.entity.Comment;
import com.example.study04.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
    private Long id;
    private String comment;

    public static CommentDTO toDTO(Comment entity) {
        return CommentDTO.builder()
                .id(entity.getId())
                .comment(entity.getComment())
                .build();
    }
}
