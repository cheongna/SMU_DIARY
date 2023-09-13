package com.smudiary.backend.mainpost.service;

import com.smudiary.backend.mainpost.dto.request.PictureRequest;
import com.smudiary.backend.mainpost.dto.response.PictureResponse;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MainPostService {
    PictureResponse changePicture(Long userId, MultipartFile picture) throws Exception;
    Resource getPicture(Long userId);
}
