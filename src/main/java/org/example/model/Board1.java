package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
public class Board1 {
    // 게시물 ID
    private Long id;

    // 제목
    private String title;

    // 내용1: 에디터 내용
    private String content1;

    // 내용2: 이미지
    private MultipartFile content2;

    // 등록일
    private LocalDateTime registrationDate;

    // 변경일
    private LocalDateTime modificationDate;

    // 작성자
    private String registrationUserId;

    // 수정자
    private String modificationUserId;

    // 삭제 여부 (Y: 삭제, N: 유지)
    private String deleteYn;
}
