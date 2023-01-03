package com.jmxbuilder.jmx.dto.repo;

import com.jmxbuilder.jmx.dto.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.jmxbuilder.jmx.dto.repo
 * fileName       : FileRepository
 * author         : im-happy-coder
 * date           : 22. 12. 13.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 12. 13.        im-happy-coder       최초 생성
 */
public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
