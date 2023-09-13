package com.smudiary.backend.mainpost.service;

import com.smudiary.backend.entity.MainPost;
import com.smudiary.backend.entity.User;
import com.smudiary.backend.mainpost.dto.response.PictureResponse;
import com.smudiary.backend.mainpost.repository.MainPostRepository;
import com.smudiary.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainPostServiceImpl implements MainPostService {
    private final UserRepository userRepository;
    private final MainPostRepository mainPostRepository;
    private static final String FILEPATH = "backend\\src\\main\\resources\\picture\\mainpost";

    @Override
    public PictureResponse changePicture(Long userId, MultipartFile picture) throws Exception {
        String pictureName = save(userId, picture);

        MainPost post = mainPostRepository.findByUserId(userId);
        if (post == null) {
            MainPost newPost = MainPost.builder()
                    .mainPicture(pictureName)
                    .user(userRepository.findById(userId).orElseThrow())
                    .build();
            mainPostRepository.save(newPost);
        } else {
            post.setMainPicture(pictureName);
            mainPostRepository.save(post);
        }
        return new PictureResponse(pictureName + "이 저장되었습니다.");
    }

    @Override
    public Resource getPicture(Long userId) {
        String pictureName = mainPostRepository.findByUserId(userId).getMainPicture();
        Path filePath = Path.of(FILEPATH.concat("/" + userId + "/" + pictureName));
        try {
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.isReadable() || resource.exists()) {
                return resource;
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("존재하지 않는 이미지입니다. :" + e.getMessage());
        }
        return null;
    }

    private String save(Long userId, MultipartFile picture) throws Exception {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new Exception("존재하지 않는 유저입니다.");
        }
        if (picture.getOriginalFilename() == null) throw new Exception("파일 이름이 null입니다.");

        var fileName = picture.getOriginalFilename();
        log.info(fileName);
        String uploadPath = FILEPATH.concat("/" + userId);
        Path filepath = Path.of(FILEPATH.concat("/" + userId));
        if (!Files.exists(filepath)) {
            Files.createDirectories(filepath);
        }

        // 기존 파일이 존재하는 경우 삭제
        assert fileName != null;

        Path existingFile = filepath.resolve(fileName);
        if (Files.exists(existingFile)) {
            Files.delete(existingFile);
        }

        Files.copy(picture.getInputStream(), Paths.get(uploadPath).resolve(fileName));
        return fileName;
    }


}
