package com.smudiary.backend.repository;

import com.smudiary.backend.entity.Board;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;

public interface BoardRepository extends JpaAttributeConverter<Board, Long> {
}
