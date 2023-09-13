package com.smudiary.backend.mainpost.dto.request;

import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public record PictureRequest(@RequestParam("file") MultipartFile file) {
}
