package com.smudiary.backend.mainpost.controller;

import com.smudiary.backend.mainpost.dto.response.PictureResponse;
import com.smudiary.backend.mainpost.service.MainPostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "메인포스트 컨트롤러")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/mainpost")
public class MainPostController {
    private final MainPostService mainPostService;

    @Operation(summary = "메인포스트 사진 저장")
    @PostMapping("/{userId}/savepicture")
    public PictureResponse pictureSave(@PathVariable Long userId, @RequestPart(name = "picture") MultipartFile picture) {
        try {
            return mainPostService.changePicture(userId, picture);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "메인포스트 사진 가져오기")
    @GetMapping("/{userId}/getpicture")
    public Resource getPicture(@PathVariable Long userId) {
        return mainPostService.getPicture(userId);
    }
}
