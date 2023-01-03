package com.jmxbuilder.jmx.dto.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * packageName    : com.jmxbuilder.jmx.dto.entity
 * fileName       : FileEntity
 * author         : im-happy-coder
 * date           : 22. 12. 13.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 12. 13.        im-happy-coder       최초 생성
 */

@NoArgsConstructor
@Table(name = "file")
@Entity
@Data
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;

    private String orgNm;

    private String orgSavedNm;

    private String orgSavePath;

    private String jmxSavePath;

    @Builder
    public FileEntity(Long id, String orgNm, String orgSavePath, String jmxSavePath) {
        this.id = id;
        this.orgNm = orgNm;
        this.orgSavePath = orgSavePath;
        this.jmxSavePath = jmxSavePath;
    }
}
