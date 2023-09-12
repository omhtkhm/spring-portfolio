package com.example.study04.controller.api;

import com.example.study04.dto.CommentDTO;
import com.example.study04.dto.CommonResponseDTO;
import com.example.study04.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CommentApiController {
    CommentService commentService;

    @PostMapping("/api/add-comment")
    public CommonResponseDTO addComment(@RequestBody CommentDTO commentDTO) {
        commentService.save(commentDTO);
        return CommonResponseDTO.builder()
                .success(true)
                .msg("댓글이 등록되었습니다.")
                .build();
    }
}
